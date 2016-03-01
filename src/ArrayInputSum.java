/**
 * Created by gmani on 2/27/16.
 */

import java.util.Scanner;

public class ArrayInputSum {

        public static void main(String[] args) {
            int input;


            Scanner sc = new Scanner(System.in);
            input = Integer.parseInt(sc.nextLine());

            int sum = 0;
            String s = sc.nextLine();
            String[] sArr = s.split(" ");
            for (int i = 0 ; i < input ; i++ ) {
                    sum += Integer.parseInt(sArr[i]);
                }

            System.out.println(sum);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        }

}
