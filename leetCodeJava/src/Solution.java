/**
 * Created by Yong on 2019/10/17.
 */
import java.*;
import java.sql.Array;
import java.util.*;

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
}
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