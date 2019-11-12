import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {


//        Solution2 s = new Solution2();
//        char [] ch1 = new char[]{'5','3','.','.','7','.','.','.','.'};
//        char [] ch2 = new char[]{'6','.','.','1','9','.','.','.','.'};
//        char [] ch3 = new char[]{'.','9','8','.','.','.','.','6','.'};
//        char [] ch4 = new char[]{'8','.','.','.','6','.','.','.','3'};
//        char [] ch5 = new char[]{'4','.','.','8','.','3','.','.','1'};
//        char [] ch6 = new char[]{'7','.','.','.','2','.','.','.','6'};
//        char [] ch7 = new char[]{'.','6','.','.','.','.','2','8','.'};
//        char [] ch8 = new char[]{'.','.','.','4','1','9','.','.','5'};
//        char [] ch9 = new char[]{'.','.','.','.','8','.','.','7','9'};
//
//        char[][] chars = new char[9][];
//        chars[0] =ch1;
//        chars[1] =ch2;
//        chars[2] =ch3;
//        chars[3] =ch4;
//        chars[4] =ch5;
//        chars[5] =ch6;
//        chars[6] =ch7;
//        chars[7] =ch8;
//        chars[8] =ch9;


//ListNode node = ListNode.listNode(new int[]{1,2});
//String[] a = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
//String[] a2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

//char[][] chars= {{'X','X','X','X'},
//        {'X','O','O','X'},
//        {'X','X','O','X'},
//        {'X','O','X','X'}};
        Solution3 s = new Solution3();

int[][] list = {{1,1,0},
                {1,1,0},
                {0,0,1}};


            int a= s.candy(new int[]{1,0,2});
System.out.println(a);


//   [感受迭代的艺术吧 欢迎交流 欢迎start 持续分享好玩的题目和解法](https://github.com/ifgyong/leetCode/wiki)


    }


    public static void print(SummaryRanges summaryRanges){
        int[][] ret = summaryRanges.getIntervals();
        for (int i = 0; i <ret.length ; i++) {
            int[] item = ret[i];
            System.out.print("["+item[0]+","+item[1]+"]");
        }
    }

}
