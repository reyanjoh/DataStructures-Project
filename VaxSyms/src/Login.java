import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public boolean signin(boolean logedin, String username, String password) {

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

    public boolean loginForm(boolean logedin) {
        String username, password;
        
        System.out.print("\033[H\033[2J"); 
        System.out.println("  Welcome! \nPlease Login\n");

        System.out.print("Username: ");
        username = scan.nextLine();
        System.out.print("Password: ");
        password = scan.nextLine();

        logedin = signin(logedin, username, password);
        return logedin;
    }

}
