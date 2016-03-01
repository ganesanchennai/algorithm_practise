/**
 * Created by gmani on 2/6/16.
 */
public class LevenshteinsDistance {

    public static int editDistance(String s, String t) {
        int[][] arr = new int[s.length()+1][t.length()+1];

        for (int i = 0; i<= s.length(); i ++) {
            arr[i][0] = i;
        }

        for (int i=0; i<= t.length(); i++) {
            arr[0][i] = i;
        }



        for(int i = 1; i <= s.length(); i++) {
            for(int j= 1; j<= t.length(); j++) {
                int sCost = 0;
                if (s.charAt(i-1) != t.charAt(j-1)) {
                    sCost = 1;
                }

                arr[i][j] = sCost + Math.min(arr[i][j-1], Math.min(arr[i-1][j], arr[i-1][j-1]));

            }
        }

        for(int i = 0; i<= s.length(); i++) {
            for(int j= 0; j<= t.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }

        return arr[s.length()][t.length()];
    }

    public static void main (String[] args) {
        System.out.println(editDistance("Vidur", "Aiduran"));
    }
}
