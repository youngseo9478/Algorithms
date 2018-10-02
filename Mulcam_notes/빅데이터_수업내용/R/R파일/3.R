# set.seed(1231)
# ind <- sample(2, nrow(iris), replace = T, prob = c(0.7,0.3))
# ind
# trainData <- iris[ ind == 1, ]
# testData <- iris[ ind == 2 , ]
# 
# trainData
# testData
# 
# str(iris)
# install.packages("party")
# library(party)
# myFormula <- Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width
# iris_ctree <- ctree(myFormula, data=trainData)
# iris_ctree
# plot(iris_ctree, type="simple")
# 
# testPred<-predict(iris_ctree, newdata = testData)
# testPred
# testData$Species
# result<-data.frame(pred=testPred, real=testData$Species)
# table(result)



library(MASS)
data(survey)
str(survey)

xtabs(~Sex + Exer, data=survey)
?xtabs
chisq.test(xtabs(~Sex + Exer, data=survey))


data <- read.csv('titanic_train.csv')
str(data)


chisq.test(xtabs(~Survived + Sex,data=data))
chisq.test(xtabs(~Survived + Pclass,data=data))
chisq.test(xtabs(~Survived + Fare,data=data))
data$Fare
data$FareGroup <- ifelse(data$Fare<10,1,ifelse(data$Fare<20,2,ifelse(data$Fare<30,3,4)))
table(data$FareGroup)
chisq.test(xtabs(~Survived + FareGroup,data=data))

fivenum(data$Fare)

# d <- c(1,3,4,NA)
# mean(d, na.rm=TRUE)


data$Age <- ifelse(is.na(data$Age), mean(data$Age,na.rm=T),data$Age)
data$Age
fivenum(data$Age)
data$AgeGroup <- ifelse( data$Age < 10, 1, ifelse(data$Age<20,2, ifelse(data$Age <30, 3,ifelse(data$Age <60,4,5))) )
table(data$AgeGroup)
chisq.test(xtabs(~Survived + AgeGroup, data=data))


str(data)
chisq.test(xtabs(~Survived + Parch, data=data))
table(data$Parch)



ca <- c(1,2,2,2,2,3,4,4,33,3)
ca[ c(1,3,5)]
ca [ c(-1,-3,-5)]
str(data)

data$Ticket<-NULL
data$Cabin <-NULL
data$Embarked <-NULL
data$Name <-NULL
data$PassengerId <-NULL

install.packages('caret')
library(caret)
?createDataPartition
train.id <- createDataPartition(data$Survived,p=0.7)[[1]]
data.train <- data[ train.id, ]
data.test <- data[ -train.id, ]
str(data)
glm( Survived ~ ., family = binomial(link="logit"),data=data.train )







