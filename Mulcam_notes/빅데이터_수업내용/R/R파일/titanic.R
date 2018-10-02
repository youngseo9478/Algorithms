# 타이타닉 관련 데이터 

library(MASS)
data(survey)
str(survey)

# 성별과 운동량의 상관이 있는지 알아보려고 함
?survey

# 빈도에 따른...뭘 알려주는 함수임 ㅎ
xtabs()
?xtabs

xtabs(~Sex+Exer,data=survey)
# Exer
# Sex      Freq None Some
# Female   49   11   58
# Male     65   13   40
# 기대 빈도에 비해 어느정도 한쪽으로 치우쳐있는지 ...
# 연관 종속성을 알려면 카이제곱검정.....을 이용한다고 한다 ^^
chisq.test(xtabs(~Sex+Exer,data=survey))
# 
# Pearson's Chi-squared test
# 
# data:  xtabs(~Sex + Exer, data = survey)
# X-squared = 5.7184, df = 2, p-value = 0.05731
#  p-value를 잘 봐야함
#  0.05보다 크면 기각할 수 없음 (성별과 운동량이 상관이 없다는 것)


# ___________________________________________________________
# 이 검정을 이용해서 타이타닉 생존자에 대해 조사해보려고 함
data <- read.csv('titanic_train.csv')  #일단 데이터를 읽어온다
# 0이면 죽은 것, NA는 미상
# sibsp는 동반가족이있는지 없는지, 있으면 몇명과...?
# 일반적으로 이름과 티켓넘버는 상관이 없을 것임.
# str(data)

chisq.test(xtabs(~Survived+Sex,data=data))
# P-value가 0.05보다 작으면 상관관계가 있다는 뜻!
# Pearson's Chi-squared test with Yates' continuity correction
# 
# data:  xtabs(~Survived + Sex, data = data)
# X-squared = 260.72, df = 1, p-value < 2.2e-16
#  2.2e-16은 10^(-16)이니까 엄청엄청 작은 거임. 당연히 0.05보다 작지!

chisq.test(xtabs(~Survived+Pclass,data = data))
# Pearson's Chi-squared test
# 
# data:  xtabs(~Survived + Pclass, data = data)
# X-squared = 102.89, df = 2, p-value < 2.2e-16

# 표값은 상관이 있을까 ?? 카이제곱할 때 주의할 점이 있음.
#  기대빈도가 다 합친게 10보다 작으면 의미가 없음...

fivenum(data$Fare)
# [1]   0.0000   7.9104  14.4542  31.0000 512.3292  제일 비싸게 주고 탄 사람이 512
#10보다 작으면 1,아니면 2
table(data$FareGroup)
data$Fare
data$FareGroup <- ifelse(data$Fare<10,1,ifelse(data$Fare<20,2,ifelse(data$Fare<30,3,4)))
chisq.test(xtabs(~Survived+FareGroup,data = data))
# > chisq.test(xtabs(~Survived+FareGroup,data = data))
# 
# Pearson's Chi-squared test
# 
# data:  xtabs(~Survived + FareGroup, data = data)
# X-squared = 92.718, df = 3, p-value < 2.2e-16



# 데이터 중에 NA가 있으면 평균값을 구할 수 없다.
d<-c(1,3,4,NA)
mean(d)
# > d<-c(1,3,4,NA)
# > mean(d)
# [1] NA
mean(d,na.rm = T)
# > mean(d,na.rm = T)
# [1] 2.666667

# 나이 정보가 없는 사람은 평균값으로 대체 
data$Age <-ifelse(is.na(data$Age),mean(data$Age,na.rm = T),data$Age)
data$Age

fivenum(data$Age)
# [1]  0.42000 22.00000 29.69912 35.00000 80.00000

data$AgeGroup <- ifelse(data$Age<10,1,ifelse(data$Age<20,2,ifelse(data$Age<30,3,ifelse(data$Age<60,4,5))))
table(data$AgeGroup)
# 1(10미만)   2(20미만)   3(30미만)   4(60미만)   5(60이상) 
# 62          102         397         304         26
chisq.test(xtabs(~Survived+AgeGroup,data=data))
# Pearson's Chi-squared test
# 
# data:  xtabs(~Survived + AgeGroup, data = data)
# X-squared = 22.644, df = 4, p-value = 0.0001492  연관이 있네

str(data)
chisq.test(xtabs(~Survived+Parch,data=data)) #Parch는 자식 수
# Warning message:
#   In chisq.test(xtabs(~Survived + Parch, data = data)) :
#   카이제곱 approximation은 정확하지 않을수도 있습니다
#  데이터가 적어서 신뢰할 수 없다는 뜻
table(data$Parch)
# 0   1   2   3   4   5   6 
# 678 118  80   5   4   5   1  별로 읎다! 왜냐면 2명 이상부터는 10이하니까




# 선형회귀 선 그려주는 메소드
?glm
str(data)
data$Ticket<-NULL
data$Cabin<-NULL
data$Embarked<-NULL
data$PassengerId<-NULL

# createDataPartition(data$Survived,p=0.7)[[1]]
install.packages('caret')
library(caret)
?createDataPartition
train.id <- createDataPartition(data$Survived,p=0.7)[[1]]
data.train <- data[train.id,]  #70%
data.test <- data[-train.id,]  #30%

logit.model <-glm(Survived~., family = binomial(link="logit"),data = data)  #싹 다는 .
summary(logit.model)
# Warning message:
#   glm.fit: 알고리즘이 수렴하지 않았습니다 
#  티켓이 NA가 너무 많고 캐빈은 필요도 없음 이 데이터들은 지우고 합시다
#  그래서 위에서 필요없는 데이터들에 널 넣어서 없애줬다

result<-predict(logit.model, newdata = data.test, type = "respond")
r<-data.frame(real=data.test$Survived,pred=round(result))
table(r)
