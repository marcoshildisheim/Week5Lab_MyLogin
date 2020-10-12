package models;

/**
 *
 * @author 820203
 */
public class AccountService 
{
    User abe;
    User barb;
    private String thePassword = "password";
    
    public AccountService()
    {
        this.abe = new User("abe", "password");
        this.barb = new User("barb", "password");
    }
    
    public User login(String username, String Password)
    {
        User user = new User(username, thePassword);
        
        if ((this.abe.getUsername().equals(user.getUsername()) || this.barb.getUsername().equals(user.getUsername())) && thePassword.equals("password"))
        {
            user.setPasswordNull();
            return user;
        }
        
        return null;
    }
    
}
