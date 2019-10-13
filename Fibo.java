//Generate the nth fibonacci sequence using recursive + memoization, bottom-up with table, bottom-up without memo table
import java.util.*;

public class Fibo {
	public static int fiboRecWithMemo(int n) {
		int[] memo = new int[n+1];
		return fiboRecWithMemo(n,memo);
	}
	
	public static int fiboRecWithMemo(int i,int[] memo) {
		if(i==0||i==1) return i;
		
		if(memo[i] == 0) {
			memo[i] = fiboRecWithMemo(i-1,memo) + fiboRecWithMemo(i-2,memo);
		}
		
		return memo[i];
	}
	
	public static int fiboBottomUp(int n) {
		if(n == 0) return 0;
		
		if(n == 1) return 1;
		
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		
		for(int i=2;i<n;i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		return memo[n-1] + memo[n-2];
	}
	
	public static int fiboBottomUpNoMemo(int n) {
		
		if(n == 0) return 0;
		
		if(n==1) return 1;
		
		int a = 0,b = 1, c = 0;
		for(int i=2;i<n;i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return a+b;
	}
	public static void main(String[] args) {
		System.out.println(fiboRecWithMemo(10));
		System.out.println(fiboBottomUp(10));
		System.out.println(fiboBottomUpNoMemo(10));
	}
}
