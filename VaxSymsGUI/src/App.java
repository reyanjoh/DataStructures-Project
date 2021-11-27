


public class App {
    public static void main(String[] args) throws Exception {
        
        boolean logedIn = true;
        if(!logedIn){
            GUILoginFrame LoginFrame = new GUILoginFrame(500, 250);
            LoginFrame.setGUI();
            LoginFrame.btnListeners();
        }else if(logedIn){
            GUIMainMenu mainMenu = new GUIMainMenu(800, 500);
            mainMenu.setGUI();
            mainMenu.btnListeners();
        }
        
        
    }
}
