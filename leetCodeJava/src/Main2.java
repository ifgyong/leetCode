import java.math.BigInteger;
import java.util.*;

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
public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();// 1->2 1指向2
        for (int i = 0; i < prerequisites.length; i++) {
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            set.clear();
            List<Integer> link = new ArrayList<>();

            set.add(prerequisites[i][0]);//记录访问过的点
            link.add(prerequisites[i][0]);
            while (link.isEmpty() == false) {
                Integer last = link.remove(link.size() - 1);
                if (map.containsKey(last)) {
                    Integer next = map.get(last);
                    if (set.contains(next)) {
                        return false;
                    }
                    set.add(next);
                    link.add(next);
                } else {
                    break;
                }
            }
        }
        return true;

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
        int n = 0;
        int m = 0;
        int l = 0;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            n = cin.nextInt();
            m = cin.nextInt();
            l = cin.nextInt();//1无向图 0有向图
            int[][] v= new int[n+1][n+1];
            for (int i = 0; i < m; i++) {
                int l_sub = cin.nextInt();
                int r_sub = cin.nextInt();
                v[l_sub][r_sub] = 1;
                if (l == 1){//无向图
                    v[r_sub][l_sub] = 1;
                }
            }
            if (l == 1){
                printArray(v);
                if (haveCircle2(v)){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }else {//无向图
                boolean[][] visited = new boolean[n+1][n+1];
                int i1 = -1,i2=-1;
                for (int i = 1; i <= n ; i++) {
                    if (i1 != -1 || i2!=-1)break;
                    for (int j = 1; j <= n; j++) {
                        if (v[i][j] == 1){
                            i1 = i;
                            i2 = j;
                            break;
                        }
                    }
                }
                if (i1 != -1 && i2 != -1){
                    boolean haveCircle = dfsHaveCiecle(i1,i2,v,visited,l==0);
                    if (haveCircle){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No");
                    }
                }else {
                    System.out.println("No");
                }
            }
        }
    }

    public static  boolean dfsHaveCiecle(int i,int next,int[][] v,boolean[][] visited,boolean l){
        if (visited[i][next] == true){
            return true;
        }
        visited[i][next] = true;
        for (int j = 1; j < v.length; j++) {
            if (v[next][j] == 1){
                return dfsHaveCiecle(next,j,v,visited,l);
            }
        }
        return false;
    }
    public  static  boolean haveCircle2(int[][] v){
        int p1 = -1,p2= -1;
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (v[i][j] == 1){
                    p1=i;
                    p2=j;
                    break;
                }
            }
            if (p1 != -1)break;
        }
        if (p1 ==-1)return false;
        Stack<Integer> stack1 = new Stack<>();
        int[] color = new int[v.length];
        color[p1] = 1;
        stack1.add(p1);
        v[p2][p1] = 0;
        while (stack1.empty()==false){
            Integer index = stack1.pop();
            for (int i = 1; i < v.length; i++) {
                if (v[index][i] == 1){
                    if (color[i] == 1){
                        return true;
                    }else {
                        v[i][index]=0;
                        stack1.add(i);
                        color[i] = 1;
                    }
                }
            }
        }
        return false;
    }
}

