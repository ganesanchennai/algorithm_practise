import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrimeQueues {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        System.out.println(N);

        int Q =  Integer.parseInt(arr[1]);
        //System.out.println(Q);

        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        for (i = 0; i < N; i++) {
            if (sc.hasNextLine()) dq.addFirst(Integer.parseInt(sc.nextLine()));
            //System.out.println(dq.peekFirst());
        }

        sc.close();
        System.out.println("REACHED");

        int[] PRIMES = new int[Q];
        int k = 0;
        for(int j =2; j< Integer.MAX_VALUE; j++) {
            if (isPrime(j)){
                PRIMES[k++] = j;
            }
            if (k==Q) break;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}