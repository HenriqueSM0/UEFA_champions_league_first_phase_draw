package classes;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Scroll_Games extends JScrollPane {
    JPanel JP = new JPanel();
    ArrayList<Team> teams;

    public void pull_games (ArrayList<String> games_of_teams) {
        for (String str : games_of_teams) {
            JLabel games = new JLabel(str);
            JP.add(games);
            JP.add(new JLabel(" "));
        }

    }

    public Scroll_Games (Window_3 W3) {
        JP.setLayout(new BoxLayout(JP, BoxLayout.Y_AXIS));
        setViewportView(JP);
        teams = new ArrayList<>();
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
}
