x<-c(1,10,100)
x

(11+54+13)*76/9
#한글이 안되면 윈도우키를 눌러본다.

5%/%3 #몫구하기

5%%3 #나머지

3**5 #지수
install.packages("rJava")
library(rJava)
install.packages("RJDBC")
library(RJDBC)
driveload1 <- JDBC("oracle.jdbc.driver.OracleDriver","C:/ojdbc6.jar")
dbCon1 <- dbConnect(driveload1, "jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")
emp <- dbGetQuery(dbCon1, "Select * from employees")
emp
test <- c(100, 300, 150, 250, 340)
barplot(test, main="baseball sell amount", 
        xlab = "season", ylab = "amount",
        names.arg = c("a", "b", "c", "d", "e"),
        border = "blue", density = c(10, 30, 50, 30, 10))

aa <- c (220,330,270,240,310)
bb <- c (155,200,205,195,190)
cc <- c (200,290,300,240,270)

dd <- matrix(c(aa, bb, cc), 5, 3)
dd

#볼 타입별 각 시즌별 매출 그래프
barplot(dd, main="무엇이 나올까", 
        xlab = "어떤 타입일까", ylab = "amount", beside = TRUE,
        names.arg = c("타입A", "타입B", "타입C"),
        border = "red", col = rainbow(5), ylim = c(0,400),
        density = c(5, 30, 50, 30, 90))

aa <- c(200, 400, 600, 1200)

col <- c()

for(i in 1:length(jokun)){
  if(aa[i] >= 1000)
    col2 <- c(col2 , "red")
  else if (jokun[i] >= 500)
    col2 <- c(col2, "green")
  else if (jokun[i] >= 300)
    col2 <- c(col2, "blue")
  else
    col2 <- c(col2, "yellow")
}
barplot(aa, main = "bread sell amount", horiz = TRUE,
        names.arg = c("a", "b", "c", "d"), col = col2)

log10(10000000)

install.packages("RJDBC",dep=TRUE)
install.packages('rJava')
install.packages("Rserve")
Rserve::Rserve(args="--RS-enable-remote")


sqrt(2) #루트

trunc(3.141592) # 소수점 자르
#[1] 3

abs(-3) # x의 절대값
#[1] 3

runif(10) # 10개의 임의의 함수
#[1] 0.086844036 0.814198359 0.879587837 0.226192319 0.439664352 0.299559717
#[7] 0.408650567 0.046567867 0.183174474 0.001892288

rm(x) # 변수 x를 삭제
rm(list=ls()) # 모든 변수를 삭제

help("for") # for 명령에 대한 도움말
is() # 현재 시스탬에서 사용하는 변수 표시
bb # is()에서 보여준 변수중 하나인 bb 변수의 내용을 화면에 보여줌
cat("i love you \n") # 문자열을 표시하고 \n 을 실행한다.
sink("output.txt") # 저장할 파일병을 입력한다

#R 의 기본데이터 iris 의정보
head(iris)
tail(iris)
View(iris)
summary(iris)

installed.packages()
install.packages("igraph")

.libPaths()

install.packages("DBI")

iris3

aa<-100
class(aa)
aa<-"ondal"
class(aa)

objects()
aa
rm(aa)
rm(list=ls())

print(aa)

date()
Sys.time()
format(Sys.time(),"%H:%M:%S")


bb<-c(2,4,6,8,10)
bb
bb[3]
bb[-3]
bb[3:5]

seq(3:5)
seq(1:3)
bb[1:(length(bb)-3)]

bb<-c(bb,700)
bb
bb[3]<-100
bb[bb>8 & bb<100]

bb[8]<-999
bb

cc<-replace(bb,c(1,2),c(200,400))
cc

ee<-append(bb,cc,after=3) #bb의 3번째 값뒤에 cc를 추가하여 붙인다.
ee
ee<-append(bb,55,after=0) 

bb
cc
ff<-bb+cc
ff
union(bb,cc) # 합집합
intersect(bb,cc) #교집합
setdiff(bb,cc) #차집

c(100,200)+c(3,4) #vector 끼리 직접 연산
c(100,200)+50 #백터와 숫자 연산

irum<-c(10,20,30)
irum

names(irum)<-c("kor","eng","mat")
irum
hist(irum)

kaja() # 함수호출

kaja<- function(){ # 함수정의
  return("ondal") 
}

help("for")
help("bwplot")

tall<-c(180,180,180)
weight<-c(120,50,60)

data1 = data.frame(성명=c("손오공","ㅁㅁ"), 나이=c(20, 30), 주소=c("서울", "부산"))
data1 =edit(data1)
data1
for(i in 1:3){
  print(bmi(tall[i],weight[i]))
}

bmi<- function(tall, weight){
  bmia<-tall**2
  bmib<-weight
  bmic<-(bmib/bmia)*10000
  if(bmic>30){
    return(paste("고도비만",bmic))
  }else if(bmic>25){
    return(paste("비만",bmic))  
  }else if(bmic>23){
    return(paste("과체중",bmic))  
  }else if(bmic>18.5){
    return(paste("정상",bmic))  
  }else{
    return(paste("저체중",bmic))
  }
}

product(10)
product<- function(val){
  protmp<- val+90
  return(protmp)
}

product<- function(val){
  protmp<- c(val,"babo")
  return(protmp)
}

rm(x)
# 두 명의 고객 정보에 대한 데이터 프레임 만들기
x <- data.frame(성명=c("손오공","ㅁㅁ"), 나이=c(20, 30), 주소=c("서울", "부산"))
x

# 동일한 결과
x <- data.frame("성명"=c("홍길동", "손오공"), "나이"=c(20, 30), "주소"=c("서울", "부산"))

# 열과 행 단위 추가
x <- cbind(x, 학과=c("e-비즈", "경영"))
x

x <- rbind(x, data.frame(성명="장발장", 나이=40, 주소="파리", 학과="행정"))
x

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
#2018-03-16

VData<-c(100,"200")
VData
length(VData)

