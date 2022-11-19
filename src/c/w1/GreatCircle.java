public class GreatCircle {
    public static void main(String[] args) {
        final double R = 6371.0;
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);

        double part1 = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double part2 = Math.cos(x1)*Math.cos(x2)*Math.pow(Math.sin((y2 - y1) / 2), 2);
        double part3 = Math.sqrt(part1 + part2);
        double distance = 2 * R * Math.asin(part3);  // https://en.wikipedia.org/wiki/Haversine_formula
        System.out.println(distance + " kilometers");
    }
}
