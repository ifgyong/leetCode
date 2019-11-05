import java.util.Arrays;

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

}
