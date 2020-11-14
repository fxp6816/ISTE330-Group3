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

    public PresentationLayer(String user, String password){
         super ("RIT - DB");
         System.out.println(user + password);
    
        //creating UI and Linking it to the DATA Layer
        
        this.setLayout(new GridLayout(3,1));
        this.setSize(400, 600);
        this.setLocation(500, 280);
        
        
        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

         //Create the combo box, select item at index 4.
         //Indices start at 0, so 4 specifies the pig.
         JComboBox operations = new JComboBox(petStrings);
         operations.setSelectedIndex(1);
         //operations.addActionListener(this);
        
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    
    
        public class nameofAction implements ActionListener {
           public void actionPerformed(ActionEvent event) {
               //perform action
           }
    }


 }