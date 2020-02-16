package plCoderslabWorkshop2.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int id;
    private int user_group_id;
    private String email;
    private String userName;
    private String password;

    public User(){

    }

    public User(String email, String userName, String password, int user_group_id) {
        this.email = email;
        this.user_group_id=user_group_id;
        this.userName = userName;
        hashPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public int getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(int user_group_id) {
        this.user_group_id = user_group_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
