package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.NoticeModel;
import com.example.demo.model.ShopModel;
import com.example.demo.service.NoticeService;
import com.example.demo.service.ShopService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private NoticeService noticeService;
	
	// 페이지 접속시 /home 경로로 이동
//    @RequestMapping("/")
//    public String home() {
//        return "/home";
//    }

	// @RequestMapping : method 속성을 생략하면 GET, POST, PUT, DELETE 등 모든 HTTP 메서드에 대한 요청을 처리
	// @GetMapping, @PostMapping등을 사용하는 이유는 메서드의 용도가 명시적으로 드러나기 때문에 코드의 가독성이 좋아진다.
	// 의도치 않게 GET 대신 POST를 사용하거나 그 반대의 경우 에러발생
	
	@GetMapping("/home")
	public ModelAndView goHome(HttpServletRequest request) {
		
		// 데이터 담는 바구니
		ModelAndView mv = new ModelAndView();
		
		// DB데이터 변수
		List<ShopModel> memberList = shopService.memberList();
		System.out.println("홈페이지");
		System.out.println("유저 수는 : " + memberList.size() + "명 입니다"); 
		
		mv.addObject("memberList", memberList);
		mv.setViewName("content/home");
		
		return mv;
	}
	
	@GetMapping("/notice")
	public ModelAndView goNotice(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();

		List<NoticeModel> noticeList = noticeService.noticeList();
		System.out.println("게시판 페이지 갯수는 : " + noticeList.size() + "개 입니다");
		
		mv.addObject("noticeList", noticeList);
		mv.setViewName("content/notice");
		
		return mv;
	}
	
	@GetMapping("/notice/write")
	public ModelAndView goNoticeWrite(HttpServletRequest request) {
		
		// 글작성 시 데이터를 담을 박스 추가
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeModel", new NoticeModel());

		mv.setViewName("content/noticeWrite");
		
		return mv;
	}
	
	@PostMapping("/notice/write/insert")
	public String goNoticeWriteCreate(@ModelAttribute("noticeModel") NoticeModel noticeModel) {
	    try {
			noticeService.noticeInsert(noticeModel);
			return "redirect:/notice";
		} catch (Exception e) {
			System.out.println(e);
			return "content/error";
		}
	}
	
	@GetMapping("/notice/{noticeNumber}")
	// 메서드 파라미터의 이름이 컴파일 시에 지워진다.
	// 그 해결법을 위해 @PathVariable(파라미터 이름)을 한다.
	public ModelAndView goNoticeDetail(@PathVariable("noticeNumber") int noticeNumber) {
	    System.out.println("상세페이지");
	    ModelAndView mv = new ModelAndView();
	    
	    try {
	    	Optional<NoticeModel> noticeListOne = noticeService.noticeListOne(noticeNumber);

	    	if (noticeListOne.isPresent()) {
	    		mv.addObject("noticeListOne", noticeListOne.get());
	    		mv.setViewName("content/noticeDetail");
	    		return mv;				
			} else {
				// 상세페이지가 없는경우
				mv.setViewName("content/error");
	    		return mv;
			}
	    } catch (Exception e) {
	        System.out.println(e);
	        mv.setViewName("content/error");
		    return mv;
	    }
	}
	
	@GetMapping("/noticeUpdate/{noticeNumber}")
	public ModelAndView goNoticeUpdate(@PathVariable("noticeNumber") int noticeNumber) {
	    System.out.println("수정페이지");
	    ModelAndView mv = new ModelAndView();
	    
	    try {
	    	Optional<NoticeModel> noticeListOneModel = noticeService.noticeListOne(noticeNumber);
	    	if (noticeListOneModel.isPresent()) {
	    		mv.addObject("noticeListOneModel", noticeListOneModel.get());
	    		mv.setViewName("content/noticeUpdate");
	    		return mv;				
			} else {
				mv.setViewName("content/error");
	    		return mv;
			}
	    } catch (Exception e) {
	        System.out.println(e);
	        mv.setViewName("content/error");
		    return mv;
	    }
	}
	
	@GetMapping("/noticeDelete/{noticeNumber}")
	public String goNoticeDelete(@PathVariable("noticeNumber") int noticeNumber) {
	    try {
			noticeService.noticeDelete(noticeNumber);
			return "redirect:/notice";
		} catch (Exception e) {
			System.out.println(e);
			return "content/error";
		}
	}
	
//	@PostMapping("/notice/write/insert")
//	public String goNoticeWriteCreate(@ModelAttribute("noticeModel") NoticeModel noticeModel) {
//	    try {
//			noticeService.noticeInsert(noticeModel);
//			return "redirect:/notice/1";
//		} catch (Exception e) {
//			System.out.println(e);
//			return "content/error";
//		}
//	}
}