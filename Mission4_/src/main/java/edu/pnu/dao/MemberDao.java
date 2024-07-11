package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberDTO;

@Repository
public class MemberDao {
	private Connection con = null;
		
	public MemberDao() throws SQLException {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/musthave";
		String USERNAME = "scott";
		String PASSWORD = "tiger";

		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public List<MemberDTO> getAllMembers() throws SQLException {
		List<MemberDTO> list = new ArrayList<>();
	
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM member order by id");
		
        while (rs.next()) {
        	MemberDTO member = MemberDTO.builder()
        			.id(rs.getInt("id"))
        			.pass(rs.getString("pass"))
        			.name(rs.getString("name"))
        			.regidate(rs.getDate("regidate"))
        			.build();
        	list.add(member);
        	}
        
        rs.close();
        st.close();
		
		return list;
	}
	

	public MemberDTO getMember(Integer id) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM member where id="+id);
				
		MemberDTO member = null;
		
        if (rs.next()) {
        	member = MemberDTO.builder()
        			.id(rs.getInt("id"))
        			.pass(rs.getString("pass"))
        			.name(rs.getString("name"))
        			.regidate(rs.getDate("regidate"))
        			.build();
        }
        
        
        rs.close();
        st.close();
        
        return member;
	}
    
	
    public MemberDTO addMember(MemberDTO dto) throws SQLException {
    	
		try {
			PreparedStatement st = con.prepareStatement("INSERT into member (id, pass, name ) values (?, ?, ?)");
			st.setInt(1, dto.getId());
			st.setString(2, dto.getPass());
			st.setString(3, dto.getName());
			st.executeUpdate();
			st.close();
			//catch 이전에 st를 close하는걸 자꾸 까먹음... 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getMember(dto.getId());
	}
    
    
    public int updateMember(Integer id, String pass, String name) {
		String sql="UPDATE member SET pass= ?, name= ? WHERE id = ? ";

		try (PreparedStatement st = con.prepareStatement(sql)) {
	    	st.setString(1, pass);
	    	st.setString(2, name);
	    	st.setInt(3, id);
		   
	    	int Result = st.executeUpdate();

	        if (Result > 0) {
	            System.out.println("업데이트 성공");
	            return 1;
	        } else {
	            System.out.println("업데이트 실패");
	            return 0;
	        }
	        //catch 이전에 st close
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return 0;
		
	}
    
    public int removeMember(Integer id) {
    	try (PreparedStatement st = con.prepareStatement("delete from member where id= ? ")){
    			st.setInt(1, id);	
    			
    		int Result = st.executeUpdate();
    		
    		if (Result > 0) {
    			System.out.println("삭제 성공");
    			return 1;
    		} else {
    			System.out.println("삭제 실패");
    			return 0;
    		}
    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
    }
}

