import javax.swing.*;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMainMenu {
    private JFrame frame;
    private JPanel panel;
    private int width;
    private int height;

    private JLabel label;
    
    private JButton add;
    private JButton view;
    private JButton dispatch;
    private JButton move;
    private JButton dsptchHistory;
    private JButton moveHistory;

    
    

    public GUIMainMenu(int w, int h){
        frame = new JFrame();
        frame.setLayout(null);
        // frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);

        panel= new JPanel();
        panel.setBounds(0,20,200,500); 
        panel.setLayout(new GridLayout(8,1));

        width = w;
        height = h;

        label = new JLabel("VaxSyms");
        // label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        // label.setBounds(110,30,125,30); 

        add = new JButton("add");
        add.setBackground(Color.LIGHT_GRAY);
        add.setBorder(BorderFactory.createEmptyBorder());
        // add.setBounds(75,70,125,30);

        view = new JButton("view");
        view.setBackground(Color.LIGHT_GRAY);
        view.setBorder(BorderFactory.createEmptyBorder());
        // view.setBounds(75,105,125,30);

        dispatch = new JButton("dispatch");
        dispatch.setBackground(Color.LIGHT_GRAY);
        dispatch.setBorder(BorderFactory.createEmptyBorder());
        // dispatch.setBounds(75,140,125,30);

        move = new JButton("move");
        move.setBackground(Color.LIGHT_GRAY);
        move.setBorder(BorderFactory.createEmptyBorder());
        // move.setBounds(75,175,125,30);

        dsptchHistory = new JButton("dispatchHistory");
        dsptchHistory.setBackground(Color.LIGHT_GRAY);
        dsptchHistory.setBorder(BorderFactory.createEmptyBorder());
        // dsptchHistory.setBounds(75,210,125,30);

        moveHistory = new JButton("moveHistory");
        moveHistory.setBackground(Color.LIGHT_GRAY);
        moveHistory.setBorder(BorderFactory.createEmptyBorder());
        // moveHistory.setBounds(75,245,125,30);


    }

    public void setGUI(){

        panel.add(label);
        panel.add(add);
        panel.add(view);
        panel.add(dispatch);
        panel.add(move);
        panel.add(dsptchHistory);
        panel.add(moveHistory);

        frame.add(panel);
        frame.setSize(width, height);
        frame.setTitle("VaxSyms");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void btnListeners(){
        ActionListener btnListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                Object sauce = e.getSource();

                if(sauce == add){
                    GUIAddStocks addStocks = new GUIAddStocks(300, 150);
                    // AddStocks addStocks = new AddStocks(500, 500);
                    addStocks.setGUI();
                    addStocks.btnListeners();
                }else if(sauce == view){
                    System.out.print("view");
                }else if(sauce == dispatch){
                    System.out.print("dispatch");
                }else if(sauce == move){
                    System.out.print("move");
                }else if(sauce == dsptchHistory){
                    System.out.print("dsptchHistory");
                }else if(sauce == moveHistory){
                    System.out.print("moveHistory");
                }
                
            }

        };

        add.addActionListener(btnListener);
        view.addActionListener(btnListener);
        dispatch.addActionListener(btnListener);
        move.addActionListener(btnListener);
        dsptchHistory.addActionListener(btnListener);
        moveHistory.addActionListener(btnListener);

        
    }
}
