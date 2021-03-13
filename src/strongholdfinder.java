import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class strongholdfinder extends JFrame{
    private JPanel mainPanel;
    private JTextField sxy;
    private JTextField x1;
    private JTextField x2;
    private JTextField y1;
    private JTextField y2;
    private JButton calculate;
    private JTextArea textArea1;
    private JTextField angle1;
    private JTextField angle2;
    private final static String newline = "\n";

    public strongholdfinder(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        int a = 0;
        if(a == 0) {
            textArea1.setText("1. Take Coords" + newline + "2.Throw Eye" + newline + "3. Put Crosshair on eye." + newline + "4. Put the facing number as A1" + newline + "(On the facing line in F3, there are 2 numbers in ()," + newline + "you want the first one)" + newline + "5. If your eye went right, go right about 500-1000 blocks." + newline + "If your eye went left, go left about 500-1000 blocks." + newline + "6. Repeat Steps 1-4 for X2, Z2, and A2.");

        }
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double xInput = (Double.parseDouble(x1.getText()));
                double yInput = (Double.parseDouble(y1.getText()));
                double x2Input = (Double.parseDouble(x2.getText()));
                double y2Input = (Double.parseDouble(y2.getText()));
                double a1 = (Double.parseDouble(angle1.getText()));
                double a2 = (Double.parseDouble(angle2.getText()));
                double sy = ((yInput*Math.tan(-(a1*(3.1416/180)))) - (y2Input*Math.tan(-(a2*(3.1416/180)))) + x2Input - xInput)/((Math.tan(-(a1*(3.1416/180))))-(Math.tan(-(a2*(3.1416/180)))));
                double sx = ((sy-yInput)*Math.tan(-(a1*(3.1416/180)))) + xInput;
                sxy.setText(Math.round(sx * 100.0) / 100.0 + "," + Math.round(sy * 100.0) / 100.0);
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new strongholdfinder("Stronghold Finder");
        frame.setVisible(true);
        frame.setSize(680,350);
        frame.setLocationRelativeTo(null);
    }

}


