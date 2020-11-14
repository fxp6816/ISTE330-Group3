
/**
 *  Faculty.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 13th, 2020
 */

public class Faculty extends Person {
        
    private int deptId;
    private String deptName;
    private String facultyAbstract;

    public Faculty(int ID, String fname, String lname, String facultyAbstract, int deptId,String deptName, String phone, String email){
        super(ID, fname, lname);
        this.deptId = deptId;
        this.facultyAbstract = facultyAbstract;
        this.setEmail(email);
        this.setPhone(phone);
    }

    public void setDeptId(int deptId){this.deptId = deptId;}
    public int getDeptId(){return this.deptId;}

    public void setDeptName (String deptName){this.deptName = deptName;}
    public String getDeptName(){return this.deptName;}

    public void setAbstract(String facultyAbstract){this.facultyAbstract = facultyAbstract;}
    public String getAbstract(){return this.facultyAbstract;}

    public String toString(){
        String out = "";
        out +="Faculty ID: " + this.getId() + "\n";
        out +="Name: " + this.getLName() + ", " + this.getFName() + "\n";
        out +="Phone: " + this.getPhone() + "| Email: " + this.getEmail() + "\n";
        out +="Dept ID: " + this.getDeptId() + "| Dept Name:" + this.getDeptName() + "\n";
        out += "Abstract: " + this.getAbstract() + "\n";

        return out;
    }
}
