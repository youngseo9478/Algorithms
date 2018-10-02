#RHIVE 연동을 위해 필요한 라이브러리
install.packages('DBI')
install.packages('rJava')
install.packages('RJDBC')

library(DBI)
library(rJava)
library(RJDBC)

path <- list.files(path = c('C:\\hive_jar'),pattern ='jar', full.names=T)

.jinit(classpath = path)

drv <- JDBC('org.apache.hive.jdbc.HiveDriver')
conn <- dbConnect(drv, 'jdbc:hive2://192.168.111.201:10000', '', '')
data <- dbGetQuery(conn, 'SELECT * FROM dept')
str(data)
# ?str


install.packages('Rserve')
library(Rserve)
# ?Rserve

# Rserve(debug = F, port = 6311, args = '--no-save')
Rserve(debug = F, port = 7002, args = '--RS-encoding utf-8 --no-save --encoding utf8 --RS-enable-remote')


install.packages("corrplot")
mtcars
mcor <- cor(mtcars)
library(corrplot)
png('result.png')
corrplot(mcor)
dev.off()


# 구글맵 패키기 인스톨
install.packages('ggmap')
library(ggmap)
# plot도 예쁜거 쓸라면 ggplot 써보기 

cctv <- read.csv('C://R/_project_gangbuk_data.csv')
# str(cctv)
g_m <- get_map('gangbukgu',zoom=13,maptype = 'roadmap')
cctv.map <- ggmap(g_m) + geom_point(data = cctv, aes(x=LON, y=LAT),
                                    size = 2, alpha = 0.7, color = '#980000')
cctv.map
ggsave(file='map_result.png')




















