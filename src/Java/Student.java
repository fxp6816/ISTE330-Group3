public class Student extends Person {
    
    private int programID;
    private String programName;

    public Student(int ID, String fname, String lname, int programId,String programName, String phone, String email){
        super(ID, fname, lname);
        this.programID = programId;
        this.programName = programName;
        this.setEmail(email);
        this.setPhone(phone);
    }

    public void setProgramId(int programId){this.programID = programId;}
    public int getProgramId(){return this.programID;}

    public void setProgramName(String programName){this.programName = programName;}
    public String getProgramName(){return this.programName;}

    public String toString(){
        String out = "";





        return out;
    }
}
