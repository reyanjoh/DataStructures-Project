import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Auth {
    
    public void logout() throws IOException {
        File file = new File("auth.txt");
        
        Scanner scanFile = new Scanner(file);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("false");
        pw.close();
        scanFile.close();
    }

    public void login() throws IOException {
        File file = new File("auth.txt");
        
        Scanner scanFile = new Scanner(file);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println("true");
        pw.close();
        scanFile.close();
    }
}
