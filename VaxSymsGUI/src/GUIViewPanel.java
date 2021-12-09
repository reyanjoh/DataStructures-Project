import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIViewPanel {
    private JPanel panel;
    private JLabel label;


    GUIViewPanel()
    {
        label = new JLabel("VaxSyms");
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setGUI(){
        panel.add(label);
    }

    public JPanel viewPanel() {
        return panel;
    }
 
}