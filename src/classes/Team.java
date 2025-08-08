package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Team {
    String name, country;
    int pos, pot, pot_1_x, pot_2_x, pot_3_x, pot_4_x;
    ArrayList<Game> games;
    ArrayList<String> countrys_of_games;

    Team (String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void reset () {
        pot_1_x = 0;
        pot_2_x = 0;
        pot_3_x = 0;
        pot_4_x = 0;
        games = new ArrayList<>();
        countrys_of_games = new ArrayList<>();
    }

    public String put_position (int pos) {
        if ((pos < 1) || (pos > 36)) {
            return "Invalid position !";
        }
        if ((pos >= 1) && (pos <= 9)) pot = 1;
        if ((pos >= 10) && (pos <= 18)) pot = 2;
        if ((pos >= 19) && (pos <= 27)) pot = 3;
        if ((pos >= 28) && (pos <= 36)) pot = 4;
        return "Sucess !!";
    }

    public String add_in_draw (Draw D) {
        for (Team T : D.teams_to_draw) {
            if (T.pos == pos) {
                return "Already exists other team in this position !!";
            }
        }
        D.add_team(this);
        return "Added with sucess !!";
    }

    public static String pull_from_file (String file_path, ArrayList<Team> teams_pulled) {
        try {
            BufferedReader BR = new BufferedReader(new FileReader(file_path));
            String raw_line, line;
            int count_v, i;
            try {
                while ((raw_line = BR.readLine()) != null) {
                    count_v = 0;
                    line = "" + "\n";
                    for (char C : raw_line.toCharArray()) {
                        if (C != ' ') line = line + C;
                    }
                    for (i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == ',') count_v++;
                    }
                    if (count_v != 1) {
                        BR.close();
                        return "Invalid format !!!";
                    }
                }
                BR.close();
                BR = new BufferedReader(new FileReader(file_path));
                i = 0;
                while ((line = BR.readLine()) != null) {
                    String[] parts = line.split(",", 2);
                    Team T = new Team(parts[0], parts[1]);
                    if (!teams_pulled.contains(T)) teams_pulled.add(T);
                    i++;
                }
                BR.close();
                return "Pulled with sucess !!!";
            } catch (IOException e) {
                return "Could not read line !";
            }
        } catch (FileNotFoundException e) {
           return "Pulled with sucess !!!";
        }
    }

    boolean can_play_with (Team T) {
        if (T.country.equals(country)) {
            return false;
        }
        int same_contry, i, j;
        for (i = 0; i < countrys_of_games.size(); i++) {
            same_contry = 0;
            for (j = 0; j < countrys_of_games.size(); j++) {
                if (countrys_of_games.get(i).equals(countrys_of_games.get(j)) && (!countrys_of_games.get(i).equals(country))) same_contry++;
            }
            if (T.country.equals(countrys_of_games.get(i)) && (same_contry > 1)) {
                return false;
            }
        }
        for (i = 0; i < T.countrys_of_games.size(); i++) {
            same_contry = 0;
            for (j = 0; j < T.countrys_of_games.size(); j++) {
                if (T.countrys_of_games.get(i).equals(T.countrys_of_games.get(j)) && (!T.countrys_of_games.get(i).equals(T.country))) same_contry++;
            }
            if (T.country.equals(T.countrys_of_games.get(i)) && (same_contry > 1)) {
                return false;
            }
        }
        if (((T.pot == 1) && (pot_1_x > 1)) || ((T.pot_1_x > 1) && (pot == 1))) {
            return false;
        } else if (((T.pot == 2) && (pot_2_x > 1)) || ((T.pot_2_x > 1) && (pot == 2))) {
            return false;
        } else if (((T.pot == 3) && (pot_3_x > 1)) || ((T.pot_3_x > 1) && (pot == 3))) {
            return false;
        } else if (((T.pot == 4) && (pot_4_x > 1)) || ((T.pot_4_x > 1) && (pot == 4))) {
            return false;
        }
        if ((games.size() > 0) && (T.games.size() > 0)) {
            if ((games.size() % 2 == 1) && (T.games.size() % 2 == 1)) {
                if (games.getLast().T1.equals(this) && T.games.getLast().T1.equals(T)) return false;
                else if (games.getLast().T2.equals(this) && T.games.getLast().T2.equals(T)) return false;
            }
        }
        return true;
    }
    
    public String get_games () {
        String text = "";
        text += name + " x " + "(";
        int i;
        for (i = 0; i < games.size(); i++) {
            if (games.get(i).T1.equals(this)) text += games.get(i).T2.name + " (H)";
            else text += games.get(i).T1.name + " (A)";
            if (i != games.size() - 1) text += ", ";
        }
        text += ")";
        return text;
    }

}
