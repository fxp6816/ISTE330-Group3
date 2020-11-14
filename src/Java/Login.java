/**
 *  PresentationLayer.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 11th, 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
   
    public static Font myFontForOutput = new Font("Courier", Font.PLAIN, 16);
    
    JTextField userName;
    JTextField password ;

   public Login(){
      //creating UI and Linking it to the DATA Layer
        super ("RIT - Log in");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);
        this.setLocation(500, 280);
        //add fields
        
        userName = new JTextField(15);
        JLabel userNameLabel = new JLabel("Username:");
        password = new JPasswordField();
        JLabel passwordLabel = new JLabel("Password:");
        userName.setFont(myFontForOutput);
         userName.setForeground(Color.BLUE);
        password.setFont(myFontForOutput);
         password.setForeground(Color.BLUE);
        
        
        this.add(userNameLabel);
        this.add(userName);
        this.add(passwordLabel);
        this.add(password);
        
        
        // add the button for log in
        JButton loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.addActionListener(new loginBtnClicked());
        this.add(loginBtn);
        
        JButton publicUser = new JButton();
        publicUser.setText("Public User / Student");
        publicUser.addActionListener(new publicUserClicked());
        this.add(publicUser);
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
   }


   public class loginBtnClicked implements ActionListener {

        
        public void actionPerformed(ActionEvent event) {
        
            //get the User and the password text
            
            PresentationLayer pl = new PresentationLayer(userName.getText() , password.getText());
            
        }
   }
   
   
   public class publicUserClicked implements ActionListener {
           public void actionPerformed(ActionEvent event) {
               PresentationLayer pl = new PresentationLayer("PUBLIC","");
           }
   }
   

   
   public static void main(String[] args){
   
      Login login = new Login();
   }

}