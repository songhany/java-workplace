package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EatCandies {
    public static void main(String[] args) {
        System.out.println(EatCandies.maxCandiesCount(new ArrayList<>(Arrays.asList(10, 20, 10))));  // 2
        System.out.println(EatCandies.maxCandiesCount(new ArrayList<>(Arrays.asList(2, 1, 4, 2, 4, 1))));  // 6
        System.out.println(EatCandies.maxCandiesCount(new ArrayList<>(Arrays.asList(1, 2, 4, 8, 16))));  // 0
        System.out.println(EatCandies.maxCandiesCount(new ArrayList<>(Arrays.asList(7, 3, 20, 5, 15, 1, 11, 8, 10))));  // 7
    }

    public static int maxCandiesCount(List<Integer> candies) {  // [1, 2, 1]
        int left = 0;
        int right = candies.size() - 1;
        int count = 0;
        int sumL = 0;
        int sumR = 0;
        int result = 0;
        while (left < right) {
            int lWeight = candies.get(left);
            int rWeight = candies.get(right);

            if (sumL < sumR) {
                sumL += lWeight;
                count++;
                left++;
            } else if (sumL > sumR) {
                sumR += rWeight;
                count++;
                right--;
            }

            if (sumL == sumR) {
                result = Math.max(result, count);
                if (lWeight < rWeight) {
                    sumL += lWeight;
                    count++;
                    left++;
                } else {
                    sumR += rWeight;
                    count++;
                    right--;
                }
            }
        }
        return result;
    }
}
