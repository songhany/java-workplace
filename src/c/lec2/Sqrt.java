package c;
/*  Implement Math.sqrt()

    Newton-Raphson method to compute √c
    1. Intialize t0 = c
    2. Repeat until ti = c / ti  (up to desired precision)
        Set t_i+1 to be the average of ti and c / ti
 */
public class Sqrt {
    public static void main(String[] args) {
        double EPS = 1E-15;  // error tolerance (15 places)
        double c = Double.parseDouble(args[0]);
        double t = c;
        while (Math.abs(t - c/t) > t * EPS)
            t = (c/t + t) / 2.0;
        System.out.println(t);
    }
}
