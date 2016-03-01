import java.util.PriorityQueue;

/**
 * Created by gmani on 2/8/16.
 */
public class ArithmeticSequence {

    public static void main (String[] args) {
        int[] arr = new int[]{1, 9, 5, 13};

        System.out.println(isArithmeticSequence(arr));
    }

    public static boolean isArithmeticSequence(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : arr  ) {
            pq.add(i);
        }

        int diff =0;
        int element = 0;
        if (pq.size() > 2) {
            element = pq.poll();
            diff = pq.peek() - element;
        } else {
            return true;
        }
        boolean isSeq = true;

        while (!pq.isEmpty()) {
            System.out.println(element);
            if (diff != (pq.peek() - element)) {
                isSeq = false;
            }
            element = pq.poll();

        }
        return isSeq;
    }
}
