package prosort;

import java.util.*;

public class TestClass {


	public static ArrayList<Integer> longestSubsequence(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> output = new ArrayList<Integer>(); 

		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i],map.get(arr[i])+1);
			}else{
				map.put(arr[i],1);  
			}

		}
map.get(6).intValue();
		for(int i : arr){
			if(!map.containsKey(i-1)){
				int j = i;
				while(map.containsKey(j)){
					output.add(j);
					
					map.remove(j);
					j++;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();

		}

		ArrayList<Integer> n = longestSubsequence(a);

		for (int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i));
		}
		//		for (int i = 0; i < N; i++) 
			//		{13 2 12 9 16 10 5 3 20 25 11 1 8 6
			//			
			//			String str = s.next();
			//			
			//		
			//			int[] a = method1(str);
		//			
		//			for (int j = 0; j < a.length; j++) {
		//				System.out.print(a[j] + " ");
		//			}
		//			System.out.println();
		//		}
	}

	private static int[] method1(String str) {
		// TODO Auto-generated method stub
		int i=str.length()-1;
		int[] ans = new int[str.length()];
		int[] count=new int[26];
		int[] lastindex=new int[str.length()];
		while(i>=0)
		{
			if(count[str.charAt(i)-'a']==0)
			{
				ans[i]=1;
				count[str.charAt(i)-'a']=i;
			}
			else
			{
				lastindex[i]=count[str.charAt(i)-'a'];
				if(ans[lastindex[i]]==1)
				{
					for(int j=)
				}
				count[str.charAt(i)-'a']=i;
			}
			i--;
		}

		return ans;
	}
}
