package classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Team_Button extends JButton {
    boolean selected;
    Team T;

    public void select () {
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                click_effect();
            }
            
        });
    }
    
    public Team_Button (Team T) {
        selected = false;
        setBackground(new Color(255, 255, 255));
        this.T = T;
        setText(T.name + " | " + T.country);
        select();
    }

    public void click_effect () {
        if (!selected) {
            setBackground(new Color (0, 255, 0));
            selected = true;
        } else {
            setBackground(new Color(255, 255, 255));
            selected = false;
        }
    } 
}
