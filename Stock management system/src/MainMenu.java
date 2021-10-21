import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    Scanner scan = new Scanner(System.in);

    public void mainMenu() {

        System.out.print("\033[H\033[2J");
        System.out.println("          WELCOME!");
        System.out.println("___________________________");
        System.out.println("| => [1]  Main menu       |");
        System.out.println("|    [2]  Enter stock     |");
        System.out.println("|    [3]  View stock      |");
        System.out.println("|    [4]  Dispatch stock  |");
        System.out.println("|    [5]  Move stock      |");
        System.out.println("|    [6]  Log out & Exit  |");
        System.out.println("|_________________________|");

    }

    public void recordsMenu() {

        System.out.print("\033[H\033[2J");
        System.out.println("    Enter stock");
        System.out.println("___________________");
        

    }

    public void selectMenu(int select) throws IOException {

        Records record = new Records();

        switch (select) {
            case 1:
                mainMenu();
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
                record.dispatch();
            break;
            case 5:
                System.out.println("Move stock ");
            break;
            case 6:
                System.out.println("Log out & Exit ");
            break;
            default:
                System.out.println("Something went wrong. . .");
                break;
        }
    }
}
