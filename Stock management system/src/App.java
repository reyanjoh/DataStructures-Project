import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        boolean logedin = false;
        
        if (!logedin) {

            Login log = new Login();
            logedin = log.loginForm(logedin);
            
        }

        if(logedin){
            try {
                MainMenu menu = new MainMenu();
                menu.mainMenu();

                System.out.print("Select Menu: ");
                int select = Integer.parseInt(scan.nextLine());

                menu.selectMenu(select);
                
            } catch (Exception e) {
                
                System.out.println(e);
                System.out.println("Something went wrong. . .");
                
            }            

        }
        
        scan.close();
    }
}
