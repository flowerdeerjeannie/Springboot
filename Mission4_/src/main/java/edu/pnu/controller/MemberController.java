package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
	public class MemberController {
	
		private final MemberService memberService;

	    @Autowired
	    public MemberController(MemberService memberService) {
	        this.memberService = memberService;
	    }	
	    
		//3번은 위처럼 @RequiredArgsConstructor로 연결하기
		
//		public MemberController() throws SQLException, ClassNotFoundException {
//			memberService = new MemberService();
//		}
//		
	    //postman에서 - get만 params로 받는거고, 나머지는 다 body의 form-data가 우선이다.
	    
		@GetMapping("/members")
		public List<MemberDTO> getAllMembers() throws SQLException{
			return memberService.getAllMembers();
		}
		
		@GetMapping("/member")
		public MemberDTO getMember(Integer id) throws SQLException {
			return memberService.getMember(id);
		}
		
		@PostMapping("/member")
		public MemberDTO addMember(MemberDTO dto) throws SQLException {
			return memberService.addMember(dto);
		}
		
		@PutMapping("/member")
		public int updateMember(Integer id, String pass, String name) throws SQLException {
			return memberService.updateMember(id,pass,name);
		}
		
		@DeleteMapping("/member")
		public int removeMember(Integer id) {
			return memberService.removeMember(id);
		}
}