NCOL(VData) #컬럼의 갯수(백터는 1data 타입이라 1개)
NROW(VData) #배열의 건수
"100" %in% VData #"100" 이 있나?

aa<-c(10,20,30) # aa vector 값 넣기
aa
(aa1<-c(10,20,30)) # 괄호를 사용하여 바로 결과 보기

mean(aa) #avg
order(aa) # 순서대로 어디있는지 알려줌(index 로 보면 될듯)
order(aa,decreasing =T)

range(aa) #aa의범위
sd(aa) #aa 표준편

sort(aa) #ascending
sort(aa,decreasing =T)

(aa2<-c(1,2,3,4,50))

mean(aa2) # 평균
median(aa2) # 중앙값
max(aa2)
min(aa2)
range(aa2) #범위

summary(aa2) # 요약정보
IQR(aa2)#3사분위와 1사분위간 범위 : 4-2=2

#사분위수
#R은 9가지 사분위수 계산법으로처리
#사분위수는 데이터 표본을 4애의 동일한 부분으로 나눈 값
#데이터의 집하의 법위와 중심 위치 평가
#1 사분위수(Q1)는 데이터의 25% 가 이 값보다 작거나 같

#sequence 연산자 : 사용
intvecl<- -3:3 #-3 부터 3사이의 정수를 Vector 데이터로

seqvec1<-seq(3) #1~3의 사이의 정수값을 vector 데이터로

seqvec2<-seq(from=1, to=3, by=0.2) #1부터 시작해서 3까지 0.2 증가
seqvec<-seq(1,3,0.2) #1부터 시작해서 3까지 0.2 증가

scan()
pp<-scan(what ="") # what 다음에 쓴 타입으로 형변환

vNum1 <- rep(100,3) # 100숫자를 3번 반복
vNum2 <- rep(1:3,2) # 1~3  차례대로 2번 반복
vNum3 <- rep(1:3,each=2) # 1~3숫자를 각각 2번 반복
vNum4 <- rep(1:3,each=2, times=3) # 1~3숫자를 각각 2번 반복 한걸 3번 반복
vNum5 <- rep(1:3, C(3,3,3)) # 1~3을 각각 3번씩 반복
vNum6 <- rep(1:3,c(1,2,3)) # 1~3을 각각 1,2,3번씩 반복
vNum7 <-rep(1:3,c(3,2,1), len=5) # LEN 이들어갔더니 규칙이 바뀜 c(3,2,1) 이 무서댐
vNum8 <-rep(1:3, len=10)

simple(1:5,3) # 중복없이 1~5 사이중 3개
for(i in c(1,2,3))
{
  print(i)
}
seq(1,5)
sample(1:5,3)
sample(1:5,3)

sort(c(1,100,5))

for(i in c(1,2,3)){
  print(i)
}

lotto(10)
lotto<-function(money){
  for(i in 1:money){
    print(sort(sample(1:45,6)))
  }
}

bb<-c(2,3,100,8,10)
cc<-c(200,400,100,8,10)

bb==cc # 위 아래로 비교

setequal(bb,cc) # 같은집합?
union(bb,cc) #합집합
intersect(bb,cc) #곱집합
setdiff(bb,cc) #차집합
setdiff(cc,bb) #차집합

is.element(3000,bb) # 3000은 bb의 요소인가
is.element(cc,bb) #Cc요소는 bb의 요소인가?

vchar<-c("L","O","V","E")
vNum9<-gl(5,2) # 1~5 까지 각각 2번 반

vchar2<-rep(c("k","a","j","a"),times=3)
vchar2

unique(vchar2) # 출력할때만 중복 숨김
vchar2

paste(vchar,collapse = "-")
paste(vchar,collapse = "")

hap1=paste(vchar[1],vchar2[3])
hap1

substring("ondal",1,3)
substring("ondal",2,3)
substring("ondal",2:3)

vchar3<-c("babo","ondal","satto","choonhyang","hyung")

vsplit1<-strsplit("happy:day",":")
vsplit1

vsplit2<-strsplit(vchar3,"a")
vsplit2

vsplit3<-toupper(strsplit(vchar3,"un")[[5]]) # 벡터 5번째 요소를 un 으로 분할한뒤 대문자 로 변경
vsplit3

######################################################################## 180316 오늘 과제
year<- function(thisyear) {
  if((thisyear%%4==0) && (thisyear%%100!=0) || (thisyear%%400==0)){
    return("윤년입니다.")
  }else{
    return("윤년이 아닙니다.")
  }
}

year(as.numeric(format(Sys.Date(),"%Y")))

## 윤년 구하기

t<-c(10,20,1,50,100)
tv<-c(10,30,4,50,99)
NCOL(t)#행
NROW(t)#열

sd(t) #표준편차

sort(t) #정렬
sort(t,decreasing =T)

mean(t) # 평균
median(t) # 중앙값
max(t) # 작은
min(t) # 작은거
range(aa2) #범위
tmp<-c(1,2,3,4,500)
summary(tmp) # 요약정보
IQR(tmp)#3사분위와 1사분위간 범위 : 4-2=2

setequal(t,tv) # 같은집합?
union(t,tv) #합집합
intersect(t,tv) #곱집합
setdiff(t,tv) #차집합
setdiff(t,tv) #차집합

is.element(500,t) # 500은 t의 요소인가
is.element(t,tv) #t요소는 bv의 요소인가?

substring(t,1,2) # 백터 각각의 요소가 subString 된다


#sequence 연산자 : 사용
intvecl<- -3:3 #-3 부터 3사이의 정수를 Vector 데이터로

seqvec1<-seq(3) #1~3의 사이의 정수값을 vector 데이터로

seqvec2<-seq(from=1, to=3, by=0.2) #1부터 시작해서 3까지 0.2 증가
seqvec<-seq(1,3,0.2) #1부터 시작해서 3까지 0.2 증가

scan()
pp<-scan(what ="") # what 다음에 쓴 타입으로 형변환

