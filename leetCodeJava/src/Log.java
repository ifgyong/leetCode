import java.util.*;

public class Log {
enum kLogProessState{
    kFYLogStart,kFYLogEnd
}

    public static void print(int[] n1){
        print(kLogProessState.kFYLogStart);
        for (int i = 0; i <n1.length ; i++) {
            System.out.print(n1[i] +",");
        }
        print(kLogProessState.kFYLogEnd);
    }
    public static void print(char[] n1){
        print(kLogProessState.kFYLogStart);
        for (int i = 0; i <n1.length ; i++) {
            System.out.print(n1[i] +",");
        }
        print(kLogProessState.kFYLogEnd);
    }

    public static void print(char[][] n1){
        print(kLogProessState.kFYLogStart);
        for (int i = 0; i <n1.length ; i++) {
            print(kLogProessState.kFYLogStart);
            for (int j = 0; i <n1[0].length ; i++) {
                System.out.print(n1[i][j] +",");
            }
            print(kLogProessState.kFYLogEnd);
        }
        print(kLogProessState.kFYLogEnd);

    }
    public static void print(int[][] n1){
        print(kLogProessState.kFYLogStart);
        for (int i = 0; i <n1.length ; i++) {
            print(kLogProessState.kFYLogStart);
            for (int j = 0; i <n1[0].length ; i++) {
                System.out.print(n1[i][j] +",");
            }
            print(kLogProessState.kFYLogEnd);
        }
        print(kLogProessState.kFYLogEnd);
    }
    private static void print(kLogProessState state){
    switch (state){
        case kFYLogEnd:System.out.println("]");break;
        case kFYLogStart:        System.out.print("[");break;
    }
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

    };
    Stack<Integer> arr = new Stack<>();
    Map<Integer,Integer> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        int ret = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.id == id && map.containsKey(id)==false){
                map.put(id,1);
                int sub = employee.importance;
                for (int j = 0; j < employee.subordinates.size(); j++) {
                    sub += getImportance(employees,employee.subordinates.get(j));//子员工的重要性
                }
                ret += sub;
                break;
            }
        }
        return ret;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {

        if (root == null)return 0;
        int maxRootDpt = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            maxRootDpt = Math.max(maxRootDpt,maxDepth(root.children.get(i)));
        }
        return maxRootDpt + 1;
    }
}
