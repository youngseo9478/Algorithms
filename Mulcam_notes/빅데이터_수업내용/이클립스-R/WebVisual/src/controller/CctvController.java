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
		//main.do��� ��û�� ó���ϴ� �޼ҵ�
		//main�̶�� �� �������� �丮������ ����
		//internalResourceViewResolver
	}
	
	@RequestMapping("getCctvMap.do")
	public String getCctvMap(Model model, String gu){
//		System.out.println(gu + "�� ���� CCTV���� �����մϴ�.");
		
		String file = service.getCctvMap(gu);
		model.addAttribute("file",file);
		return "cctvMap";
	}
	
	@RequestMapping("getPicture.do")
	public View getPicture(String file){
		return new DownloadView(file);
	}
}
