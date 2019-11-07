import java.lang.reflect.Array;
import java.util.*;
class NumMatrix {
    Map<String,Integer>map = new HashMap<>();
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int row1 = 0,col1=0;
        for (int i = 1; i < matrix.length; i++) {
            int row2 = i;
            for (int j = 1; j < matrix[0].length; j++) {
                int col2 = j;
                String key = row1+","+col1+","+row2+","+col2;
                int sum = sumRegion(row1,col1,row2,col2);
                map.put(key,sum);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        String key = row1+","+col1+","+row2+","+col2;
        if (map.containsKey(key)==false){
            int count = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    count += this.matrix[i][j];
                }
            }
            map.put(key,count);
            return count;
        }else {
            return map.get(key);
        }
    }
}
public class Solution2 {
//11.盛水最多容器
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0,right=height.length-1;
        while (left < right){
            int min = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,min*(right-left));
            if (height[left] < height[right]){
                left ++;
            }else {
                right --;
            }
        }
        return maxArea;
    }
    //35 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)return 0;
        int ret = 0;
        int l =0 ,r = nums.length-1;
        while (l<= r){
            int mid = l+(r-l)/2;
            if (nums[mid] < target){
                l=mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }


//42 接雨水
class ObjIndexAndVal{
    int val;
    int index;
    ObjIndexAndVal(int val,int index){
        this.index = index;
        this.val = val;
    }
}
    public int trap(int[] height) {

        ObjIndexAndVal obj1 = new ObjIndexAndVal(0,0);
        ObjIndexAndVal obj2 = new ObjIndexAndVal(0,0);
        int l=0,r=height.length-1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= obj1.val){
                obj1.val = height[i];
                obj1.index = i;
            }
        }
        obj2.index = obj1.index;
        obj2.val = obj1.val;
        int size = 0;

        while (obj1.index != 0 || obj2.index != height.length-1){

            ObjIndexAndVal objSub = getObjIndexAndVal(height,0,obj1.index-1);
            if (objSub.val != 0){
                int minH = Math.min(obj1.val,objSub.val);
                for (int i = objSub.index + 1; i < obj1.index; i++) {
                    size += (minH-height[i]);
                }
                obj1.index = objSub.index;
                obj1.val = objSub.val;
            }else {
                obj1.index = 0;
                obj1.val = objSub.val;
            }

            ObjIndexAndVal objSub2 = getObjIndexAndVal(height,obj2.index+1,height.length-1);
            if (obj2.val != 0){
                int minH2 = Math.min(obj2.val,objSub2.val);
                for (int i = obj2.index + 1; i < objSub2.index; i++) {
                    size += (minH2 - height[i] );
                }
                obj2.index = objSub2.index;
                obj2.val = objSub2.val;
            }else {
                obj2.index = height.length-1;
                obj2.val = objSub2.val;
            }
        }
        return size;
    }
    public ObjIndexAndVal getObjIndexAndVal(int[] height,int start,int end){
        ObjIndexAndVal obj1 = new ObjIndexAndVal(0,0);
        for (int i = start; i <= end; i++) {
            if (height[i] >= obj1.val){
                obj1.val = height[i];
                obj1.index = i;
            }
        }
        return obj1;
    }

    public int trap2(int[] height) {
        int val = 0,index=0;
        int defaultSize = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > val){
                val = height[i];
                index = i;
            }
            defaultSize += height[i];
        }
        if (height.length == 0)return 0;
        int l_max = height[0],r_max=height[height.length-1],r_index=height.length-1;
        for (int i = 1; i <= index ; i++) {
            if (height[i]  > l_max){
                int now_maxArea = (height[i]-l_max) *i;
                defaultSize += now_maxArea;
                l_max = height[i];
            }
        }
        for (int i = height.length-1; i >=index ; i--) {
            if (height[i]  > r_max){
                int now_maxArea = (height[i]-r_max) *(height.length-i-1);
                defaultSize += now_maxArea;
                r_max = height[i];
            }
        }
        int ret = val * height.length - defaultSize;
        return ret;
    }

        //45 跳跃游戏2 贪心算法
    public int jump(int[] nums) {
        int index = 0,count=0;
        while (index < nums.length-1){
            int maxIndex=index;
            if (nums[index] > 0){
                if (nums[index]+index >= nums.length-1){
                    return count+1;
                }
                int maxStep = 0;
                for (int i = index+1; i < nums.length && i<=nums[index]+index; i++) {
                    if (nums[i]+i > maxStep){
                        maxStep = nums[i]+i;
                        maxIndex = i;
                    }
                }
                index = maxIndex;
                count++;
            }
        }
        return count;
    }
    //407 接雨水2
    public int trapRainWater(int[][] heightMap) {
        int maxH = 0;
        int dfSize = 0;
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j <heightMap[i].length ; j++) {
                maxH = Math.max(heightMap[i][j],maxH);
                dfSize += heightMap[i][j];//所有土的体积
            }
        }


        return 1;
    }
