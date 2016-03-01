/**
 * Created by gmani on 2/7/16.
 */
public class FindPatternIn2DArray {
    public static void main(String[] args) {
       int[][] matrix = new int[][]{
                {7,2,8,3,4,5,5,8,6,4},
                {6,7,3,1,1,5,8,6,1,9},
                {8,9,8,8,2,4,2,6,4,3},
                {3,8,3,9,5,0,5,3,2,4},
                {9,5,0,9,5,1,5,8,1,3},
                {3,8,4,3,8,4,5,3,8,4},
                {6,4,7,3,5,3,0,2,9,3},
                {7,0,5,3,1,0,6,6,0,1},
                {0,8,3,4,2,8,2,9,5,6},
                {4,6,0,7,9,2,4,1,3,7},
                {4,6,0,7,9,2,4,1,3,7}
        };
  /*
        int[][] matrix = new int[][] {
                { 9, 5, 0 , 0},
                { 3, 8, 4 , 0},
                { 3, 5, 3 , 0} };
*/
        int[][] pattern = new int[][] {
                { 9, 5, 0 },
                { 3, 8, 4 },
                { 3, 5, 3 } };

        System.out.println(findPattern(matrix, pattern).toString());

    }

    public static class Result {
        int R;
        int C;

        public Result(int R, int C) {
            this.R = R;
            this.C = C;
        }

        @Override
        public String toString(){
            return R+"--"+C;
        }

    }

    public static Result findPattern(int[][] matrix, int[][]pattern ) {
        //lnSystem.out.println(matrix.length + "--" + matrix[0].length);
        if (matrix.length < pattern.length || matrix[0].length < pattern[0].length) {
            return new Result(-1, -1);
        }

        int count = 0;
        //System.out.print(matrix[0].length - pattern[0].length);
        //System.out.println(matrix.length - pattern.length);
        for (int i = 0; i < matrix[0].length - pattern[0].length + 1; i++) {
            for (int j = 0; j < matrix.length - pattern.length + 1; j++) {
                count++;
                int I = i;
                int J = j;
               // System.out.println(matrix[I][J] +"----" + pattern[0][0]);
               //// System.out.println("HI");
                    if (match(matrix, I, J, pattern)) {
                       // System.out.print("HI");
                        return new Result(I, J);
                    }

            }
        }

        System.out.println(count);
        return new Result(-1,-1);


    }

    public static boolean match(int[][] matrix, int i, int j, int[][] pattern) {
        int J = j;
        for (int m = 0 ; m < pattern[0].length ; m++) {
            for (int n = 0; n < pattern.length ; n++) {
                if (matrix[i][j] != pattern[m][n]) {
                    System.out.println(" NO " + pattern[m][n] + " --- " + matrix[i][j] + " " );
                    return false;
                } else {

                    System.out.println(j + " --- " + i + " ");
                    j++;
                }
            }
            i++;
            j = J;
        }
        System.out.println("");
    return true;
    }





}
