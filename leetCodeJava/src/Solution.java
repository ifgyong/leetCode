/**
 * Created by Yong on 2019/10/17.
 */
import javafx.util.Pair;
import org.w3c.dom.NodeList;

import java.*;
import java.sql.Array;
import java.util.*;
class TopVotedCandidate2 {
    //911 在线选举
    int[] persons;
    int[] times;
    int t_length = 0;
    HashMap<String,String> retMap = new HashMap<String, String>();
    public TopVotedCandidate2(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.t_length=times.length;
    }
    public int q(int t) {

        if (t < this.times[0]){
            return 0;
        }else if (t==this.times[0]){
            return this.persons[0];
        }
        if (t >= this.times[this.t_length-1]){
            return this.getValueForTimeIndex(this.t_length-1);
        }
        int left = 0,right = this.times.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (t == this.times[mid]){
                return this.getValueForTimeIndex(mid);
            }else if (t <this.times[mid]){
                if ( t >= this.times[mid-1]){
                    return this.getValueForTimeIndex(mid-1);
                }else {
                    right = mid-1;
                }
            }else if (t > this.times[mid]){
                if ( t < this.times[mid+1]){
                    return this.getValueForTimeIndex(mid);
                }else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
    public int getValueForTimeIndex(int t_index){
        String time = Integer.toString(this.times[t_index]);
        if (this.retMap.containsKey(time)){
            return Integer.parseInt(this.retMap.get(time));
        }else {
            int ret = this.success(Arrays.copyOfRange(this.persons,0,t_index+1));
            this.retMap.put(time,Integer.toString(ret));
            return ret;
        }
    }
    public int success(int[] s){
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int maxLength = 0;
        ArrayList arr = new ArrayList();
        int last =0 ;
        for (int i = 0; i < s.length ; i++) {
            String key = String.valueOf(s[i]);
            if (map.containsKey(key)){
                Integer value = map.get(key) + 1;
                if (maxLength <= value){
                    last = s[i];
                    maxLength=value;
                }
                map.put(key,value);
            }else {
                if (maxLength <= 1){
                    last = s[i];
                }
                maxLength = maxLength ==0?1:maxLength;
                arr.add(key);
                map.put(key,1);
            }
        }
        if (maxLength == 0){return 0;}
        return last;
    }
}
class TopVotedCandidate {
    //911 在线选举
    int[] persons;
    int[] times;
    int t_length = 0;
    ArrayList<String> arr = new ArrayList();

    HashMap<String,String> retMap = new HashMap<String, String>();
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.t_length=times.length;
        setAllP(persons);//设置全部获胜的人
    }
    ArrayList arr_All =new ArrayList();
    public void setAllP(int[] p){
        HashMap<String,String> keys = new HashMap<>();//存储所有的人的票数 key:时间 value:获胜者
        //[0,1][2,3][1]
        int now_SuccessMax = 1;//默认 票数1
        int now_success_p = 0;//获胜的人


        HashMap<String,String> p2 = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            ArrayList peo = new ArrayList();
            if (i > 0){
//k:人员id v:票数
//success ：胜利人
//  Successindex:胜利人的index
//  index： 当前人的索引
                String k = Integer.toString(p[i]);
                if (keys.containsKey(k)){
                    String lastCount = p2.get(k).toString();
                    int now_count = Integer.parseInt(lastCount)+1;
                    p2.put(Integer.toString(p[i]),Integer.toString(now_count));//设置该人员的票数

                    if (now_count >= now_SuccessMax){
                        if (now_count > now_SuccessMax ||
                                (now_count == now_SuccessMax )){
                            now_success_p = p[i];//获胜者人
                            arr.add(Integer.toString(now_success_p));//添加上一个成功的人
                        }else {
                            arr.add(arr.get(arr.size()-1));//添加上一个成功的人
                        }
                        now_SuccessMax = now_count;
                    }else {
                        arr.add(arr.get(arr.size()-1));//添加上一个成功的人
                    }
                }else {
                    keys.put(Integer.toString(p[i]),"1");
                    if (now_SuccessMax == 1){
                        now_success_p = p[i];
                        arr.add(Integer.toString(now_success_p));//添加一个成功的人
                    }else {
                        arr.add(arr.get(arr.size()-1));//添加上一个成功的人
                    }
                    p2.put(Integer.toString(p[i]),Integer.toString(1));//存储人员的人和票数
                }
            }else {
                keys.put(Integer.toString(p[0]),Integer.toString(1));
                p2.put(Integer.toString(p[0]),Integer.toString(1));
                arr.add(Integer.toString(p[i]));
            }
        }
    }
    public int q(int t) {
        if (t < this.times[0]){
            return 0;
        }else if (t==this.times[0]){
            return this.persons[0];
        }
        if (t >= this.times[this.t_length-1]){
            return this.getValueForTimeIndex(this.t_length-1);
        }
        int left = 0,right = this.times.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (t == this.times[mid]){
                return this.getValueForTimeIndex(mid);
            }else if (t <this.times[mid]){
                if ( t >= this.times[mid-1]){
                    return this.getValueForTimeIndex(mid-1);
                }else {
                    right = mid-1;
                }
            }else if (t > this.times[mid]){
                if ( t < this.times[mid+1]){
                    return this.getValueForTimeIndex(mid);
                }else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
    public int getValueForTimeIndex(int t_index){
        return Integer.parseInt(this.arr.get(t_index));
    }
}
class SummaryRanges {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        int left=0,right = arr.size()-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            Integer now = arr.get(mid);
            if (now == val){
                return;
            }else if (val > now){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        if (left%2==0){
            if (left < arr.size() && arr.get(left)-1==val){
                arr.set(left,val);
            }else {
                arr.add(left,val);
                arr.add(left,val);
            }
            if (left >0 && arr.get(left)-arr.get(left-1) <= 1){
                arr.remove(left);
                arr.remove(left-1);
            }
        }
    }
    public int[][] getIntervals() {
        int[][] ret = new int[arr.size()/2][2];
        int length = arr.size()/2;
        for (int i = 0; i < length; i++) {
            ret[i][0] = arr.get(i*2);
            ret[i][1] = arr.get(i*2+1);
        }
        return ret;
    }
}
class MyQueue {
    ArrayList<Integer> stack = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack.size() > 0){
            Integer ret = stack.remove(0);
            return ret;
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (stack.size() > 0){
            return stack.get(0);
        }
        return -1;
    }
    /** Get the top element. */
    public int top() {
        if (stack.size() > 0){
            return stack.get(stack.size()-1);
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (stack.size()>0){
            return false;
        }
        return true;
    }
}

class TimeMap {
    class Obj {
        String value;
        int timesamp;
        public Obj(String value,int timesamp){
            this.value = value;
            this.timesamp = timesamp;
        }
    }
    HashMap<String,ArrayList> map = new HashMap<String,ArrayList>();
    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        Obj obj = new Obj(value,timestamp);
        if (map.containsKey(key)){
            ArrayList<Obj> arr = map.get(key);
            arr.add(obj);
            map.put(key,arr);
        }else {
            ArrayList<Obj> arr = new ArrayList<>();
            arr.add(obj);
            map.put(key,arr);
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<Obj> arr = map.get(key);
        int left=0,right = arr.size()-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr.get(mid).timesamp>timestamp){
                right = mid-1;
            }else if (arr.get(mid).timesamp==timestamp){
                return arr.get(mid).value;
            }else {
                left=mid+1;
            }
        }
        if (right >=0 && right<=arr.size()-1){
            return arr.get(right).value;
        }
        return "";

    }
}
public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] arr={a,b,c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int count = 1;
        int a_count=a,b_count=b,c_count=c;
        while (a_count==b_count || b_count==c_count ||a_count==c_count){
            if (a_count==b_count ||a_count==c_count){
                a_count = add(a_count,a);
            }
            if (b_count==c_count){
                b_count = add(b_count,b);
            }
        }
        while (count < n){
            int min_count = min(a_count,b_count,c_count) ;
//            最小的值向上增加
            if (a_count==min_count) {
                a_count = add(a_count,a);
            }else if (b_count==min_count){
                b_count= add(b_count,b);
            }else if (c_count == min_count){
                c_count = add(c_count,c);
            }
//            如果有公倍数则跳过
            while (a_count==b_count || b_count==c_count ||a_count==c_count){
                if (a_count==b_count ||a_count==c_count){
                    a_count = add(a_count,a);
                }
                if (b_count==c_count){
                   b_count = add(b_count,b);
                }
            }
            count ++;
        }
        return min(a_count,b_count,c_count);
    }
    public int min(int a,int b,int c){
        int m = Integer.MAX_VALUE;
        m=a<b?a:b;
        m=m<c?m:c;
        return m;
    }
    public int add(int a,int b){
        if (Integer.MAX_VALUE - a>b){
            a += b;
        }else {
            a = Integer.MAX_VALUE;
        }
        return a;
    }
    public int nthUglyNumber2(int n, int a, int b, int c) {
        int rt = min(a,b,c);
        rt=Integer.MAX_VALUE/n >=rt?rt*n:Integer.MAX_VALUE;

        int left=0,right=rt;
        int[] minPlus= new int[4];
        minPlus[0]=getMinComNumber(a, b);
        minPlus[1]=getMinComNumber(a,c);
        minPlus[2]=getMinComNumber(b,c);
        minPlus[3] = getMinComNumber(a, b, c);

        int[] arr={a,b,c};
        Arrays.sort(arr);
        int m1 = arr[0],m2=arr[1],m3=arr[2];

        while (left<=right){
            int mid = left +(right-left)/2;
            int count1 = mid/m1;
            int count2 = mid/m2;
            int count3 = mid/m3;

            int dis1 = mid/minPlus[0];
            int dis2 = mid/minPlus[1];
            int dis3 = mid/minPlus[2];
            int dis4= mid/minPlus[3];
            int dd = count1+count2+count3 -dis1-dis2-dis3+dis4;
            System.out.println("count:"+dd+" i:"+mid+"l:"+left+" r:"+right);
            if (dd > n){
                right=mid;
            }else if (dd<n){
                if (left==mid && left <right){
                    left=right;
                }else {
                    left = mid;
                }
            }else {
                if (mid%a==0 ||mid%b==0 ||mid%c==0){
                    return mid;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public int getMinComNumber(int a,int b){
        if (Math.min(a,b)==1){
            return Math.max(a,b);
        }else {
            int minCount = Math.min(a,b);
            int maxCount = Math.max(a,b);
            int i = maxCount;
            boolean have = false;
            while (have==false){
                if (i%minCount == 0 && i%maxCount == 0){
                    have=true;
                    break;
                }
                if (Integer.MAX_VALUE - maxCount >=i){
                    i += maxCount;
                }else {
                    break;
                }

            }
            return i;
        }
    }
    public int getMinComNumber(int a,int b,int c){
        int maxN = a>b?a:b;
        maxN = maxN>c?maxN:c;
        int minN = min(a, b, c);
        int minCount = minN;
        int maxCount = maxN;
        int i = maxCount;
        boolean have = false;
        while (have==false){
            if (i%a == 0 && i%b == 0&& i%c==0){
                have=true;
                break;
            }
            if (Integer.MAX_VALUE - maxCount >=i){
                i += maxCount;
            }else {
                break;
            }
        }
        return i;
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0,right = letters.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (letters[mid] <= target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        int index = left%letters.length;
        return letters[index];
    }
    public int[] dailyTemperatures(int[] T) {

        int[] arr2 = new int[T.length];
        Arrays.fill(arr2,0);//填充0

        int[] ret = new int[T.length-1];


        int now_max = 30,now_min = 101;

        for (int i = T.length-1; i >= 0 ; i--) {
            if (T[i] >= now_max){
                arr2[i] = 0;
            }else if (T[i] < now_min){
                arr2[i] = 1;
            }else {
                for (int j = i+1; j <T.length ; j++) {
                    if (T[j] > T[i]){
                        arr2[i] = j-i;
                        break;
                    }
                }
            }
            now_max = Math.max(T[i],now_max);
            now_min = Math.min(T[i],now_min);
        }
        return arr2;
    }
//    岛屿数量
    public int haveChar1(char[][] grid,int x,int y){
        if (x>grid.length){

        }
        if (y>grid.length){

        }
        return 1;
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if (grid[i][j] == '1'){
                    count ++;
                    dfslands(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfslands(char [][] grid,int x,int y){
        if (x<0 || y<0 || x>=grid.length || y >= grid[0].length){
            return;
        }else if (grid[x][y] == '1'){
            grid[x][y] = '0';
            dfslands(grid,x-1,y);
            dfslands(grid,x+1,y);
            dfslands(grid,x,y-1);
            dfslands(grid,x,y+1);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor){
            return image;
        }
        int[][] imageNew = new int[image.length][image[0].length];
        for (int i = 0; i <imageNew.length ; i++) {
            Arrays.fill(imageNew[i],0);
        }
        dfsColor(image,sr,sc,oldColor,newColor,imageNew);
        return image;
    }
    public void dfsColor(int[][] image,int x,int y,int oldColor,int newColor,int[][] newImage){
        if (x<0 || y<0 || x>image.length-1 || y> image[0].length-1 ){return;}
        if (newImage[x][y]==0 && image[x][y] == oldColor)
        {
            image[x][y] = newColor;
            newImage[x][y] = 1;
            dfsColor(image,x+1,y,oldColor,newColor,newImage);
            dfsColor(image,x,y+1,oldColor,newColor,newImage);
            dfsColor(image,x-1,y,oldColor,newColor,newImage);
            dfsColor(image,x,y-1,oldColor,newColor,newImage);
        }
    }

    //1235 规划兼职工作
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxPrice = 0;
        int index = 0;
        while (index < startTime.length){
            int now_price = profit[index];
            int end_time = endTime[index];
            for (int i = index; i < startTime.length; i++) {
                if (startTime[i]>=end_time){
                    now_price += profit[i];
                    end_time = endTime[i];
                }
            }
            maxPrice = Math.max(now_price,maxPrice);
            index ++;
        }
        return maxPrice;
    }
    public String decodeString(String s) {
        StringBuffer strB = new StringBuffer();
        ArrayList arr = new ArrayList();
        for (int i = 0; i <s.length() ; i++) {
            arr.add(s.charAt(i));
            if (s.charAt(i) ==']'){
                arr.remove(arr.size()-1);
//                StringBuffer strSub= new StringBuffer();
                while (true){
                    if (arr.size()>0){
                        if (arr.get(arr.size()-1).toString() .equals("[")){
                            arr.remove(arr.size()-1);
                            //统计数字大小
                            StringBuffer buffer = new StringBuffer();
                            for (int j = arr.size()-1; j >= 0; j--) {
                                char ch = arr.get(j).toString().charAt(0);
                                if (ch >='0' && ch <='9'){
                                    buffer.insert(0,ch);
                                    arr.remove(j);
                                }else {
                                    break;
                                }
                            }
                            //根据数字
                            if (buffer.length()>0){
                                int number = Integer.parseInt(buffer.toString());
                                for (int j = 0; j < number; j++) {
                                    for (int k = 0; k < strB.length();k++ ) {
                                        arr.add(strB.charAt(k));
                                    }
                                }
                                strB.delete(0,strB.length());//删除
                            }

                            break;
                        }else {
                            strB.insert(0,arr.remove(arr.size()-1));
                        }
                    }
                }
            }
        }

        for (int i = 0; i <arr.size() ; i++) {
            strB.append(arr.get(i).toString());
        }
        return strB.toString();
    }
    class Pair{
        Integer roomIndex;
        Integer keyIndex;
        public Pair(Integer obj,Integer value){
            this.roomIndex=obj;
            this.keyIndex = value;
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Pair> arr = new ArrayList<Pair>();
        HashMap roomJoin = new HashMap();

        Pair p = new Pair(0,0);

        arr.add(p);
        roomJoin.put(0,1);
        while (arr.size()>0){

            Pair p1 = arr.get(arr.size()-1);
            int nextRoomIndex = p1.roomIndex;
            List<Integer> keys_Now = rooms.get(p1.roomIndex);
            if (keys_Now.size()<=p1.keyIndex){
                break;
            }
            int nextRoomNumber = keys_Now.get(p1.keyIndex);
            int nowRoom = p1.roomIndex;
            List<Integer> keys = rooms.get(nowRoom);

            if (nextRoomNumber < rooms.size()){
                if (nextRoomNumber == rooms.size()-1){return true;}
                else if (roomJoin.containsKey(nextRoomNumber)){
                    //下个钥匙
                    if (nextRoomIndex+1 < keys.size()){
                        Pair p_next = new Pair(p1.roomIndex,nextRoomIndex+1);
                        arr.remove(arr.size()-1);
                        arr.add(p_next);//更换下一个钥匙开始遍历
                    }else {
                        while (arr.size()>0){
                            arr.remove(arr.size()-1);
                            Pair p_sub = arr.get(arr.size()-1);
                            if (p_sub.keyIndex+1 >= rooms.size()){
                                continue;
                            }else {
                                Pair p_new = new Pair(p_sub.roomIndex,p_sub.keyIndex+1);
                                arr.remove(arr.size()-1);
                                arr.add(p_new);
                                break;
                            }
                        }
                        //删除完了 跳出循环
                        if (arr.size() == 0){
                            break;
                        }
                    }
                }else {
                    if (rooms.get(nextRoomNumber).size() == 0){
                        while (arr.size()>0){
                            arr.remove(arr.size()-1);
                            Pair p_sub = arr.get(arr.size()-1);
                            if (p_sub.keyIndex+1 >= rooms.size()){
                                continue;
                            }else {
                                Pair p_new = new Pair(p_sub.roomIndex,p_sub.keyIndex+1);
                                arr.remove(arr.size()-1);
                                arr.add(p_new);
                                break;
                            }
                        }
                        //删除完了 跳出循环
                        if (arr.size() == 0){
                            break;
                        }
                    }else {
                        Pair p_next = new Pair(nextRoomNumber,0);
                        arr.add(p_next);
                    }

                }
            }
        }
        return false;
    }
    public void delRoom(){

    }
    HashMap<String,Integer> map= new HashMap<String,Integer>();
    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j] = getMatrixValue(matrix,i,j);
            }
        }
        return matrix;
    }
    public int getMatrixValue(int[][] mattrix,int x,int y){
        if (x<0 || x> mattrix.length-1 ||y<0 || y>mattrix[0].length-1){
            return Integer.MAX_VALUE;
        }
        String key = x+":"+y;

        if (map.containsKey(key)){
            return map.get(key);
        }else {
            if (mattrix[x][y] == 0){
                map.put(key.toString(),0);
                setRoundZero(mattrix,x+1,y,1);
                map.put(new StringBuffer().append(x+1).append("_").append(y).toString(),1);
                setRoundZero(mattrix,x-1,y,1);
                map.put(new StringBuffer().append(x-1).append("_").append(y).toString(),1);
                setRoundZero(mattrix,x,y+1,1);
                map.put(new StringBuffer().append(x).append("_").append(y+1).toString(),1);
                setRoundZero(mattrix,x,y-1,1);
                map.put(new StringBuffer().append(x).append("_").append(y-1).toString(),1);
                for (String a:map.keySet()
                     ) {
                    System.out.println(a);

                }
                return 0;
            }else {
                int top = getMatrixValue(mattrix,x,y-1);
                int left = getMatrixValue(mattrix,x-1,y);
                int bottom = getMatrixValue(mattrix,x,y+1);
                int right = getMatrixValue(mattrix,x+1,y);
                int m = min(top,left,right,bottom);
                map.put(key.toString(),m+1);
                return m+1;
            }
        }
    }
    public void setRoundZero(int[][] matrix,int x,int y,int value){
        if (x>=0 && x<matrix.length &&y>=0 &&matrix[0].length >y){
            matrix[x][y] = value;
        }
    }
    public int min(int x,int y,int i,int j){
        int a = 0;
        a = a<x?a:x;
        a=a<y?a:y;
        a=a<i?a:i;
        a=a<j?a:j;
        return a;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int count = 0;
        while (count < houses.length){
            int radiusNow = findTarget(heaters,houses[count]);
            radius = Math.max(radius,radiusNow);
            count ++;
        }
        return radius;
    }
    public int findTarget(int[] houses ,int t){
        int left=0,right = houses.length-1;
        if (t < houses[0]){
             return houses[0] - t;
        }else if (t > houses[right]){
            return t - houses[right];
        }
        while (left<=right){
            int mid = left+(right-left)/2;
            if (houses[mid] == t){
                return 0;
            }
            else if (houses[mid] > t){
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        if (left == 0){
            return t-houses[left];
        }else {
            return Math.min(Math.abs(houses[left]-t),Math.abs(t-houses[left-1]));
        }
    }

    public int numSquares(int n) {
        int count = 1;
        double d = Math.sqrt(n);
        int a = Integer.valueOf(Double.toString(d));
        while (count<=n){

            if (a == d){
                return count;
            }else {

            }
            count ++;
        }


        return 1;
    }
//    887 扔鸡蛋
    public int superEggDrop(int K, int N) {
        if (K == 1){
            return N;
        }
        int count = 1;
        while (K > 1){
            if (N%2 == 0){
                N = N/2;
            }else {
                N = N/2 + 1;
            }
            K--;
        }
        return N + K-1;
    }
    ArrayList <Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        getAllNode(root);
        return list;
    }
    public void getAllNode(TreeNode root){
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1){

        }
        return findTargetSumWays(Arrays.copyOfRange(nums,0,nums.length-1),S-1)+
                findTargetSumWays(Arrays.copyOfRange(nums,0,nums.length-1),S+1);
    }
    public int openLock(String[] deadends, String target) {
        int less0 = 0,bigger0 =0,less1=0,bigger1=0,less2=0,bigger2=0,less3=0,bigger3=0;
        for (int i = 0; i < deadends.length; i++) {
            String str = deadends[i];
            if (str.charAt(0) > target.charAt(0)){
                bigger0 = 1;
            }else if(str.charAt(0) < target.charAt(0)){
                less0 =1;
            }
            if (str.charAt(1) > target.charAt(1)){
                bigger1 = 1;
            }else if(str.charAt(1) < target.charAt(1)){
                less1 =1;
            }
            if (str.charAt(2) > target.charAt(2)){
                bigger2 = 1;
            }else if(str.charAt(2) < target.charAt(2)){
                less2 =1;
            }
            if (str.charAt(3) > target.charAt(3)){
                bigger3 = 1;
            }else if (str.charAt(3) < target.charAt(3)){
                less3 =1;
            }
            if ("0000".equals(str)){
                return -1;
            }
        }
        if ((less0==1 &&bigger0 ==1) ||(less1==1&&bigger1==1) ||
                (less2==1 && bigger2==1) ||(less3==1 && bigger3==1) ){
            return -1;
        }else {
            int count = 0;
            for (int i = 0; i < target.length(); i++) {
                Character character= target.charAt(i);
                int nowSub = Integer.valueOf(character.toString());
                count = count + Math.min(10-nowSub,nowSub);
            }
            return count;
        }
    }


    public int kthGrammar(int N, int K) {
        int lineWidth = N-1 << 2;
        System.out.print(lineWidth);
        return 1;

    }
//    #131 出现一次的数字
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i <nums.length ; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<String,Integer> hashMap = new HashMap();
        for (int i = 0; i < nums1.length ; i++) {
            String key = Integer.toString(nums1[i]);
            if (hashMap.containsKey(key)){
                hashMap.put(key,hashMap.get(key)+1);
            }else {
                hashMap.put(key,1);
            }
        }
        ArrayList<Integer> arr= new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            String key = Integer.toString(nums2[i]);
            if (hashMap.containsKey(key)){
                arr.add(nums2[i]);
                if (hashMap.get(key)-1 == 0){
                    hashMap.remove(key);
                }else {
                    hashMap.put(key,hashMap.get(key)-1);
                }
            }
        }
        int[] ret = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }
    public int[] twoSum(int[] nums, int target) {
        int left=0,right = nums.length-1;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    // 122
    public int maxProfit(int[] prices) {
        int[] newPrice = new int[prices.length];
        int all = 0;
        int lastHihgtPrice = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1] && prices[i+1] > lastHihgtPrice){
                newPrice[i] = prices[i+1]-prices[i];
                all += newPrice[i];
                lastHihgtPrice = prices[i+1];
            }
        }
        return all;
    }
    //123 买卖股票最佳时机3
    public int maxProfit2(int[] prices) {
        int max1=0,max2=0,nowPay = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]){
                nowPay += prices[i+1] - prices[i];
            }else {
                int m = Math.min(max1,max2);
                if (nowPay > m){
                    max1 = nowPay;
                    max2 = Math.max(max1,max2);
                }
                nowPay = 0;
            }
        }
        if (nowPay != 0){
            int m = Math.min(max1,max2);
            if (nowPay > m){
                max1 = nowPay;
                max2 = Math.max(max1,max2);
            }
        }
        return Math.max(max1,max2);
    }
    public boolean isPalindrome(String s) {
        StringBuffer b =new  StringBuffer(s.toLowerCase());
        for (int i =  b.length()-1; i > -1; i--) {
            if (((b.charAt(i) >= 'a' && b.charAt(i) <='z' )||(b.charAt(i)>='0' &&b.charAt(i)<='9' ))==false){
                b.deleteCharAt(i);
            }
        }
        if (b.toString().equals(b.reverse().toString())){

            return true;
        }
        return false;
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0){return "";}
        else if (strs.length == 1){return strs[0];}
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i <strs[0].length() ; i++) {
            char tamp = strs[0].charAt(i);
            ret.append(tamp);
            for (int j = 1; j <strs.length ; j++) {
                if (strs[j].length() <= i){return ret.deleteCharAt(i).toString();}
                char ch2 = strs[j].charAt(i);
                if (tamp != ch2){
                    return ret.deleteCharAt(i).toString();
                }
            }
        }
        //当 所有循环都 通过 ret
        return ret.toString();
    }
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if (map.get(t.charAt(i)) == 0){
                    map.remove(t.charAt(i));
                }
            }else {
                return false;
            }
        }
        if (map.keySet().isEmpty()){
            return true;
        }
        return false;

    }
    public int myAtoi(String str) {
        StringBuffer b = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
              b.deleteCharAt(0);
            }else {
                str = b.toString();
                b = new StringBuffer();
                break;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (((str.charAt(i) == '-' || str.charAt(i)=='+') && b.length()==0 )||(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                b.append(str.charAt(i));
            }else {
                break;
            }
        }


        if (b.length() > 0){
            int i = 0;
            if (b.charAt(0) =='-'){
                i=1;
            }else if (b.charAt(0)=='+'){
                if (b.length() > 1){
                    if (b.charAt(1) < '0' && b.charAt(1) > '9'){
                        return 0;
                    }
                }else if (b.length() == 1){
                    return 0;
                }
            }
            for (int j = i; j < b.length(); j++) {
                if (b.charAt(j) == '0'){
                    b.deleteCharAt(j);
                    j--;
                }else {
                    break;
                }
            }
        }
        if (b.length()>0){
            if (b.charAt(0) == '+'){
                b.deleteCharAt(0);
            }
        }
        if (b.length() == 0){
            return 0;
        }else if (b.length()==1 && b.charAt(0)=='-'){
            return 0;
        }
        String i_Min = Integer.toString(Integer.MIN_VALUE);
        String i_Max = Integer.toString(Integer.MAX_VALUE);
        if (b.charAt(0) == '-'){
            if (b.length() >i_Min.length()){
                return Integer.MIN_VALUE;
            }else if (b.length() == i_Min.length()){
                for (int i = 0; i <b.length() ; i++) {
                    if (b.charAt(i) > i_Min.charAt(i)){
                        return Integer.MIN_VALUE;
                    }else if (b.charAt(i) == i_Min.charAt(i)){
                        continue;
                    }else {
                        return Integer.parseInt(b.toString());
                    }
                }
                return Integer.MIN_VALUE;
            }else {
                return Integer.parseInt(b.toString());
            }
        }else {
            if (b.length() >i_Max.length()){
                return Integer.MAX_VALUE;
            }else if (b.length() == i_Max.length()){
                for (int i = 0; i <b.length() ; i++) {
                    if (b.charAt(i) > i_Max.charAt(i)){
                        return Integer.MAX_VALUE;
                    }else if (b.charAt(i) == i_Max.charAt(i)){
                        continue;
                    }else {
                        return Integer.parseInt(b.toString());
                    }
                }
                return Integer.MAX_VALUE;
            }else {
                return Integer.parseInt(b.toString());
            }
        }
    }

    public String countAndSay(int n) {
        if (n <=1)return "1";
        else {
            String s = "1";
            while (n > 1) {
                StringBuffer b = new StringBuffer();
                char lastCh = s.charAt(0);
                int count = 1;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == lastCh) {
                        count++;
                    } else {
                        b.append(count + ""+lastCh);
                        lastCh = s.charAt(i);
                        count = 1;
                    }
                }
                b.append(count + ""+lastCh);
                s = b.toString();
                b.delete(0, b.length());
                n--;
            }
            return s;
        }
    }
    public void deleteNode(ListNode node) {
        if (node == null)return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0)return head;
        HashMap<Integer,ListNode> map = new HashMap<>();
        int count= 1;
        while (head != null){
            map.put(count,head);
            head=head.next;
            count ++;
        }
        ListNode node= map.get(count-n-1);
        if (node != null){
            if (node.next != null){
                node.next = node.next.next;
            }
        }else {
            return map.get(2);//正数第2个
        }
        return map.get(1);
    }
    public boolean isPalindrome(ListNode head) {
        ArrayList <ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        for (int i = 0; i < list.size()/2 ; i++) {
            if (list.get(i).val != list.get(list.size()-i-1).val){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(ListNode head) {
        if (head == null){return false;}
        ListNode slow = head;
        ListNode fast = head.next;
        if (head.next == null){return false;}
        while (slow != null && fast!= null){
            if (slow.val == fast.val){return true;}
            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                return false;
            }
            fast = fast.next;
        }
        if (slow == null || fast == null){
            return false;
        }else {
            if (slow.val == fast.val){
                return true;
            }
            return false;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ret = new int[m];
        for (int i = 0; i < m; i++) {
            ret[i] = nums1[i];
        }

        int i = 0,j = 0,index = 0;
        while (i < m && j < n){
            if (ret[i] < nums2[j]){
                nums1[index] = ret[i];
                i++;
            }else {
                nums1[index] = nums2[j];
                j++;
            }
            index ++;
        }
        for (int k = i; k < m; k++) {
            nums1[index ] = ret[k];
            index ++;
        }
        for (int k = j; k < n; k++) {
            nums1[index ] = nums2[k];
            index ++;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root ==null){return true;}
//        if (root.left != null){
//            if (root.left.val >= root.val){
//                return false;
//            }
//        }
//        if (root.right != null){
//            if (root.val >= root.right.val){
//                return false;
//            }
//        }
        addBST(root);
        return ret;
    }
    Integer lastItem = Integer.MAX_VALUE;
    boolean ret = true;
    public void addBST(TreeNode root){
        if (root == null)return;
        if (ret == false)return;
        addBST(root.left);
        if (lastItem == Integer.MAX_VALUE){
            lastItem = root.val;
        }else {
            if (root.val <= lastItem){
                ret = false;
            }
        }
        addBST(root.right);
    }
//    打家劫舍1 11 111
    public int rob(int[] nums) {
//0 不偷 1偷
        int[][] dp = new int[nums.length][2];//第一间房子偷
        int[][] dp2 = new int[nums.length][2];//不偷
        if (nums.length > 0){//第一天偷的话的金钱 不偷的话为0，默认就是0，不用处理。
            dp[0][1] = nums[0];
        }else {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = 1; i <nums.length ; i++) {
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][0]+nums[i]/*上次不偷+这次偷*/);
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp2[i][1] = Math.max(dp2[i-1][0],dp2[i-1][0]+nums[i]/*上次不偷+这次偷*/);
            dp2[i][0] = Math.max(dp2[i-1][1],dp2[i-1][0]);

        }
         return Math.max(dp2[nums.length-1][1],dp[nums.length-1][0]);
    }
//最大子序列和
    public int maxSubArray(int[] nums) {
        int m= Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        if (nums.length ==0)return 0;
        else if (nums.length == 1)return  nums[0];

        dp[0] =  nums[0];
        m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] >= 0){
                dp[i] = Math.max(nums[i], dp[i-1] +nums[i]);
            }else {
                dp[i] = nums[i];
            }
            m = Math.max(m,dp[i]);
        }
        return m;
    }
    public int hammingWeight(int n) {
        int dis = 1;
        int count = 0;
        while (dis < 32){
            int now = 1<<dis;
            if ((now & n) == now){
                count ++;
            }
            dis++;
        }
        return count;
    }
    public int hammingDistance(int x, int y) {
        int dis = 0;
        int count = 0;
        int now = 1;
        while (dis < 32){
            if ((now &x ) != (now &y)){
                count ++;
            }
            now = now<<1;
            dis ++;
        }
        return count;
    }
    public int reverseBits(int n) {
        String str= Integer.toBinaryString(n);
        StringBuffer s = new  StringBuffer(str);
        s.reverse();
        return Integer.reverse(n);
    }
    public int missingNumber(int[] nums) {
Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return nums[nums.length-1]+1;
    }
    public List<String> fizzBuzz(int n) {
        int i = 1;
        List<String> arr= new LinkedList<>();
        while (i  <= n){
        if (i %3==0 && i % 5==0){
            arr.add("FizzBuzz");
        }else if (i%3 == 0){
            arr.add("Fizz");
        }else if (i%5 == 0){
            arr.add("Buzz");
        }else {
            arr.add(Integer.toString(i));
        }
            i ++;
        }
        return arr;
    }
    public int countPrimes(int n) {

        int ret = 0;
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);
        for (int i = 2; i*i < n; i++) {
            if (isPrim[i]){
                for (int j = i*i; j < n; j+=i) {
                    isPrim[j]=false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrim[i])ret++;
        }
        return ret;
    }
    public boolean isPowerOfThree(int n) {
         int val = 1;
        for (; val < n; ) {
            val=val*3;
        }
        return val == n;
    }
}

