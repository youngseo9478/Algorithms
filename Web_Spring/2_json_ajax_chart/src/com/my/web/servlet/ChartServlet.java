package com.my.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 나중에 디스패쳐 컨트롤러가 서비스 메소드 가지고 있을 거니까 get/post보다는 service메소드에 구현하는게 좋다.
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 이걸 제이슨 객체로 만들어 보기 [{ name: 'Tokyo', data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5,
		 * 25.2, 26.5, 23.3, 18.3, 13.9, 9.6] }, { name: 'London', data: [3.9, 4.2, 5.7,
		 * 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8] }]
		 */

		JSONArray json = new JSONArray();
		JSONObject obj1 = new JSONObject();// 제이슨 객체로 만들기 위함
		JSONObject obj2 = new JSONObject();// 제이슨 객체로 만들기 위함
		// obj1.put("data", "[7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3,
		// 13.9, 9.6]");
		// 위에처럼 하면 데이터 값이 스트링으로 넘어가서 ""이 붙음 위에 제이슨보면 ""이 없다는 걸 알 수 있음 이렇게 하는게 아니다~

		double[] num = { 7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6 };
		JSONArray numJson = new JSONArray();
		for (double data : num) {
			numJson.add(data);
		}
		obj1.put("data", numJson);
		obj1.put("name", "Tokyo");
		json.add(obj1); //Tokyo 데이터 제이슨객체의 배열로 변환 끝

		double[] num2 = { 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8 };
		JSONArray numJson2 = new JSONArray();
		for (double data : num2) {
			numJson2.add(data);
		}
		obj2.put("data", numJson2);
		obj2.put("name","London");
		json.add(obj2);

		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.close();
	}

}
