
public class MainMenu {

    public void mainMenu() {

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

    public void selectMenu(int select) {

        switch (select) {
            case 1:
                mainMenu();
                selectMenu(select);
            break;
            case 2:
                System.out.println("Enter stock");
            break;
            case 3:
                System.out.println("View stock");
            break;
            case 4:
                System.out.println("Dispatch stock");
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
