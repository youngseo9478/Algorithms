###lattice
##graph
data("ToothGrowth")
head(ToothGrowth)
str(ToothGrowth)
summary(ToothGrowth)
plot(ToothGrowth)


plot(ToothGrowth$len,ToothGrowth$dose)  # 2 item select

###lattice패키지 2
data("quakes")
head(quakes)
# lat   long depth mag stations
# 1 -20.42 181.62   562 4.8       41
# 2 -20.62 181.03   650 4.2       15
# 3 -26.00 184.10    42 5.4       43
# 4 -17.97 181.66   626 4.1       19
# 5 -20.42 181.96   649 4.0       11
# 6 -19.68 184.31   195 4.0       12
str(quakes)
# 'data.frame':	1000 obs. of  5 variables:
#   $ lat     : num  -20.4 -20.6 -26 -18 -20.4 ...
# $ long    : num  182 181 184 182 182 ...
# $ depth   : int  562 650 42 626 649 195 82 194 211 622 ...
# $ mag     : num  4.8 4.2 5.4 4.1 4 4 4.8 4.4 4.7 4.3 ...
# $ stations: int  41 15 43 19 11 12 43 15 35 19 ...
summary(quakes)
# lat              long           depth            mag      
# Min.   :-38.59   Min.   :165.7   Min.   : 40.0   Min.   :4.00  
# 1st Qu.:-23.47   1st Qu.:179.6   1st Qu.: 99.0   1st Qu.:4.30  
# Median :-20.30   Median :181.4   Median :247.0   Median :4.60  
# Mean   :-20.64   Mean   :179.5   Mean   :311.4   Mean   :4.62  
# 3rd Qu.:-17.64   3rd Qu.:183.2   3rd Qu.:543.0   3rd Qu.:4.90  
# Max.   :-10.72   Max.   :188.1   Max.   :680.0   Max.   :6.40  
# stations     
# Min.   : 10.00  
# 1st Qu.: 18.00  
# Median : 27.00  
# Mean   : 33.42  
# 3rd Qu.: 42.00  
# Max.   :132.00  
plot(quakes)
# 혹시 안나오면 library(lattice)해줘야 한다.
##quakes --> R이 갖고 있는 데이터
##피지에서 지진의 위치
#MB>4.0의 1000개의 지진 발생 이벤트의 위치를 제공
#사건은 1964년 이후 피지 근처의 큐브에서 발생
#5개의 변수에 대한 1000개의 관측치가 있는 데이터 프레임
#[,1]lat 위도
#[,2]long 경도
#[,3]depth 깊이(km)
#[,4]mag 리히터 크기(지진의 크기)
#[,5]stations 지진관측소 수


# factor()의 특징 : 범주형자료이다.(4장 참조)
sung<-c("남","여","남","남","여")
sung
#[1] "남" "여" "남" "남" "여"
#Levels : 남 여   #내부 계산 시 남1 여2로 처리

#데이터 마이닝 (data mining) - 현재 주어진 자료를 분석해서 미래를 예측하는 일









install.packages("KoNLP") #한글처리위해
library(KoNLP)

content1<-readLines("proposeMY.txt")
content1
# [1] "철수가 영희를 만나 사랑한다고 하자"                 
# [2] "영희는 화를 냈다"                                   
# [3] "\"어떻게 사랑하는 사람이 그럴수 있어요\""           
# [4] "영희가 화를 내자 철수는 무릎을 꿇었다"              
# [5] "그리고 조용히 품에서 반지 상자를 꺼내 영희의 "      
# [6] "손에 끼워주었다"                                    
# [7] "그리고 나지막하지만 진정이 담긴 목소리로 "          
# [8] "속삭였다 "                                          
# [9] "\"나랑 결혼해 줄래...\""                            
# [10] "영희는 반지를 보자 너무나 기뻤다 사실"              
# [11] "철수가 자신과 결혼할 생각이 없는 것처럼"            
# [12] "하는 것이 제일 맘이 상한 이유였다"                  
# [13] "이제는 앞에있는 나무가 나에게 인사하는 말이 들리고 "
# [14] "하늘의 구름이 그렇게포근할 수가 없었다 " 

