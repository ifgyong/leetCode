package leetCodeJava;

import java.awt.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.*;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class IntAction {
	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int minNumber = Math.min(height[i], height[j]);
				double d = minNumber;
				int now = (int) Math.pow(d, j - i);
				max = now > max ? now : max;
			}
		}
		return max;
	}
	public int maxArea2(int[] height) {
		int max = 0;
		
		
		return max;
	}
	public IntAction() {
		// TODO Auto-generated constructor stub
	}
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int count = 0;
    	for (int i = 0; i < nums.length; ) {
    		count += nums[i];
			i += 2;
		}
		return count;
        
    }
    public int[] twoSum(int[] numbers, int target) {
    	int index1=0;
    	int index2=0;
    	for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i]+numbers[j]==target) {
					return new int[] {i,j};
				}
			}
		}
     return new int[] {};   
    }
    public int[] twoSum2(int[] numbers, int target) {
    	int index1=0;
    	int index2=numbers.length-1;
    	while (index1<index2) {
    		if (numbers[index1]+numbers[index2] > target) {
    			if (numbers[index1]+numbers[index2-1] < target) {
					index1 +=1;
				}else if (numbers[index1]+numbers[index2-1] >target) {
					index2 -=1;
				}else {
					return new int[] {index1+1,index2};
				}
			}else if (numbers[index1]+numbers[index2] < target) {
				index1 +=1;
			} else {
				return new int[] {index1+1,index2+1};
			}
    	}
     return new int[] {};   
    }
    public int removeElement(int[] nums, int val) {
//        int left=0;
//        int right = nums.length-1;
//        while (left < right) {
//        	if (nums[right]==val) {
//				ArrayList<int> Object = nums;
//				right -=1;
//			}
//        }
    	return 0;
    }
   public int findMaxConsecutiveOnes(int[] nums) {
       int left=0;
       int right = nums.length-1;
       int maxret = 0;
       int leftCount = 0;
       int rightCount=0;
       if (nums.length == 0) {
    	   return 0;
	}
       while(left<right) {
    	   if (nums[left] == 1) {
			leftCount +=1;
		}else {
			leftCount = 0;
		}
    	   maxret = Math.max(leftCount, maxret);
       }
 
	   return maxret;
    }
   public int minSubArrayLen(int s, int[] nums) {
    int sum = 0;
    int length = Integer.MAX_VALUE;
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
    	sum += nums[i];
    	if (sum >= s) {
    		if (i-left+1 <length) {
    			length = i-left+1;
			}
			while (sum >= s) {
				if (left <= i) {
					sum -= nums[left];
					left +=1;
				}
				int nowLength = i-left+1;
				if (sum >= s && nowLength <length) {
					length = nowLength;
				}
			}
		}
	}
    
	return length == Integer.MAX_VALUE?0:length;
   
   }
   public int findLength(int[] A, int[] B) {
	   
    return 0;   
   }
   public void rotate(int[] nums, int k) {
	   for (int i = 0; i < k; i++) {
		for (int j = 0; j < nums.length-1; j++) {
			int tap = nums[j];
			nums[j]=nums[j+1];
			nums[j+1] = tap;
		}
	}
   }
   public String reverseWords(String s) {
	   StringBuffer str = new StringBuffer();
	   
	   String[] s_arr= s.split(" ");
	   
	   for (int i = s_arr.length-1; i >=0 ; i--) {
		if (s_arr[i] .length() > 0) {
			str.append(s_arr[i]);
			str.append(" ");
		}
	}
	   for (int i = str.length()-1; i >=0 ; i--) {
		if (str.charAt(i) != ' ') {
			return str.substring(0, i+1);
		}
	}
    return str.toString();   
   }
   public String reverseWords2(String s) {
	   StringBuffer rets= new StringBuffer();
	   int last = 0;
	   for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == ' ' || i == s.length()-1) {
			StringBuffer s_sub =new StringBuffer("");
			for (int j=last;j<i;j++) {
				s_sub.insert(0, s.charAt(j));
			}
			if (i==s.length()-1) {
				s_sub.insert(0, s.charAt(i));
			}
			rets.append(s_sub);
			rets.append(' ');
			last =i+1;
		}
	}
	   if (rets.length() == 0) {
		    return "";   

	}
    return rets.substring(0, rets.length()-1).toString();   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntAction ac = new IntAction();
		int list[] = {1,1};
//	int  max =
			String string = ac.reverseWords2("Let's take LeetCode contest");
			System.out.println(string);
//		System.out.println(max);
	}

}
