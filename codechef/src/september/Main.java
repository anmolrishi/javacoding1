package september;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Scanner s = new Scanner(System.in);
		//		int t = s.nextInt();
		//		while (t-->0) {
		//
		//			int n=s.nextInt();
		//			int[] a = new int[n+1];
		//			long[] prefix = new long[n+1];
		//			
		//			for (int i = 1; i <= n  ; i++) {
		//				a[i] = s.nextInt();
		//				prefix[i] = a[i] + prefix[i-1];
		//			}
		////			for (int i = 0; i < prefix.length; i++) {
		////				System.out.print(prefix[i] + " ");
		////			}
		//			System.out.println(chefSum(a,prefix));
		//			
		//
		//		}

//		Scanner s = new Scanner(System.in);
//		int t = s.nextInt();
//		while (t-->0) {
//
//			//			int n=s.nextInt();
//			String input = s.next();	
//			chefpDig(input);


//		}
		
		System.out.println(7+5%2);
	}

	private static void chefpDig(String input) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length() ; i++) {
//			System.out.println((int)input.charAt(i)-48);
			if(map.containsKey((int)input.charAt(i)-48))
			map.put((int)input.charAt(i)-48,map.get((int)input.charAt(i)-48));
			
			else{
				map.put((int)input.charAt(i)-48, 1);
			}
			
		}

		String k = "";

		for (int i = 0; i <= 25 ; i++) {
//			System.out.print((int)i/10 + " " + (int)i%10 + " ");
//			i+=65;
			if(map.containsKey((i+65)/10) && map.get((i+65)/10)>0){
				map.put((i+65)/10,map.get((i+65)/10)-1);
				
				if(map.containsKey((i+65)%10)){
					
					k+=(char)(i + 65);
				}
				map.put((i+65)/10,map.get((i+65)/10)+1 );
				
			}
		}
	
		System.out.println(k);
	}

	private static void minPerm(int n) {
		// TODO Auto-generated method stub
		if(n%2==0){
			for (int i = 1; i < n; i+=2) {
				System.out.print(i+1 + " " + i + " ");
			}
		}else{
			for (int i = 1; i < n-2; i+=2) {
				System.out.print(i+1 + " " + i + " ");
			}
			System.out.print(n-1 + " " + n + " ");
			System.out.print(n-2);
		}
		System.out.println();

	}

	private static int chefSum(int[] a, long[] pre) {
		int n = a.length-1;
		long post[] = new long[n+1];
		for (int i = 1; i <= n; i++) {
			post[i] = a[n-i+1] + post[i-1];
		}

		long min =Long.MAX_VALUE;
		int minPos = 0;

		for (int i = 1; i < post.length; i++) {
			long st = post[n-i+1]+pre[i];
			if(st < min){
				min = st;
				minPos = i;
			}
		}
		return minPos;
	}

	private static int wrongChefSum(int[] a) {
		int n = a.length;
		long[] prefSum = new long[n];long[] sufSum = new long[n];
		prefSum[0] = a[0];
		
		for (int i = 1; i < n; i++) {
			prefSum[i] = prefSum[i - 1] + a[i];
		}
		sufSum[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sufSum[i] = sufSum[i + 1] + a[i];
		}
		
		long mn = prefSum[0] + sufSum[0];
		int where=1;long b = 4294967295l;
		for (int i = 1; i < n; i++) {
			long val = (prefSum[i] + sufSum[i])%b;
			if (val < mn) {
				mn = val;
				where = i + 1;
			}
		}
		return where;
		
	}
	
//	int wrongSolver(std::vector <unsigned int> a) {
//		int n = a.size();
//		std::vector<unsigned int> prefSum(n), sufSum(n);
//		prefSum[0] = a[0];
//		for (int i = 1; i < n; i++) {
//			prefSum[i] = prefSum[i - 1] + a[i];
//		}
//		sufSum[n - 1] = a[n - 1];
//		for (int i = n - 2; i >= 0; i--) {
//			sufSum[i] = sufSum[i + 1] + a[i];
//		}
//		unsigned int mn = prefSum[0] + sufSum[0];
//		int where = 1;
//		for (int i = 1; i < n; i++) {
//			unsigned int val = prefSum[i] + sufSum[i];
//			if (val < mn) {
//				mn = val;
//				where = i + 1;
//			}
//		}
//		return where;
//	}

}
