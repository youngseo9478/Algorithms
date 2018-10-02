package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import service.CctvService;

@Controller
public class CctvController {
	
	@Autowired
	private CctvService service;
	
	@RequestMapping("main.do")
	public String main(){
		return "main"; 
		//main.do라는 요청을 처리하는 메소드
		//main이라는 뷰 네임으로 뷰리졸버에 전달
		//internalResourceViewResolver
	}
	
	@RequestMapping("getCctvMap.do")
	public String getCctvMap(Model model, String gu){
//		System.out.println(gu + "에 대한 CCTV맵을 응답합니다.");
		
		String file = service.getCctvMap(gu);
		model.addAttribute("file",file);
		return "cctvMap";
	}
	
	@RequestMapping("getPicture.do")
	public View getPicture(String file){
		return new DownloadView(file);
	}
}
