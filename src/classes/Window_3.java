package classes;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window_3 extends JFrame {
    
    public Window_3 (ArrayList<String> games) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(new Dimension(1000, 400));
        setVisible(true);
        Scroll_Games SG = new Scroll_Games(this);
        SG.pull_games(games);
        add(SG, BorderLayout.CENTER);
    }
}
