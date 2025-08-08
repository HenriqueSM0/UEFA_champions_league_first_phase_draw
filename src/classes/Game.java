package classes;

import java.util.Random;

public class Game {
    Team T1, T2;
    String country;

    Game (Team T1, Team T2) {
        if ((T1.games.size() % 2 == 0) && (T2.games.size() % 2 == 0)) {
            Random R = new Random();
            int num = R.nextInt(2);
            if (num == 0) {
                this.T1 = T1;
                this.T2 = T2;
                country = T1.country;
            } else {
                this.T1 = T2;
                this.T2 = T1;
                country = T2.country;
            }
        } else if ((T1.games.size() % 2 == 1) && (T2.games.size() % 2 == 0)) {
            if (T1.games.getLast().T1.equals(T1)) {
                this.T1 = T2;
                this.T2 = T1;
                country = T2.country;
            } else {
                this.T1 = T1;
                this.T2 = T2;
                country = T1.country;
            }
        } else if ((T2.games.size() % 2 == 1) && (T1.games.size() % 2 == 0)) {
            if (T2.games.getLast().T1.equals(T2)) {
                this.T1 = T1;
                this.T2 = T2;
                country = T1.country;
            } else {
                this.T1 = T2;
                this.T2 = T1;
                country = T2.country;
            }
        } else if (T1.games.getLast().T1.equals(T1) && T2.games.getLast().T2.equals(T2)) {
            this.T1 = T2;
            this.T2 = T1;
            country = T2.country;
        } else if (T1.games.getLast().T2.equals(T1) && T2.games.getLast().T1.equals(T2)) {
            this.T1 = T1;
            this.T2 = T2;
            country = T1.country;
        }
    }
}