vNum1 <- rep(100,3) # 100숫자를 3번 반복
vNum2 <- rep(1:3,2) # 1~3  차례대로 2번 반복
vNum3 <- rep(1:3,each=2) # 1~3숫자를 각각 2번 반복
vNum4 <- rep(1:3,each=2, times=3) # 1~3숫자를 각각 2번 반복 한걸 3번 반복
vNum5 <- rep(1:3, C(3,3,3)) # 1~3을 각각 3번씩 반복
vNum6 <- rep(1:3,c(1,2,3)) # 1~3을 각각 1,2,3번씩 반복
vNum7 <-rep(1:3,c(3,2,1), len=5) # LEN 이들어갔더니 규칙이 바뀜 c(3,2,1) 이 무서댐
vNum8 <-rep(1:3, len=10)

seq(1,5)
sample(1:5,3)
sample(1:5,3)

bb<-c(2,3,100,8,10)
cc<-c(200,400,100,8,10)

bb==cc # 위 아래로 비교

setequal(bb,cc) # 같은집합?
union(bb,cc) #합집합
intersect(bb,cc) #곱집합
setdiff(bb,cc) #차집합
setdiff(cc,bb) #차집합

is.element(3000,bb) # 3000은 bb의 요소인가
is.element(cc,bb) #Cc요소는 bb의 요소인가?

vchar<-c("L","O","V","E")
vNum9<-gl(5,2) # 1~5 까지 각각 2번 반

vchar2<-rep(c("k","a","j","a"),times=3)
vchar2

unique(vchar2) # 출력할때만 중복 숨김
vchar2

paste(vchar,collapse = "-")
paste(vchar,collapse = "")

hap1=paste(vchar[1],vchar2[3])
hap1

substring("ondal",1,3)
substring("ondal",2,3)
substring("ondal",2:3)

vchar3<-c("babo","ondal","satto","choonhyang","hyung")

vsplit1<-strsplit("happy:day",":")

vsplit2<-strsplit(vchar3,"a")

vsplit3<-toupper(strsplit(vchar3,"un")[[5]]) # 벡터 5번째 요소를 un 으로 분할한뒤 대문자 로 변경

############################################################################ 180316 과제 끝

## lotto 10 game
for(i in seq (1,10,by=1)){
  lotto2 <- c(sort(sample(1:45,6)))
  print(lotto2)
}

kaja <- function(){
  
  print("babo")
}

kaja()


# 파이썬 문법
# default kaja1():
#   print "babo"
# 
# kaja


##논리 데이터 &
vlogic1 <-30
(vlogic1>20) & (vlogic1<100)    #20<vlogic1<100


#0~1 사이의 수 3개 출력
vlogic2 <- runif(3)
vlogic2



#lotto 번호를 만들어보자
ceiling(runif(6)*45)      #runif(6) 0~1까지 난수 6개 생성
#*45 0.00001~0.00044.9999
#ceiling() 올림처리->1~45

#java 0~1
#Math.random()*45   #0.000001~44.9999
#소숫점 이하 올림 Math.ceil(Ma.....)

#sort를 활용한 lotto 생성
lottoNum <- sort(ceiling(runif(6)*45))
lottoNum



any(lottoNum>23)    #번호 중에 23보다 큰 수 가 있는지 확인

any(lottoNum>100)   #번호 중에 10보다 큰 수 가 있는지 확인

all(lottoNum<100)   #번호 모두가 100보다 작은지 확인

all(lottoNum<23)    #번호 모두가 23보다 작은지 확인



is.vector(lottoNum) #lottoNum이 vector인지 확인




##행렬
(invec1 <- c(10,20,30))

(invec2 <- c(100,200,300))

(invec3 <- c(1000,2000,3000))


#벡터를 행 추가하여 2차원 행렬을 만든다.
(matx1 <- rbind(invec1,invec2,invec3))


#벡터를 열 추가하여 2차원 행렬을 만든다.
(matx2 <- cbind(invec1,invec2,invec3))


#기존에 행 추가
(matx3 <- rbind(matx1, c(1,2,3)))


#기존에 열 추가
(matx4 <- cbind(matx3, c(10000,20000,30000,4)))


#줄 max값
(apply(matx4, 1, max))

#줄 sum
(apply(matx4, 1, sum))

#칸 max
(apply(matx4, 2, max))


#컬럼명 입력
(colnames(matx4) <- c("벡터1","벡터2","벡터3","벡터4"))
matx4


##character matrix로 타입 변환 (1차원vector->2차원matrix)
#wordcount 같은 경우에 활용 가능
vChar1 <- c("babo","ondal","satto","choonhyang","wolmae","pojol")
vChar1
(mChar <- matrix(vChar1))


#행의 크기를 지정, (1열1행,1열2행, 2열1행,2열2행.. 순서로 진행)
(mChar2 <- matrix(vChar1, nrow = 2))

#열의 크기를 지정 (1열1행,1열2행,1열3행, 2열1행,2열2행,2열3행..순서로 진행)
(mChar3 <- matrix(vChar1, ncol = 2))



#파일 불러들이기
#setwd() 워킹 디렉토리 설정
#read.csv csv파일을 읽을때 사용
(matScore <- read.csv("C:/Rbang/top50.csv", sep=",", header=TRUE))

# 총 행,열을 알려준다
matScore
dim(matScore)


#3줄만 읽음
head(matScore, 3)


#편집하기
edit(matScore)
matScore



#SCI열에 대한 summary 보여줌 (일부분을 출력할때 $를 사용한다)
summary(matScore $SCI)

#1부터 2행만 분리하여 저장
matScore1 <- matScore[1:2,]
matScore1


#1,2열만 분리하여 저장
matScore10 <- matScore[,1:2]
matScore10



#3부터 6행만 분리하여 저장
matScore2 <- matScore[3:6,]
matScore2

#행 결합해서 모두 추가하기
matScore3 <- rbind(matScore1,matScore2)
matScore3



##data frame

#이름
(vName1 <- c("ondal", "satto"))
#나이
(vAge1 <- c(30,50))
#급여
(vSalary1 <- c(200,300))

