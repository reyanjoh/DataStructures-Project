import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Records {

    MainMenu menu = new MainMenu();

    public void enterStock() throws IOException {
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        

        Scanner scan = new Scanner(System.in);
        String add = "y";
        while (add.equals("y")) {

            File file = new File("records.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            System.out.println("Enter new stock: ");
            System.out.print("Quantity: ");
            String quantity = scan.nextLine();
            System.out.print("Product: ");
            String name = scan.nextLine();
                if(Integer.parseInt(quantity)<10){
                    pw.println( " [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  000" + quantity + "  ] [ " + name + " ] ");
                }else if(Integer.parseInt(quantity)<100){
                    pw.println( " [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  00" + quantity + "  ] [ " + name + " ] ");
                }else if(Integer.parseInt(quantity)<1000){  
                    pw.println( " [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  0" + quantity + "  ] [ " + name + " ] ");
                }else if(Integer.parseInt(quantity)<10000){
                    pw.println( " [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  " + quantity + "  ] [ " + name + " ] ");
                }
            pw.close();

            System.out.print("\033[H\033[2J"); 
            System.out.println("stock added successfully!");
            System.out.println("add more? [y/n]");
            add = scan.nextLine();
            System.out.print("\033[H\033[2J"); 
        }
        
        System.out.print("\033[H\033[2J"); 
        System.out.println("press [Enter] to Exit");
        scan.nextLine();
        
        scan.close();
    }
    

    public void viewStock() throws IOException {

        System.out.print("\033[H\033[2J"); 
        try {
            File file = new File("records.txt");
            Scanner scan = new Scanner(file);

            if (scan.hasNextLine()) {
                System.out.println("|     Date     |   Time  | Quantity | Product name|");
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            }else{
                System.out.println("No records. . .");
            }
    
            scan.close();
        } catch (Exception e) {

            System.out.println("No records. . .");
            System.out.println("Please [2] Enter stock records. . .");
            System.out.println("re-run program. . .");

        }
        
        
    }
}
