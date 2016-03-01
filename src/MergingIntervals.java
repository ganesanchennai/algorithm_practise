import java.util.*;

public class MergingIntervals {
    public static List mergeIntervals(List<Interval> list) {

        Collections.sort(list, new MergeComparator());

        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i+1).start < list.get(i).end) {
                if (list.get(i+1).end > list.get(i).end) {
                  list.get(i).end = list.get(i+1).end;
                }
                list.remove(i+1);
            } else {
                i++;
            }

        }

        return list;



    }


    public static void main (String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,5));
        list.add(new Interval(2,3));
        list.add(new Interval(6,7));
        list.add(new Interval(8,11));
        list.add(new Interval(10,15));
        list.add(new Interval(11,19));
        list.add(new Interval(15,19));

        List<Interval> mergedList = mergeIntervals(list);

        for(int i =0; i <mergedList.size(); i++) {
            System.out.println(mergedList.get(i).toString());
        }
    }


    public static class Interval{
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end =end;
        }

        public String toString(){
            return "("+this.start +", "+this.end+")";
        }
    }

    public static class MergeComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }

    }
}