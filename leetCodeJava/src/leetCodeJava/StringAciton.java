package leetCodeJava;

import java.awt.List;
import java.util.Iterator;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

public class StringAciton {
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
