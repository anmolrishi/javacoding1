package august;

import java.util.Scanner;

public class TestClass {
	public static void main(String args[] ) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int i = 0; i < N; i++) 
		{
			int k = s.nextInt();
			if(k%2==1 || k==0)
			{
				System.out.println(0);
			}
			else
			{
				int[][] arr= new int[100000][100000];
				System.out.println(method1(k,0,arr));
			}
		}



	}

	private static int method1(int k,int d,int[][] arr) 
	{
//		if(arr[k][d]!=0)
//		{
//			return arr[k][d];
//		}
		
		if(d<k/2){
			method1(k-1, d+1, arr);
			
		}
		
		
		
	}



}
