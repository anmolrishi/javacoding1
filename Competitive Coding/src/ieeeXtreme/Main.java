package ieeeXtreme;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	  public static void merge(pair[] a,pair[] b, pair[] c) {
			
			int i=0,j=0,k=0;
			int n=a.length;
			int m=b.length;

		

			while(i<n && j<m){
				if(a[i].height<b[j].height){
					c[k] = a[i];
					k++;
					i++;
				}
				else{
					c[k] = b[j];
					k++;
					j++;
				}
			}
			if(i<n){
				for(int p = i;p<n;p++){
					c[k] = a[p];k++;
				}

			}

			else if(j<m){
				for(int p = j;p<m;p++){
					c[k] = b[p];k++;
				}
			}
			


		}


		public static void mergeSort(pair[] input){
		if(input.length <= 1){
				return;
			}
			
			int mid = input.length / 2;
			pair part1[] = new pair[mid];
			pair part2[] = new pair[input.length - mid];
			
			for(int i = 0; i < part1.length; i++){
				part1[i] = input[i];
				}
			
			for(int i = 0; i < part2.length; i++ ){
				part2[i] = input[mid + i];
			}
			
			mergeSort(part1);
			mergeSort(part2);
			merge(part1, part2, input);
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		
		
		    BigInteger fact = BigInteger.valueOf(1);
		    for (int i = 1; i <= t; i++)
		        fact = fact.multiply(BigInteger.valueOf(i));
		    System.out.println(fact);
		
		
		
//		pair thieves[] = new pair[t];
//		for (int i = 0; i < t; i++) {
//			thieves[i] = new pair();
//			thieves[i].name=s.next();
//			thieves[i].height = s.nextInt();
//			
//		}
//		
//		mergeSort(thieves);
//		for (pair pair : thieves) {
//			System.out.println(pair.name + " " + pair.height);
//		}
		
//		int start=0,end=0;
//		
//		int h = thieves[0].height;
//		int iter=0;
//		while(iter<t){
//			int i=start;
//			
//			while(h==thieves[i].height){
//				end++;
//				i++;
//			}
//			
//			String ans[] = new String[end - start];
//			for (int j = 0; j < ans.length; j++) {
//				ans[j] = thieves[start+j].name;
//			}
//			Arrays.sort(ans);
//			
//			for (int j = 0; j < ans.length; j++) {
//				System.out.print(ans[j] +  " ");
//			}
//			System.out.print((start+1) + " " + (end));
//			start=end+1;
//			h=thieves[end+1].height;
//			int l=0;
//			int start=1;
//			int k;
//			for(k=1;k<thieves.length;k++)
//			{
//				if(thieves[k].height!=thieves[l].height)
//				{
//					String[] str=new String[k-l];
//					for(int m=0;m<str.length;m++)
//					{
//						str[m]=thieves[l].name;
//						l++;
//					}
//					Arrays.sort(str);
//					for(int m=0;m<str.length;m++)
//					{
//						System.out.print(str[m]+" ");
//					}
//					System.out.println(start+" "+(start+str.length-1));
//					start+=str.length;
//				}
//			}
//			String[] str=new String[k-l];
//			for(int m=0;m<str.length;m++)
//			{
//				str[m]=thieves[l].name;
//				l++;
//			}
//			Arrays.sort(str);
//			for(int m=0;m<str.length;m++)
//			{
//				System.out.print(str[m]+" ");
//			}
//			System.out.println(start+" "+(start+str.length-1));
//			start+=str.length;
//		//	System.out.println();
//		//	iter++;
			
		}
		
		}
		

	


class pair{
	String name;
	int height;
}