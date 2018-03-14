package october;


import java.util.Scanner;

public class Main {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Scanner s = new Scanner(System.in);	
		//		int t=s.nextInt();
		//		
		//		while(t-- >0){
		//			int n = s.nextInt();
		//			int p = s.nextInt();
		//			int[] a = new int[n];
		//			
		//			for (int i = 0; i < a.length; i++) {
		//				a[i] = s.nextInt();
		//			}
		//			
		//			System.out.println(perfcount(n,p,a));
		//		}

		//		Scanner s = new Scanner(System.in);	
		//		int t=s.nextInt();
		//		
		//		while(t-- >0){
		//			int n = s.nextInt();
		//			int k = s.nextInt();
		//			int[] a = new int[n];
		//			int max=-1;
		//			for (int i = 0; i < a.length; i++) {
		//				a[i] = s.nextInt();
		//				if(a[i]>max){
		//					max=a[i];
		//				}
		//			}
		//			
		//			
		//			System.out.println(MaxMex(n,k,a,max));
		//		}

		Scanner s = new Scanner(System.in);	
		//	
		//		long a = 4294937541l;
		//		long b = 4294967295l;
		//		System.out.println(a%b);
		//		System.out.println(b-a);

		//		int t=s.nextInt();	
		//		while(t-- >0){
		//			int n = s.nextInt();
		//			
		//			for (int i = 1; i <= 7310; i++) {
		//				System.out.print(1 + " ");
		//			}
		//			for (int i = 1; i <= n-7310; i++) {
		//				
		//				System.out.print(i + " ");
		//			}
		//			System.out.println();
		//		}

		int t=s.nextInt();	
		while(t-- >0){
			
			String input = s.next();
			int x = s.nextInt(),y = s.nextInt();
			
			System.out.println(Lunger(input,x,y));
			
		}

	}

	private static String Lunger(String input, int x, int y) {
		// TODO Auto-generated method stub
		int a=0,b=0;
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)=='a'){
				a++;
			}else b++;
		}
		
		if(a==0){
			return lungerSingle(b,'b',y);
		}else if(b==0){
			return lungerSingle(a, 'a', x);
		}else{
			String ans="";
			while(a!=0 && b!=0){
				
			}
		}
		
		return null;
	}

	private static String lungerSingle(int b, char fruit,int k) {
		// TODO Auto-generated method stub
		String ans = "";
		if(fruit=='b'){
			for (int i = 0; i < b; i++) {
				ans+="b";
				if((i+1)%k==0 && i!=b-1){
					ans+="*";
				}
			}
		}else if(fruit=='a'){
			for (int i = 0; i < b; i++) {
				ans+="a";
				if((i+1)%k==0 && i!=b-1){
					ans+="*";
				}
			}
		}
		
		return ans;
		
	}

	private static int MaxMex(int n, int k, int[] a,int max) {
		// TODO Auto-generated method stub
		int mex=0;
		int[] ar = new int[max+k+1];
		for (int i = 0; i < a.length; i++) {
			ar[a[i]] = 1;
		}

		for (int i = 0; i < ar.length; i++) {
			if(ar[i]==0 && k==0){
				return mex;
			}
			else if(ar[i]==0 && k>0){
				++mex;--k;
			}else if(ar[i]==1){
				++mex;
			}
		}

		return mex;
	}

	private static String perfcount(int n, int p,int[] a) {
		// TODO Auto-generated method stub
		if(n<3){
			return "no";
		}
		int cake=0,hard=0;

		for (int i = 0; i < n; i++) {
			if(cake>1 || hard>2){
				return "no";
			}

			if(a[i] <= p/10){
				++hard;
			}else if(a[i] >= p/2){
				++cake;
			}

		}

		if(cake==1 && hard==2){
			return "yes";
		}
		return "no";


	}

}
