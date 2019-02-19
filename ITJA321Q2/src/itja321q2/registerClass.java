/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itja321q2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static itja321q2.main.conn;
import static itja321q2.main.st;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jnaud
 */
public class registerClass {
    
    main m = new main();  //reference to main class.
    public int num;
    static String sql1;
    public static ResultSet rs;
    
    public static boolean validate_login(String username, String password){//this method should connect to xampp to validate if credentials are correct.
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");
            st = (Statement) conn.createStatement();
            String sqlcommand = "SELECT * FROM login";  //this does not want to work.
            rs = st.executeQuery(sqlcommand);
            
            while (rs.next()) {                //this reads all the fields within the database.
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
            }
            System.out.println("Connected to Database");
        } catch (Exception e) {
            System.out.println("Not Connected to Database");
            return false;
        }
        
        System.out.println(username + " "+ password);  //so this works :)
        try{
            sql1 = "SELECT * FROM login WHERE username = '" 
            + username + "' AND password ='" + password + "'";
            ResultSet rs = main.st.executeQuery(sql1);
            
            if(rs.next()){  //this means if the value is there.
                System.out.println("Correct, access granted.");
                return true;
            }else{
                System.out.println("Incorrect, access denied.");
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
                                                            
    }
    
    public void disconnect_db(){
        try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    } 

    void insertDetails(Student[] studentList) {
        try {
            LocalDateTime aDate = LocalDateTime.now();
            for (int x = 0; x < studentList.length; x++) {
                System.out.println("INSERT INTO classregister VALUES ("
                + "'"  + studentList[x].getStudentNo() + "', "
                + "'" + studentList[x].getName() + "', "
                + "'" + studentList[x].getSurName() + "', "
                + "'" + studentList[x].getSubject() + "', "
                + "'" + aDate.format(DateTimeFormatter.ISO_DATE) + "')");
            st.executeUpdate("INSERT INTO classregister VALUES ("
                + "'"  + studentList[x].getStudentNo() + "', "
                + "'" + studentList[x].getName() + "', "
                + "'" + studentList[x].getSurName() + "', "
                + "'" + studentList[x].getSubject() + "', "
                + "'" + aDate.format(DateTimeFormatter.ISO_DATE) + "')");
            }
            
            rs = st.executeQuery("SELECT * FROM classregister GROUP BY Student_number");
            while(rs.next()){
                System.out.println("Student Number:" + rs.getInt("Student_number"));
                System.out.println("Student Name:" + rs.getString("Student_name"));
                System.out.println("Student Surname:" + rs.getString("Student_surname"));
                System.out.println("Subject: " + rs.getString("Student_subject"));
                System.out.println("Data added:" + rs.getDate("date") + "\n-------------------");
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    
    
    
}