# 데이터 중심에서 명사만 골라서 할당
# KoNLP 에서 제공하는 extractNoun을 사용하여 명사 추출
# 사실 ...명사만 고르지는 않음
word1<-sapply(content1, extractNoun, USE.NAMES = FALSE)
word1
# [[1]]
# [1] "철수"   "영희를" "사랑"  
# 
# [[2]]
# [1] "영희는" "화"     "냈"    
# 
# [[3]]
# [1] "사랑" "사람" "수"  
# 
# [[4]]
# [1] "영희가" "화"     "내"     "철수"   "무릎"   "꿇었"  
# 
# [[5]]
# [1] "반지" "상자" "영희" "의"  
# 
# [[6]]
# [1] "손"       "끼워주었"
# 
# [[7]]
# [1] "나지막" "진정"   "목소리" "로"    
# 
# [[8]]
# [1] "속삭였"
# 
# [[9]]
# [1] "나"   "결혼" "해"  
# 
# [[10]]
# [1] "영희는" "반지"   "실"    
# 
# [[11]]
# [1] "철수" "자신" "결혼" "생각" "것처" "럼"  
# 
# [[12]]
# [1] "것"     "제"     "이유였"
# 
# [[13]]
# [1] "앞에있는" "나무"     "나"       "인사"     "말"       "리"      
# 
# [[14]]
# [1] "하늘"         "구름"         "그렇게포근할" "수"           "없었"   


## 필터링을 위해 unlist 작업을 해서 저장
cdata1 <- unlist(word1)
cdata1
# [1] "철수"         "영희를"       "사랑"         "영희는"       "화"          
# [6] "냈"           "사랑"         "사람"         "수"           "영희가"      
# [11] "화"           "내"           "철수"         "무릎"         "꿇었"        
# [16] "반지"         "상자"         "영희"         "의"           "손"          
# [21] "끼워주었"     "나지막"       "진정"         "목소리"       "로"          
# [26] "속삭였"       "나"           "결혼"         "해"           "영희는"      
# [31] "반지"         "실"           "철수"         "자신"         "결혼"        
# [36] "생각"         "것처"         "럼"           "것"           "제"          
# [41] "이유였"       "앞에있는"     "나무"         "나"           "인사"        
# [46] "말"           "리"           "하늘"         "구름"         "그렇게포근할"
# [51] "수"           "없었"    

tail(cdata1) #너무 길까봐 끝에만 보기 위해~
# [1] "리"           "하늘"         "구름"         "그렇게포근할" "수"          
# [6] "없었" 

wordcount1<-table(cdata1) #count 출력을 위해
wordcount1
# 것         것처         결혼         구름 그렇게포근할         꿇었 
# 1            1            2            1            1            1 
# 끼워주었           나         나무       나지막           내           냈 
# 1            2            1            1            1            1 
# 럼           로           리           말       목소리         무릎 
# 1            1            1            1            1            1 
# 반지         사람         사랑         상자         생각       속삭였 
# 2            1            2            1            1            1 
# 손           수           실     앞에있는         없었         영희 
# 1            2            1            1            1            1 
# 영희가       영희는       영희를           의       이유였         인사 
# 1            2            1            1            1            1 
# 자신           제         진정         철수         하늘           해 
# 1            1            1            3            1            1 
# 화 
# 2 

#너무 많을때는 sort해서 20줄만 보기도 가능!
#카운트를 기준으로 내림차순 , 카운트가 sortkey
wordcount1<-head(sort(wordcount1,decreasing = TRUE),20)
wordcount1
# 철수         결혼           나         반지         사랑           수 
# 3            2            2            2            2            2 
# 영희는           화           것         것처         구름 그렇게포근할 
# 2            2            1            1            1            1 
# 꿇었     끼워주었         나무       나지막           내           냈 
# 1            1            1            1            1            1 
# 럼           로 
# 1            1 



