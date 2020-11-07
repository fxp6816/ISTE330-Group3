//group 3 - DataLayer
//@Author Francisco Paliouras Delgado
//@Version Nov 7th, 2020


/**
 * This version is lacking due to missing items , like the SQL proceedures as well as a full implementation of the database so testing 
 * could not be applied to the datalayer, all code is at a theoretical point of implementaiton.*/ 

import java.sql.*;
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
      System.out.println("User: \"root\"");
      //Connecting to the local mySQL db
	  //asking for database name
	  //System.out.print("Enter the local MySQL Database name: ");
	  //String dbname = in.nextLine();

	  //asking for the password
	  System.out.print("Enter your MYSQL password (if it's 'student' just hit enter): ");
	  String pass = in.nextLine();
	  String password = "";
	  if(pass.equals("")){
	           password = "student";
	        }
	  else{
	      password = pass;
      }

      //reaname the dbs name to the correct db
      String url = "jdbc:mysql://localhost/RIT";

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

      return (conn!=null);
   } // End of connect method


/**
 * 
 * Tables in the DB:
 *    college[collageID,collageName]
 *    department[DeptId, departmentName]
 *    deptphone[deptID, PhoneNumber]
 *    faculty [ID,fName,lName,deptNum]
 *    facultyContactInfo[facultyID, phone, email]
 *    facultyInterest [facultyID, String(Interest)]
 *    programs[programID, programName]
 *    student[studentId, Fname, Lname, ProgramId]
 *    studentContactInfo[StudentID, phone, email]
 *    studentInterests[StudentID, String(Interest)]
 */



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
                  System.out.println("ERROR MESSAGE --> "+sqle);                  sqle.printStackTrace();
            }
            return (numRows);
   }//END - getNumRows()







   //insert new student into student table
   public void insertStudent(int ID, String fName, String lName, int programID, String phone, String email, String interests){
      try{
         stmt = conn.createStatement();
         String idString = Integer.toString(ID);
         String programIdString = Integer.toString(programID);
         String sql = "INSERT INTO student (ID, Fname, Lname, deptId, phone, email, interests) VALUES("+"'"+idString+"'" +","+
                                                                                                         "'"+fName+"'" +","
                                                                                                         +"'"+lName+"'" +","
                                                                                                         +"'"+programIdString+"'" +","
                                                                                                         +");";

         System.out.println("Statement to be executed:\n->" + sql);
         rows = stmt.executeUpdate(sql);
         System.out.println("-----INSERT finished-----");

         //insert contact infor student
         sql = "INSERT INTO studentContactInfo (ID, phone, email) VALUES(" + "'" + idString + "'" + "," +
                                                                         "'" + phone +"'" + ","
                                                                         + "'" + email+"'" + ","
                                                                         + ");";

         System.out.println("Statement to be executed:\n->" + sql);
         rows = stmt.executeUpdate(sql);
         System.out.println("-----INSERT finished-----");

         //get array of interests that are to be inserted
         String[] interestArray ;
         //iterate the insert
         for(int i = 0; i <interestArray.length; i++){
            sql = "INSERT INTO facultyInterest (ID, interest) VALUES("+"'"+ID+"'" +","+"'"+interestArray[i]+"'"+");";
            System.out.println("Statement to be executed:\n->" + sql);
            rows = stmt.executeUpdate(sql);
         }

         //Show prompt of the number of rows inserted



      }catch(SQLException sqle){
         System.out.println("Insert Failed!");
         sqle.printStackTrace();
         
      }//catch
   }//END - insertFaculty()

   // Retrive data from student Contact Info table
   public String getStudentContactInfo(String studentID){



      return "";
   }//END - getStudentContactInfo()
   //Retrive data from progrma table
   public String getStudentProgramInfo(Sting programID){


      return "";
   }//END - getStudentProgramInfo()
   //search student based in interest
   public void searchStudent(){
      try {
         //  Create a statement
            stmt = conn.createStatement();
            sql = "SELECT studentID, interest FROM studentInterests WHERE interest == "+ interest +";" ;
            rs = stmt.executeQuery(sql);
            

            ArrayList<String> studentID = new ArrayList<String>();
            //created list of faculty that match the search
            while (rs.next()) {
               facultyID.add(rs.getString(0));
           }
           //show all the info found including contact info
           for(int i=0;i< studentID.size(); i++){
            sql = "SELECT ID, FName, LName, deptID FROM student WHERE ID == " + studentID.get(i)+";";
            rs = stmt.executeQuery(sql);
            int ID = rs.getInt(1);
            String fName = rs.getString(2);
            String lName = rs.getString(3);
            int deptID = rs.getInt(4);

            //get student contact info and program info (supplementary method)
            

            System.out.println(ID + " Faculty : " + fName +", "  + lName + ", " + deptID);
            
           }

            }//end of try
      catch (SQLException sqle)
         {
            System.out.println("\nSome RUN-TIME ERROR has occurred while getting number of rows from Table:" + tableName + ".");
            System.out.println("*****************************************************************");
               System.out.println("ERROR MESSAGE --> "+sqle);                  sqle.printStackTrace();
         }

   }//END - searchStudent()






   //insert new favulty member into faculty table
   public void insertFaculty(int ID, String fName, String lName, int deptID, String phone, String email, String interests){
      try{
         stmt = conn.createStatement();
         String idString = Integer.toString(ID);
         String deptIdString = Integer.toString(deptID);
         String sql = "INSERT INTO faculty (ID, Fname, Lname, deptId) VALUES("+"'"+idString+"'" +","+
                                                                                                         "'"+fName+"'" +","
                                                                                                         +"'"+lName+"'" +","
                                                                                                         +"'"+deptIdString+"'" +","
                                                                                                         +");";

         System.out.println("Statement to be executed:\n->" + sql);
         rows = stmt.executeUpdate(sql);
         System.out.println("-----INSERT finished-----");                                                                                     

         //insert contact info
         sql = "INSERT INTO facultyContactInfo (ID, phone, email) VALUES("+"'"+ID+"'" +","+"'"+phone+"'"+","+"'"+email+"'"+");";
         System.out.println("Statement to be executed:\n->" + sql);
         rows = stmt.executeUpdate(sql);
         System.out.println("-----INSERT finished-----");    
         //insert interests
            //get array of interests that are to be inserted
            String[] interestArray ;
            //iterate the insert
            for(int i = 0; i <interestArray.length; i++){
               sql = "INSERT INTO facultyInterest (ID, interest) VALUES("+"'"+ID+"'" +","+"'"+interestArray[i]+"'"+");";
               System.out.println("Statement to be executed:\n->" + sql);
               rows = stmt.executeUpdate(sql);
            }

         

         //Show prompt of the number of rows inserted


      }//try
      catch(SQLException sqle){
         System.out.println("Insert Failed!");
         sqle.printStackTrace();
         
      }//catch
   }//END - insertFaculty()
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
            System.out.println("\nSome RUN-TIME ERROR has occurred while getting number of rows from Table:" + tableName + ".");
            System.out.println("*****************************************************************");
               System.out.println("ERROR MESSAGE --> "+sqle);                  sqle.printStackTrace();
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
   //Serach for faculty members based on interst
   public void searchFaculty(String interest){
      try {
         //  Create a statement
            stmt = conn.createStatement();
            sql = "SELECT facultyID FROM facultyInterest WHERE interest == "+ interest +";" ;
            rs = stmt.executeQuery(sql);
            

            ArrayList<String> facultyID = new ArrayList<String>();
            //created list of faculty that match the search
            while (rs.next()) {
               facultyID.add(rs.getString(0));
           }
           //show all the info found including contact info
           for(int i=0;i< facultyID.size(); i++){
            sql = "SELECT ID, FName, LName, deptID FROM faculty WHERE ID == " + facultyID.get(i)+";";
            rs = stmt.executeQuery(sql);
            int ID = rs.getInt(1);
            String fName = rs.getString(2);
            String lName = rs.getString(3);
            int deptID = rs.getInt(4);

            String contactInfo = this.getFacultyContactInfo(Integer.toString(ID));

            System.out.println(ID + " Faculty : " + fName +", "  + lName + ", " + deptID);
            
           }

            }//end of try
      catch (SQLException sqle)
         {
            System.out.println("\nSome RUN-TIME ERROR has occurred while getting number of rows from Table:" + tableName + ".");
            System.out.println("*****************************************************************");
               System.out.println("ERROR MESSAGE --> "+sqle);                  sqle.printStackTrace();
         }
   }//END - searchFaculty()

   //update faculty interest
   public void updateFacultyInterest(){
      //look up for the interest and populate the window

      //rewrite the interest into the database

   }//END - updateInterest()

   //delete faculty interest
   public void deleteFacultyInterest(String facultyID){
      //get the id that you are interested in

      System.out.println("-----DELETE started-----");
      try{
         stmt = conn.createStatement();
         String sql = "DELETE FROM facultyInterest WHERE facultyID = " + facultyID + ";";
         System.out.println("Command to be executed: " + sql);
         rows = stmt.executeUpdate(sql);
         System.out.println("-----DELETE finished-----");
         //display the number of rows affected

      }//try
      catch(SQLException sqle){
         System.out.println("DELETE FAILED!!!!");
         System.out.println("ERROR MESSAGE IS -> "+sqle);
         sqle.printStackTrace();
         
      }
   }//END - delteFacultyInterest()





   //MAIN METHOD, FOR TESTING METHODS WRITTEN IN THE DATA LAYER CLASS....
   public static void main(Stirng[] args){
      DataLayer dl = new DataLayer();
      dl.connect();
   }



} // End of Class   DataLayer.java