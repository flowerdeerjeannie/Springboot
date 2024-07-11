package edu.pnu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

//dao->service->controller 이므로
//controller는 안에 memberservice를 변수로 선언하고
//생성자를 만들어서 얘의 요청을 받아들이는 것. 
@RestController
public class MemberController {
	private final MemberService memberService;
	
	public MemberController() throws SQLException {
		memberService = new MemberService();
	}
	
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