#------------------워드클라우드(p.220)
install.packages("wordcloud")
library(wordcloud) # 설치한 패키지 로

#세종 사전을 사용함
useSejongDic() #실행하면 다운로드 시작!
#참고 backup was just finished!.....뭐라머라 꽤 걸림
#     370957 words dictionary was built 이거 나오고 > 나오면 끝!
txt<-readLines("proposeMY.txt")
place<-sapply(txt,extractNoun,USE.NAMES = F)
place

#추출된 명사를 30개만 출력해봄
head(unlist(place),30)
# [1] "철수"     "영희를"   "사랑"     "영희는"   "화"       "냈"      
# [7] "사랑"     "사람"     "수"       "영희가"   "화"       "내"      
# [13] "철수"     "무릎"     "꿇었"     "반지"     "상자"     "영희"    
# [19] "의"       "손"       "끼워주었" "나지막"   "진정"     "목소리"  
# [25] "로"       "속삭였"   "나"       "결혼"     "해"       "영희는" 

#필터링을 위해 unlist 작업을 해서 저장
c<-unlist(place)
c
# [1] "철수"         "영희를"       "사랑"         "영희는"       "화"          
# [6] "냈"           "사랑"         "사람"         "수"           "영희가"      
# [11] "화"           "내"           "철수"         "무릎"         "꿇었"        
# [16] "반지"         "상자"         "영희"         "의"           "손"          
# [21] "끼워주었"     "나지막"       "진정"         "목소리"       "로"          
# [26] "속삭였"       "나"           "결혼"         "해"           "영희는"      
# [31] "반지"         "실"           "철수"         "자신"         "결혼"        
# [36] "생각"         "것처"         "럼"           "것"           "제"          
# [41] "이유였"       "앞에있는"     "나무"         "나"           "인사"        
# [46] "말"           "리"           "하늘"         "구름"         "그렇게포근할"
# [51] "수"           "없었" 

#두 글자 이상 되는 것만 필터링하기
place<-Filter(function(x) {nchar(x) >=2},c)
place
# [1] "철수"         "영희를"       "사랑"         "영희는"       "사랑"        
# [6] "사람"         "영희가"       "철수"         "무릎"         "꿇었"        
# [11] "반지"         "상자"         "영희"         "끼워주었"     "나지막"      
# [16] "진정"         "목소리"       "속삭였"       "결혼"         "영희는"      
# [21] "반지"         "철수"         "자신"         "결혼"         "생각"        
# [26] "것처"         "이유였"       "앞에있는"     "나무"         "인사"        
# [31] "하늘"         "구름"         "그렇게포근할" "없었"

#원하지 않는 내용 걸러내기
place<-gsub("철수","",place)
place<-gsub("영희","",place)
place
# [1] ""             "를"           "사랑"         "는"           "사랑"        
# [6] "사람"         "가"           ""             "무릎"         "꿇었"        
# [11] "반지"         "상자"         ""             "끼워주었"     "나지막"      
# [16] "진정"         "목소리"       "속삭였"       "결혼"         "는"          
# [21] "반지"         ""             "자신"         "결혼"         "생각"        
# [26] "것처"         "이유였"       "앞에있는"     "나무"         "인사"        
# [31] "하늘"         "구름"         "그렇게포근할" "없었"

#파일로 저장한 후, 테이블 형태로 변환하여 불러온다.
write(unlist(place),"proposeMY2.txt")

#수정 완료된 파일을 table 형식으로 변환하여 다시 불러온다.
rev<-read.table("proposeMY2.txt")
rev
V1
# 1            를
# 2          사랑
# 3            는
# 4          사랑
# 5          사람
# 6            가
# 7          무릎
# 8          꿇었....이런식으로 나옴

