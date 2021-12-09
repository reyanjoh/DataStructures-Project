import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordAddStocks {

    public boolean IsInt(String quantity) {
        Boolean flag=true;
        
        int i = 0, size = quantity.length();
        while (i!=size) {
            if(quantity.charAt(i)>='0'&& quantity.charAt(i)<=9){
                i++;
            }else{
                return flag=false;
            }
            return flag;
        }
        return flag;
    }

    
    public void enterStock(String pName, String quantity) throws IOException {
        
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");



        File file = new File("records.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        
            int id = 0;
            
            while (id<100) {
                id = ((int)(Math.random() * 100000)) % 1000;
            }

            if(Integer.parseInt(quantity)<10){
                pw.println( id + "    |[  " +dateFormat.format(date) + " ][      " + time.format(date) + "      ][           " + quantity + "                ][ " + pName);
            }else if(Integer.parseInt(quantity)<100){
                pw.println(id + "    |[  " +dateFormat.format(date) + " ][      " + time.format(date) + "      ][          " + quantity + "               ][ " + pName);
            }else if(Integer.parseInt(quantity)<1000){  
                pw.println(id + "    |[  " +dateFormat.format(date) + " ][      " + time.format(date) + "      ][           " + quantity + "            ][ " + pName);
            }else if(Integer.parseInt(quantity)<10000){
                pw.println(id + "    |[  " +dateFormat.format(date) + " ][      " + time.format(date) + "      ][           " + quantity + "          ][ " + pName);
            }
        pw.close();
    }
}
