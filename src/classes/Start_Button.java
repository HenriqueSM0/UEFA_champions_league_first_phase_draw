package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start_Button extends JButton {
    Window_1 W1_connected;
    JLabel Add_teams_text = new JLabel("Choose 36 teams :");

    public void generate_transition_screen () {
        JFrame Transcreen = new JFrame();
        Transcreen.setLayout(null);
        Transcreen.setBounds(350, 220, 200, 100);
        Transcreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Add_teams_text.setBounds(10, 30, 150, 30);
        Transcreen.add(Add_teams_text);
        JButton ok_but = new JButton("OK");
        ok_but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transcreen.dispose();
            }
        });
        ok_but.setBounds(120, 30, 60, 30);
        Transcreen.add(ok_but);
        Transcreen.setVisible(true);
    }

    public void jump_to_window_2 () {
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                W1_connected.dispose();
                new Window_2();
                generate_transition_screen();
            }
            
        });
    }

    public Start_Button (Window_1 W1) {
        setBounds(420, 260, 70, 50);
        setText("DRAW");
        W1_connected = W1;
        jump_to_window_2();
    }
}
