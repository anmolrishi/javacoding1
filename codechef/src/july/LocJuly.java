package july;

import java.util.Scanner;

public class LocJuly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(); 
		System.out.println(Double.MAX_VALUE);
		for (int i = 1; i <= t; i++) {
			long n = s.nextLong();
			long m = s.nextLong();
			System.out.println(bossloss(n,m));
		}
		
	}

	private static int bossloss(long n, long m) {
		// TODO Auto-generated method stub
		long k=(n*(n+1))/2;
		if(m>k){
			return -1;
		}
		
		if(n>1420000000){
			return -1;
		}
		double ans = Math.sqrt(2*m + 0.25) - 0.5;
//		System.out.println(ans);
		double key = ans-(long)ans;
		if(key > 0){
			ans+=1;
		}
		return (int)ans;
	}

}
