package classes;

import java.util.ArrayList;
import java.util.Random;

public class Draw {
   ArrayList<Team> teams_to_draw = new ArrayList<>();

   public String add_team (Team T) {
        if (this.teams_to_draw.size() == 36) {
           return "Full list of teams !!";
        }
        if (this.teams_to_draw.size() == 1) {
            if (this.teams_to_draw.get(0).pos > T.pos) this.teams_to_draw.add(0, T);
            else this.teams_to_draw.add(1, T);
            return "Added on draw list !!";
        }
        int i;
        for (i = 0; i < this.teams_to_draw.size() - 1; i++) {
            if (this.teams_to_draw.get(i + 1).pos > T.pos) {
                this.teams_to_draw.add(i + 1, T);
                return "Added on draw list !!";
            }
        }
        this.teams_to_draw.addLast(T);
        return "Added on draw list !!";
    }

    public String try_draw () {
        if (this.teams_to_draw.size() != 36) return "Not enought teams !!! (Needed 36)";
        ArrayList<Team> pot_1_teams = new ArrayList<>();
        ArrayList<Team> pot_2_teams = new ArrayList<>();
        ArrayList<Team> pot_3_teams = new ArrayList<>();
        ArrayList<Team> pot_4_teams = new ArrayList<>();
        int i = 1;
        for (Team T : this.teams_to_draw) {
            T.put_position(i);
            T.reset();
            switch (T.pot) {
                case 1:
                    pot_1_teams.add(T);
                    break;
                case 2 :
                    pot_2_teams.add(T);
                    break;
                case 3 :
                    pot_3_teams.add(T);
                    break;
                case 4 :
                    pot_4_teams.add(T);
                    break;
            } 
            i++;
        }
        Random R = new Random();
        int matcher;
        ArrayList<Integer> pot_1_black_list;
        ArrayList<Integer> pot_2_black_list;
        ArrayList<Integer> pot_3_black_list;
        ArrayList<Integer> pot_4_black_list;
        ArrayList<Team> completed_pot_1 = new ArrayList<>();
        ArrayList<Team> completed_pot_2 = new ArrayList<>();
        ArrayList<Team> completed_pot_3 = new ArrayList<>();
        ArrayList<Team> completed_pot_4 = new ArrayList<>();
        Team T;
        while (completed_pot_1.size() != 9) {
            matcher = R.nextInt(9);
            T = pot_1_teams.get(matcher);
            while (completed_pot_1.contains(T)) {
                matcher = R.nextInt(9);
                T = pot_1_teams.get(matcher);
            }
            pot_1_black_list = new ArrayList<>();
            while (T.pot_1_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_1_black_list.size() != 9) && (!pot_1_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_1_teams.get(matcher))) {
                        Game G = new Game(T, pot_1_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_1_teams.get(matcher).games.add(G);
                        pot_1_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_1_x++;
                        pot_1_teams.get(matcher).pot_1_x++;
                    } 
                    pot_1_black_list.add(matcher);
                } else if (pot_1_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_2_black_list = new ArrayList<>();
            while (T.pot_2_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_2_black_list.size() != 9) && (!pot_2_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_2_teams.get(matcher))) {
                        Game G = new Game(T, pot_2_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_2_teams.get(matcher).games.add(G);
                        pot_2_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_2_x++;
                        pot_2_teams.get(matcher).pot_1_x++;
                    } 
                    pot_2_black_list.add(matcher);
                } else if (pot_2_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_3_black_list = new ArrayList<>();
            while (T.pot_3_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_3_black_list.size() != 9) && (!pot_3_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_3_teams.get(matcher))) {
                        Game G = new Game(T, pot_3_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_3_teams.get(matcher).games.add(G);
                        pot_3_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_3_x++;
                        pot_3_teams.get(matcher).pot_1_x++;
                    }
                    pot_3_black_list.add(matcher);
                } else if (pot_3_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_4_black_list = new ArrayList<>();
            while (T.pot_4_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_4_black_list.size() != 9) && (!pot_4_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_4_teams.get(matcher))) {
                        Game G = new Game(T, pot_4_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_4_teams.get(matcher).games.add(G);
                        pot_4_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_4_x++;
                        pot_4_teams.get(matcher).pot_1_x++;
                    } 
                    pot_4_black_list.add(matcher);
                } else if (pot_4_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            completed_pot_1.add(T);
        }
        while (completed_pot_2.size() != 9) {
            matcher = R.nextInt(9);
            T = pot_2_teams.get(matcher);
            while (completed_pot_2.contains(T)) {
                matcher = R.nextInt(9);
                T = pot_2_teams.get(matcher);
            }
            pot_1_black_list = new ArrayList<>();
            while (T.pot_1_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_1_black_list.size() != 9) && (!pot_1_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_1_teams.get(matcher))) {
                        Game G = new Game(T, pot_1_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_1_teams.get(matcher).games.add(G);
                        pot_1_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_1_x++;
                        pot_1_teams.get(matcher).pot_2_x++;
                    } 
                    pot_1_black_list.add(matcher);
                } else if (pot_1_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_2_black_list = new ArrayList<>();
            while (T.pot_2_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_2_black_list.size() != 9) && (!pot_2_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_2_teams.get(matcher))) {
                        Game G = new Game(T, pot_2_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_2_teams.get(matcher).games.add(G);
                        pot_2_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_2_x++;
                        pot_2_teams.get(matcher).pot_2_x++;
                    }
                    pot_2_black_list.add(matcher);
                } else if (pot_2_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_3_black_list = new ArrayList<>();
            while (T.pot_3_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_3_black_list.size() != 9) && (!pot_3_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_3_teams.get(matcher))) {
                        Game G = new Game(T, pot_3_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_3_teams.get(matcher).games.add(G);
                        pot_3_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_3_x++;
                        pot_3_teams.get(matcher).pot_2_x++;
                    }
                    pot_3_black_list.add(matcher);
                } else if (pot_3_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_4_black_list = new ArrayList<>();
            while (T.pot_4_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_4_black_list.size() != 9) && (!pot_4_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_4_teams.get(matcher))) {
                        Game G = new Game(T, pot_4_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_4_teams.get(matcher).games.add(G);
                        pot_4_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_4_x++;
                        pot_4_teams.get(matcher).pot_2_x++;
                    }
                    pot_4_black_list.add(matcher);
                } else if (pot_4_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            completed_pot_2.add(T);
        }
        while (completed_pot_3.size() != 9) {
            matcher = R.nextInt(9);
            T = pot_3_teams.get(matcher);
            while (completed_pot_3.contains(T)) {
                matcher = R.nextInt(9);
                T = pot_3_teams.get(matcher);
            }
            pot_1_black_list = new ArrayList<>();
            while (T.pot_1_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_1_black_list.size() != 9) && (!pot_1_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_1_teams.get(matcher))) {
                        Game G = new Game(T, pot_1_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_1_teams.get(matcher).games.add(G);
                        pot_1_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_1_x++;
                        pot_1_teams.get(matcher).pot_3_x++;
                    }
                    pot_1_black_list.add(matcher);
                } else if (pot_1_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_2_black_list = new ArrayList<>();
            while (T.pot_2_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_2_black_list.size() != 9) && (!pot_2_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_2_teams.get(matcher))) {
                        Game G = new Game(T, pot_2_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_2_teams.get(matcher).games.add(G);
                        pot_2_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_2_x++;
                        pot_2_teams.get(matcher).pot_3_x++;
                    }
                    pot_2_black_list.add(matcher);
                } else if (pot_2_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_3_black_list = new ArrayList<>();
            while (T.pot_3_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_3_black_list.size() != 9) && (!pot_3_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_3_teams.get(matcher))) {
                        Game G = new Game(T, pot_3_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_3_teams.get(matcher).games.add(G);
                        pot_3_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_3_x++;
                        pot_3_teams.get(matcher).pot_3_x++;
                    }
                    pot_3_black_list.add(matcher);
                } else if (pot_3_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_4_black_list = new ArrayList<>();
            while (T.pot_4_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_4_black_list.size() != 9) && (!pot_4_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_4_teams.get(matcher))) {
                        Game G = new Game(T, pot_4_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_4_teams.get(matcher).games.add(G);
                        pot_4_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_4_x++;
                        pot_4_teams.get(matcher).pot_3_x++;
                    }
                    pot_4_black_list.add(matcher);
                } else if (pot_4_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            completed_pot_3.add(T);
        }
        while (completed_pot_4.size() != 9) {
            matcher = R.nextInt(9);
            T = pot_4_teams.get(matcher);
            while (completed_pot_4.contains(T)) {
                matcher = R.nextInt(9);
                T = pot_4_teams.get(matcher);
            }
            pot_1_black_list = new ArrayList<>();
            while (T.pot_1_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_1_black_list.size() != 9) && (!pot_1_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_1_teams.get(matcher))) {
                        Game G = new Game(T, pot_1_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_1_teams.get(matcher).games.add(G);
                        pot_1_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_1_x++;
                        pot_1_teams.get(matcher).pot_4_x++;
                    } 
                    pot_1_black_list.add(matcher);
                } else if (pot_1_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_2_black_list = new ArrayList<>();
            while (T.pot_2_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_2_black_list.size() != 9) && (!pot_2_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_2_teams.get(matcher))) {
                        Game G = new Game(T, pot_2_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_2_teams.get(matcher).games.add(G);
                        pot_2_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_2_x++;
                        pot_2_teams.get(matcher).pot_4_x++;
                    }
                    pot_2_black_list.add(matcher);
                } else if (pot_2_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_3_black_list = new ArrayList<>();
            while (T.pot_3_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_3_black_list.size() != 9) && (!pot_3_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_3_teams.get(matcher))) {
                        Game G = new Game(T, pot_3_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_3_teams.get(matcher).games.add(G);
                        pot_3_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_3_x++;
                        pot_3_teams.get(matcher).pot_4_x++;
                    }
                    pot_3_black_list.add(matcher);
                } else if (pot_3_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            pot_4_black_list = new ArrayList<>();
            while (T.pot_4_x < 2) {
                matcher = R.nextInt(9);
                if ((pot_4_black_list.size() != 9) && (!pot_4_black_list.contains(matcher))) {
                    if (T.can_play_with(pot_4_teams.get(matcher))) {
                        Game G = new Game(T, pot_4_teams.get(matcher));
                        T.games.add(G);
                        T.countrys_of_games.add(G.country);
                        pot_4_teams.get(matcher).games.add(G);
                        pot_4_teams.get(matcher).countrys_of_games.add(G.country);
                        T.pot_4_x++;
                        pot_4_teams.get(matcher).pot_4_x++;
                    } 
                    pot_4_black_list.add(matcher);
                } else if (pot_4_black_list.size() == 9) return "Permutation uncluky problem !!";
            }
            completed_pot_4.add(T);
        }
        return "Succesful Draw !!";
    }

    public ArrayList<String> make_draw () {
       ArrayList<String> process_states = new ArrayList<>();
       String result;
       while (!(result = try_draw()).equals("Succesful Draw !!")) {
            process_states.add(result);
        } 
        return process_states;
    }
}