#text 형태로 결과를 확인
nrow(rev) #데이터 건수의 확
# [1] 30

wordcount<-table(rev) # 테이블 형태로 변환하여 워드카운트
wordcount
# 가         것처         결혼         구름 그렇게포근할         꿇었 
# 1            1            2            1            1            1 
# 끼워주었         나무       나지막           는           를       목소리 
# 1            1            1            2            1            1 
# 무릎         반지         사람         사랑         상자         생각 
# 1            2            1            2            1            1 
# 속삭였     앞에있는         없었       이유였         인사         자신 
# 1            1            1            1            1            1 
# 진정         하늘 
# 1            1 

head(sort(wordcount, decreasing = TRUE),30) # 상위 30개의 ...

########-----------
#그래픽 출력을 위한 라이브러리 로드
library(RColorBrewer)

#RColorBrewer 패키지의 모든 색 확인해보기
display.brewer.all(n=10,exact.n = FALSE) #ZOOM 시켜 확
display.brewer.pal(9,"Set1") # Set9개 색상보기

#카테고리별 보기
op<-par(mfrow=c(1,3)) #1행 3열로 보기- 한꺼번에
display.brewer.all(type="div")
display.brewer.all(type="seq")
display.brewer.all(type = "qual")

brewer.pal.info
# maxcolors category colorblind
# BrBG            11      div       TRUE
# PiYG            11      div       TRUE
# PRGn            11      div       TRUE
# PuOr            11      div       TRUE
# RdBu            11      div       TRUE
# RdGy            11      div      FALSE
# RdYlBu          11      div       TRUE
# RdYlGn          11      div      FALSE
# Spectral        11      div      FALSE
# Accent           8     qual      FALSE
# Dark2            8     qual       TRUE
# Paired          12     qual       TRUE
# Pastel1          9     qual      FALSE
# Pastel2          8     qual      FALSE
# Set1             9     qual      FALSE
# Set2             8     qual       TRUE
# Set3            12     qual      FALSE
# Blues            9      seq       TRUE
# BuGn             9      seq       TRUE
# BuPu             9      seq       TRUE
# GnBu             9      seq       TRUE
# Greens           9      seq       TRUE
# Greys            9      seq       TRUE
# Oranges          9      seq       TRUE
# OrRd             9      seq       TRUE
# PuBu             9      seq       TRUE
# PuBuGn           9      seq       TRUE
# PuRd             9      seq       TRUE
# Purples          9      seq       TRUE
# RdPu             9      seq       TRUE
# Reds             9      seq       TRUE
# YlGn             9      seq       TRUE
# YlGnBu           9      seq       TRUE
# YlOrBr           9      seq       TRUE
# YlOrRd           9      seq       TRUE

palette<-brewer.pal(9,"Set1") #글자색 지정
palette
# [1] "#E41A1C" "#377EB8" "#4DAF4A" "#984EA3" "#FF7F00" "#FFFF33" "#A65628"
# [8] "#F781BF" "#999999"

wordcloud(names(wordcount), freq = wordcount,
          scale = c(3,0,5), rot.per = 0.25, min.freq = 1,
          random.order = FALSE, random.color = TRUE, colors = palette)
#만일 warning이 나오면 warnings() 입력하면 이유를 알려줌
#주로 scale(폰트크기(1-7))을 줄이거나 늘리면 됨
#scale:폰트크기 scale(MAX,MIN)을 의미
#rot.per : 로테이션되는 word 빈도
#min.freq : 출력되는 워드의 최소빈도
#random.order=F : 많이 나오는 워드를 중앙으로 배치
#random.color=T : 실행할 때 워드색 변화 true

#jpeg로 저장~
jpeg(filename = "proposeMY.jpg",
     width = 480, height = 480)



