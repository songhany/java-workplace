public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        while (Math.abs(x) + Math.abs(y) < r) {
            System.out.println("(" + x + ", " + y + ")");
            double probability = Math.random();
            if (probability > 0.75)  // left
                x += 1;
            else if (probability > 0.5)  // right
                x -= 1;
            else if (probability > 0.25)  // up
                y += 1;
            else  // down
                y -= 1;

            steps++;
        }

        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
