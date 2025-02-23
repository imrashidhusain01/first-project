package studentData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Mohd {
			
			private final static String url="jdbc:postgresql://localhost:5432/postgres";
			private final static  String user="postgres";
			private final static String pass="Rashid12";
			public static void main(String[] args)throws Exception {
			//DataFile df=new  DataFile(4,"khan","rashidhuain123@gmail.com","shahwajpurdor Amroha");
			
			Connection con=DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Ban Gaya");
			PreparedStatement ps=con.prepareStatement("create table Servlet(id serial primary key, client varchar(50), email varchar(70), password varchar(100))");
//		PreparedStatement ps=con.prepareStatement("insert into a1 (id, name, email, address)values(?,?,?,?)");
//		ps.setInt(1, df.getId());
//		ps.setString(2, df.getName());
//		ps.setString(3, df.getEmail());
//		ps.setString(4, df.getAddress());
//		ps.executeUpdate();
			int i =ps.executeUpdate();
			if (i>0) {
				System.out.println("record inerted");
			}
			else {
				System.out.println("not inserted");
			}
		}
		

	}