#######웹 크롤링@@@@@!!!
## web crawling or web scraping으로 그려보는 wordcloude
# web scraping is a computer software technique of extracting information from websites
# 언론사, 페이스북 등 모두 가능
# 검색기능에는 검색로봇이 있음, 제한된 범위를 넘어서면 법적으로 문제됨.
install.packages("XML")
library(XML)
library(stringr)

#html구조 그대로 받아서 긁어온다. (웹사이트소스보기같은형식)
#한국일보의 경우 P태그를 이용해서 글을 쓴다. 이건 사이트마다 차이 있음
t<-htmlTreeParse("http://hankookilbo.com",
                 useInternalNodes = TRUE, trim = TRUE)
t   #한글깨지는건 신경쓰지말기. 어차피 알아서 처리됨

#순수한 글내용만 필요하므로 p태그를 날려야 함
content2<-xpathSApply(t,"//p",xmlValue)
content2
# [273] "김성태 “준표 때리기 토크쇼로 한국당 이미지 ..."                                                                                                                                                                                     
# [274] "\r\n                                        "                                                                                                                                                                                        
# [275] "\r\n                                        "                                                                                                                                                                                        
# [276] "아동수당 대상 238만명… 소득 따라 월 2만..."                                                                                                                                                                                         
# [277] "\r\n                                        "                                                                                                                                                                                        
# [278] "\r\n                                        "                                                                                                                                                                                        
# [279] "팀 킴, 컬링 한일전 또 승리… 6강 진출 확정"                                                                                                                                                                                          
# [280] "\r\n                                        "                                                                                                                                                                                        
# [281] "\r\n                                        "                                                                                                                                                                                        
# [282] "트럼프 ‘러시아 스캔들’ 담당 다우드 변호사 사임"                                                                                                                                                                                    
# [283] "\r\n                                        "                                                                                                                                                                                        
# [284] "\r\n                                        "                                                                                                                                                                                        
# [285] "손질 생홍합서 마비 일으키는 독소 검출"                                                                                                                                                                                               
# [286] "\r\n                                        "                                                                                                                                                                                        
# [287] "\r\n                                        "                                                                                                                                                                                        
# [288] "[포토]자유한국당, 지방선거용 기획수사 중단하라"                                                                                                                                                                                      
# [289] "\r\n                                        "                                                                                                                                                                                        
# [290] "Copyright © The Hankook-Ilbo All rights reserved"


library(KoNLP)
library(wordcloud)
#library(stringr)  # <-패키지를 로딩합니다.

useSejongDic()
word2 <- sapply(content2,extractNoun, USE.NAMES = F)
word2
# [[286]]
# [1] "\r\n                                        "
# 
# [[287]]
# [1] "\r\n                                        "
# 
# [[288]]
# [1] "[포토]자유한국당" "지방"             "선거용"           "기획"            
# [5] "수사"             "중단"             "라"              
# 
# [[289]]
# [1] "\r\n                                        "
# 
# [[290]]
# [1] "Copyright" "©"         "The"       "Hankook"   "Ilbo"      "All"      
# [7] "rights"    "reserve"   "d"   ###뭐 이런식으루 나온다.

cdata2<-unlist(word2)
cdata2
# [854] "Hankook"                                                                                                                                                                                                     
# [855] "Ilbo"                                                                                                                                                                                                        
# [856] "All"                                                                                                                                                                                                         
# [857] "rights"                                                                                                                                                                                                      
# [858] "reserve"                                                                                                                                                                                                     
# [859] "d"   ###이런식..!

#주요 기사를 보고싶은데 불필요한 정보가 너무 많음 줄바꿈이나 copyright 같은거까지..!
#필요한 정보만으로 wordcloud 그리기

