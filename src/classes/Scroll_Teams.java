package classes;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Scroll_Teams extends JScrollPane {
    JPanel JP = new JPanel();
    ArrayList<Team> teams_pulled;
    ArrayList<Team_Button> button_acess;
    ArrayList<Team> teams_selected;
    Window_2 W2;

    public void generate_screen (String text) {
        JFrame Warning_win = new JFrame();
        Warning_win.setBounds(350, 220, 100, 100);
        Warning_win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Warning_win.add(new JLabel(text));
        Warning_win.setVisible(true);
    }

    public boolean pull_teams () {
        String result = Team.pull_from_file("src\\files\\teams.txt", teams_pulled);
        if (!result.equals("Pulled with sucess !!!")) {
            generate_screen(result);
            return false;
        }
        for (Team T : teams_pulled) {
            Team_Button BT = new Team_Button(T);
            JP.add(BT);
            button_acess.add(BT);
        }
        return true;
    }

    public Scroll_Teams (Window_2 W2) {
        JP.setLayout(new BoxLayout(JP, BoxLayout.Y_AXIS));
        setViewportView(JP);
        teams_pulled = new ArrayList<>();
        teams_selected = new ArrayList<>();
        button_acess = new ArrayList<>();
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.W2 = W2;
        if (!pull_teams()) W2.dispose();
        else if (teams_pulled.size() < 36) {
            W2.dispose();
            generate_screen("Not enought teams in file !!");
        }
    }
}
