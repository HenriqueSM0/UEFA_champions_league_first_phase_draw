package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window_2 extends JFrame {

    public Window_2 () {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(new Dimension(1000, 400));
        setVisible(true);
        Scroll_Teams ST = new Scroll_Teams(this);
        add(ST, BorderLayout.CENTER);
        Draw_Button DB = new Draw_Button(ST);
        add(DB, BorderLayout.SOUTH);
    }
}
