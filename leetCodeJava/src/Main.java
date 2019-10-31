import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.countPrimes(10);
        System.out.println(a);




    }
    public static void print(int[] n1){
        System.out.print("[");
        for (int i = 0; i <n1.length ; i++) {
            System.out.print(n1[i] +",");
        }
        System.out.println("]");
    }
    public static void print(SummaryRanges summaryRanges){
        int[][] ret = summaryRanges.getIntervals();
        for (int i = 0; i <ret.length ; i++) {
            int[] item = ret[i];
            System.out.print("["+item[0]+","+item[1]+"]");
        }
    }
}
