import java.util.*;

/**
 * Created by gmani on 2/7/16.
 */
public class LongestSequenceInList {
    public static void main (String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(8);
        list.add(9);
        list.add(7);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(3);

        System.out.println(findMaxSequence(list));
    }

    public static Seq findMaxSequence(List<Integer> list) {
        if (list.isEmpty()) return null;

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int i =0 ; i < list.size() ; i++) {
            int item = list.get(i);
            if (!map.containsKey(item)) {
                ArrayList<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(item, index);
                System.out.println("Added item " + item + " at index "+ i + " to item ");
            } else {
                ArrayList<Integer> index = (ArrayList) map.get(item);
                index.add(i);
                System.out.println("Added item " + item + " at index " + i + " to item ");


            }
           /* for  (int j : map.get(item)) {
                System.out.print(j);
            }*/
        }


        System.out.print("-------------");


        int maxSeqLength = 0;
        int lIndex = 0;
        int rIndex = 0;
        for (int item : list) {
            int max = 0;
            int indexOne = 0;
            int indexTwo = 1;
            if (map.containsKey(item) && (map.get(item)).size() > 1) {
                System.out.println("HERE");
                ArrayList<Integer> arr = (ArrayList)map.get(item);
                for (int j = 0; j < arr.size() -1; j++) {
                    if (arr.get(j+1) - arr.get(j) > max) {
                        max = arr.get(j+1) - arr.get(j);
                        indexOne = arr.get(j);
                        indexTwo = arr.get(j+1);
                    }
                }
                map.remove(item);
            }

            if (max > maxSeqLength) {
                maxSeqLength = max;
                lIndex = indexOne;
                rIndex = indexTwo;
            }



        }
        return new Seq(maxSeqLength, lIndex, rIndex);
    }

    public static class Seq {
        int max;
        int lIndex;
        int rIndex;

        public Seq(int max, int lIndex, int rIndex) {
            this.max = max;
            this.lIndex = lIndex;
            this.rIndex = rIndex;
        }

        public String toString() {
            return max + " -- " + lIndex + " -- " + rIndex;
        }
    }

}
