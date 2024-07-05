package edu.pnu.service;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberDTO;

public class MemberService {
	List<MemberDTO> list = new ArrayList<>();
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	
	public MemberDTO addMember(Connection con, String pass, MemberDTO MemberDTO) throws SQLException {
		
		try {
			if (getMemberById(MemberDTO.getId()) != null) {
				System.out.println(MemberDTO.getId()+ "가 이미 존재합니다.");
						return null;
		}
			PreparedStatement ps = con.prepareStatement("insert into member(pass,name) values (?,?)");
			ps.setString(1, MemberDTO.getPass());
			ps.setString(2, MemberDTO.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MemberDTO.setRegidate(new Date());
        rs.add(MemberDTO);
		return MemberDTO;
	}
	
	private MemberDTO getMemberById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateMember(Connection con, MemberDTO MemberDTO) throws SQLException {
		
		try {
			MemberDTO m = getMemberById(MemberDTO.getId());
			if (m==null) 
				return 0;
			else {
			PreparedStatement ps = con.prepareStatement("Update member set pass=?, name=? where id=?");
			m.setName(MemberDTO.getName());
			m.setPass(MemberDTO.getPass());
			m.setId(MemberDTO.getId());
			ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public int removeMember(Connection con, int id) throws SQLException {
		try {
			list.remove(getMemberById(id));
			PreparedStatement ps = con.prepareStatement("delete from member where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}			
		return 1;
	}

		
	public  List<MemberDTO> getAllMembers(Connection con)throws SQLException {
		
	    try {
	    	ps = con.prepareStatement("select * from member");
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	        	MemberDTO member = new MemberDTO(id, pass, name, );
	            member.setId(rs.getInt("id"));
	            member.setPass(rs.getString("pass"));
	            member.setName(rs.getString("name"));
	            list.add(member);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	     
	    return list;
	    }
	}
}
