package edu.pnu.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

//dao->service->controller 이므로
//Service안에는 dao 변수를 선언하고 
//dao 생성자를 만들어서 얘가 주는 데이터를 받을수있또록 함 
public class MemberService {
	
	private final MemberDao memberDao;
	
	public MemberService() throws SQLException {
		memberDao = new MemberDao();
	}
	
	public List<MemberDTO> getAllMembers() throws SQLException {
		return memberDao.getAllMembers();
	}
	
	public MemberDTO getMember(Integer id) throws SQLException {
		return memberDao.getMember(id);
	}
	//con은 필요없기때문에 매개변수로 받지않는다. 
	public MemberDTO addMember(MemberDTO dto) throws SQLException {
		return memberDao.addMember(dto);
	}
	
	public int updateMember(Integer id, String pass, String name) throws SQLException {
		return memberDao.updateMember(id, pass, name);
	}
	
	public int removeMember(Integer id) {
		return memberDao.removeMember(id);
	}



}