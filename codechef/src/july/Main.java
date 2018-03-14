package july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {



	//		public static String[] add(String str,String[] s){
	//
	//			String p[] = new String[s.length+1];
	//			for(int i=0;i<s.length;i++){
	//				p[i]=s[i];
	//			}
	//			p[s.length]=str;
	//			return p;
	//
	//		}
	//		public static String[] recur(String input,String str,String[] s){
	//
	//			if(input.length()==0){
	//				return add(str,s);
	//			}
	//
	//			char m =(char)(Integer.parseInt(input.substring(0,1)) + 96);
	//			String[] a = recur(input.substring(1),str+m,s);
	//			if(input.length()<=1 && Integer.parseInt(input.substring(0,2))>26){
	//				return s;
	//			}
	//
	//			else{
	//				char n = (char)(Integer.parseInt(input.substring(0,2)) + 96);
	//				return recur(input.substring(2),str+n,a);
	//			}
	//		}
	//
	//
	//
	//		public static void main(String[] args) {
	//
	//			String s[] = recur("1123",new String(),new String[0]);		
	//			for(int i=0;i<s.length;i++){
	//				System.out.println(s[i]);
	//			}
	//		}

	
	public static String reverseWordWise(String input) {
		// Write your code here
String temp="";
String result="";
	for(int i=0;i<input.length();i++)
	{
		if(input.charAt(i)!=' ')
		{
		    
		
			temp=temp+input.charAt(i);
		}
		if(input.charAt(i)==' ')
		{
			result=temp+result;
			temp="";
		}
		
		
		if(i==input.length()-1)
		{
			result=temp+" "+result;
		}
	}
return result;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

//		System.out.println(reverseWordWise("Welcome to coding ninjas"));
		
//		int t = s.nextInt(); 

//		for (int i = 1; i <= t; i++) {
//			int m = s.nextInt();
//			int n = s.nextInt();
//			int factor[][] = new int[m][n];
//			for (int row = 0; row < m; row++) {
//				for (int col = 0; col < n; col++) {
//					factor[row][col] = s.nextInt();
//				}
//			}
//			int time[][] = new int[n][m];
//			
//			for (int row = 0; row < m; row++) {
//				for (int col = 0; col < n; col++) {
//					time[row][col] = s.nextInt();
//				}
//			}
//			HorrorHouse(factor,time,n,m);
//						HorrorHouse(factor,m,n);
//			System.out.println(minfactor);
//		}

				int t = Integer.parseInt(s.nextLine()); 
				
				for (int i = 1; i <= t; i++) {
//					ArrayList<Integer> list = new ArrayList<>();
////					if(s.hasNextInt() && s.hasNext(" ")){
////						list.add(s.nextInt());
////					}
//					int n=1,c=0,max=Integer.MIN_VALUE;
//					for (int j = 0; j < n; j++) {
//						int m=s.nextInt();
//						
//					}
					
					
//					int[] a = new int[50];
//					int j=0;
//					while(s.hasNext()) {
//						
//						if (s.hasNextInt())
//							a[j++] = s.nextInt();
//				        else 
//				            s.next();
//					
//						
//					}
//					
//					for (int k = 0; k < a.length; k++) {
//						System.out.println(a[k]);
//					}
					String input = s.nextLine();
					Maximum(input);
				}
				
				
	}



	private static void Maximum(String input) {
		// TODO Auto-generated method stub
//		ArrayList<Integer> list = new ArrayList<>();
//		int k=0;
//		for (int i = 0; i < input.length(); i++) {
//			if(input.charAt(i)==' '){
//				list.add(Integer.parseInt(input.substring(k, i)));
//				k=i+1;
//			}
//			if(i==input.length()-1){
//				list.add(Integer.parseInt(input.substring(k)));
//			}
//		}
		
		String[] num = input.split(" ");
		
		int n=num.length-1;
		
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			if(Integer.valueOf(num[i])==n){
				num[i]="0";
				break;
			}
			
		
//			System.out.print(list.get(i) + " ");
		}
		
		for (int i = 0; i < num.length; i++) {
			if(Integer.valueOf(num[i])>max){
				max=Integer.valueOf(num[i]);
			}
		}
		System.out.println(max);
//		System.out.println();
	}

	private static void HorrorHouse(int[][] factor, int m, int n) {
		// TODO Auto-generated method stub
		int path[] = new int[m+n];
		printpaths(factor,0,0,m,n,path,0);

	}


	static int minfactor=Integer.MAX_VALUE;
	static int mintime = Integer.MAX_VALUE;
	private static void printpaths(int[][] factor, int i, int j, int m, int n, int[] path, int pi) {
		// TODO Auto-generated method stub
		if (i==m-1){
			for (int k = j; k < n; k++) {
				path[pi+k-j] = factor[i][k];			
			}
			int s=0;
			for (int k = 0; k < pi+n-j; k++) {
				s+=path[k];
			}
			if(minfactor>s){
				
				minfactor=s;
			}
			else if(minfactor==s){
				
			}
			return;
		}

		if (j==n-1){
			for (int k = i; k < m; k++) {
				path[pi+k-i] = factor[k][j];			
			}
			int s=0;
			for (int k = 0; k < pi+m-i; k++) {
				s+=path[k];
			}
			if(minfactor>s){
				minfactor=s;
			}

			return;
		}
		// Add the current cell to the path being generated
		path[pi] = factor[i][j];

		// Print all the paths that are possible after moving down
		printpaths(factor, i+1, j, m, n, path, pi+1);

		// Print all the paths that are possible after moving right
		printpaths(factor, i, j+1, m, n, path, pi+1);

		// Print all the paths that are possible after moving diagonal
		// printAllPathsUtil(mat, i+1, j+1, m, n, path, pi + 1);


	}



	private static void HorrorHouse(int[][] factor, int[][] time, int n, int m) {
		// TODO Auto-generated method stub
		

	}



	private static String HistoryStrings(String p, String q) {
		// TODO Auto-generated method stub
		if(p.length() != q.length()){
			return "NO";
		}
		char c=' ',d=' ';
		for (int i = 0; i < p.length(); i++) {
			c=p.charAt(i);
			d=q.charAt(i);
			int j=i+1;
			while(j<p.length()){
				if(p.charAt(j)==c && q.charAt(j)!=d){
					return "NO";
				}
				if(p.charAt(j)!=c && q.charAt(j)==d){
					return "NO";
				}
				j++;
			}
		}



		//		while(i<p.length()-1){
		//			if(p.charAt(i)==p.charAt(i+1) && q.charAt(i)!=q.charAt(i+1)){
		//				return "NO";
		//			}
		//			if(p.charAt(i)!=p.charAt(i+1) && q.charAt(i)==q.charAt(i+1)){
		//				return "NO";
		//			}
		//			i++;
		//		}


		return "YES";
	}



	private static void TRAVERSE(int m) {
		// TODO Auto-generated method stub
		if(m==0){
			System.out.println(0 + " " + 0);
			return;
		}
		int x=1,y=0;
		int a = m-3;
		//		System.out.println(a);
		while(a>0){
			x++;
			a-=3;
		}
		System.out.print(x + " ");

		int c=0;
		for (int i = 0; i < m; i++) {
			if(c==2){
				y++;
				c=0;
			}
			else if(c==1){
				y++;
				c++;
			} 
			else if(c==0){
				c++;
			}
		}
		System.out.println(y);

	}



	private static int sequence(String str) {
		// TODO Auto-generated method stub

		int max=0;
		int i=0;
		int count1=0,count2=0;
		while(i<str.length()){


			if(str.charAt(i)=='>'){
				count1++;
				count2=0;
				if(count1>max){
					max=count1;
				}
			}
			else if(str.charAt(i)=='<'){
				count2++;
				count1=0;
				if(count2>max){
					max=count2;
				}
			}

			i++;

		}
		return max+1;
	}

	private static String three(String w) {
		// TODO Auto-generated method stub
		String ans = "";
		ans += w.toUpperCase().charAt(0) + ". ";


		int i=0;
		while(i<w.length() && w.charAt(i)!=' '){
			i++;
		}
		ans += two(w.substring(i+1));
		return ans;
	}

	private static String two(String w) {
		// TODO Auto-generated method stub
		String ans = "";
		ans += w.toUpperCase().charAt(0) + ". ";

		int c=0;
		for (int j = 0; j < w.length(); j++) {
			if(w.charAt(j)!=' '){
				++c;
			}else{
				break;
			}
		}
		ans += one(w.substring(c+1));
		return ans;
	}

	private static String one(String w) {
		// TODO Auto-generated method stub
		String ans = "";
		if(w.charAt(0)>'Z'){
			ans += (char)(w.charAt(0)-32);
		}else{
			ans +=w.charAt(0);
		}

		for (int i = 1; i < w.length(); i++) {
			if(w.charAt(i)<'a'){
				ans += (char)(w.charAt(i)+32);
			}else{
				ans += w.charAt(i);
			}
		}

		return ans;
	}

}
