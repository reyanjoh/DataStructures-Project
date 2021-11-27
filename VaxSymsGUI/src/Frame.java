import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame {
    private JFrame frame;
    private int width;
    private int height;

    private JLabel label;
    private JTextField txtfld;
    
    private JButton btn1;
    private JButton btn2;
    

    public Frame(int w, int h){
        frame = new JFrame();
        width = w;
        height = h;

        label = new JLabel("Enter Something");
        txtfld = new JTextField(10);

        btn1 = new JButton("btn1");
        btn2 = new JButton("btn2");
    }

    public void setGUI(){

        Container cp = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        
        cp.setLayout(flow);
        cp.add(label);
        cp.add(txtfld);
        cp.add(btn1);
        cp.add(btn2);

        frame.setSize(width, height);
        frame.setTitle("sad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void btnListeners(){
        ActionListener btnListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.print();
                label.setText(txtfld.getText());
                
            }

        };

        btn1.addActionListener(btnListener);
        btn2.addActionListener(btnListener);
    }
}
