
/**
 *  Person.java:
 *  @Author Group-03 [Francisco Paliouras(fxp6816),]
 *  @version Nov 13th, 2020
 */
public class Person {
    //common fields
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String phone;

    public Person(int ID, String fname, String lname){
        this.id = ID;
        this.fName = fname;
        this.lName =lname;
        this.phone ="";
        this.email ="";
    }


    //accesors and mutators
    public int getId(){return this.id;}
    public String getFName(){return this.fName;}
    public String getLName(){return this.lName;}
    public String getPhone (){return this.phone;}
    public String getEmail(){return this.email;}


    public void setFName(String fname){this.fName = fname;}
    public void setLName(String lname){this.lName = lname;}
    public void setEmail(String email){ this.email = email;}
    public void setPhone(String phone){this.phone = phone;}

}