#컬럼 설정 = DB Table 구조
(dfSawon1 <- data.frame(irum=vName1, na2=vAge1, sal=vSalary1))


#1행 출력 (,뒤에 없음)
dfSawon1[1,]
#2행 출력 (,뒤에 없음)
dfSawon1[2,]


#1열 출력 (,앞에 없음)
dfSawon1[,1]
#2열 출력 (,앞에 없음)
dfSawon1[,2]



dfSawon1
dfSawon1[,1:2]
#제외하고 나머지 출력
dfSawon1[,-1]



#-------
id <- c(1, 2, 3, 4, 5)
sung <- c("m","f","m","m","f")
ki <- c(180, 170, 155, 160, NA)
mom <- c(78, 65, 55, 56, 55)

#컬럼명=밸류
x <- data.frame(ID=id, SUNG=sung, KI=ki, MOM=mom)
x


##P.46

#-1:-2 제외하고 평균, na.rm=TRUE (NA를 제외하고 계산) = 간단한 계산법
sapply(x[,-1:-2], mean, na.rm=TRUE)

#키열, 성별열, 평균, na.rm=TRUE (NA를 제외하고 계산) = 구룹별로 계산
tapply(x$KI, x$SUNG, mean, na.rm=TRUE)


#배열 형식으로 출력
x["KI"]

#값 형식으로 KI만 출력
x$KI


#1,2컬럼, NA제외하고 평균 목록(list)
lapply(x[,-1:-2], mean, na.rm=TRUE)



##LIST
#직접 값을 집어넣고, 각기 출력된다.
listVal1 <- list(irum="ondal", tel="010-8888-7777", sal=300)
listVal1


#각각 출력
listVal1$irum
listVal1$tel
listVal1$sal

#1,2번(irum/tel) 출력
listVal1[1:2]


#내용 추가하기
(listVal1$hire_date <- "1980-12-11")
listVal1




##Array = 하나의 데이터 타입
#2차원을 묶어서 처리 -> 3차원배열
iris3


(aVar1 <- array(c(10,20,30,40,50,60,70,80),dim=c(2,4)))

#평균 (20, 40, 60, 80)
mean(aVar1[2,])


#1은 행단위
aVar1
apply(aVar1, 1, sum)
#동일한 표현
rowSums(aVar1)


#2는 열단위
aVar1
apply(aVar1, 2, sum)
#동일한 표현
colSums(aVar1)


#행단위 평균
apply(aVar1, 1, mean)
rowMeans(aVar1)

#열단위 평균
apply(aVar1, 2, mean)
colMeans(aVar1)



##2행 3열짜리가 4개 (=4면 2행 3열)
(a3Var1 <- array(10:33, dim=c(2,3,4)))

#3면 2행 4열
(a3Var1 <- array(10:33, dim=c(2,4,3)))



#각 1행 1st 출력
a3Var1[1,,]

#1행 3열 1st 출력
a3Var1[1, 3, ]

#2번째 면에서 1행 3열 
a3Var1[1, 3, 2]

#14,22,30 평균 66/3 = 22
mean(a3Var1[1,3,])


#3열 출력
a3Var1[,3,]


#3열 평균 135/6=22.5
mean(a3Var1[,3,])




#1. 데이터 넣기
bun <- c(10,11,12)
irum <- c("ondal", "kongjoo", "satto")
sawon <- data.frame(NO=bun, NAME=irum)
sawon


#2. 저장
save(bun, irum, sawon, file="C:/Rbang/datasave1.data")

#3. 기억창고 삭제
rm(irum)
rm(bun)
rm(sawon)
rm(irum,bun,sawon)

#4. 확인
ls()

#5. load 불러오기
load("C:/Rbang/datasave1.data")

bun
irum
sawon


#불러오기 P51~53 excel_open_save
#위치가 워킹디렉토리면 해당 파일명만 필요하다. 아니면 fullpath 필요
x <- read.csv("a.csv")
x

#1행 출력
x[1,]

#구조를 요약
str(x)

# name을 chr형으로 변경 (기존에 factor형)
x$name <- as.character(x$name)
str(x)


#워킹 디렉토리에 넣고 바로 불러오기
xx <- read.csv("b.csv")
xx

#head 추가 (X1 X.hong. X100는 가상의 컬럼)
names(xx) <- c("id", "name", "score")
xx

setwd("c:/R")
a<-scan("textdata.txt",what = "") #데이터를 배열형태로 읽음
a

c<-read.table("textdata.txt", header = T)
c

text<-c("babo","Ondal","choongyang","ondal","baboo","zzzz", "abc777")
text

install.packages("sqldf")
library(sqldf)
library(tcltk)

(emp<-read.csv("c:/R/emp_mt.csv",header = TRUE))

sqldf("select ename, sal from emp")

emp [ , c("EMPNO","ENAME")]

pie(emp$SAL, col=rainbow(12))

dept<-read.csv("c:/R/dept_mt.csv",header = TRUE)
dept
sqldf("select * from dept")

dept
sqldf("select * from dept")

(pro<-read.csv("c:/R/Pro.csv",header = TRUE))
pro
pro[1,]
str(pro)
pro$단가 <- as.character(pro$단가)
pro

num <- c(1,2,3,4)
name <- c("cpu","vga","ram","case")
prices <- c(22000,3300,9800,3000)
qty <- c(5,9,8,2)

computer <-data.frame(Num=num, Name=name, Price=prices, QTY=qty)
computer
ls()
write.csv(computer, file="computer.csv")
rm(computer)
ls()

computer <- read.csv("computer.csv")
computer 

dept[dept$DEPTNO==30,c("DEPTNO","DNAME","LOC_ID")]
sqldf("select deptno, dname,loc_id from dept where deptno=30")

emp[grep("^S+",emp$ENAME),c("ENAME","SAL","HIREDATE")]
sqldf("select ename,sal,hiredate from emp where ename like 'S%'")



#벡터 3개 만
(i1 <- c(11,22,33))
(i2 <- c(111,222,333))
(i3 <- c(1111,2222,3333))

