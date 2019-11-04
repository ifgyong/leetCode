
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
    public int trap(int[] height) {

    }
}