//    84 助兴中的最大矩形 未解决
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ret = 0;
        for (int i = 0; i < heights.length; i++) {

            stack.add(heights[i]);
            while (true){
                if (stack.size() > 1){
                    if (stack.lastElement() > stack.get(stack.size()-2)){
                        stack.pop();
                    }
                }
            }
//            ret = Math.max(ret,stack.);
        }
        return ret;
    }
//    154 寻找旋转排序数组中的最小值2
    public int findMin(int[] nums) {
        if (nums.length == 0)return -1;
        else if (nums.length == 1)return nums[0];

        int l = 0,r = nums.length-1;
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]){
                index = i+1;
            }
        }

        return nums[index];
    }

    public int majorityElement(int[] nums) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String key = Integer.toString(nums[i]);
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            String key = Integer.toString(nums[i]);
            int count = map.get(key);
            if (count > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }

    public boolean containsDuplicate(int[] nums,int k) {
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String key = Integer.toString(nums[i]);
            if (map.containsKey(key)){
                ArrayList<Integer> arrayList = map.get(key);
                for (int j = 0; j < arrayList.size(); j++) {
                    int now = arrayList.get(j);
                    if (i-now+1 == k){
                        return true;
                    }else if (i-now +1 < k){
                        break;
                    }
                }
                arrayList.add(i);
                map.put(key,arrayList);
            }else {
                ArrayList<Integer> arr= new ArrayList<>();
                arr.add(i);
                map.put(key,arr);
            }
        }
        return false;
    }
