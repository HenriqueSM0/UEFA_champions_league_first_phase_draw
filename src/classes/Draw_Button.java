package classes;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Draw_Button extends JButton {
    Scroll_Teams ST;

    public ArrayList<String> export () {
        int i;
        ST.teams_selected.clear();
        for (i = 0; i < ST.button_acess.size(); i++) {
            if (ST.button_acess.get(i).selected) ST.teams_selected.add(ST.button_acess.get(i).T);
        }
        ArrayList<String> games_of_teams = new ArrayList<>();
        if (ST.teams_selected.size() != 36) return null;
        Draw D = new Draw();
        for (i = 0; i < 36; i++) {
            D.add_team(ST.teams_selected.get(i));
        }
        D.make_draw();
        for (i = 0; i < 36; i++) {
            games_of_teams.add(ST.teams_selected.get(i).get_games());    
        }
        System.out.println("Oii");
        return games_of_teams;
    }

    public void generate_screen (String text) {
        JFrame Warning_win = new JFrame();
        Warning_win.setBounds(350, 220, 100, 100);
        Warning_win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Warning_win.add(new JLabel(text));
        Warning_win.setVisible(true);
    } 

    public void action () {
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> games_of_teams = export();
                if (games_of_teams == null) generate_screen("36 teams !!!");
                else {
                    new Window_3(games_of_teams);
                    ST.W2.dispose();
                }
            }
            
        });
    }

    public Draw_Button (Scroll_Teams ST) {
        this.ST = ST;
        setPreferredSize(new Dimension(1000, 50));
        setText("DRAW");
        action();
    }
    
}
