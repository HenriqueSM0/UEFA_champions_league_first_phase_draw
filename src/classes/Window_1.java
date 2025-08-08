package classes;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window_1 extends JFrame {

    JLabel hello_text = new JLabel("UEFA Champions League Draw Simulator :");

    public Window_1 () {
        setLayout(null);
        hello_text.setBounds(350, 220, 300, 20);
        add(hello_text);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 50, 1000, 400);
        Start_Button DB = new Start_Button(this);
        add(DB);
        setVisible(true);
    }
   
    public static void main(String[] args) {
        new Window_1();
    }
    
}
