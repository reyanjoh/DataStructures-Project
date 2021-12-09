public class Login {
    
    public boolean login(String username, String password, boolean logged) {

        if(username.equals("reyan") && password.equals("12345")){
            return logged = true;
        }
        return logged = false;
    }

    public boolean isAdmin(String username, String password, boolean logged) {

        if(username.equals("admin") && password.equals("admin")){
            return logged = true;
        }
        return logged = false;
    }
}