#정규 표현식 regular expression  
#가-힣 으로 시작아닌(^) 모든 문자
#영어, 숫자, 특수문자가 전부 "" 로 대체된다.
cdata2<-str_replace_all(cdata2,"[^[가-힣]]","")
cdata2<-str_replace_all(cdata2,"한국일보닷컴","")
cdata2<-str_replace_all(cdata2,"한국일보","")
cdata2<-str_replace_all(cdata2,"보기","")
cdata2
# [808] "대상"             ""                 "만"              
# [811] "명"               "소득"             "월"              
# [814] ""                 ""                 ""                
# [817] "팀"               "컬링"             "한"              
# [820] "전"               "승리"             "강"              
# [823] "진출"             "확"               ""                
# [826] ""                 "트럼프"           "러시아"          
# [829] "스캔들"           "담당"             "다우"            
# [832] "드"               "변호사"           "임"              
# [835] ""                 ""                 "손질"            
# [838] "생홍합서"         "마비"             "독소"            
# [841] ""                 ""                 "포토자유한국당"  
# [844] "지방"             "선거용"           "기획"            
# [847] "수사"             "중단"             "라"              
# [850] ""                 ""                 ""                
# [853] ""                 ""                 ""                
# [856] ""                 ""                 ""                
# [859] ""     

cdata2<-Filter(function(x) {nchar(x) >=2}, cdata2)
write(unlist(cdata2),"imsi.txt")
imsi2<-read.table("imsi.txt")
(wordcount2<-table(imsi2))
# 하게             학교             학력           학부모 
# 1                1                1                1 
# 한국           한국당         한국만평         한국에서 
# 2                2                1                1 
# 한부모             행복             호소             호킹 
# 2                1                1                1 
# 혼란       홀로코스트           홍준표             확인 
# 2                1                1                1 
# 황영식             회원             회장 
# 1                1                1 

#정렬까지 해보면
wordcount2<-head(sort(wordcount2,decreasing = TRUE),20)
wordcount2
# 대통령     구속     측근     발뺌     가족   개헌안   구치소     단독 
# 6        5        5        4        3        3        3        3 
# 대상     영장     이유     이윤     인사     컬링   피해자     감독 
# 3        3        3        3        3        3        3        2 
# 검찰 경진대회     고려     고향 
# 2        2        2        2 


library(plotrix)
#한국일보의 20180323의 주요 뉴스 키워드 클라우드!!
wordcloud(names(wordcount2),freq = wordcount2,
          scale = c(3,0,5), rot.per = 0.35, min.freq = 2,
          random.order = FALSE, random.color = TRUE,
          colors = rainbow(10))

legend(0.2,1,"뉴스로 바라본 wordcloud",
       cex=1.2, bg="white",fill=NA, border=NA,
       text.col="red",text.font=0.5,box.col="blue")

#save-img- wordcloud_webcrawling.jpgfh wjwkd
jpeg(filename = "wordcloud_webcrawling.jpg",
     width = 480, height = 600)


###########주사위 던지기 시뮬레이션 (p.207)
die<-function(n){
  count1<-0
  count2<-0
  count3<-0
  count4<-0
  count5<-0
  count6<-0
  
  for(i in 1:n){
    
    #0~1 사이의 숫자를 뽑고, 여기에 6을 곱하고, 소수점 이하를 버린다.
    # 그러면 0이 나오는 경우가 있으므로 1을 더한다
    x<-(trunc(runif(1)*6)+1)
    
    #나온 숫자를 보여준다.
    cat("x is",x,"\n")
    
    #숫자별로 변수에 더한다.
    if(x==1) count1=count1+1
    if(x==2) count2=count2+1
    if(x==3) count3=count3+1
    if(x==4) count4=count4+1
    if(x==5) count5=count5+1
    if(x==6) count6=count6+1
  } #for-end
  
  #결과를 표시한다
  cat(" 1 number occurs : ",count1,"\n")
  cat(" 2 number occurs : ",count2,"\n")
  cat(" 3 number occurs : ",count3,"\n")
  cat(" 4 number occurs : ",count4,"\n")
  cat(" 5 number occurs : ",count5,"\n")
  cat(" 6 number occurs : ",count6,"\n")
}

