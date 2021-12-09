
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;



public class GUILoginFrame {
    private JFrame frame;
    private JPanel panel;
    private int width;
    private int height;

    private JLabel usrNameLabel;
    private JTextField usrNameInput;
    private JLabel passwordLabel;
    private JPasswordField passwordInput;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JLabel warning;

    private JButton loginbtn;
    private JButton cancelbtn;
    

    public GUILoginFrame(int w, int h){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setLocation(screenSize.width/2 - w / 2, screenSize.height/2 - h);
        // frame.setLayout(null);
        // frame.setBounds(0,0,500,250);
        // frame.setLocationRelativeTo(null);

        
        panel= new JPanel();
        panel.setLayout(null);
        // panel.setBackground(Color.red);
        width = w;
        height = h;

        usrNameLabel = new JLabel("Username: ");
        usrNameLabel.setBounds(50,60,95,30); 
        usrNameInput = new JTextField();
        usrNameInput.setBorder(BorderFactory.createEmptyBorder());
        usrNameInput.setBounds(150,60,255,30); 

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(50,100,95,30); 
        passwordInput = new JPasswordField();
        passwordInput.setBorder(BorderFactory.createEmptyBorder());
        passwordInput.setBounds(150,100,255,30); 

        warning = new JLabel("");
        warning.setForeground(Color.red);
        warning.setFont(new Font("Serif", Font.CENTER_BASELINE,10));
        warning.setBounds(155,125,295,30); 

        loginbtn = new JButton("Login");
        loginbtn.setBackground(Color.LIGHT_GRAY);
        loginbtn.setBorder(BorderFactory.createEmptyBorder());
        loginbtn.setBounds(150,150,125,30); 
        cancelbtn = new JButton("Cancel");
        cancelbtn.setBackground(Color.LIGHT_GRAY);
        cancelbtn.setBorder(BorderFactory.createEmptyBorder());
        cancelbtn.setBounds(280,150,125,30); 
    }

    public void setGUI(){

        panel.add(usrNameLabel);
        panel.add(usrNameInput);

        panel.add(passwordLabel);
        panel.add(passwordInput);

        panel.add(warning);

        panel.add(loginbtn);
        panel.add(cancelbtn);

        frame.add(panel);
        frame.setSize(width, height);
        frame.setTitle("VaxSyms");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void btnListeners(){
        ActionListener btnListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == loginbtn){
                    String usrnm = usrNameInput.getText();
                    String pass = String.valueOf(passwordInput.getPassword());
                    Login log = new Login();
                    Boolean logog = log.login(usrnm, pass, false);
                    Boolean admin = log.isAdmin(usrnm, pass, false);

                    if(logog){
                        frame.dispose();
                        // warning.setText("success!");
                        GUIRegMainMenu mainMenu = new GUIRegMainMenu(1000, 700, "main");
                        mainMenu.setGUI();
                        mainMenu.btnListeners();

                    }else if(!logog){
                        warning.setText("WARNING!: Incorrect username or password");
                    }

                    if(admin){
                        frame.dispose();
                        // warning.setText("success!");
                        GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "main");
                        mainMenu.setGUI();
                        mainMenu.btnListeners();
                    }
                }
                if(e.getSource()==cancelbtn){
                    System.exit(0);
                }
                
            }

        };

        loginbtn.addActionListener(btnListener);
        cancelbtn.addActionListener(btnListener);
    }
}
