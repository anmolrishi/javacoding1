package september;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);	
		int t=s.nextInt();	
		while(t-- >0){
			int n = s.nextInt();
			int rem = n-99990;
			int[] a=new int[n];
			for (int i = 0; i < rem; i++) {
				a[i] = 100000;
			}
			
			for (int i = rem; i < n; i++) {

				a[i]=1;
			}
			
			while(s.h)
//			for (int i = 0; i < n; i++) {
//				System.out.print(a[i] + " ");
//			}

			//			for (int i = 0; i < a.length; i++) {
			//				if(a[i]==0)
			//				System.out.print(a[i] + " ");
			//			}
			System.out.println();

						System.out.println("WRONG " + wrongChefSum(a));
						System.out.println("RIGHT " + chefSum(a));
		}
	}

	private static int chefSum(int[] a) {
		int minPos=1;
		int min=Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if(a[i]<min){
//				System.out.println("in1");
				min=a[i];
				minPos=i;
			}
		}

		return minPos;
	}

	private static int wrongChefSum(int[] a) {
		int n = a.length;
		long[] prefSum = new long[n];
		long[] sufSum = new long[n];
		prefSum[0] = a[0];

		for (int i = 1; i < n; i++) {
			prefSum[i] = prefSum[i - 1] + a[i];
		}
		sufSum[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sufSum[i] = sufSum[i + 1] + a[i];
		}
		long b = 4294967296l;
		long mn = (prefSum[0] + sufSum[0])%b;
		int where=1;
		for (int i = 1; i < n; i++) {
			long val = (prefSum[i] + sufSum[i])%b;
			if (val < mn) {
				mn = val;
				where = i + 1;
			}
		}
		return where;

	}

}
/*
10
99991
99992
99993
99994
99995
99996
99997
99998
99999
100000
*/
