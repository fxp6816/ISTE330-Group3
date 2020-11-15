/**
 *  DataLayer.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 11th, 2020
 */

/**
 * This version is lacking due to missing items , like the SQL procedures as well as a full implementation of the database so testing
 * could not be applied to the datalayer, all code is at a theoretical point of implementation.
 * teStiNG
 * */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class DataLayer{

   private Connection conn;
   private ResultSet rs;
   private Statement stmt;
   private String sql;
   //private int col;

   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

   public DataLayer(){
   }//end of constructor

   public boolean connect(){
      conn = null;
      Scanner in = new Scanner(System.in);
      
      String userName = "root";
      String password = "student";

      //reaname the dbs name to the correct db
      String url = "jdbc:mysql://localhost/rit";

      url = url + "?serverTimezone=UTC"; //added 8/27  Mac Users

      try{
         Class.forName(DEFAULT_DRIVER);
         conn = DriverManager.getConnection(url, userName, password);
         System.out.println("\nCreated Connection!\n");
      }
      catch(ClassNotFoundException cnfe){
		 System.out.println("ERROR, CAN NOT CONNECT!!");
         System.out.println("Class");
         System.out.println("ERROR MESSAGE-> "+cnfe);
         System.exit(0);
      }
      catch(SQLException sqle){
		   System.out.println("ERROR SQLExcepiton in connect()");
		   System.out.println("ERROR MESSAGE -> "+sqle);
         sqle.printStackTrace();
         System.exit(0);
      }//end of catch



      in.close();

      return (conn!=null);
   } // End of connect method



   //Helper Method that allows to know total number of entries in one table
   public int getNumberOfRows(String tableName)     {
            int numRows = 0;
            String sql = new String();
            try {
            //  Create a statement
               stmt = conn.createStatement();
               sql = "SELECT count(*) FROM "+ tableName +";" ;
               rs = stmt.executeQuery(sql);
               rs.next();
               numRows = rs.getInt(1);
               }//end of try
         catch (SQLException sqle)
            {
               System.out.println("\nSome RUN-TIME ERROR has occurred while getting number of rows from Table:" + tableName + ".");
               System.out.println("*****************************************************************");
               System.out.println("ERROR MESSAGE --> "+sqle);                  
               sqle.printStackTrace();
            }
            return (numRows);
   }//END - getNumRows()



   //get Faculty contat info from table
   public String getFacultyContactInfo(String facultyID){
      try {
         //  Create a statement
            stmt = conn.createStatement();
            sql = "SELECT facultyID, phone, email FROM facultyContactInfo WHERE facultyID == "+ facultyID +";" ;
            rs = stmt.executeQuery(sql);
            rs.next();
            

            //created list of faculty that match the search
            
            int id = rs.getInt(1);
            String phone = rs.getString(2);
            String email = rs.getString(3);

            //display data for ea

            String out = Integer.toString(id) + "," + phone + "," + email;
            return out;

            }//end of try
      catch (SQLException sqle)
         {
            System.out.println("\nSome RUN-TIME ERROR has occurred");
            System.out.println("*****************************************************************");
            System.out.println("ERROR MESSAGE --> "+sqle);                  
            sqle.printStackTrace();
         }
      return "";
   }//END - searchFaculty()


   //get Faculty Department Information from table
   public String getFacultyDepInfo(String deptID){
      try{
         stmt = conn.createStatement();
         String sql = "SELECT deptID, deptName FROM department WHERE deptID == "+ deptID + ";";
         System.out.println("Command to be executed: " + sql);
         rs = stmt.executeQuery(sql);
         System.out.println("-----DELETE finished-----");
         
         //get the information
         String deptName = rs.getString(2);
         //display the information (maybe a return here???)
         return deptName;


      }//try
      catch(SQLException sqle){
         System.out.println("DELETE FAILED!!!!");
         System.out.println("ERROR MESSAGE IS -> "+sqle);
         sqle.printStackTrace();
         
      }
      return "";
   }





   public ArrayList<Student> searchStudent(int interest){
      
      ArrayList<Student> foundStudents = new ArrayList<Student>();
      String query = "{CALL search_student(?)}";
            try{
               CallableStatement stmt = conn.prepareCall(query);
               stmt.setInt(1, interest);

               ResultSet rs = stmt.executeQuery();

               // Test (condition of while loop) if there are query results
               while (rs.next()) {
                  // Retrieve resultset data to print on the screen
                  int studentId = rs.getInt(1);
                  String fname = rs.getString(2);
                  String lname = rs.getString(3);
                  int programId = rs.getInt(4);
                  String programName= rs.getString(5);
                  String phone = rs.getString(6);
                  String email = rs.getString(7);

                  Student temp = new Student(studentId,fname,lname,programId,programName,phone,email);
                  foundStudents.add(temp);

               }// end of while loop, end of processing the result set
            }catch(SQLException sqle){
               sqle.printStackTrace();
            }


            return foundStudents;
   }// END - searchStudent()


   public boolean insertStudent(int studentId, String fName, String lName, int programID, String phone, String email, String interests){
         try{

            String query = "{CALL add_student(?,?,?,?,?,?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, studentId);
            stmt.setString(2, fName);
            stmt.setString(3, lName);
            stmt.setInt(4, programID);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            

            ResultSet rs = stmt.executeQuery();
            
            //split the interest String add to the interest table
            String[] interestsArray =  interests.split(",");
            
            for(int i =0 ; i < interestsArray.length; i++){
            
                String interestIDQuery = "SELECT interestID FROM interests WHERE interestDesc LIKE" + interestsArray[i];
                rs = stmt.executeQuery(interestIDQuery);
                rs.next();
                
                int interestId = rs.getInt(1);
                
                String query2 = "INSERT INTO student_interest VALUES(studentID, interestID,) ("+ studentId + "," + interestId +")";
                rs = stmt.executeQuery(query2);
                rs.next();
            }
            
            return true;

         }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
         }
   }//END - insertStudent()

   public ArrayList<Faculty> searchFaculty(String keyword){

      ArrayList<Faculty> foundFaculty = new ArrayList<Faculty>();
      try{
         String query = "{CALL search_faculty(?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setString(1, keyword);

         ResultSet rs = stmt.executeQuery();

         // Test (condition of while loop) if there are query results
         while (rs.next()) {
            // Retrieve resultset data to print on the screen
            int facultyID = rs.getInt(1);
            String fname = rs.getString(2);
            String lname = rs.getString(3);
            String facAbstract = rs.getString(4);
            int deptId = rs.getInt(5);
            String deptName= rs.getString(6);
            String phone = rs.getString(7);
            String email = rs.getString(8);

            Faculty temp = new Faculty(facultyID, fname, lname, facAbstract, deptId, deptName, phone, email);

            foundFaculty.add(temp);

         }// end of while loop, end of processing the result set
      }catch(SQLException sqle){
         sqle.printStackTrace();
      }

      return foundFaculty;
                  
   }//END - serachFaculty()


   public boolean insertFaculty(int ID, String fName, String lName, String fAbastract, int deptID, String phone, String email){
      try{
         String query = "{CALL add_faculty(?,?,?,?,?,?,?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setInt(1,ID);
         stmt.setString(2, fName);
         stmt.setString(3, lName);
         stmt.setString(4, fAbastract);
         stmt.setInt(5, deptID);
         stmt.setString(6, email);
         stmt.setString(7, phone);

         ResultSet rs = stmt.executeQuery();

         //return boolean to check if insert worked
         return true;

      }catch(SQLException sqle){
         sqle.printStackTrace();
         return false;
      }
   }// END - intsertFaculty()



   //update faculty interest
   public boolean updateFaculty(int ID, String fName, String lName, String fAbastract, int deptID, String phone, String email){
      try{
         String query = "{CALL update_faculty(?,?,?,?,?,?,?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setInt(1,ID);
         stmt.setString(2, fName);
         stmt.setString(3, lName);
         stmt.setString(4, fAbastract);
         stmt.setInt(5, deptID);
         stmt.setString(6, email);
         stmt.setString(7, phone);

         ResultSet rs = stmt.executeQuery();

         //return boolean to check if insert worked
         return true;

      }catch(SQLException sqle){
         sqle.printStackTrace();
         return false;
      }

   }//END - updateFaculty()


 public boolean updateStudent(int ID, String fName, String lName, int deptID, String phone, String email, String interests){
      try{
         String query = "{CALL update_student(?,?,?,?,?,?,?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setInt(1,ID);
         stmt.setString(2, fName);
         stmt.setString(3, lName);
         
         stmt.setInt(4, deptID);
         stmt.setString(5, email);
         stmt.setString(6, phone);
         stmt.setString(7, interests);

         ResultSet rs = stmt.executeQuery();

         //return boolean to check if insert worked
         return true;

      }catch(SQLException sqle){
         sqle.printStackTrace();
         return false;
      }

   }//END - updateFaculty()

   //delete faculty interest
   public boolean deleteFaculty(int facultyID){
      try{
         String query = "{CALL delete_faculty(?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setInt(1, facultyID);


         ResultSet rs = stmt.executeQuery();

         //return boolean to check if insert worked
         return true;

      }catch(SQLException sqle){
         sqle.printStackTrace();
         return false;
      }

   }//END - delteFacultyInterest()
   
      //delete faculty interest
   public boolean deleteStudent(int studentId){
      try{
         String query = "{CALL delete_student(?)}";
         CallableStatement stmt = conn.prepareCall(query);
         stmt.setInt(1, studentId);


         ResultSet rs = stmt.executeQuery();

         //return boolean to check if insert worked
         return true;

      }catch(SQLException sqle){
         sqle.printStackTrace();
         return false;
      }

   }//END - delteFacultyInterest()



//this method will help encrypt the password
   public String encrypt(String secret){

      String sha1 = "";
      String value = new String(secret);
         try {
               MessageDigest digest = MessageDigest.getInstance("SHA-1");
               digest.reset();
               digest.update(value.getBytes("utf8"));
               sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
         } catch (Exception e){
            e.printStackTrace();
         }// end of catch


      return sha1;
   }//end of function




   //MAIN METHOD, FOR TESTING METHODS WRITTEN IN THE DATA LAYER CLASS....
   public static void main(String[] args){
      DataLayer dl = new DataLayer();
      dl.connect();
   }



} // End of Class   DataLayer.java
