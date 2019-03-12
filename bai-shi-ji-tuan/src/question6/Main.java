package question6;

import java.util.Iterator;
import java.util.Random;

/**
 * 6.输入一个数逐位相加如果返回小于10的结束否则反复相加
 * @author Xin
 *
 */
public class Main {

	public static void main(String[] args) {
		Random rd = new Random();
		for(int i=0;i<100;i++) {
			int randomInt = rd.nextInt(Integer.MAX_VALUE);
			int result = function(randomInt+"");
			System.out.println(randomInt+"->"+result);
		}
	}
	
	public static int function(String numStr) {
		int result=0;
		char[] charArray = numStr.toCharArray();
		int[] intArray = getIntArray(charArray);
		int length = intArray.length;
		for(int i =0;i<length;i++) {
			result+=intArray[i];
		}
		return result<10?result:function(result+"");
		
	}
	
	public static int[] getIntArray(char[] charArray) {
		int length = charArray.length;
		int[] intArray = new int[length];
		for(int i=0;i<length;i++) {
			intArray[i] = charArray[i] - '0';
		}
		return intArray;
	}

}
