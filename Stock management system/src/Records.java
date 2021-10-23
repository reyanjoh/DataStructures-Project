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
        String add = "";
        while (add.equals("")) {

            File file = new File("records.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            System.out.print("Quantity: ");
            String quantity = scan.nextLine();
            System.out.print("Product: ");
            String name = scan.nextLine();
                if(Integer.parseInt(quantity)<10){
                    pw.println(((int)(Math.random() * 100000)) % 1000 + "| [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  " + quantity + "     ] [ " + name);
                }else if(Integer.parseInt(quantity)<100){
                    pw.println(((int)(Math.random() * 100000)) % 1000 + "| [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  " + quantity + "    ] [ " + name);
                }else if(Integer.parseInt(quantity)<1000){  
                    pw.println(((int)(Math.random() * 100000)) % 1000 + "| [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  " + quantity + "   ] [ " + name);
                }else if(Integer.parseInt(quantity)<10000){
                    pw.println(((int)(Math.random() * 100000)) % 1000 + "| [ " +dateFormat.format(date)+ " ] [ " + time.format(date) + " ] [  " + quantity + "  ] [ " + name);
                }
            pw.close();

            System.out.print("\033[H\033[2J"); 
            System.out.println("stock added successfully!");
            System.out.println("add more? [Enter]");
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
        Scanner scan = new Scanner(System.in);
        try {
            File file = new File("records.txt");
            Scanner scanFile = new Scanner(file);

            if (scanFile.hasNextLine()) {
                System.out.println("ID | [    Date    ] [ Time  ] [Quantity] [ Product name      ]");
                while (scanFile.hasNextLine()) {
                    System.out.println(scanFile.nextLine());
                }
            }else{
                System.out.println("No records. . .");
            }

            System.out.println("\n               [1] dispatch stock");
            System.out.println("               [2] Log out & Exit\n");

            System.out.print("               Enter option:");
            String option = scan.nextLine();
            scan.nextLine();

            if(option.equals("1")){
                String filename= "dispatch.txt";
                moveOrDispatch(filename);
            }else{
                System.exit(0);
            }

            scan.close();
            scanFile.close();
            
        } catch (Exception e) {

            System.out.println("No records. . .");
            System.out.println("Please [2] Enter stock records. . .");
            System.out.println("re-run program. . .");

        }
    
    }

    public void moveOrDispatch(String filename) throws IOException {

        System.out.print("\033[H\033[2J"); 

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        try {


            File newFile = new File(filename);
            FileWriter fw = new FileWriter(newFile, true);
            PrintWriter pw = new PrintWriter(fw);

            File temp = new File("temp.txt");
            FileWriter fw1 = new FileWriter(temp, true);
            PrintWriter pw1 = new PrintWriter(fw1);
            
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter ID to Dispatch: ");
            String toDispatch = scan.nextLine();

            // System.out.println("Enter Location to Send: ");
            // String dispatchLocation = scan.nextLine();

            String dispached, recordsFileName = "records.txt";

            File file = new File(recordsFileName);
            Scanner scanFile = new Scanner(file);

            while (scanFile.hasNextLine()) {
                dispached = scanFile.nextLine();

                Scanner yw = new Scanner(dispached);
                yw.useDelimiter("[^0-9]+");

                if(!yw.hasNext(toDispatch)){
                    // System.out.println(yw.next());
                    pw1.println(dispached);
                }
                if(yw.hasNext(toDispatch)){
                   if(filename.equals("dispatch.txt")){

                        System.out.println("ID: " + yw.next() + " successfuly dispatched!!");

                   }else if(filename.equals("movedStocks.txt")){

                        System.out.println("ID: " + yw.next() + " successfuly moved!!");

                   }
                    pw.println( "[ "+ dateFormat.format(date)+ " ] [ " + time.format(date) + " ] | "+dispached);
                }
            
                yw.close();
            }

            pw1.close();
            pw.close();
            scan.close();
            scanFile.close();

            file.delete();
            File dump = new File(recordsFileName);
            temp.renameTo(dump);

        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

    
}
