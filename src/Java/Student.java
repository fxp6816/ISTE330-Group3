/**
 *  Student.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 13th, 2020
 */

import java.util.ArrayList;

public class Student extends Person {
    
    private int programID;
    private String programName;
    private ArrayList<String> interests;

    public Student(int ID, String fname, String lname, int programId,String programName, String phone, String email){
        super(ID, fname, lname);
        this.programID = programId;
        this.programName = programName;
        this.setEmail(email);
        this.setPhone(phone);

        this.interests = new ArrayList<String>();
    }

    public void setProgramId(int programId){this.programID = programId;}
    public int getProgramId(){return this.programID;}

    public void setProgramName(String programName){this.programName = programName;}
    public String getProgramName(){return this.programName;}

    public void addInterest(String interestID){
        this.addInterest(interestID);
    }


    public String  interestsToString(){
        String out = "";
        //header for interests
        out += "Interests: \n";

        for(String item: this.interests){
            out += "- " + item + "\n";
        }

        return out;
    }

    public String toString(){
        String out = "";
        out += "Name: " + this.getLName() + ", "+this.getFName() + "\n";
        out += "Phone: " + this.getPhone() + " | Email: " + this.getEmail()+ "\n"; 
        out += "ProgramID: " + this.getProgramId() + " Program Name: " + this.getProgramName()+ "\n";
        out += this.interestsToString();

        return out;
    }
}
