package leetCodeJava;

import com.sun.accessibility.internal.resources.accessibility;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntAction ac = new IntAction();
		int list[] = {1,2,3,4,5};
	int  max =ac.maxArea(list);
		System.out.println(max);
	}

}