#벡터를 행 추가하여 2차원 행렬을 만든다(rbind)
(m1 <- rbind(i1,i2,i3))
#벡터를 열 추가하여 2차원 행렬을 만든다.(cbind)
(m2 <- cbind(i1,i2,i3))


#기존에 행 추가
(m3 <- rbind(m1, c(1,2,3)))

#기존에 열 추가
(m4 <- cbind(m3, c(15,6,7,4)))

#줄 max값
(apply(m4, 1, max))

#줄 sum
(apply(m4, 1, sum))

#칸 max
(apply(matx4, 2, max))


#컬럼명 입력
(colnames(m4) <- c("컬1","컬2","컬3","컬4"))
m4


##character matrix로 타입 변환
Char1 <- c("하나","둘","삼","넷")
Char1
(Char <- matrix(Char1))


#행의 크기를 지정
(Char2 <- matrix(Char1, nrow = 1))

#열의 크기를 지정
(Char3 <- matrix(Char1, ncol = 2))


#파일 불러들이기
#setwd() 워킹 디렉토리 설정
#read.csv csv파일을 읽을때 사용
(matScore <- read.csv("C:/Rbang/top50.csv", sep=",", header=TRUE))

# 총 행,열을 알려준다
matScore
dim(matScore)


#3줄만 읽음
head(matScore, 3)


#편집하기
edit(matScore)
matScore



#SCI열에 대한 summary 보여줌 (일부분을 출력할때 $를 사용한다)
summary(matScore $SCI)

#1부터 2행만 분리하여 저장
matScore1 <- matScore[1:2,]
matScore1


#1,2열만 분리하여 저장
matScore10 <- matScore[,1:2]
matScore10



#3부터 6행만 분리하여 저장
matScore2 <- matScore[3:6,]
matScore2

#행 결합해서 모두 추가하기
matScore3 <- rbind(matScore1,matScore2)
matScore3

##################################################################################
# [1] 엑셀로 일렬번호(숫자),품명(문자),단가(숫자), 판매수(숫자) 를 넣은후 
# 단가*판매수금액을 계산하여 넣는다 
# (단, head도 있다) 
# 이를 csv파일을 저장한후 R에서 읽어들여 p52-53내용대로 실습한다
prob1 <- read.csv("prob1.csv")
prob1[1,]
str(prob1)
prob1$품명 <- as.character(prob1$품명)
prob2 <- read.csv("prob2.csv")
names(prob2) <-c("일렬번호추가","품명추가","단가추가","판매수추가","금액추가")

no <- c(1,2,3,4)
name <- c("apple","banana","peach","berry")
price <- c(500,200,200,5)
qty <- c(5,2,7,9)
fruit <- data.frame(No=no, Name=name, Price=price, QTY=qty)
write.csv(fruit,"fruit.csv")
rm(fruit)
fruit <-read.csv("fruit.csv")


# [2] dept_mt 테이블을 사용해본다
# 단, 중복 되더라도 sqldf 패키지를 다시 인스톨 한다
# sqldf, R로 각각

# 1) 전체 테이블을 출력한다 
#TABLE 메모리에 넣기
(dept <- read.csv("C:/Rbang/dept_mt.csv", header = TRUE))
#SQL
sqldf("select * from dept")
#R
dept[,]

# 2) 30번 부서에 해당되는 부서명과 지역을 출력하는 문장을 만든다
#SQL
sqldf("select DNAME, LOC_ID from dept where DEPTNO=30")
#R
dept[dept$DEPTNO==30, c("DNAME","LOC_ID")]


# 3) 이름의 첫 글자가 S로 시작하는 사원들의 이름과 급여, 입사일 출력
# (단, R로는 substr과 grep(p.57참조) 을 각각 사용한다) 
#SQL
sqldf("select * from emp")
sqldf("select ENAME, SAL, HIREDATE from emp where ENAME like 'S%'")
#R
emp[substr(emp$ENAME,1,1)== 'S', c("ENAME","SAL","HIREDATE")]

#첫글자가 S인 경우 eg: Smith
emp[grep("^S", emp$ENAME), c("ENAME","SAL","HIREDATE")]

#1개 이상인 경우 eg: SamSung
emp[grep("^S+", emp$ENAME), c("ENAME","SAL","HIREDATE")]

#[3] 오늘 배운 주요 내용 중 [1][2]문제에 속하지 않는 것을 요약하여 제출한다 




##P 64
#지역변수 = 스텍메모리 ( {}밖에선 존재x 휘발성 )
#전역변수 = 스테틱메모리 ( 시스템 끝날때까지 남아있음 )

#전역변수(시스템변수) 생성
x <- c("a", "b")
x


#1형식 = 함수호출 -> 처리하고 돌아옴
#2형식 = 값을 가지고 감(인자-argument) -> 처리하고 돌아옴


## 1형식
#함수 정의문
minho <- function(){
  x <- 10           #지역변수
  y <- 20           #지역변수
  return(x*y)       #지역변수
}

#함수 호출문
minho()

x


## 2형식
#함수 정의문
minho2 <- function(x, y){ #매개변수 - parameter
  xx <- x
  yy <- y
  return(sum(xx,yy))
}

#함수 호출문
minho2(10, 20)


#win_java + win_R + linux_HADOOP-hive

## 2형식
#함수 정의문
minho3 <- function(x, y){ #매개변수 - parameter
  x3 <- x+1               # 9+1 = 10
  print(x3)
  y3 <- y+1               # 19+1 = 20
  
  x4 <- minho2(x3,y3)     #함수에서 다른 함수 호출 10+20 = 30
  return(x4)              # 30
}

#함수 호출문
minho3(9, 19)



## 화면에 결과값 보이지 않게 하는 경우
#함수 정의문
minho4 <- function(){ #매개변수 - parameter
  x <- 10
  y <- 10 
  
  return(invisible(x*y))  #리턴값 출력이 기본인데 리턴값 출력 안하겠다는 뜻
  #결과는 계산되어 있음
}

