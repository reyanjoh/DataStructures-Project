import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    Scanner scan = new Scanner(System.in);

    public void mainMenu(boolean admin) {

        System.out.print("\033[H\033[2J");
        System.out.println("              WELCOME!");
        System.out.println("____________________________________");
        System.out.println("| => [1]  Main menu                |");
        System.out.println("|    [2]  Enter vanccine stock     |");
        System.out.println("|    [3]  View vanccine stock      |");
        System.out.println("|    [4]  Dispatch vanccine stock  |");
        System.out.println("|    [5]  Move vanccine stock      |");
    if(admin){
        System.out.println("|    [6]  Move history             |");
        System.out.println("|    [7]  Dispatch history         |");
        System.out.println("|    [8]  Log out & Exit           |");
    }else{
        System.out.println("|    [6]  Log out & Exit           |");
    }
        System.out.println("|__________________________________|");  

    }

    public void recordsMenu() {

        System.out.print("\033[H\033[2J");
        System.out.println("    Enter stock");
        System.out.println("___________________");
        

    }

    public void selectMenu(int select) throws IOException {
        String filename;
        Records record = new Records();

        switch (select) {
            case 1:
                File file = new File("auth.txt");
                Scanner scanFile = new Scanner(file);

                boolean admin = Boolean.parseBoolean(scanFile.nextLine());

                mainMenu(admin);
                System.out.print("Select Menu: ");
                select = Integer.parseInt(scan.nextLine());
                selectMenu(select);

            break;
            case 2:
                recordsMenu();
                record.enterStock();
            break;
            case 3:
                record.viewStock();
            break;
            case 4:
                filename = "dispatched.txt";
                record.moveOrDispatch(filename);
            break;
            case 5:
                filename = "movedStocks.txt";
                record.moveOrDispatch(filename);
            break;
            case 6:

                Auth auth = new Auth();
                System.out.print("\033[H\033[2J");
                auth.logout();
                System.out.print("Goodbye. . .\n\n\n");
                System.exit(0);
            break;
            default:
                System.out.println("Something went wrong. . .");
                break;
        }
    }
}
