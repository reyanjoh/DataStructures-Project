import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RecordsmoveOrDispatch {
    

    public RecordsmoveOrDispatch() {
        
    }

    public void moveOrDispatch(String toDispatch, String filename) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

        String formattedDate = myDateObj.format(myFormatObj);

        
        try {


            File newFile = new File(filename);
            FileWriter fw = new FileWriter(newFile, true);
            PrintWriter pw = new PrintWriter(fw);

            File temp = new File("temp.txt");
            FileWriter fw1 = new FileWriter(temp, true);
            PrintWriter pw1 = new PrintWriter(fw1);
            
            Scanner scan = new Scanner(System.in);

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
                   if(filename.equals("dispatched.txt")){
                        System.out.println("ID: " + yw.next() + " successfuly dispatched!!");

                   }else if(filename.equals("movedStocks.txt")){
                        System.out.println("ID: " + yw.next() + " successfuly moved!!");

                   }
                    pw.println( " "+ formattedDate + "   ][    "+dispached);
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