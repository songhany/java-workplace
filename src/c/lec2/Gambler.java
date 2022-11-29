package c;
/*
Gambler's Ruin Simulation
Probability of winning = stake / goal
Excepted number of bets = stack * desired gain

eg. stack = 500$, goal = 2500$
20% chance turning $500 into $2500.   500 / 2500 = 20%
Expected to make 1 million $1 bets.   500 * (2500 - 500) = 1,000,000
*/

public class Gambler {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);

        int wins = 0;
        for (int t = 0; t < trials; t++) {
            int cash = stake;
            while (cash > 0 && cash < goal) {
                if (Math.random() < 0.5) cash++;
                else cash--;
            }
            if (cash == goal) wins++;
        }
        System.out.println(wins + " wins of " + trials);
    }
}
