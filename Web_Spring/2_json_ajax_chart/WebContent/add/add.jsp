<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
    //System.out.println(request.getParameter("p1"));
    //System.out.println(request.getParameter("p2"));
    int p1 = Integer.parseInt(request.getParameter("p1"));
    int p2 = Integer.parseInt(request.getParameter("p2"));
    int result = p1+p2;
    Thread.sleep(7000); //비동기식이 가능한지 테스트 해 보기 위함! 잠깐 슬립 걸어놓는 동안 아래 addclass/remove버튼 다 동작함!
    //앞으로 데이터 베이스와 연동해서 사용하다보면 실제로 로딩시간이 길어짐. 그럴때 동기식이라면 응답을 받기전까지 아무것도 할 수 없게됨.
    //응답을 기다리는 동안에도 다른 일을 수행하게 하려고 ajax를 쓰는 것! 
%>

{
  "result" : <%=result %>,
  "p1" : <%=p1 %>,
  "p2" : <%=p2 %>
}
