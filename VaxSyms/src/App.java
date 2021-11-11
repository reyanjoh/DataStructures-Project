import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        File file = new File("auth.txt");
        Scanner scanFile = new Scanner(file);

        boolean logedin = Boolean.parseBoolean(scanFile.nextLine());
        boolean admin = logedin;
        if (!logedin) {

            Login log = new Login();
            logedin = log.loginForm(logedin);
            
        }

        if(logedin){
            try {
                MainMenu menu = new MainMenu();
                menu.mainMenu(admin);

                System.out.print("Select Menu: ");
                int select = Integer.parseInt(scan.nextLine());

                menu.selectMenu(select);
                
            } catch (Exception e) {
                
                System.out.println(e);
                System.out.println("Something went wrong. . .");
                
            }            

        }
        scanFile.close();
        scan.close();
    }
}
