public class Login {

    public boolean signin(boolean loged, String username, String password) {
        boolean logedin = false;

        if(username.equals("sad") && password.equals("sad")){
            logedin = !logedin;
            System.out.print("\033[H\033[2J");
            return logedin;
        }else{
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid Username or Password");

        }
        return logedin;
        
    }

}