#함수 호출문
minho4()                  #no display

#댓글 -> AJAX (비동기화처리) - UI

result1 <- minho4()
result1



#변수 전체 확인 함수
ls()



## 자바에서 전역변수 선언 - 클래스 바로 아래 (보통 int 같은 것 )
## 자바에서 전역변수 접근 - static 처리

#기존에 선언된 전역변수
x

#함수 정의문
minho5 <- function(){
  x <<- 500           # <- 지역변수
  # <<- 시스템변수에 입력
  # x="a","b" -> 500
  # 함수 외부에서 접근 x <- 500
  # 함수 내부에서 접근 x <<- 500
}

#함수 호출문
minho5()

#변경된("500") 전역변수
x




##P70 조건문

#IF
x <- runif(1) #난수 생성 (random number)
x


#if 1형식
if(x > 0 )
  print(abs(x))   #abs=절대값


#if 2형식 (if-else)
if(x < 0.5)
  print(1-x) else
    print(x)


## java
# string aa = (a > 3) ? "커" : "안커" ;
# a가 3보다 크면 커를 aa에 넣고, 작으면 안커를 aa에 값을 넣는다.

#ifelse (3항 연산자)
ifelse(x < 0.5, 1-x, x)


##switch
# if else if else ..반복
# 다중if를 대체하기 위한 switch문
xxx <- c(1:10)
switch (xxx[2],
        "1" = print("one"),
        "2" = print("two"),
        "3" = print("three"),
        print("not")            #default
)


## 순환하며 더하기 1+2+...+10
sum <- 0
for(i in seq(1, 10, by=1))  #1,2,3,4...10
  sum = sum+i;            #1+2+3+4...+10
sum


##star wars
# *
# **
# ***
# ****
# *****


# cat("*\t") = System.printfl("%d\t",30)
# cat("\n") 줄바꿈

#행으로 5번 / 열은 1~5 증가

cat("★\t")
for(i in seq(1, 5, by=1)){            #1~5 행
  for(j in seq(1, i, by=1))           #1~5 열
    cat("★\t")
  cat("\n")                 #line skip
}


##while
i <- 0                #초기치
while (i <= 3 ) {     #목적치 0~3까지 총 4차례 babo 출력
  print("babo")
  i <- i+1            #증가치
}

## lotto 10 game
for(i in seq(1,10, by=1)){
  lotto2=c(sort(sample(1:45,6)))
  print(lotto2)
}

## 구구단 3단까지 출력
for(i in 1:3){
  for(j in 1:3){
    cat (j, "*", i, "=", j*i, "\t")
  }
  cat("\n")
}

##반복문 (무한루프)
i <- 0
repeat{
  i<- i+1
  print("ondal")
  if(i>3) break
}


##P77 function 저장

#win-java + win-R 할때 함수 저장 필요

#1. 저장할 함수 생성
myF <- function(x){
  return(x*x)
}

myF(2)

#2. 특별한 위치를 지정하지 않으면 워킹 디렉토리에 저장된다.
save(myF, file = "myF.Rdata")

#3. 함수 삭제
rm(myF)

#4. 함수 불러오기
load("myF.Rdata")


## java & C# GUI
# C#     - textbox
# java   - textfield

# textfield1, textfield2, textfield3..., textfield6
# 객체.속성 = 값
# textfield + i ==> textfield1, 2, 3..6


## R에서 x1=2, x2=5, x3=7.. 일정한 패턴이 있는 경우
# x1, x2, .. assign = 할당해서 값을 넣는다.
for(i in 1:10){
  assign(paste("x",i,sep = ""),i+10)    #x에 i를 더해서 객채명 생성
  #x+1->x1 여기에 1+10인 11을 넣고
  #assign(xi,11)로 처리됨 즉, x1이름에 값(11)을 넣는다.
  #x1~x10에 기억창고에 11~20의 값이 들어간다.
}
x1
x10


##keyboard input
#c언어의 scanf와 동일한 기능
#리눅스 = 소문자,대문자 구별한다.


fun <- function(){
  yn <-readline("y or n input :")   #입력신호 대기
  print(yn)
  
  if(substr(yn,1,1)=="n")           #1번째부터 한글자
    cat("input is n \n")
  else
    cat("input is y \n")
}

fun()


##data space data
#stringsplit기능

fun2 <- function(){
  yn2 <- readline("many data with space : ")
  unlist(strsplit(yn2," "))       #빈칸으로 잘라줌
  #빈칸이 많으면 빈칸도 " "로 묶인다.
}

fun2()




##menu display
fun3 <- function(){
  yn3 <- menu (c("jjajang", "jjambong", "mandoo"), title="메뉴를 선택하시오")
  
  if(yn3==1)
    cat("eat jjajang\n")
  else if(yn3==2)
    cat("eat jjambong\n")
  else
    cat("eat mandoo\n")
}

fun3()


##another input : group
# 이미 값이 들어간 변수를 이용해서 다른 변수에 값을 동일하게 넣어줄때 사용

k <- c("babo","ondal")
p <- get(readline())      #명령 실행시 커서가 입력을 대기한다.
#user input : k

p # 벡터 c가 p에 들어감





##P91 graph
#R GUI = R studio tool로 대체

#R = 통계+그래프

#1. 값 입력
abc <- c (260,300,250,280,310)
def <- c (180,200,210,190,170)
ghi <- c (210,250,260,210,270)



#plot graph
plot(abc,type = "o")    #abc 백터 자료를 가지고 type=o(dot-line double: 선이 점과 겹침) 형식에 그래프 생성

#c# .net(dotNET = ipadress + network)

plot(def,type = "s")    #def 백터 자료를 가지고 type=s(왼쪽 값을 시작으로 계단모양) 형식에 그래프 생성

plot(def,type = "b")    #def 백터 자료를 가지고 type=b(dot-line: 선과 떨어져있음) 형식에 그래프 생성


## graph를 jpg 파일로 redirect 하기
jpeg("p091_plot2.jpg")

