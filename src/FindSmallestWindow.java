import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by gmani on 2/8/16.
 */
public class FindSmallestWindow {

    public static void main (String[] args) {
        int[] arr = new int[]{2, 10, 1, 9, 5, 13, 1, 2, 5};
        int[] pattern = new int[]{1, 2, 5};

        System.out.println(findSmallestWindow(arr, pattern));
    }

    public static String findSmallestWindow(int[] arr, int[] pattern) {
        if (arr.length ==0 || pattern.length == 0) return null;


        PriorityQueue<Integer> index = new PriorityQueue<>();
        Map<Integer, Integer> patternMap = new LinkedHashMap<>();

        for (int i = 0; i < pattern.length; i++) {
            patternMap.put(pattern[i], -1);
        }

        int l =0;
        int r = 0;
        int win = r - l ;
        boolean isLWSet = false;
        int lastRep = 0;
        for (int i =0; i < arr.length ;  i++) {

            if (patternMap.containsKey(arr[i])) {
                if (patternMap.get(arr[i]) == -1){
                    patternMap.put(arr[i], i);
                    r = i;
                    if (l == 0 && !isLWSet) { l = i; isLWSet = true;} ;
                    win = r - l;
                    index.add(i);
                } else {

                if ( !index.isEmpty()) {
                int temp = index.poll();
                if (!index.isEmpty() && win + (i - r) - (index.poll() - temp) < win) {
                    index.add(i);
                    r = i;
                    l = index.peek();
                    win = r -l ;
                    patternMap.put(arr[i], i);
                }}
            }
            //System.out.println("G " + arr[i] );
            }
            System.out.println (arr[i] + " -- " + " i= " + i + " l= " + l + " r= " + r + " w= " + win);
        }


    return win + " is the win size";
    }
}
