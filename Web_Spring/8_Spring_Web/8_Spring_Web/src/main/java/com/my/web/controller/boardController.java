package com.my.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.my.biz.board.service.BoardService;
import com.my.biz.board.vo.BoardVO;

@Controller
public class boardController {
	@Autowired
	BoardService service;

	@RequestMapping(value = { "/listboard.do", "/listBoard.do" }) // 이름규칙어겨도 (b,B)다 처리 가능하도록
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.boardSelectAll());
		mav.setViewName("board/boardlist");
		return mav;
	}
	
	//레스트풀 서비스 -> 필요로하는 데이터를 만들어내는 작업 그래서 뷰페이지 갖고있지 않다.   
	//@ResponseBody는 @RestController와 같은 기능이다 스프링4.이상에서만 사용가능한 기능!!
	//json타입으로 바꾼 데이터를 넘겨주는 일을 함
	@RequestMapping(value = { "/jsonboard.do", "/jsonBoard.do" }) // 이름규칙어겨도 (b,B)다 처리 가능하도록
	@ResponseBody //결과를 응답 바디에 바로 붙여버림 (jsp이런거 안거치고!!)->annotation driven이 있어서 처리 가능한 기능!
	public List<BoardVO> jsonlist() {
		return service.boardSelectAll(); //modelandview가 아닌 list를 막바로 리턴함
	}

	@RequestMapping(value = { "/searchboard.do", "/searchBoard.do" }) // 이름규칙어겨도 (b,B)다 처리 가능하도록
	public ModelAndView searchBoard(String condition, String keyword) {// BoardVO 로 받아도 된다. 안에 컨디션이랑 키워드넣어놨기때문
		// public ModelAndView searchBoard(String condition, String keyword) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.searchBoard(condition, keyword));
		// mav.addObject("list",
		// service.searchBoard(vo.getCondition(),vo.getKeyword()));
		mav.setViewName("board/boardlist");
		return mav;
	}

	@RequestMapping("/getBoard.do")
	public String getboard(int seq, Model model) {
		model.addAttribute("board", service.boardFind(seq));
		return "board/board";
	}

	@RequestMapping("/addBoard.do")
	public String addboard(BoardVO vo, @RequestParam("uploadFile") MultipartFile uploadFile) {
		if (!uploadFile.isEmpty()) { //파일이 첨부되었을때만 삽입하겠다는 것
			String fileName = uploadFile.getOriginalFilename(); //원본파일 이름을 얻어옴
			File file = new File("c:/file/upload/"+fileName); //java io 작업 filename은 상대경로이므로 절대경로로 붙여줌
			try {
				uploadFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			vo.setFileName("c:/file/upload/" + fileName);
		}
		service.boardInsert(vo);
		return "redirect:listboard.do";
	}

	/*
	 * @RequestMapping("/updateBoard.do") public String
	 * updateboard(@ModelAttribute("board") BoardVO vo) { //커맨드객체는 뷰단까지
	 * 살아있다.(request와 동일한 scope) //근데 키값이 클래스이름의 첫글자 소문자인 boardVO가 됨! board가아님! 나머지를
	 * 다 바꾸려면 상당히 번거로움 //그래서 이름을 바꿔주는 방법이 있따. service.boardUpdate(vo); return
	 * "board/board"; //그냥 뷰로 보내도 살아있음! } 근데 이방법이 지금 등록일과 작성자를 못가져오기때문에 다음에 다시 써보기로
	 * .....
	 */

	/*
	 * @RequestMapping("/updateBoard.do") public String updateboard(BoardVO vo,
	 * Model model) { // 커맨드 객체는 스코프가 리퀘스트와 같다! 즉 뷰단까지 살아서 가기 때문에 굳이 모델에 담아주지 않아도
	 * 된다. service.boardUpdate(vo); model.addAttribute("board",
	 * service.boardFind(vo.getSeq())); return "board/board"; }
	 */
	@RequestMapping("/updateBoard.do")
	public String updateboard(BoardVO vo) {
		// 커맨드 객체는 스코프가 리퀘스트와 같다! 즉 뷰단까지 살아서 가기 때문에 굳이 모델에 담아주지 않아도 된다.
		service.boardUpdate(vo);
		return "redirect:listboard.do"; // 수정을 확인하려면 다시 클릭해 들어가야해서 번거롭긴한데..뭐..ㅎ
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteboard(int[] seq) {
		for (int num : seq) {
			service.boardDelete(num);
		} // 하나 또는 여러개 삭제 가능
		return "redirect:listboard.do";
	}
}
