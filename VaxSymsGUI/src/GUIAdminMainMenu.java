import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Scanner;
import java.io.File;

public class GUIAdminMainMenu {
    private JFrame frame;
    
    private JPanel topPanel;
    private JPanel titleAndProfilePanel;
    private JPanel titlePanel;
    private JPanel profilePanel;
    private JLabel profile;

    
    private JPanel topLabels;
    private JPanel topLabelsContainer;
    private JLabel movedOrDispatchedDate;
    private JLabel id;
    private JLabel date;
    private JLabel time;
    private JLabel quantity;
    private JLabel brand;
    

    
    private JPanel navPanel;
    private JPanel viewPanel;
    private JPanel dispatchHistoryPanel;
    private JPanel movingHistoryPanel;
    private JPanel footer;

    private JButton close;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int width;
    private int height;

    private JLabel title;
    private JLabel stocksInfo;
    

    private JButton view;
    private JButton add;
    private JButton dispatch;
    private JButton move;
    private JButton dsptchHistory;
    private JButton moveHistory;
    private JButton exit;

    private JScrollPane scroll;

    GridBagConstraints frameConstraints = new GridBagConstraints();
    


    public GUIAdminMainMenu(int w, int h, String centerView){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        // screenSize.width/2 - w / 2
        frame.setLocation(screenSize.width/2 - w / 2, screenSize.height/2 - h / 2);
        frame.setUndecorated(true);
        
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(0,90));
        topPanel.setLayout(new GridLayout(2,0));

        close = new JButton("x");
        close.setSize(5,5);
        close.setBounds(500, 0, 30, 30);

        titleAndProfilePanel = new JPanel();
        // titleAndProfilePanel.setLayout(null);
        titleAndProfilePanel.setLayout(new GridLayout(0,2));
        titleAndProfilePanel.setBackground(new Color(39,44,46));

        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBackground(new Color(39,44,46));

        title = new JLabel("VaxSyms");
        title.setBounds(48, 0, 100, 50);
        title.setForeground(new Color(188,190,191));
        title.setFont(new Font("sans", Font.PLAIN,18));
        title.setBackground(Color.BLACK);

        profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(0,1));
        profilePanel.setBackground(new Color(39,44,46));

        profile = new JLabel("ADMIN               ");
        profile.setHorizontalAlignment(JButton.RIGHT);
        profile.setForeground(new Color(34, 177, 76));
        profile.setFont(new Font("sans", Font.BOLD,18));

        
        topLabels = new JPanel();
        topLabels.setLayout(null);
        topLabels.setBackground(new Color(59,65,68));

        topLabelsContainer = new JPanel();
        topLabelsContainer.setBounds(280, 0, 800, 50);
        topLabelsContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
        topLabelsContainer.setBackground(new Color(59,65,68));
        // topLabelsContainer.setBackground(Color.black);

        movedOrDispatchedDate = new JLabel("    MOVED DATE");
        movedOrDispatchedDate.setOpaque(true);
        movedOrDispatchedDate.setPreferredSize(new Dimension(150,36));
        movedOrDispatchedDate.setBackground(new Color(79, 88, 93));
        movedOrDispatchedDate.setForeground(new Color(188,190,191));
        movedOrDispatchedDate.setFont(new Font("sans", Font.BOLD,17));
        movedOrDispatchedDate.setVisible(false);

        id = new JLabel("    ID");
        id.setOpaque(true);
        id.setPreferredSize(new Dimension(55,36));
        id.setBackground(new Color(79, 88, 93));
        id.setForeground(new Color(188,190,191));
        id.setFont(new Font("sans", Font.BOLD,17));

        date = new JLabel("    DATE");
        date.setOpaque(true);
        date.setPreferredSize(new Dimension(90,36));
        date.setBackground(new Color(79, 88, 93));
        date.setForeground(new Color(188,190,191));
        date.setFont(new Font("sans", Font.BOLD,17));

        time = new JLabel("    TIME");
        time.setOpaque(true);
        time.setPreferredSize(new Dimension(90,36));
        time.setBackground(new Color(79, 88, 93));
        time.setForeground(new Color(188,190,191));
        time.setFont(new Font("sans", Font.BOLD,17));

        quantity = new JLabel("    QUANTITY");
        quantity.setOpaque(true);
        quantity.setPreferredSize(new Dimension(122,36));
        quantity.setBackground(new Color(79, 88, 93));
        quantity.setForeground(new Color(188,190,191));
        quantity.setFont(new Font("sans", Font.BOLD,17));

        brand = new JLabel("    BRAND");
        brand.setOpaque(true);
        brand.setPreferredSize(new Dimension(122,36));
        brand.setBackground(new Color(79, 88, 93));
        brand.setForeground(new Color(188,190,191));
        brand.setFont(new Font("sans", Font.BOLD,17));
        

        navPanel= new JPanel();
        navPanel.setPreferredSize(new Dimension(260,100));
        navPanel.setLayout(new GridLayout(10,1,0,2));
        navPanel.setBackground(new Color(39,44,46));

        viewPanel = new JPanel();
        // viewPanel.setBackground(new Color(240, 240, 240));
        viewPanel.setBackground(Color.lightGray);

        dispatchHistoryPanel = new JPanel();
        dispatchHistoryPanel.setBackground(Color.lightGray);

        movingHistoryPanel = new JPanel();
        movingHistoryPanel.setBackground(Color.lightGray);
        
        width = w;
        height = h;

        view = new JButton("         View Stocks");
        view.setBackground(new Color(23,26,27));
        view.setBorder(BorderFactory.createEmptyBorder());
        view.setForeground(new Color(188,190,191));
        view.setFocusable(false);
        view.setHorizontalAlignment(JButton.LEFT);
        view.setFont(new Font("sans", Font.PLAIN,18));

        add = new JButton("         Add Stocks");
        add.setBackground(new Color(23,26,27));
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setForeground(new Color(188,190,191));
        add.setFocusable(false);
        add.setHorizontalAlignment(JButton.LEFT);
        add.setFont(new Font("sans", Font.PLAIN,18));

        dispatch = new JButton("         Dispatch");
        dispatch.setBackground(new Color(23,26,27));
        dispatch.setBorder(BorderFactory.createEmptyBorder());
        dispatch.setForeground(new Color(188,190,191));
        dispatch.setFocusable(false);
        dispatch.setHorizontalAlignment(JButton.LEFT);
        dispatch.setFont(new Font("sans", Font.PLAIN,18));

        move = new JButton("         Move");
        move.setBackground(new Color(23,26,27));
        move.setBorder(BorderFactory.createEmptyBorder());
        move.setForeground(new Color(188,190,191));
        move.setFocusable(false);
        move.setHorizontalAlignment(JButton.LEFT);
        move.setFont(new Font("sans", Font.PLAIN,18));

        dsptchHistory = new JButton("         Dispatch History");
        dsptchHistory.setBackground(new Color(23,26,27));
        dsptchHistory.setBorder(BorderFactory.createEmptyBorder());
        dsptchHistory.setForeground(new Color(188,190,191));
        dsptchHistory.setFocusable(false);
        dsptchHistory.setHorizontalAlignment(JButton.LEFT);
        dsptchHistory.setFont(new Font("sans", Font.PLAIN,18));
        
        moveHistory = new JButton("         Moving History");
        moveHistory.setBackground(new Color(23,26,27));
        moveHistory.setBorder(BorderFactory.createEmptyBorder());
        moveHistory.setForeground(new Color(188,190,191));
        moveHistory.setFocusable(false);
        moveHistory.setHorizontalAlignment(JButton.LEFT);
        moveHistory.setFont(new Font("sans", Font.PLAIN,18));

        exit = new JButton("         Logout and exit");
        exit.setBackground(new Color(23,26,27));
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setForeground(new Color(237,28,32));
        exit.setFocusable(false);
        exit.setHorizontalAlignment(JButton.LEFT);
        exit.setFont(new Font("sans", Font.PLAIN,18));

        footer = new JPanel();
        footer.setPreferredSize(new Dimension(0,50));
        footer.setBackground(Color.DARK_GRAY);

        if(centerView.equals("main")){
            movedOrDispatchedDate.setVisible(false);
            add.setEnabled(true);
            dispatch.setEnabled(true);
            move.setEnabled(true);
            
            
            scroll = new JScrollPane(viewPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.getVerticalScrollBar().setUnitIncrement(5);            

            try {
                File file = new File("records.txt");
                Scanner scanFile = new Scanner(file);
                int counter = 0;
                
                if (scanFile.hasNextLine()) {
            
                    while (scanFile.hasNextLine()) {
                        counter++;
                        viewPanel.setLayout(new GridLayout(counter,0));
                        stocksInfo = new JLabel("          "+scanFile.nextLine());
                        stocksInfo.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                        stocksInfo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(132, 134, 134)));
                        viewPanel.add(stocksInfo);
                    }
                }else{
                    stocksInfo = new JLabel("No Records. . . ");
                    viewPanel.add(stocksInfo);
                }
                scanFile.close();
            
            } catch (Exception e3) {
                System.out.println(e3);
            }

        }else if(centerView.equals("dispatchHistory")){
            movedOrDispatchedDate.setVisible(true);
            add.setEnabled(false);
            dispatch.setEnabled(false);
            move.setEnabled(false);
            
            scroll = new JScrollPane(dispatchHistoryPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.getVerticalScrollBar().setUnitIncrement(5);  

            try {
                File file = new File("dispatched.txt");
                Scanner scanFile = new Scanner(file);
                int counter = 0;
                
                if (scanFile.hasNextLine()) {
            
                    while (scanFile.hasNextLine()) {
                        counter++;
                        dispatchHistoryPanel.setLayout(new GridLayout(counter,0));
                        stocksInfo = new JLabel("          "+scanFile.nextLine());
                        stocksInfo.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                        stocksInfo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(195, 195, 195)));
                        dispatchHistoryPanel.add(stocksInfo);
                    }
                }else{
                    stocksInfo = new JLabel("No Records. . . ");
                    dispatchHistoryPanel.add(stocksInfo);
                }
                scanFile.close();
            
            } catch (Exception e3) {
                System.out.println(e3);
            }
        }else if(centerView.equals("movingHistory")){
            movedOrDispatchedDate.setVisible(true);
            add.setEnabled(false);
            dispatch.setEnabled(false);
            move.setEnabled(false);

            scroll = new JScrollPane(movingHistoryPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.getVerticalScrollBar().setUnitIncrement(5);  

            try {
                File file = new File("movedStocks.txt");
                Scanner scanFile = new Scanner(file);
                int counter = 0;
                
                if (scanFile.hasNextLine()) {
            
                    while (scanFile.hasNextLine()) {
                        counter++;
                        movingHistoryPanel.setLayout(new GridLayout(counter,0));
                        stocksInfo = new JLabel("          "+scanFile.nextLine());
                        stocksInfo.setFont(new Font("Serif", Font.CENTER_BASELINE,15));
                        stocksInfo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
                        movingHistoryPanel.add(stocksInfo);
                    }
                }else{
                    stocksInfo = new JLabel("No Records. . . ");
                    movingHistoryPanel.add(stocksInfo);
                }
                scanFile.close();
            
            } catch (Exception e3) {
                System.out.println(e3);
            }
        }

        
    }

    public void setGUI(){

        titlePanel.add(title);
        titleAndProfilePanel.add(titlePanel);

        profilePanel.add(profile);
        titleAndProfilePanel.add(profilePanel);

        // titleAndProfilePanel.add(title);
        topLabelsContainer.add(movedOrDispatchedDate);
        topLabelsContainer.add(id);
        topLabelsContainer.add(date);
        topLabelsContainer.add(time);
        topLabelsContainer.add(quantity);
        topLabelsContainer.add(brand);
        topPanel.add(titleAndProfilePanel);
        topLabels.add(topLabelsContainer);
        topPanel.add(topLabels);
        
        navPanel.add(view);
        navPanel.add(add);
        navPanel.add(dispatch);
        navPanel.add(move);
        navPanel.add(dsptchHistory);
        navPanel.add(moveHistory);
        navPanel.add(exit);
        // panel.setVisible(false);

        frame.add(navPanel, BorderLayout.WEST);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);


        frame.setSize(width, height);
        frame.setTitle("VaxSyms");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }



    public void btnListeners(){
        ActionListener btnListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                Object sauce = e.getSource();
                
                if (sauce == view) {
                    refresh();
                } else if(sauce == add){
                    GUIAddStocks addStocks = new GUIAddStocks(450, 250);
                    // AddStocks addStocks = new AddStocks(500, 500);
                    addStocks.setGUI();
                    addStocks.btnListeners();
                }else if(sauce == dispatch){
                    
                    GUIDispatch dispatch = new GUIDispatch(350, 150, "DISPATCH");
                    // AddStocks addStocks = new AddStocks(500, 500);
                    dispatch.setGUI();
                    dispatch.btnListeners();
                }else if(sauce == move){
                    GUIMove move = new GUIMove(350, 150, "MOVE");
                    // AddStocks addStocks = new AddStocks(500, 500);
                    move.setGUI();
                    move.btnListeners();
                }else if(sauce == dsptchHistory){
                    frame.dispose();
                    // GUIDispatchHistory dispatchHistory = new GUIDispatchHistory(1000, 700);
                    // dispatchHistory.setGUI();
                    // dispatchHistory.btnListeners();

                    GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "dispatchHistory");
                    mainMenu.setGUI();
                    mainMenu.btnListeners();
                }else if(sauce == moveHistory){
                    frame.dispose();
                    // GUIMovingHistory movingHistory = new GUIMovingHistory(1000, 700);
                    // movingHistory.setGUI();
                    // movingHistory.btnListeners();

                    GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "movingHistory");
                    mainMenu.setGUI();
                    mainMenu.btnListeners();
                }else if(sauce == exit){
                    System.exit(1);
                }
                
                
            }

        };

        view.addActionListener(btnListener);
        add.addActionListener(btnListener);
        dispatch.addActionListener(btnListener);
        move.addActionListener(btnListener);
        dsptchHistory.addActionListener(btnListener);
        moveHistory.addActionListener(btnListener);
        exit.addActionListener(btnListener);
    } 

    public void refresh() {
        frame.dispose();
        GUIAdminMainMenu mainMenu = new GUIAdminMainMenu(1000, 700, "main");
        mainMenu.setGUI();
        mainMenu.btnListeners();
        // SwingUtilities.updateComponentTreeUI(frame);
        // frame.invalidate();
        // frame.validate();
        // frame.repaint();
    }

    
}
