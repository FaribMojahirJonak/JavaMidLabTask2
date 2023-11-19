public class User {
    private String email;
    private String fullName;
    private String password;

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(int id) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setName(String name) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
