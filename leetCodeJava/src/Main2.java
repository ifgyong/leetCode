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
        ds1007();
    }
    public static void ds1007(){
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int line = cin.nextInt();
            Stack<Character> stack = new Stack<>();
            int ret = 0;
            for (int j = 0; j < line; j++) {
                stack.clear();
                String s = cin.next();
                for (int i = 0; i < s.length(); i++) {
                    if (stack.size() > 0){
                        Character character = stack.pop();
                        if (character.equals('(') && s.charAt(i) == ')'){
                            continue;
                        }else if (character.equals('[') && s.charAt(i) == ']'){
                            continue;
                        }else if (character.equals('{') && s.charAt(i) == '}'){
                            continue;
                        }else {
                            stack.push(character);
                            stack.push(s.charAt(i));
                        }
                    }else {
                        stack.push(s.charAt(i));
                    }
                }

                
                ret += stack.size();
            }
            System.out.println(ret);
        }
    }

    public static void mergeList(String[] arg){
        Scanner cin = new Scanner(System.in);
        int listSize = cin.nextInt();
        int listCount = 0;
        while (cin.hasNext()){
           int n = cin.nextInt();
           listCount += n;
           int[] nlist = new int[n];
            for (int i = 0; i < n; i++) {
                nlist[i] = cin.nextInt();
            }
        }
        //合并
        int[] ret = new int[listCount];
        for (int i = 0; i < listCount; i++) {

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

