/**
 *  PresentationLayer.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 11th, 2020
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PresentationLayer extends JFrame{

   DataLayer db = new DataLayer();
   public JPanel ui;
 
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
     
      JButton runBtn = new JButton("Execute");
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
               
               break;
            case "Search Student":
               System.out.println("Search Student");
               JTextField studentName_Search = new JTextField();
               JLabel studentLbl_Search = new JLabel("Student Name:");
               
               ui.add(studentLbl_Search);
               ui.add(studentName_Search);
               
               
               ui.revalidate();
               ui.repaint();
               
               break;
            case "Delete Student":
               System.out.println("Search Student");
               JTextField studentName_Delete = new JTextField();
               JLabel studentLbl_Delete = new JLabel("Student Name:");
               
               ui.add(studentLbl_Delete);
               ui.add(studentName_Delete);
               
               
               ui.revalidate();
               ui.repaint();
               
               break;
            case "Insert Faculty":
               System.out.println("Insert Faculty");
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
               
               break;
            case "Search Faculty":
               System.out.println("Search Faculty");
               JTextField facultyName_Search = new JTextField();
               JLabel facultyLbl_Search = new JLabel("Faculty Name:");
               
               ui.add(facultyLbl_Search);
               ui.add(facultyName_Search);
               
               
               ui.revalidate();
               ui.repaint();
               
               break;
            case "Update Student":
               System.out.println("Update Student");
               ui.revalidate();
               ui.repaint();
               
               break;
            case "Delete Faculty":
               System.out.println("Delete Faculty");
               JTextField facultyName_Delete = new JTextField();
               JLabel facultyLbl_Delete = new JLabel("Faculty Name:");
               
               ui.add(facultyLbl_Delete);
               ui.add(facultyName_Delete);
               
               
               ui.revalidate();
               ui.repaint();
               
               break;
            
            default:
            
         
         }            
         
         
        
      }
   }


}