//229 求众数2
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        int size = nums.length/3;
        for (int i = 0; i < nums.length; i++) {
            String key = Integer.toString(nums[i]);
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
                if (map.get(key)>size && arr.contains(nums[i])==false){
                    arr.add(nums[i]);
                }
            }else {
                map.put(key,1);
            }
        }
        return arr;
    }
    public int[][] imageSmoother(int[][] M) {
        int[][] ret = new int[M.length][M[0].length];
        for (int i = 0; i < M.length-2; i++) {
            for (int j = 0; j < M[0].length-2; j++) {
                int av = M[i][j]+M[i][j+1]+M[i+1][j]+M[i+1][j+1];
                av /=4;
                ret[i][j]=av;
                ret[i][j+1]=av;
                ret[i+1][j]=av;
                ret[i+1][j+1]=av;
            }
        }
        return ret;
    }

    public int longestValidParentheses(String s) {
        if (s.length()==0)return 0;
        int mLength = 0,subLength=0;

        List<String> arr= new ArrayList<>();
        boolean isDouble =false;
        for (int i = 0; i < s.length(); i++) {
            arr.add(String.valueOf(s.charAt(i)));
            while (arr.size() > 1) {
                if (arr.get(arr.size() - 1).equals(")") && arr.get(arr.size() - 2).equals("(")) {
                    arr.remove(arr.size() - 1);
                    arr.remove(arr.size() - 1);
                    subLength += 2;
                    mLength = Math.max(mLength, subLength);
                } else {
                    break;
                }
            }
        }
        return mLength;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//        int sum = Integer.MAX_VALUE;
//        List<Integer> arr = new ArrayList<>();
//        int subSum = 0;
//        for (int i = 0; i < triangle.size() ; i++) {
//
//            arr.add(0);
//            subSum += triangle.get(i).get(0);
//        }
//        sum = subSum;
//        while (true){
//            while (arr.size()>1){
//                int index =arr.remove(arr.size()-1);
//                int index2 = arr.remove(arr.size()-1);
//
//                if (index2 == index && index+1 < triangle.get(arr.size()-1).size()){
//                    arr.add(index);
//                    arr.add(index2+1);
//                    break;
//                }else {
//                    arr.add(index2);//
//
//                }
//            }
//        }
//        return 1;
        return 1;
    }
    public int maxCoins(int[] nums) {
        if (nums.length == 0)return 0;
        else if (nums.length == 1)return nums[0];
        //1 破 0不破
        int[][] dp = new int[nums.length][2];
        for (int i = 1; i < nums.length-1; i++) {
            if (i == 0 ){
                dp[i][1] = nums[i]*nums[i+1];
                dp[i][0] = nums[i];
            }
            if (i == nums.length-1){
                dp[i][0] = nums[i]*nums[i-1];
                dp[i][1] = dp[i-1][0]*nums[i];
            }
            if (i > 0 && i<nums.length-1){
                dp[i][0] = nums[i] ;
                dp[i][1] = nums[i]*dp[i-1][0]*dp[i+1][0];
            }
        }
        return dp[nums.length-1][0]>dp[nums.length-1][1]?dp[nums.length-1][0]:dp[nums.length-1][1];
    }
    Map<Integer,Integer>map = new HashMap<>();
    int rand = 0;
    int size ;
    Solution2(int N, int[] blacklist) {
        for (int i = 0; i < blacklist.length; i++) {
            map.put(blacklist[i],1);
        }
        size = N;
    }
    Solution2(){}

    public int pick() {
        while (rand>0){
            rand+=1;
            if (rand == Integer.MAX_VALUE){
                rand = size;
            }
            int index = rand%size;
            if (map.containsKey(index)==false){
                return index;
            }
        }
        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)return true;
        int[][] p = new int[numCourses][numCourses];
        int[] d = new int[numCourses];//入度
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            //a -> b
            p[a][b] = 1;
            d[b] ++;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0)
            {stack.add(i);
            set.add(i);}
        }

        while (stack.size()>0){
            int i = stack.pop();
            for (int j = 0; j <numCourses ; j++) {
                if (p[i][j] == 1){
                    p[i][j]=0;
                    d[j]--;
                    if (d[j] == 0){
                        stack.add(j);
                        set.add(j);
                    }
                }
            }
        }
        if (set.size() != numCourses)return false;
        return true;
    }
    //210 课程表2
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        if (prerequisites.length == 0){
            for (int i = 0; i < numCourses; i++) {
                ret[i] = i;
            }
            return ret;
        }
        int[][] p = new int[numCourses][numCourses];
        int[] d = new int[numCourses];//入度
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            //a -> b
            p[a][b] = 1;
            d[b] ++;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int index =0 ;
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0)
            {
                stack.add(i);
                set.add(i);
                ret[index++] = i;
            }
        }

        while (stack.size()>0){
            int i = stack.pop();
            for (int j = 0; j <numCourses ; j++) {
                if (p[i][j] == 1){
                    p[i][j]=0;
                    d[j]--;
                    if (d[j] == 0){
                        stack.add(j);
                        set.add(j);
                        ret[index++] = j;
                    }
                }
            }
        }
        if (set.size() == numCourses)return ret;
        return new int[]{};
    }
}
