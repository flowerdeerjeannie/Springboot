package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
		//memberService변수선언 서비스가 로컬변수 되니까 밑에 controller 생성자 안에서 인스턴스 만들수잇음
		private final MemberService memberService;
		
		//memberService를 controller생성자 안에 service 인스턴스 만들어줌.호출가능하도록 
		public MemberController() {
			memberService= new MemberService();
		}
		
	   @GetMapping("/members")
	    public List<MemberVO> getAllMembers() {
	        return memberService.getAllMembers();
	    }
	   
		@GetMapping("/member")
		public MemberVO getMemberById(Integer id) {
			return memberService.getMemberById(id);
		}
		 
	   @PostMapping("/member")
		public MemberVO addMember(MemberVO memberVO) {
			return memberService.addMember(memberVO);
	   }
		
	   @PostMapping("/memberJSON")
	   public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
		   return addMember(memberVO);
	   }
	   
	   @PutMapping("/member")
	   public int updateMember(MemberVO memberVO){
	       return memberService.updateMember(memberVO);
	   }
		
		@DeleteMapping("/member")
		public int removeMember(Integer id) {
			return memberService.removeMember(id);
		}
}
