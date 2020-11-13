public class Faculty extends Person {
        
    private int deptId;
    private String deptName;

    public Faculty(int ID, String fname, String lname, int deptId,String deptName, String phone, String email){
        super(ID, fname, lname);
        this.deptId = deptId;
        this.setEmail(email);
        this.setPhone(phone);
    }

    public void setDeptId(int deptId){this.deptId = deptId;}
    public int getDeptId(){return this.deptId;}

    public void setDeptName (String deptName){this.deptName = deptName;}
    public String getDeptName(){return this.deptName;}

    public String toString(){
        String out = "";





        return out;
    }
}
