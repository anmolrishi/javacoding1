package lunchtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


	public static void findPairsDifferenceK(int[] input, int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0;i < input.length;i++){
			if(map.containsKey(input[i])){
				map.put(input[i],map.get(input[i])+1); 
			}else{
				map.put(input[i],1); 
			}
		}
		for(int i = 0 ; i < input.length; i++){
			if(map.containsKey(input[i]+k) && map.get(input[i]) > 0 && k == 0){
				int n = factorial(map.get(input[i]));
				int r = factorial(map.get(input[i]) - 2);
				for(int j = 0 ; j < n/(r*2); j++){
					String a = "";
					if(input[i]<input[i]+k){
						a = input[i]+" "+(input[i]+k);
					}
					else{
						a = (input[i] + k)+" "+input[i];
					}
					System.out.println(a);  	
				}
				
				map.remove(input[i]);
				
			}
			if(map.containsKey(input[i]+k) && map.get(input[i]) > 0 && k != 0){
				int n = map.get(input[i]) * map.get(input[i]+k);
				for(int j = 0 ; j < n; j++){
					String a = "";
					if(input[i]<input[i]+k){
						a = input[i]+" "+(input[i]+k);
					}
					else{
						a = (input[i] + k)+" "+input[i];
					}
					System.out.println(a);
				}
				if(map.get(input[i]+k)>0)
				map.put(input[i], 0);
			}
			
			
		}

	}
	private static int factorial(int number) {
		if (number <= 1) return 1;
		else return number * factorial(number - 1);
	}

	public static ArrayList<Integer> longestSubsequence(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>(); 
        
      	for(int i=0;i<arr.length;i++){
          if(map.containsKey(arr[i])){
            map.put(arr[i],map.get(arr[i])+1);
            continue;
          }
          map.put(arr[i],1);
        }
        int big = 0;
      	for(int i : arr){
            if(!map.containsKey(i-1) && map.containsKey(i+1)){
              int j = i;
              while(map.containsKey(j)){
               // output.add(j);
                j++;
              }
              if(big < j-i){
            	  output = new ArrayList<Integer>();
                int k = i;
                while(map.containsKey(k)){
                  output.add(k);
                  k++;
                }
                big = j-i;
                System.out.println(big+ " here");
              }
            }
        }
        if(big == 0){
          output.add(arr[0]);
          return output;
        }
        return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		

		int[] ka = {2,1,3};
				findPairsDifferenceK(ka, 2);
				
				
//		ArrayList<Integer> out = longestSubsequence(ka);
//
//		for (int i = 0; i < out.size(); i++) {
//			System.out.println(out.get(i));
//		}

		int N = s.nextInt();

		for (int i = 0; i < N; i++) 
		{
			int[][] a = new int[26][2];
			for (int j = 0; j < 26; j++) {
				a[j][0] = s.nextInt();
			}

			String str = s.next();

			for (int j = 0; j < str.length(); j++) {
				a[str.charAt(j) - 'a'][1]++;
			}

			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				if(a[j][1]==0){
					sum+=a[j][0];
				}
			}

			System.out.println(sum);
		}
	}

}