#여러개의 그래프를 합쳐서 하나로 그리기
#par() 또는 layout 사용
#1행 3열로 배치


m <- par(mfrow=c(1,3))  #mfrow : row가 그려지는 순서 담당 1행3열
#mfcol : colomn이 그려지는 순간 담당
#c (nrows,ncols)를 의미하며 1*3개의 plot으로 분할

plot(abc, type = "o")
plot(def, type = "s")
plot(ghi, type = "b")

dev.off()               #그래프를 jpg파일로 redirect 하지말라





#그래프를 pdf 파일로 redirect 하라
pdf("p091_plot.pdf")

m <- par(mfrow=c(3, 1)) #3행 1열로 그림

plot(abc, type = "o")

#col-컬러 main-제목 sub-서브제목, xlab-x축 이름, ylab-y축 이름
plot(def, type = "s", col="blue", lty=6, main="그래프",
     sub="그래프라는", xlab="babo", ylab="ondal")
plot(ghi, type = "b")

dev.off()


plot(abc,type="o") # 점 모양 그래프
plot(abc,type="l") # 선 모양 그래프(꺾은선)
plot(abc,type="b") # 점과 선 모양 그래프
plot(abc,type="c") # "b"에서 점을 생략한 모양
plot(abc,type="o") # 점과 선을 중첩해서 그린 그래프
plot(abc,type="h") # 각 점에서 x축 까지의 수직선 그래프
plot(abc,type="s") # 왼쪽값을 기초로 계단모양으로 연결
plot(abc,type="S") # 오른쪽 값을 기초로 계단모양으로 연결
plot(abc,type="n") # 축만 그리고 그래프 그리지 않음


#graph 산포도 (x는 등차, y는 등비)
jpeg("p093_scatter.jpg")

x <- seq(1,10,0.1)        #1~10 0.1 gap
x
exp(1)      #e^1
exp(2)      #e^2
exp(9)      #e^9
exp(10)     #e^10

y <- exp(x) #e^x
y

plot(x,y)   #statistical dispersion
dev.off()


##내장 데이터 이용법
#data( 자동완성 중 Toothgrowth로 실습 )
data("ToothGrowth")

#앞부분
head(ToothGrowth)

#뒷부분
tail(ToothGrowth)

#구조
str(ToothGrowth)

#요약
summary(ToothGrowth)

#그래프
plot(ToothGrowth)





library(lattice)    #격자무늬(Trellis graphic) 그래프
#eg: xyplot/ bwplot / levelplot

bwplot(len ~ dose | supp, data = ToothGrowth)
# y축 ~ x축을 의미
# boxplot + wiskers(구렛나루)
# len-dose graph / supp
# if dose many, len, long
# 즉, 양이 많을 수록 길이가 길다
# 하한선과 상한선



##highchart
install.packages("highcharter")
install.packages("dplyr")
install.packages("tidyr")

#라이브러리 불러오기
library(highcharter)

aa <- c(1, 2, 3, 4, 5)

#같이 수행시켜야 하는 부분 (%>% 연결 표현)
highchart() %>%
  hc_add_series(aa)



#mtcars 활용 (산포도)
library(magrittr)
highchart() %>%
  hc_title(text = "chart") %>%
  hc_add_series_scatter(mtcars$wt, mtcars$mpg, mtcars$drat, mtcars$hp)


#막대그래프
highchart() %>%
  hc_chart( type = "column" ) %>%
  hc_title( text = "chart" ) %>%
  hc_xAxis( categories = 1998:2001 ) %>%
  hc_add_series( data = c(400, 500, 300, 200), name = "YEAR" )


##P97
abc <- c (260,300,250,280,310)
def <- c (180,200,210,190,170)
ghi <- c (210,250,260,210,270)

#최소값
min(abc, na.rm = TRUE)

#최대값
max(abc, na.rm = TRUE)





plot(abc, type = "o", col="red", ylim = c(0,400), axes = F, ann = F)
# type = "o" - dot-line
# col="red" - color=red
# ylim = c(0,400) - 0~400
# axes = F - x-y축 없음
# ann = f - title

#x-y axis 추가
axis(1, at=1:5, lab=c("a","b","c","d","e"))
axis(2, ylim=c(0,400))

#title 추가
title(main="Fruit", col.main="red", font.main=4,
      sub="kawil", col.sub="red")

title(xlab = "Day", col.lab=3)        #green
title(ylab = "Price", col.lab="blue")



#중첩 시키기
lines(def, type = "o", pch=21, col="green", lty=2)
lines(ghi, type = "o", pch=22, col="blue", lty=2)
#type = "o" - dot-line
#pch=21     - 21:rect 네모칸 내용
#lty=2      - dash 선



#범례
legend(4, 400, c("sakwa", "bae", "kam"), cex=0.8,
       col = c("red","green","#0000ff"), pch = 21, lty = 1:3)
#cex = 0.8 : dot scale(base=1)




plot(sin, -pi, pi, xlab="", ylab="", lty=2)
#par(new = TRUE)
par(new = TRUE)
plot(cos, -pi, pi, xlab="x", ylab="y")

#par(new = T) TRUE/T = sin, cos 같이 그래프를 그림
#par(new = T) FALSE/F = sin, cos 따로 그래프를 그림

library(magrittr)
highchart() %>%
hc_title(text ="mtcars chart") %>%
hc_xAxis(categories = mtcars$wt) %>%
hc_add_series(name="갤런",data=mtcars$mpg) %>%
hc_add_series(name="차축",data=mtcars$drat) %>%
hc_add_series(name="총마력",data=mtcars$hp)

highchart() %>%
hc_title(text="welcome") %>%# 제목
hc_subtitle(text ="test")  %>%# 소제목
hc_xAxis(categories = mtcars$wt)%>% #x축 레이블,스타일 변경         
hc_yAxis(categories = mtcars$gear)%>% #y축 레이블, 스타일 변경
hc_add_series_labels_values(mtcars$mpg, mtcars$hp, name = "hp",
                              colorByPoint = TRUE, type = "column") %>% 
