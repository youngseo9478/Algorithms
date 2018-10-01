<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"49631",secure:"49636"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-6" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/board/board.jsp">
	<div align="center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-6" data-genuitec-path="/8_Spring_Web/src/main/webapp/WEB-INF/views/board/board.jsp">
		<h2>상세 정보 보기</h2>
		<form action="updateBoard.do" method="get">
			<input type="hidden" name="seq" value="${board.seq}">
			<%-- <input type="hidden" name="writer" value="${board.writer}">
<input type="hidden" name="regdate" value="${board.regdate}"> --%>
			<table border="1" width="80%">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value=" ${board.title}"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
					<%-- <td>${board.writer}</td> 
     이렇게 해두면 컨트롤러에서 커맨드 객체가 뷰단까지 올때 이 정보는 담아오지 않게됨 .
     인풋상자가 아니기때문에 히든으로 가져온다음 여기에 박아줘야함
     근데 지금은 에러나기때문에 주석처리 해놓고 redirect로 받는 방법 선택할것임--%>
				</tr>
				<tr>
					<td>등록일</td>
					<td>${board.regdate}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="12" cols="50" name="content">
            ${board.content}
        </textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>

				</tr>
			</table>
		</form>
		<a href="listboard.do">글목록보기</a> <a href="insertBoard.html">글쓰기 </a> <a
			href="deleteBoard.do?seq=${board.seq}">글삭제</a>

	</div>
	<br/>
	<br/>
	<br/>
	<!-- /row -->
	<div id="modifyDiv" style="display: none; padding-left: 8em;">
		<span class='title-dialog'></span>번 댓글
		<div>
			<input type="text" id="reContent" size="60">
		</div>

		<div align="center">
			<button type="button" id="reModifyBtn">수정</button>
			<button type="button" id="reDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>
		</div>
	</div>
	<div style="padding-left: 8em;">
		<div>
			작성자 : <input type="text" name="replyer" id="writer" />
		</div>

		<div>
			&nbsp;&nbsp;&nbsp;댓글 : <input type="text" size="50"
				name="replyContent" id="addReContent" />
		</div>

		<br />
		<button id="submitBtn">댓글 작성</button>

	</div>
	<div style="padding-left: 8em;">
	<h4>댓글 리스트</h4>
	<ul id="reply">
	</ul>

	<!-- <ul class="pgeNumList">
	</ul> -->
	</div>
	<script type="text/javascript">
	
	var seq = ${board.seq};
	
	//getPgeNum(1);
	reListAll();
	function reListAll(){
		
		$.getJSON("/replies/selectAll/"+seq, function(data){
			// console.log(data.length);
			var str = "";
			
			$(data).each(function(){
				str +="<li data-rebid='"+this.rebid+"' class='reList'>"
					+ this.rebid + " | "+ this.replyContent
					+"<button>수정</button>"
					+"</li>";
			});
			
			$("#reply").html(str);
		});	
	} //reListAll()
	
		
	//댓글 목록 처리
	$("#reply").on("click", ".reList button", function(){
		var li = $(this).parent();
		
		var rebid = li.attr("data-rebid");
		var reContent = li.text();
		
		//alert("댓글번호 : "+rebid+"  수정할 내용 : "+reContent);
		$(".title-dialog").html(rebid);
		$("#reContent").val(reContent);
		$("#modifyDiv").show("slow");
	});
	
	//댓글 쓰기 처리
	$("#submitBtn").click(function(){
	
		var reWriter = $("#writer").val();
		var reContent = $("#addReContent").val();
		alert("1");
		$.ajax({
			type : 'post',
			url : '/replies',
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			
			dataType : 'text',
			data :JSON.stringify({
			 seq : seq,
			 replyer : reWriter,
			 replyContent : reContent
			}),
			success : function(result){
				alert("2");
				if (result == 'Success'){
					alert("3");
					// alert("댓글 등록 성공!!!")
					reListAll();				
				}
			} ,
			error:function(err){
				alert(err.name);
			}
			
		});
	});
	
	//삭제 처리
	$("#reDelBtn").on("click", function(){
	
	var rebid = $(".title-dialog").html();
	var reContent = $("#reContent").val();
	
		$.ajax({
			type:'delete',
			url:'/replies/'+rebid,
			headers :{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType: 'text',
			success: function(result){
				console.log("result:" + result);
				if(result == 'Success'){
					alert("삭제 성공!!!");
					$("#modifyDiv").hide("slow");
					reListAll();
				}
			}
		
		});//ajax
	});
	
	

	//수정 처리
	$("#reModifyBtn").on("click", function(){
	
	var rebid = $(".title-dialog").html();
	var reContent = $("#reContent").val();
	
		$.ajax({
			type:'put',
			url:'/replies/'+rebid,
			headers :{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"				
			},
			data:JSON.stringify({replyContent:reContent}),
			dataType: 'text',
			success: function(result){
				console.log("result:" + result);
				if(result == 'Success'){
					alert("수정 성공!!!");
					$("#modifyDiv").hide("slow");
					reListAll();
				}
			}
		
		});//ajax
	});
</script>
</body>
</html>