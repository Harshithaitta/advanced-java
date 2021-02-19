CREATE table emp
( 
age NUMBER(10),
Name VARCHAR(10),
Salary NUMBER(5),
department VARCHAR(5)
);


emp.java

import java.sql.*;
import java.util.*;
public class emp {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("INSERT INTO emp values(23,'john',10000,'CSE')");
			ResultSet rs=stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
			}
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception:"+"oracle driver not available"+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Exception:"+"improper syntax in statement"+e.getMessage());
		}
	}
}

