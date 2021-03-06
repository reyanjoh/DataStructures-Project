import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUIAddStocks {
    
    private JFrame frame;
    private JPanel panel;
    private int width;
    private int height;

    private JLabel titLabel;

    private JLabel name;
    private JTextField nametxtfld;

    private JLabel quantity;
    private JTextField quantitytxtfld;

    private JLabel warnings;

    private JButton add;
    private JButton done;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public GUIAddStocks(int w, int h){
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

        titLabel = new JLabel("Add Stocks");
        titLabel.setBounds(180,10,100,30); 

        name = new JLabel("Product Name: ");
        name.setBounds(30,30,250,30); 
        name.setBorder(BorderFactory.createEmptyBorder());

        nametxtfld = new JTextField();
        nametxtfld.setBounds(130,30,250,30); 
        nametxtfld.setBorder(BorderFactory.createEmptyBorder());

        quantity = new JLabel("Quantity: ");
        quantity.setBounds(66,70,250,30); 
        quantity.setBorder(BorderFactory.createEmptyBorder());

        quantitytxtfld = new JTextField();
        quantitytxtfld.setBounds(130,70,250,30); 
        quantitytxtfld.setBorder(BorderFactory.createEmptyBorder());

        warnings = new JLabel("");
        warnings.setForeground(Color.red);
        warnings.setFont(new Font("Serif", Font.CENTER_BASELINE,10));
        
        warnings.setBounds(130,100,250,30); 

        add = new JButton("Add");
        add.setBounds(130,130,124,30); 
        add.setBackground(Color.LIGHT_GRAY);
        add.setBorder(BorderFactory.createEmptyBorder());

        done = new JButton("Done");
        done.setBounds(256,130,124,30); 
        done.setBackground(Color.LIGHT_GRAY);
        done.setBorder(BorderFactory.createEmptyBorder());
    }

    public void setGUI(){
        
        frame.add(titLabel);

        panel.add(name);
        panel.add(nametxtfld);

        panel.add(quantity);
        panel.add(quantitytxtfld);

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

                    
                    String pName = nametxtfld.getText();
                    String quantity = quantitytxtfld.getText();
                    try {

                        Integer.parseInt(quantity); 

                        if (pName.equals("") || quantity.equals("")) {
                            warnings.setText("WARNING!: Empty Input Field");
                            
                        } else {
                            warnings.setText("");
                            RecordAddStocks records = new RecordAddStocks();
                            try {
                                records.enterStock(pName.toString(), quantity.toString());
                                GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "main");
                                mainMenu.refresh();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }  
                        }
                        
                    } catch (Exception ee) {
                        warnings.setText("WARNING!: Enter an ID Number");
                    }

                    
                    

                    System.out.println(pName);
                    System.out.println(quantity);

                    nametxtfld.setText("");
                    quantitytxtfld.setText("");

                }else if(sauce == done){
                    frame.dispose();
                }
                
            }

        };

        add.addActionListener(btnListener);
        done.addActionListener(btnListener);
    }
}
