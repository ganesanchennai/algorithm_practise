/**
 * Created by gmani on 2/4/16.
 */

import java.util.ArrayList;
import java.util.List;

public class AmericanFootBallScoreCombination {

    public static int getNoOfWays(int target, List<Integer> scores) {
        int arr[] = new int[target + 1];
        arr[0] = 1;
        for (int i : scores) {
            for (int j = i; j <= target; ++j) {
                arr[j] += arr[j - i];
            }
        }

        return arr[target];
    }

    public static int getNoOfWaysRec(int target) {

        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            System.out.println(target);
            return getNoOfWaysRec(target - 2) + getNoOfWaysRec(target - 3) + getNoOfWaysRec(target - 7);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(2);
        scores.add(3);
        scores.add(7);

        //System.out.println(getNoOfWays(9, scores));
        getNoOfWaysRec(9);
    }
}
