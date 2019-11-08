import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public Main2() {
    }
public static void  getFi(int n){
    BigInteger v0 = new BigInteger("0");
    BigInteger v1 = new BigInteger("1");
    BigInteger v2 = new BigInteger("2");
    if (n<=0)System.out.println(0);
    if (n==1){System.out.println(1);}else {
        for (int i = 2; i <= n; i++) {
            v2 = v0.add(v1);
            v0 = v1;
            v1 = v2;
        }
        System.out.println(v2);
    }
}
public static  int getCircle(){
    int n = 0, m = 0, l = 0;
    Scanner cin = new Scanner(System.in);
    if (cin.hasNext()){
        n = cin.nextInt();//顶点个数
        m = cin.nextInt();//边的个数
        l= cin.nextInt();
        int[][] p = new int[n+1][n+1];
        int[] p2 = new int[m+1];
        for (int i = 1; i <= m; i++) {
            p2[i] =i;
        }
        //构造邻接表
        for (int i = 0; i < m; i++) {
            int p_l = cin.nextInt();
            int p_r = cin.nextInt();
            if (l == 1){//无向图
                p[p_l][p_r] =1;
                p[p_r][p_l] = 1;
            }else {
                p[p_l][p_r] = 1;
            }
        }
        //
printArray(p);
        for (int i = 1; i < p.length ; i++) {
                HashMap<Integer,Integer> map = new HashMap<>();
                map.put(i,1);
                List<Integer> arr = new ArrayList<>();
                for (int j = 1; j < p[0].length; j++) {
                    if (p[i][j] == 1){
                        map.put(j,1);
                        arr.add(j);
                    }
                    if (arr.size() == 0)continue;
                    while (arr.size() > 0){
                        int last = arr.remove(arr.size()-1);
                        for (int k = 0; k <= n; k++) {
                            if (p[last][k] == 1){
                                //无向图 1->2  2->1 同时存在在存在第三个点的时候才是环
                                if (l == 1){
                                    if (map.containsKey(k) && map.keySet().size() > 2){
                                        return 1;
                                    }else {
                                        map.put(k,1);
                                        arr.add(k);//添加一个点
                                    }
                                }else {
                                    if (map.containsKey(k) && map.keySet().size() > 1){
                                        return 1;
                                    }else {
                                        map.put(k,0);
                                        arr.add(k);//添加一个点
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
    return -1;
}
public static boolean haveCircle(int[][] p){
    int[][] p2= new  int[p.length][];
    for (int i = 2; i < p.length; i++) {
        for (int j = 2; j <p[0].length ; j++) {
            if (p[i][j] == 1){
                p[i][j] = 1;
            }
        }
    }
    return false;
}

public static void printArray(int[][] p){
    for (int i = 0; i < p.length; i++) {
        for (int j = 0; j < p[0].length; j++) {
            System.out.print(p[i][j]);
        }
        System.out.println("");
    }
}
    public static void main(String[] var0) {
        if (getCircle() == -1){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }
}