die(10)
# x is 5 
# x is 2 
# x is 6 
# x is 1 
# x is 3 
# x is 4 
# x is 4 
# x is 1 
# x is 2 
# x is 3 
# 1 number occurs :  2 
# 2 number occurs :  2 
# 3 number occurs :  2 
# 4 number occurs :  2 
# 5 number occurs :  1 
# 6 number occurs :  1 


die(1000)   #수행횟수가 많아질수록 값이 비슷해진다.
#~~~~수행하고
# 1 number occurs :  159 
# 2 number occurs :  181 
# 3 number occurs :  178 
# 4 number occurs :  166 
# 5 number occurs :  160 
# 6 number occurs :  156 


###########의사결정트리(p.214)
install.packages("rpart")
install.packages("rpart.plot")

#사용을 위한 준비
library(rpart)
library(rpart.plot)
library(plotrix)
#아이리스 꽃에 대한 데이터
iris

head(iris)
# Sepal.Length Sepal.Width Petal.Length Petal.Width Species
# 1          5.1         3.5          1.4         0.2  setosa
# 2          4.9         3.0          1.4         0.2  setosa
# 3          4.7         3.2          1.3         0.2  setosa
# 4          4.6         3.1          1.5         0.2  setosa
# 5          5.0         3.6          1.4         0.2  setosa
# 6          5.4         3.9          1.7         0.4  setosa

#Species를 기반으로 데이터를 분리한다
m1<-rpart(Species~.,data=iris)
m1
# n= 150 
# 
# node), split, n, loss, yval, (yprob)
# * denotes terminal node
# 
# 1) root 150 100 setosa (0.33333333 0.33333333 0.33333333)  
# 2) Petal.Length< 2.45 50   0 setosa (1.00000000 0.00000000 0.00000000) *
#   3) Petal.Length>=2.45 100  50 versicolor (0.00000000 0.50000000 0.50000000)  
# 6) Petal.Width< 1.75 54   5 versicolor (0.00000000 0.90740741 0.09259259) *
#   7) Petal.Width>=1.75 46   1 virginica (0.00000000 0.02173913 0.97826087) *

#분리된 데이터 정보가 읽기 어렵기 때문에, 이것을 그래프로!
prp(m1,type = 4, extra = 1, digits = 3)


#####################################
#########       과제


#----------------------곡성 대본으로 해보기!
library(KoNLP)

content2<-readLines("wailing.txt")
content2

word2<-sapply(content2, extractNoun, USE.NAMES = FALSE)
word2

cdata2 <- unlist(word2)
cdata2

#두 글자 이상 되는 것만 필터링하기
place1<-Filter(function(x) {nchar(x) >=2},cdata2)
place1

#파일로 저장한 후, 테이블 형태로 변환하여 불러온다.
write(unlist(place1),"wailing2.txt")


#수정 완료된 파일을 table 형식으로 변환하여 다시 불러온다.
rev1<-read.table("wailing2.txt")
rev1

nrow(rev1) #데이터 건수의 확인

wordcount3<-table(rev1) # 테이블 형태로 변환하여 워드카운트
wordcount3

head(sort(wordcount3, decreasing = TRUE),30) # 상위 30개의 ...

#그래픽 출력을 위한 라이브러리 로드
library(RColorBrewer)
palette<-brewer.pal(9,"Set1") #글자색 지정
palette

library(wordcloud)
wordcloud(names(wordcount3), freq = wordcount,
          scale = c(3,0,5), rot.per = 0.25, min.freq = 1,
          random.order = FALSE, random.color = TRUE, colors = palette)

#jpeg로 저장~
jpeg(filename = "wailing.jpg",
     width = 480, height = 480)


########################################
###   지하철 과제






