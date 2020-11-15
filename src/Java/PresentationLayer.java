/**
 *  PresentationLayer.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 11th, 2020
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PresentationLayer extends JFrame{

   DataLayer db = new DataLayer();
   public JPanel ui;
   JButton runBtn = new JButton("Execute");
 
   public static Font myFont = new Font("Courier", Font.PLAIN, 16);
 
   public PresentationLayer(String user, String password){
      super ("RIT - DB");
      System.out.println(user + password);
   
     //creating UI and Linking it to the DATA Layer
     
      this.setLayout(new BorderLayout());
      this.setSize(400, 600);
      this.setLocation(500, 280);
     
     
      String[] publicOps = { "Search Faculty", "View All" };
      String[] facultyOps = { "Insert Student", "Insert Faculty", "Update Student", "Search Faculty", "Search Student","Delete Faculty", "Delete Student" };
   
   
      JComboBox operations;
      if(user.equals("PUBLIC")){
         operations  = new JComboBox(publicOps);
      }else{
         operations = new JComboBox(facultyOps);
      }
      
      
      operations.addActionListener(new choice());
     
     
      this.add(operations,BorderLayout.NORTH);
     
      this.ui = new JPanel(new GridLayout(12,1));
     
      if(user.equals("PUBLIC")){
        //add search faculty here
        
        
      }else{
         JTextField fname = new JTextField();
         JLabel fnameLbl = new JLabel("First Name:");
         fname.setPreferredSize(new Dimension(15,20));
         JTextField lname = new JTextField();
         JLabel lnameLbl = new JLabel("Last Name:");
         
         JTextField programTF = new JTextField();
         JLabel programLbl = new JLabel("Program Id:");
         
         JTextField phone = new JTextField();
         JLabel phoneLbl = new JLabel("Phone:");
         
         JTextField email = new JTextField();
         JLabel emailLbl = new JLabel("Email:");
         
         JTextField interests = new JTextField();
         JLabel interestsLbl = new JLabel("Interest (seperate by ','):");
         
         ui.add(fnameLbl);
         ui.add(fname);
         ui.add(lnameLbl);
         ui.add(lname);
         ui.add(programLbl);
         ui.add(programTF);
         ui.add(phoneLbl);
         ui.add(phone);
         ui.add(emailLbl);
         ui.add(email);
         ui.add(interestsLbl);
         ui.add(interests);
      
      }
     
     
      this.add(ui,BorderLayout.CENTER);
     
      
      this.add(runBtn, BorderLayout.SOUTH);
     
     
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      this.setVisible(true);
   
   }
 
 
   public class choice implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         JComboBox cb = (JComboBox)e.getSource();
         String option = (String)cb.getSelectedItem();
         ui.removeAll();
         
         switch(option){
         
            case "Insert Student":
               System.out.println("Insert Student");
               
               JTextField studentId = new JTextField();
               JLabel studentIdLbl = new JLabel("Student Id:");
               
               JTextField fname = new JTextField();
               JLabel fnameLbl = new JLabel("First Name:");
               
               JTextField lname = new JTextField();
               JLabel lnameLbl = new JLabel("Last Name:");
               
               JTextField programTF = new JTextField();
               JLabel programLbl = new JLabel("Program Id:");
               
               JTextField phone = new JTextField();
               JLabel phoneLbl = new JLabel("Phone:");
               
               JTextField email = new JTextField();
               JLabel emailLbl = new JLabel("Email:");
               
               JTextField interests = new JTextField();
               JLabel interestsLbl = new JLabel("Interest (seperate by ','):");
               
            
               ui.add(studentIdLbl);
               ui.add(studentId);
               ui.add(fnameLbl);
               ui.add(fname);
               ui.add(lnameLbl);
               ui.add(lname);
               ui.add(programLbl);
               ui.add(programTF);
               ui.add(phoneLbl);
               ui.add(phone);
               ui.add(emailLbl);
               ui.add(email);
               ui.add(interestsLbl);
               ui.add(interests);
               
               ui.revalidate();
               ui.repaint();
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                     int _stuId = Integer.parseInt(studentId.getText());
                     String _fName = fname.getText();
                     String _lName = lname.getText();
                     int _progId = Integer.parseInt(programTF.getText());
                     String _phn = phone.getText();
                     String _email = email.getText();
                     String _interest = interests.getText();
                     
                     boolean studentInserted = db.insertStudent(_stuId,_fName,_lName,_progId,_phn,_email,_interest);
                     
                     
                     if(studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Successfull");
                     }else if(!studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Failed");
                     }
                     
                     
                  }
               });
               
               break;
            case "Search Student":
               System.out.println("Search Student");
               JTextField interestId_Search = new JTextField();
               JLabel studentLbl_Search = new JLabel("Student Interst Id:");
               
               ui.add(studentLbl_Search);
               ui.add(interestId_Search);
               
               
               ui.revalidate();
               ui.repaint();
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                     ArrayList<Student> studentsFound = db.searchStudent(Integer.parseInt(interestId_Search.getText()));
                     String out = "";
                     
                     for(Student st: studentsFound){
                        out += st.toString();
                     }//ForLoop
                     
                     JOptionPane.showMessageDialog(new JFrame("Students Found"),out);
                  }
               });
               
               break;
            case "Delete Student":
               System.out.println("Search Student");
               JTextField studentName_Delete = new JTextField();
               JLabel studentLbl_Delete = new JLabel("Student Id:");
               
               ui.add(studentLbl_Delete);
               ui.add(studentName_Delete);
               
               
               ui.revalidate();
               ui.repaint();
               
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                     db.deleteStudent(Integer.parseInt(studentName_Delete.getText()));
                     
                     
                     JOptionPane.showMessageDialog(new JFrame("Students Found"),"Delete Succesfull");
                  }
               });
               
               break;
            case "Insert Faculty":
               System.out.println("Insert Faculty");
               
               JTextField facultyId = new JTextField();
               JLabel facultyIdLbl = new JLabel("Faculty Id:");
               
               JTextField fname_faculty = new JTextField();
               JLabel fnameLbl_faculty = new JLabel("First Name:");
               
               JTextField lname_faculty = new JTextField();
               JLabel lnameLbl_faculty = new JLabel("Last Name:");
               
               JTextField deptTF_faculty = new JTextField();
               JLabel deptLbl_faculty = new JLabel("Program Id:");
               
               JTextField phone_faculty = new JTextField();
               JLabel phoneLbl_faculty = new JLabel("Phone:");
               
               JTextField email_faculty = new JTextField();
               JLabel emailLbl_faculty = new JLabel("Email:");
               
               JTextArea abstractTA_faculty = new JTextArea(5, 100);
               JLabel abstractLbl_faculty = new JLabel("Abastract:");
               abstractTA_faculty.setLineWrap(true);
               
               ui.add(facultyIdLbl);
               ui.add(facultyId);
               ui.add(fnameLbl_faculty);
               ui.add(fname_faculty);
               ui.add(lnameLbl_faculty);
               ui.add(lname_faculty);
               ui.add(deptLbl_faculty);
               ui.add(deptTF_faculty);
               ui.add(phoneLbl_faculty);
               ui.add(phone_faculty);
               ui.add(emailLbl_faculty);
               ui.add(email_faculty);
               ui.add(abstractLbl_faculty);
               ui.add(abstractTA_faculty);
               
               ui.revalidate();
               ui.repaint();
               
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                     String _facultyId = facultyId.getText();
                     String _fName = fname_faculty.getText();
                     String _lName = lname_faculty.getText();
                     int deptId = Integer.parseInt(deptTF_faculty.getText());
                     String _phn = phone_faculty.getText();
                     String _email = email_faculty.getText();
                     String _abstract = abstractTA_faculty.getText();
                     
                     db.insertFaculty(Integer.parseInt(_facultyId),_fName,_lName, _abstract,deptId,_phn,_email);
                     
                     
                     // if(studentInserted){
//                         JOptionPane.showMessageDialog(new JFrame("Operation"),"Insert Successfull");
//                      }else if(!studentInserted){
//                         JOptionPane.showMessageDialog(new JFrame("Operation"),"Insert Failed");
//                      }
//                      
                     
                  }
               });
               
               break;
            case "Search Faculty":
               System.out.println("Search Faculty");
               JTextField facultyName_Search = new JTextField();
               JLabel facultyLbl_Search = new JLabel("Keyword:");
               
               ui.add(facultyLbl_Search);
               ui.add(facultyName_Search);
               
               
               ui.revalidate();
               ui.repaint();
               
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                     
                     String key = facultyName_Search .getText();
                     
                     
                     ArrayList<Faculty> facultyFound = db.searchFaculty(key);
                     
                     String out = "";
                     for(Faculty item: facultyFound){
                        out += item.toString();
                     }
                     

                     JOptionPane.showMessageDialog(new JFrame("Faculty found"),"Insert Succesfull");
                    
                     
                     
                  }
               });
               
               break;
            case "Update Student":
               System.out.println("Update Student");
               
               
               
               System.out.println("Insert Student");
               
               JTextField studentId_update = new JTextField();
               JLabel studentIdLbl_update = new JLabel("Student Id:");
               
               JTextField fname_update = new JTextField();
               JLabel fnameLbl_update = new JLabel("First Name:");
               
               JTextField lname_update = new JTextField();
               JLabel lnameLbl_update = new JLabel("Last Name:");
               
               JTextField programTF_update = new JTextField();
               JLabel programLbl_update = new JLabel("Program Id:");
               
               JTextField phone_update = new JTextField();
               JLabel phoneLbl_update = new JLabel("Phone:");
               
               JTextField email_update = new JTextField();
               JLabel emailLbl_update = new JLabel("Email:");
               
               JTextField interests_update = new JTextField();
               JLabel interestsLbl_update = new JLabel("Interest (seperate by ','):");
               
            
               ui.add(studentIdLbl_update);
               ui.add(studentId_update);
               ui.add(fnameLbl_update);
               ui.add(fname_update);
               ui.add(lnameLbl_update);
               ui.add(lname_update);
               ui.add(programLbl_update);
               ui.add(programTF_update);
               ui.add(phoneLbl_update);
               ui.add(phone_update);
               ui.add(emailLbl_update);
               ui.add(email_update);
               ui.add(interestsLbl_update);
               ui.add(interests_update);
               
               
               ui.revalidate();
               ui.repaint();
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                     int studentId2 = Integer.parseInt(studentId_update.getText());
                     String _fName_update = fname_update.getText();
                     String _lName_update = lname_update.getText();
                     String program_update = programTF_update.getText();
                     String _phn_update = phoneLbl_update.getText();
                     String _email_update = email_update.getText();
                     String _interests = interests_update.getText();
                     
                     boolean studentInserted = db.insertStudent(studentId2,_fName_update,_lName_update, Integer.parseInt(program_update) ,_phn_update,_email_update,_interests);
                     
                     
                     if(studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Successfull");
                     }else if(!studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Failed");
                     }
                     
                     
                  }
               });
               
               break;
            case "Delete Faculty":
               System.out.println("Delete Faculty");
               
               JTextField facultyId_Delete = new JTextField();
               JLabel facultyLbl_Delete = new JLabel("Faculty ID:");
               
               ui.add(facultyLbl_Delete);
               ui.add(facultyId_Delete);
               
               
               ui.revalidate();
               ui.repaint();
               
               
               runBtn.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                  
                     int _facultyId_delete = Integer.parseInt(facultyId_Delete.getText());
       
                     
                     boolean studentInserted = db.deleteFaculty(_facultyId_delete);
                                          
                     if(studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Successfull");
                     }else if(!studentInserted){
                        JOptionPane.showMessageDialog(new JFrame("Students Found"),"Insert Failed");
                     }
                     
                     
                  }
               });
               
               break;
            
            default:
            
         
         }            
         
         
        
      }
   }


}