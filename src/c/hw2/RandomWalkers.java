public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sumSteps = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                double p = Math.random();
                if (p > 0.75)
                    x += 1;
                else if (p > 0.5)
                    x -= 1;
                else if (p > 0.25)
                    y += 1;
                else
                    y -= 1;
                steps++;
            }
            sumSteps += steps;
        }

        double average = sumSteps / (double)trials;
        System.out.println("average number of steps = " + average);
    }
}

