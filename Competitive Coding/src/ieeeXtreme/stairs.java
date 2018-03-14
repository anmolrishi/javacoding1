package ieeeXtreme;

import java.math.BigInteger;
import java.util.Scanner;

public class stairs {

	    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int t= s.nextInt();
		while(t-- >0)
		{
			int n=s.nextInt();
			if(n==1)
			{
				System.out.println(1);
			}
			else
			{
				BigInteger arr[]=new BigInteger[n+1];
				arr[1]=new BigInteger("1");
				arr[2]=new BigInteger("2");
				for(int i=3;i<=n;i++)
				{
					arr[i]=new BigInteger("0");
					arr[i]=arr[i-1].add(arr[i-2]);
				}
				System.out.println(arr[n]);
			}
			
		}
	}

}
