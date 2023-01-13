package jdbc_maven_eb9_users;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;


public class UsersCRUD {

	public Connection getConnection() throws Exception {
		//create object for Driver class
		Driver driver=new Driver();
		//register the Driver
		DriverManager.registerDriver(driver);
		//passing file path which is having properties like url, username, password related to database
		FileInputStream fileInputStream=new FileInputStream("dbconfig.properties");
		
		//create object of properties
		Properties properties=new Properties();
		
		properties.load(fileInputStream);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		return connection;
	}

	// for signUp
	public void saveUsers(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS(ID,USERNAME,EMAIL,PASSWORD,ADDRESS) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, users.getId());
		preparedStatement.setString(2, users.getUserName());
		preparedStatement.setString(3, users.getEmail());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getAddress());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("signed up successfully");

	}
	
	//for login
	public boolean loginUsers(Users users) throws Exception {
		String query="select * from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		while(resultSet.next()) {
			password=resultSet.getString("password");
		}
		if(users.getPassword().equals(password)) {
			return true;
		}
		return false;
		
	}
	
	//to display facebook password
	public void displayFacebookPassword(Users users) throws Exception {
		String query="select facebookpassword from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
	
		while(resultSet.next()) {
			System.out.print("facebookpassword : ");
			String password=resultSet.getString("facebookpassword");
			if(password==null) {
				System.out.println("password is null first set the password");
			}
			else
			{
				System.out.println(password);
			}
		}
		
		connection.close();	
		
	}
	
	//to display instagram password
	public void displayInstagramPassword(Users users) throws Exception {
		String query="select instagrampassword from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
	
		while(resultSet.next()) {
			
			System.out.print("instagrampassword : ");
			String password=resultSet.getString("instagrampassword"); 
			if(password==null) {
				System.out.println("password is null first set the password");
			}
			else
			{
				System.out.println(password);
			}
			
		}
		
		connection.close();	
		
	}
	
	//to display snapchat password
	public void displaySnapchatPassword(Users users) throws Exception {
		String query="select snapchatpassword from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
	
		while(resultSet.next()) {
			
			System.out.print("snapchatpassword : ");
			String password=resultSet.getString("snapchatpassword"); 
			if(password==null) {
				System.out.println("password is null first set the password");
			}
			else
			{
				System.out.println(password);
			}
			
		}
		
		connection.close();	
		
	}
	
	//to display whatsapp password
	public void displayWhatsappPassword(Users users) throws Exception {
		String query="select whatsapppassword from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
	
		while(resultSet.next()) {
			
			System.out.print("whatsapppassword : ");
			String password=resultSet.getString("whatsapppassword"); 
			if(password==null) {
				System.out.println("password is null first set the password");
			}
			else
			{
				System.out.println(password);
			}
			
		}
		
		connection.close();	
		
	}
	
	//to display twitter password
	public void displayTwitterPassword(Users users) throws Exception {
		String query="select twitterpassword from users where email=?";
		Connection connection =getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getEmail());
		
		ResultSet resultSet=preparedStatement.executeQuery();
	
		while(resultSet.next()) {
			
			System.out.print("twitterpassword : ");
			String password=resultSet.getString("twitterpassword"); 
			if(password==null) {
				System.out.println("password is null first set the password");
			}
			else
			{
				System.out.println(password);
			}
		}
		
		connection.close();	
		
	}
	
	//to reset facebook password
	public void resetFacebookPassword(Users users) throws Exception{
		String query ="UPDATE USERS SET FACEBOOKPASSWORD=? WHERE EMAIL=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getFacebookPassword());
		preparedStatement.setString(2,users.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("facebook password changed successfully");
	
	}
	
	//to reset Instagram password
	public void resetInstagramPassword(Users users) throws Exception{
		String query ="UPDATE USERS SET INSTAGRAMPASSWORD=? WHERE EMAIL=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getInstagramPassword());
		preparedStatement.setString(2,users.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("instagram password changed successfully");
	
	}
	
	//to reset Snapchat password
	public void resetSnapchatPassword(Users users) throws Exception{
		String query ="UPDATE USERS SET SNAPCHATPASSWORD=? WHERE EMAIL=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getSnapchatPassword());
		preparedStatement.setString(2,users.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("snapchat password changed successfully");
	
	}
	
	//to reset Whatsapp password
	public void resetWhatsappPassword(Users users) throws Exception{
		String query ="UPDATE USERS SET WHATSAPPPASSWORD=? WHERE EMAIL=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getWhatsappPassword());
		preparedStatement.setString(2,users.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("whatsapp password changed successfully");
	
	}
	
	//to reset Twitter password
	public void resetTwitterPassword(Users users) throws Exception{
		String query ="UPDATE USERS SET TWITTERPASSWORD=? WHERE EMAIL=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,users.getTwitterPassword());
		preparedStatement.setString(2,users.getEmail());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("twitter password changed successfully");
	}
}







