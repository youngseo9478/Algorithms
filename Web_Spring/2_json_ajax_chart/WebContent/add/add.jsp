<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
    //System.out.println(request.getParameter("p1"));
    //System.out.println(request.getParameter("p2"));
    int p1 = Integer.parseInt(request.getParameter("p1"));
    int p2 = Integer.parseInt(request.getParameter("p2"));
    int result = p1+p2;
    Thread.sleep(7000); //�񵿱���� �������� �׽�Ʈ �� ���� ����! ��� ���� �ɾ���� ���� �Ʒ� addclass/remove��ư �� ������!
    //������ ������ ���̽��� �����ؼ� ����ϴٺ��� ������ �ε��ð��� �����. �׷��� ������̶�� ������ �ޱ������� �ƹ��͵� �� �� ���Ե�.
    //������ ��ٸ��� ���ȿ��� �ٸ� ���� �����ϰ� �Ϸ��� ajax�� ���� ��! 
%>

{
  "result" : <%=result %>,
  "p1" : <%=p1 %>,
  "p2" : <%=p2 %>
}
