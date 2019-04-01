package leetCodeJava;

import java.awt.List;
import java.util.Iterator;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

public class StringAciton {
	 public boolean isPalindrome(int x) {
		  
		 if (x < 0) {
			return false;
		}else if (x < 10) {
			return true;
		}else {
			String xNumber = String.valueOf(x);
			int len = xNumber.length();
			int  i = 0;
			boolean is = true;
			for (i = 0;i < len/2;i ++){
				if (xNumber.charAt(i) != xNumber.charAt(len-i-1)) {
					is = false;
					break;
				}
			}
			return is;
		}
}
	 public int myAtoi(String str) {
		 str = str.trim();
		 if (str.isEmpty()) {
			return 0;
		}
		 else {
			
		}
		 if (str.length() == 0 || str == null) {
			return 0;
		}
		 int minInt = Integer.MIN_VALUE;
		 boolean plus = true;
		 
		 int i  = 0;
		 int start = -1,end = 0;
		 boolean isstop = false;
		 for ( i = 0;i < str.length();i ++) {
			 char item = str.charAt(i);
			 if (Character.isWhitespace(item) && isstop) {
				 end = i-1;
				break;
			}else  if(item == '-'||(item >= '0' && item <= '9')) {
				if (item == '-') {
					plus= false;
					if (start == -1) {
						start = i;
					}
				}else {
					if (start == -1) {
						start = i;
					}
				}
				isstop = true;
			}else {//字母
				end = i;
				break;
			}
			 if (i == str.length() -1) {
				 end = i;
			}
		 }
		 if (start == -1 || end == -1) {
			return 0;
		}
		 String newS = str.substring(start, end+1);
		 String minS = String.valueOf(minInt);
		 String maxS = String.valueOf(Integer.MAX_VALUE);
		 int result = 0;
		 if (plus) {
			 if (newS.length() > maxS.length()  ) {
					return  Integer.MAX_VALUE;
				}else if (newS.length() == maxS.length() &&  newS.charAt(0) > maxS.charAt(0)) {
					return  Integer.MAX_VALUE;
				}else {
					result = Integer.parseInt(newS);
				}
		}else {
			if (newS.length() > minS.length()) {
				return Integer.MIN_VALUE;
			}else if (newS.length() == maxS.length() && newS.charAt(1) > minS.charAt(1)) {
				return Integer.MIN_VALUE;
			}else {
				result = Integer.parseInt(newS);
			}
		}
		 return result;
	    }
	
/*最长不重复子字符串
 * */
	 public int lengthOfLongestSubstring(String s) {
		 if (s.length() <2) {
			return s.length();
		}
		 String str= new String(s);
		 int currentLocation = 0;
		 int max = 0;
		 for (int i = 1; i < s.length(); i++) {
			String news = str.substring(currentLocation, i);
			char ch =  s.charAt(i);
			if (news .contains(Character.toString(ch)) == true) {
				int locationNow = news.indexOf(ch) ;
				currentLocation += locationNow == -1 ? 0:1;
			}
			int dis =  i - currentLocation+1;
			if (dis > max) {
				max = dis;
			}
		}
	        return max;
	    }
	 public void main() {
		 int count =   lengthOfLongestSubstring("abcabcbb");
			System.out.println(count);
	}
	public StringAciton() {
		// TODO Auto-generated constructor stub
			
	}

}
