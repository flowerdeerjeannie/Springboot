package edu.pnu.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

@Service
public class MemberService {

		private final MemberDao memberDao;
		private final LogDao logDao;
		
		//변수에 final 하고 생성자 함께 만들든지,
		//아니면 autowired만 하고 final 생성자 다 없애든지. 
		
		@Autowired
		public MemberService(MemberDao memberDao, LogDao logDao) throws SQLException, ClassNotFoundException {
			this.memberDao = new MemberDao();
			this.logDao = new LogDao();
		}
		
		public List<MemberDTO> getAllMembers() throws SQLException {
			//Map은 한가지가 아니고 여러가지 타입을 가져와서 모을수있는 거라서 string, object다 받을수있으니깐 얘를 써준다.
			
//			Map <String, Object> map = memberDao.getAllMembers();
//			@SuppressWarnings("unchecked")
//			List<MemberDTO> list = (List<MemberDTO>) map.get("result");
//			String sqlString = (String) map.get("sqlString");
//			boolean success = (boolean) map.get("success");
//			logDao.addLog("GET", sqlString, success);
//			return list;
			
			        List<MemberDTO> list = memberDao.getAllMembers();
			        String sqlString = "SELECT * FROM members"; // This should match the query used in the DAO method
			        boolean success = true; // Assuming success if no exceptions are thrown
			        logDao.addLog("GET", sqlString, success);
			        return list;
		}
		
	    // DAO에서 가져온 정보를 로깅해야 합니다.
	    // DTO는 여러 가지 타입의 정보를 가지고 있습니다.
	    // memberDao.getAllMembers() 메서드가 return list;로 List를 반환하기 때문에
	    // 이 리스트를 분해해서...
	    // "success" 키에 해당하는 값은 작업 성공 여부를 나타내는 boolean 값입니다.
	    // 작업 로깅을 위해 logDao를 사용하여 로그를 추가합니다.
	    // 가져온 회원 리스트를 반환합니다.
		
		public MemberDTO getMember(Integer id) throws SQLException {
			return memberDao.getMember(id);
		}
		
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
