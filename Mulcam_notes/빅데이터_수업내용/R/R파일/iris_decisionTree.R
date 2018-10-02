ind <- sample(2,nrow(iris), replace = T, prob = c(0.7,0.3))
ind
trainData <- iris[ind==1,]
testData <- iris[ ind==2,]
trainData
testData

str(iris)
install.packages("party")
library(party)
myFormula <- Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width
iris_ctree <- ctree(myFormula,data = trainData)
iris_ctree
plot(iris_ctree, type="simple")

testPred <-predict(iris_ctree,newdata=testData)
testPred
testData$Species
result<-data.frame(pred=testPred,real=testData$Species)
table(result)
