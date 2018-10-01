conn system/1234
drop user 유저네임 cascade
create user 유저네임 identified by Password;
grant connect,resource,dba to 유저네임;

게시판 프로그램 관련 SQL

conn 유저네임/Password
users 테이블 생성

sqlplus java01/1234
conn java01/1234

drop table users cascade CONSTRAINT;

users 테이블 생성
drop table users;
drop table users cascade CONSTRAINT;

create table users(
     id         varchar2(8) primary key,
     name       varchar2(20) not null,
     pw       varchar2(8) not null,
     role          varchar2(5) default 'User'
);

insert into users values('java01','홍길동','1234',default);
insert into users (id,pw,name) values('java02','1234','고길동');
commit;

select * from users;


drop table userinfo;
create table userinfo (
     id         varchar2(8) primary key,
     name       varchar2(20) not null,
     pw       varchar2(8) not null,
     role          varchar2(5) default 'User'
);

insert into users values('java01','홍길동','1234',default);
insert into users (id,pw,name) values('java02','1234','고길동');
commit;




board 테이블 생성
drop table board;
create table board(
     seq         number(5) primary key,
     title       varchar2(100) not null,
     writer      varchar2(30) not null,
     content     varchar2(2000) not null,
     regdate     date  default sysdate,
     cnt         number(5) default 0,
     userid      varchar2(8),
     constraint board_userid_fk FOREIGN KEY(userid) REFERENCES users(id)
);



insert into board values(1,'연습용01','나그네','.... 잘보고갑니다.',sysdate,default,'java01');

insert into board (seq,title,writer,content,userid)values(4,'연습용01','나그네','.... 잘보고갑니다.','java01');

select * from board;
commit;



insert into board (seq,title,writer,content,userid)
    values((select nvl(max(seq),0)+1 from board),'연습용01','나그네','.... 잘보고갑니다.','java02');

    
update board set title = ?,content = ? where seq = ?

delete from board where seq=?

select seq,regdate,userid from board;

select * from board;


데이터검색(Query)

select * from board;
select title,writer,regdate,cnt from board;
select title,writer,regdate,cnt from board 
             where regdate between '12/01/01' and '12/06/30';


select b.title,b.writer,b.regdate,b.cnt,u.id from users u,board b
     where u.id=b.userid and u.name='홍길동' order by b.seq desc;

select title,writer,b.regdate,b.cnt,u.id from users u,board b
     where u.id=b.userid and u.name='홍길동' order by b.seq desc;


select count(*) as "등록글 수"  from board;



select count(*) as "등록글 수"  from users u,board b 
                  where u.id=b.userid and u.name='홍길동'

select*  from board where title like'%연%';

select b.*  from users u,board b 
                  where u.id=b.userid and u.name='고길동' and title like'%연%';


select u.name "사용자명" , count(*) as "등록글 수"  from users u,board b 
                  where u.id=b.userid group by u.name;


select u.name "사용자명" , count(*) as "등록글 수"  from users u,board b 
                  where u.id=b.userid group by u.name having count(*)>=4;

select Month "월" , count(*) as "게시글 수" 
    from( select to_char(regdate,'MM') Month from board) 
    group by Month order by 월;  


select seq from board order by seq desc;

select seq from (
   select seq ,title, rownum ROW# from ( select * from board order by seq desc)
) where ROW# between 4 and 6;
