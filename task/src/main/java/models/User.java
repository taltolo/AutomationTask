package models;

public class User {
    private String email;
    private String password;
    private String subject;
    private String text;
    private String firstName;
    private String lastName;
    private String username;

    public User(String Email,String password,String subject,String text
                ,String firstName,String lastName,String username){
        this.email=Email;
        this.password=password;
        this.subject=subject;
        this.text=text;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
    }
    public String getText(){
        return this.text;
    }
    public String getSubject(){
        return this.subject;
    }

    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getUserame(){
        return this.username;
    }


    
}
