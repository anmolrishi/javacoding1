package ieeeXtreme;

import java.util.Scanner;

public class beetleBag {

	
	static int max(int a, int b) { return (a > b)? a : b; }
    
	   // Returns the maximum value that can be put in a knapsack of capacity W
	    static int knapSack(int W, int wt[], int val[], int n)
	    {
	         int i, w;
	     int K[][] = new int[n+1][W+1];
	      
	     // Build table K[][] in bottom up manner
	     for (i = 0; i <= n; i++)
	     {
	         for (w = 0; w <= W; w++)
	         {
	             if (i==0 || w==0)
	                  K[i][w] = 0;
	             else if (wt[i-1] <= w)
	                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	             else
	                   K[i][w] = K[i-1][w];
	         }
	      }
	      
	      return K[n][W];
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s= new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
			int c=s.nextInt();
			int n=s.nextInt();
			
			int wt[] = new int[n];
			int f[] = new int[n];
			
			for (int i = 0; i < f.length; i++) {
				wt[i]=s.nextInt();
				f[i]=s.nextInt();
			}
			
			System.out.println(knapSack(c, wt, f, n));
			
		}
		
	}

}
