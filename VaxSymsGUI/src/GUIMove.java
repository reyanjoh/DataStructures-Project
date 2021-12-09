

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMove {
    
    private JFrame frame;
    private JPanel panel;
    private int width;
    private int height;

    private JLabel titLabel;

    private JLabel name;
    private JTextField nametxtfld;

    private JLabel warnings;

    private JButton add;
    private JButton done;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public GUIMove(int w, int h, String title){
        frame = new JFrame();
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(screenSize.width/2 - w / 2, screenSize.height/3 - h / 2);
        
        // frame.setLocationRelativeTo(null);
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,30,w,h); 
        // panel.setLayout(new GridLayout(8,1));
        
        width = w;
        height = h;

        titLabel = new JLabel(title);
        titLabel.setBounds(160,10,100,30); 

        name = new JLabel("Enter ID: ");
        name.setBounds(10,10,250,30); 
        name.setBorder(BorderFactory.createEmptyBorder());

        nametxtfld = new JTextField();
        nametxtfld.setBounds(80,10,250,30); 
        nametxtfld.setBorder(BorderFactory.createEmptyBorder());

        warnings = new JLabel("");
        warnings.setForeground(Color.red);
        warnings.setFont(new Font("Serif", Font.CENTER_BASELINE,10));
        warnings.setBounds(80,35,250,30); 

        add = new JButton(title);
        add.setBounds(80,60,124,30); 
        add.setBackground(Color.LIGHT_GRAY);
        add.setBorder(BorderFactory.createEmptyBorder());

        done = new JButton("DONE");
        done.setBounds(206,60,124,30); 
        done.setBackground(Color.LIGHT_GRAY);
        done.setBorder(BorderFactory.createEmptyBorder());
    }

    public void setGUI(){
        
        frame.add(titLabel);

        panel.add(name);
        panel.add(nametxtfld); 

        panel.add(warnings);
        // WARNING!: invalid quantity input

        panel.add(add);
        panel.add(done);

        frame.add(panel);
        frame.setSize(width, height);
        frame.setTitle("sad");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void btnListeners(){
        ActionListener btnListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Object sauce = e.getSource();

                if(sauce == add){

                    
                    String toDispatch = nametxtfld.getText(); 

                    if (toDispatch.equals("")) {
                        warnings.setText("WARNING!: Empty Input Field");
                        
                    } else {
                        try {
                            Integer.parseInt(toDispatch); 
                            warnings.setText("");
                            RecordsmoveOrDispatch dispatch = new RecordsmoveOrDispatch();
                            dispatch.moveOrDispatch(toDispatch.toString(), "movedStocks.txt");
                            GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "main");
                            mainMenu.refresh();  
                        } catch (Exception e1) {
                            warnings.setText("WARNING!: Enter an ID Number");
                        }
                        
                    }
                    
                    System.out.println(toDispatch); 

                    nametxtfld.setText(""); 

                }else if(sauce == done){
                    frame.dispose();
                }
                
            }

        };

        add.addActionListener(btnListener);
        done.addActionListener(btnListener);
    }
}
