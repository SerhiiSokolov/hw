package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import person.Person;

public class DS_MySQL implements DS {

	@Override
	public void create(Person p) {
		try 
		{
			String myDriver ="com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/test";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
			Statement st = conn.createStatement();
			String values="'"+p.getfName()+"', '"+p.getlName()+"', '"+p.getAge()+"'";
			String query="INSERT INTO PERSON (FirstName,LastName,Age) VALUES("+values+");";
			st.execute(query);
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() {
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			String myDriver ="com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/test";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
			while(rs.next())
			{
				pp.add( new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)) );
			}
			rs.close();
			st.close();
			conn.close();

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub
		try 
		{
			String myDriver ="com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/test";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
			Statement st = conn.createStatement();
			String query="UPDATE PERSON SET "+
					"FirstName='"+p.getfName()+
					"', LastName='"+p.getlName()+
					"', Age="+p.getAge()+
					" WHERE Id="+p.getId()+";";
			st.executeUpdate(query);
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) {
		try 
		{
			String myDriver ="com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/test";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
			Statement st = conn.createStatement();
			String query="DELETE FROM Person WHERE Id="+p.getId()+";";
			st.executeUpdate(query);
			st.close();
			conn.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
