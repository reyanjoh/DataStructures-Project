


public class App {
    public static void main(String[] args) throws Exception {
        
        boolean logedIn = false;
        if(!logedIn){
            GUILoginFrame LoginFrame = new GUILoginFrame(500, 250);
            LoginFrame.setGUI();
            LoginFrame.btnListeners();
        }else if(logedIn){
            GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "main");
            mainMenu.setGUI();
            mainMenu.btnListeners();
        }
        
        
    }
}
