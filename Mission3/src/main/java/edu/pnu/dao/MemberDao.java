package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberDTO;

public class MemberDao {
	private Connection con = null;
	//MemberDao 생성자 안에는 다 private
	//con앞에 private 붙여주기
	//나는 왜 memberDao를 main을 해야한다고 생각했지? 여기서는 실행이 아니므로 main 할필요가 없음
	//그리고 여기서 con 해줬기 때문에 밑에서는 파라미터로 받을 필요 없이
	//그냥 메소드안에 바로사용할수있음.. 메소드() 안에 con넣을 필요 x
	
		
	public MemberDao() throws SQLException {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/musthave";
		String USERNAME = "scott";
		String PASSWORD = "tiger";

		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	//지금 연결하는게 많아지니까 잘 모르는데 preparedStatement하니까 좀더 어려워진거같음
	//차라리 명확하게 하고싶을때는 createStatement 하는게 나을거같다.
	
	public List<MemberDTO> getAllMembers() throws SQLException {
		List<MemberDTO> list = new ArrayList<>();
	
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM member order by id");
		
		//아래 while문에서 엄청헤맸는데, DTO에서 builder를 사용했기 때문에
		//일반 생성자 맞춰주는 방식이 안먹힘.. 그래서 builder을 사용해야함 이생각을 아예 못했음
		//builder를 사용하면 거기에는 생성자 할 필요가 없기 때문에
		//거기서는 간단하게 끝내주고 여기에다가 builder구구절절쓰면됨 
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
		//여기 안에서 DTO의 객체를 하나 사용하는 방법을 생각을 못함 ㅠ 
		//어차피 가져와야되는건 DTO중의 하나니까 걔를 null값으로 변수선언을 하나 해주고
		//while 돌필요가 없으니까 if로서 builder객체를 (생성자)처럼 불러와준다
		
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
        //그리고 return은 member객체하나니까. 
	}
    
	
    public MemberDTO addMember(MemberDTO dto) throws SQLException {
    	//dto객체를 하나 입력해가지고 add한다고 생각.
    	//그리고 그 dto를 set해준다.
    	
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
		//getMember를 통해서 dto의 id를 return해줌...
		//add의 리턴타입을 작성하기 엄청 어려웠는데,
		//getMember(다른 메소드)를 return타입으로 할수있다는 생각을 못했음.
		//위에 원하는 멤버의 정보만 읽어내오는 메소드를 작성해줬으니까
		//걔를 넣고, dto.(새로내가넣은거)의 아이디만 넣어서 그 메소드를 불러오도록 하는 생각..
		return getMember(dto.getId());
	}
    
    
    public int updateMember(Integer id, String pass, String name) {
		String sql="UPDATE member SET pass= ?, name= ? WHERE id = ? ";
		//웃긴점 WHERE=id 생각을 못해가지고 ..update니까 where id를 해줘야지; 
		
		//prepare과 그냥을 한 클래스 안에 섞어서 쓸 수 있따! 
		//그래서 update는 prepare이 맞지. pass로 들어온건 첫번째 자리에 st(쿼리문)으로 전달, 쭉쭉.. 하도록.
	    try (PreparedStatement st = con.prepareStatement(sql)) {
	    	st.setString(1, pass);
	    	st.setString(2, name);
	    	st.setInt(3, id);
	    	
	    	//update저렇게 이미 실행한게 result에 들어가므로 여기에 sql 안넣어줌 
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


