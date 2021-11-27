import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAddStocks {
    private JFrame frame;
    private JPanel panel;
    private int width;
    private int height;

    private JLabel label;
    private JTextField txtfld;
    
    private JButton add;
    private JButton done;
    

    public GUIAddStocks(int w, int h){
        frame = new JFrame();
        // frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        panel= new JPanel();
        panel.setLayout(null);
        // panel.setBounds(0,20,200,500); 
        // panel.setLayout(new GridLayout(8,1));
        
        width = w;
        height = h;

        label = new JLabel("Add Stocks");
        label.setBounds(120,0,100,30); 
        txtfld = new JTextField();
        txtfld.setBounds(5,30,290,30); 
        txtfld.setBorder(BorderFactory.createEmptyBorder());

        add = new JButton("Add");
        add.setBounds(5,65,290,30); 
        add.setBackground(Color.LIGHT_GRAY);
        add.setBorder(BorderFactory.createEmptyBorder());

        done = new JButton("Done");
        done.setBounds(5,100,290,30); 
        done.setBackground(Color.LIGHT_GRAY);
        done.setBorder(BorderFactory.createEmptyBorder());
    }

    public void setGUI(){
        
        panel.add(label);
        panel.add(txtfld);
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
                // System.out.print();
                // label.setText(txtfld.getText());
                if(sauce == add){
                    System.out.print(txtfld.getText());
                    txtfld.setText("");
                }else if(sauce == done){
                    frame.dispose();
                }
                
            }

        };

        add.addActionListener(btnListener);
        done.addActionListener(btnListener);
    }
}