hc_legend(align = "left", verticalAlign = "top",
            layout = "vertical", x = 0, y = 100) %>% 
hc_tooltip(crosshairs = TRUE, borderWidth = 5, sort = TRUE, table = TRUE)


hc_legend() #차트의 각 항목에 대한 심볼, 이름, 색상등 스타일 수정
hc_tooltip() # 도구 설명에 관한 옵션


#pie graph
kab <- c(320,500,700,400,100)
kab
pie(kab)


#----------------------label-----------------------------
pie(kab,init.angle = 90,col=rainbow(length(kab)),
    labels = c("mon","tue","wed","thr","fri"),
    clockwise = TRUE)

hap2 <- "babo"
hap3 <-"ondal"
(result1 <- paste(hap1,hap2,sep="/"))
(result1 <- paste(result1,hap3,sep=""))

install.packages("igraph")



pie3D(kab,main="week sell", col=rainbow(length(kab)),cex=0.8,labels = label1,explode = 0.1)
#col : 현재는 no clockwise(clockwiese는 시계방향이고 pie의 기본)
#       이므로 무지개 색깔이 시계반대방향으로 빨..주..노..초..보라
# init.angle = 90 : center start(시작되는 시점의 각도)


## win R - linux HIVE 연결
## (winR + win JAVA) +  linux HIVE
## 서로 다른 환경끼리 연결 = thrift
## hive에서 port 10000이 수행되어야 함

#1 리눅스 상태 확인
#[root@hadoopserver ~]. /etc/profile 실행 후
#[root@hadoopserver ~]jsp 후 6개 서비스가 구동되지 않으면
#[root@hadoopserver ~]start-all.sh로 서비스 구동

#2 리눅스 - hive 띄우기 (소요시간 걸림. 강제종료x)
#[root@hadoopserver ~] hive --service hiveserver2 --hiveconf hive.server2.thrift.port=10000 --hiveconf hive.root.logger=INFO,console

#3 리눅스 - 10000포트 확인
#[root@hadoopserver ~]# netstat -nl | grep 10000 체크
# = 결과 tcp6       0      0 :::10000                :::*                    LISTEN   
# 방화벽 해제
#[root@hadoopserver ~]# systemctl stop firewalld

#4 library 구축
# C:/java_hive_lib 안에는 linuxjava-hive에서 사용한 jar file.
# win에서 필요한 이유 : winJava - linux hive를 위해서


#5 win R에 패키지 설치
install.packages("RJDBC", dep = TRUE)
install.packages('rJava')

# Rserve package install
# winR ~ linuxHive와 연동을 하귀 위해 필요 (이때 사용 되는 포트는 6311 필요)
install.packages("Rserve")

# rJava package / Rserve package 중요
# 위치 : C:/Program Files/R/R-3.4.3/library


#6 Rserve remote
Rserve::Rserve(args="--RS-enable-remote")

shortest.paths(TR,mode="in")

install.packages("KoNLP")
library(KoNLP)
library(wordcloud)
install.packages("wordcloud")

content1<-readLines("review.txt")
content1
word1<-sapply(content1,extractNoun,USE.NAMES = FALSE)
word1

cdata1<-unlist(word1)
cdata1

tail(cdata1)
wordcount1<-table(cdata1)
wordcount1

txt <- readLines("review.txt")
place <- sapply(txt, extractNoun, USE.NAMES = F)
place

c <- unlist(place)

c<- gsub('[~!@#$%&*()_+=?<>^]','',c)
c <- gsub('[ㄱ-ㅎ]','',c)
c<- gsub('(ㅜ|ㅠ)','',c)
c <- gsub("\\d+","",c)

place <- Filter( function(x) { nchar(x) >=2}, c)
write( unlist(place), "output.txt" )
rev <- read.table("output.txt")
wordcount <- table(rev)

wordcount <- table(rev)
wordcount
wordcount_top <-head(sort(wordcount, decreasing = T),60)
palete <- brewer.pal(9, "Set1")

wordcloud(names(wordcount_top), wordcount_top, scale = c(2, 1), rot.per = 0.25, min.freq = 1,
          random.order = FALSE, random.color = TRUE, colors = palete)


install.packages("RColorBrewer")
library(wordcloud)
library(RColorBrewer)
library(KoNLP)

wordcount <- table(rev)
wordcount
wordcount_top <-head(sort(wordcount, decreasing = T),60)
wordcloud(names(wordcount_top), wordcount_top)

rev<- gsub('[~!@#$%&*()_+=?<>^]','',rev)
rev <- gsub('[ㄱ-ㅎ]','',rev)
rev<- gsub('(ㅜ|ㅠ)','',rev)
rev <- gsub("\\d+","",rev)



tmp<-unlist(wordcount1)
tmp
place <- sapply(txt, extractNoun, USE.NAMES = F)
write( tmp, "output.txt" )
rev<-read.table("output.txt")
rev

install.packages("igraph")
library(igraph)

#"종각", "종로3가", "종로5가", "동대문",
#  1        2           3         4   
#"시청", "을지로입구", "을지로3가", "을지로4가", "동대문역사문화공원",
#   5         6             7           8              9
# "서울역","회현", "명동", "충무로", "동대입구", "약수"
#   10        11      12      13        14          15

TR2<-graph(c(1,2,2,1,1,7, 2,3,3,2, 1,14, 15,14, 3,4, 4,5, 6,7, 7,8, 8,9, 8,10, 9,10, 10,3, 11,4, 12,3, 13,10, 14,1, 14,15))

V(TR2)$name<-c("종각", "종로3가", "종로5가", "동대문",
               "시청", "을지로입구", "을지로3가", "을지로4가", "동대문역사문화공원",
               "서울역","회현", "명동", "충무로", "동대입구", "약수")

plot(TR2, layout=layout.kamada.kawai,
     vertex.label=V(TR2)$name)

degree(TR2, mode="in")
degree(TR2, mode="out")
get.shortest.paths(TR2, from=15, to=5, mode="out")
