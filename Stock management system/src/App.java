import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        boolean loged = false;
        boolean logedin = false;
        
        if (!loged) {

            String username, password;
            
            Login log = new Login();

            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println("  Welcome! \nPlease Login\n");

            System.out.print("Username: ");
            username = scan.nextLine();
            System.out.print("Password: ");
            password = scan.nextLine();

            logedin = log.signin(loged, username, password);

            System.out.flush();  
            
            
        }

        if(logedin){

            
                        
            MainMenu menu = new MainMenu();
            menu.mainMenu();

            System.out.print("Select Menu: ");
            int select = Integer.parseInt(scan.nextLine());

            menu.selectMenu(select);



        }else{
            System.out.println("Something went wrong. . .");
            System.out.println("Please re-run the program. . .");
        }
        
        

        scan.close();
    }
}
