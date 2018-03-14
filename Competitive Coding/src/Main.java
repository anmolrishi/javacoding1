import java.util.ArrayList;
import java.util.Scanner;
//import java.util.*;

public class Main {

	public static int findUnique(int[] arr){
		Scanner scan=new Scanner(System.in);
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					sum++;
				}

			}
			if(sum==1)
			{
				sum=arr[i];
				break;
			}
			//return a[i];
		}
		return sum;
	}



	public static void pushZerosAtEnd(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]==0 && arr[j+1]>0){
					arr[j]=arr[j+1];
					arr[j+1]=0;
				}
			}
		}

	}


	public static int[] sumOfTwoArrays(int[] arr1, int[] arr2){
		int i = arr1.length-1;
		int j = arr2.length-1;
		int k = 0;
		if(i>=j)
		{   k = i+2;
		}
		else
		{   k = j+2;
		}
		int arr3[] = new int[k];
		int sum = 0;
		k--;
		while(i>=0 && j>=0)
		{   sum = sum + (arr1[i] + arr2[j]);
		if(sum>9)
		{   int t = sum%10;
		arr3[k] = t;
		sum = sum/10;
		}
		else
		{   arr3[k] = sum;
		sum = 0;
		}
		i--;
		j--;
		k--;
		}
		arr3[k] = sum;
		// if((i==-1||j==-1)&&k!=0)
		// {   arr3[k] = sum;
		// }
		while(i>=0 && k>=0)
		{   arr3[k] = arr1[i];
		i--;
		k--;
		}
		while(j>=0 && k>=0)
		{   arr3[k] = arr2[j];
		j--;
		k--;
		}

		return arr3;
	}

	public static void rotate(int[] arr, int d) {
		/* Your class should be named ArrayRotate
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing the output is handled automatically.
		 */
		int s[]=new int[d];	 
		for(int i=0;i<d;i++)
		{
			s[i]=arr[i];
		}


		for(int i=0;i<arr.length-d;i++)
		{

			arr[i]=arr[i+d];

		}

		for(int i=0;i<d;i++)
		{
			arr[arr.length-1+i]=s[i];
		}
	}

	public static void findLargest(int input[][]){
		int n=input.length;
		int m=input[0].length;

		int i,j;
		int max=Integer.MIN_VALUE;
		int max1=Integer.MIN_VALUE;
		int pos=0,pos1=0,sum=0,sum1=0;

		for(i=0;i<n;i++){
			sum=0;
			for(j=0;j<m;j++){
				sum+=input[i][j];

			}
			if(sum>max){
				max=sum;
				pos=i;
			}
		}

		for(i=0;i<n;i++){
			sum1=0;
			for(j=0;j<m;j++){
				sum1+=input[j][i];
			}
			//		     System.out.println(sum1 + " " + pos1 + " " + max1);
			if(sum1>max1){
				max1=sum1;
				pos1=i;
			}

		}
		System.out.println(max1);
		if(max>max1)
			System.out.print("row"+" "+pos+" "+sum);

		else if(max1>max)
			System.out.print("column"+" "+pos1+" "+sum1);

		else{

			System.out.print("row"+" "+pos+" "+sum);
		}
	}

	public static void wavePrint(int input[][]){

		// Write your code here
		int columns = input[0].length;
		int rows = input.length;
		int i = 0 ;
		int j = 0 ;


		if ( columns % 2 != 0){

			while ( (i <= columns - 1) && (j <= rows - 1) ){

				if (j == rows - 1 ) {

					System.out.print(input[j][i] + " ");
					i++;
					System.out.print(input[j][i] + " ");
					j--;

				}else if (j == 0 && i != 0){

					System.out.print(input[j][i] + " ");
					i++;
					System.out.print(input[j][i] + " ");
					j++;

				}else if ( i % 2 == 0){

					System.out.print(input[j][i] + " ");
					j++;

				}else if (i % 2 != 0){
					System.out.print(input[j][i] + " ");
					j--;
				}
			}



		}else {

			while ( (i != columns - 1) && (j != 0) ){

				if (j == rows - 1 ){

					System.out.print(input[j][i] + " ");
					i++;
					System.out.print(input[j][i] + " ");
					j--;

				}else if (j == 0 && i != 0){

					System.out.print(input[j][i] + " ");
					i++;
					System.out.print(input[j][i] + " ");
					j++;

				}else if ( i % 2 == 0){

					System.out.print(input[j][i] + " ");
					j++;

				}else if (i % 2 != 0){
					System.out.print(input[j][i] + " ");
					j--;
				}
			} 
		}
	}


	public static void sort(int a, int b,int c)
	{
		if(a>b)
		{
			int temp=a;
			a=b;
			b=temp;
		}
		if(b>c)
		{
			int temp=b;
			b=c;
			c=temp;
		}
		if(a>c)
		{
			int temp=a;
			a=c;
			c=temp;
		}

		System.out.println(a+" "+b+" "+c);
	}

	public static String compress(String str) {

		String s = new String();
		int k=0;

		for(int i=0;i<str.length()-1;i++){

			if(str.charAt(i)==32){
				s+=" ";
				i++;
				k=0;
			}

			else if(str.charAt(i)==str.charAt(i+1)){
				k++;
			}

			else{
				if(k!=0){
					s+=str.charAt(i);
					s+=(k+1);
					k=0;
				}

				else{
					s+=str.charAt(i);
					k=0;
				}
			}
		}
		s+=str.charAt(str.length()-1);
		return s;

	}

	public static String reverseWordWise(String input) {

		input = input + " " ;
		int n = input.length();
		int start = 0 ;
		int end = 0 ;
		String ans = "" ;
		String ans1 = "" ;
		for(int i = 0 ; i<n ; i++){
			if(input.charAt(i) == ' '){
				end = i ;
				for(int j = end - 1 ; j>=start ; j--){
					ans = ans + input.charAt(j) ;
				}
				start = end + 1 ;
				ans = ans + " " ;

			}
		}
		for(int k = n - 1 ; k>=0 ; k--){
			ans1 = ans1 + ans.charAt(k) ;
		}


		return ans1 ;
	}  

	public static String reverseEachWord(String input) {
		// Write your code here

		String ans = "";
		String ANSWER = "";
		int space=0;
		for(int i=0;i<input.length();i++){

			if(input.charAt(i)==' '){ //To check for spaces
				String res="";
				ans = input.substring(space,i); //To save a word
				int l = ans.length();  //saving this word's length

				for(int j=l-1 ; j>=0 ;j--){ //reversing that word and saving in res
					res=res+ans.charAt(j);
				}

				ANSWER += res + " "; //saving res into the final answer string
				space = i+1;
			}
		}
		return ANSWER;
	}

	public static String removeConsecutiveDuplicates(String input) {
		String temp = "";
		int begin = 0;
		int end = 0;
		int i=0;
		for(i=0;i<input.length();i++)
		{   end = begin+1;
		while(end<input.length() && (input.charAt(begin)==input.charAt(end)) )
		{   end++;
		}
		temp += input.charAt(begin);
		begin = end;
		i = end;
		}

		//		    temp += input.charAt(input.length()-1);

		return temp;
	}

	public static String  ge(String s,int start,String s1)
	{     if(s.length()==start)
		return s1;

	if(s.charAt(start)==s.charAt(start-1))
		s1+='*' + s.charAt(start) ;

	else
		s1+=s.charAt(start);

	return ge(s,start+1,s1);


	}

	public static String addStars(String s) {

		if(s.length()==1)
			return s;

		String s1="";
		//	          
		//	          s1+=s1.charAt(0);

		return ge(s,1,s1);

	}

	public static String star(String str) {
		if(str.length()==1){
			return str.substring(0);
		}

		String s = "";
		if(str.charAt(0)==str.charAt(1)){
			s = str.charAt(0) + "*" + star(str.substring(1));
		}
		else{
			s = str.charAt(0) + star(str.substring(1));
		}



		return s;
	}

	private static int[] allindices(int[] input, int i) {
		int[] k= help(input,i,0,0);
		return k;
	}

	public static int[] allindices(int[] arr, int index, int x, int[] count)

	{
		int i;

		if (index == arr.length) return count;


		if (arr[index] == x)
		{
			int[] count1 = new int[count.length + 1];
			for (i = 0; i < count.length; i++) {
				count1[i] = count[i];

			}
			count1[count1.length - 1] = index;


			int[] ans = allindices(arr, index + 1, x, count1);

			return ans;

		} else return allindices(arr, index + 1, x, count); }



	private static int[] help(int[] input, int i, int j,int count) {

		if(j==input.length){
			return null;
		}

		int ans[] = new int[count+1];


		if(input[j]==i){

			ans[count++]=j;
			help(input,i,j+1,count);
			return ans;

		}
		else{
			return help(input,i,j+1,count);	
		}

	}


	public static int recur(int[] a,int pos1 ,int pos2){

		if(pos1>=pos2){

			return 0;
		}

		if(a[pos1]==((a[pos2-1]-a[pos1]))  && ((a[pos2-1]-a[pos1]))==((a[a.length-1]-a[pos2-1]))){
			return 1;
		}


		else{
			return recur(a,pos1+1,pos2) + recur(a,pos1,pos2-1);
		}


	}
	
	public static int splitIntoThree(int[] input, int sI) {
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("IN");

		//		System.out.println(star("llllllaaaa"));
		Scanner s=new Scanner(System.in);
		//		int arr[][] = new int[3][3];
		//		for (int i = 0; i < arr.length; i++) {
		//			for (int j = 0; j < arr[0].length; j++) {
		//				arr[i][j] = s.nextInt();
		//			}
		//		}
		
//		 int n= s.nextInt();
//		 int a[] = new int[n];
		 
//		 int n=s.nextInt();
//		 
//		 int sqrt=0;
//		 while(sqrt*sqrt<=n)
//		 {
//		     sqrt++;
//		 }
//		 System.out.println(sqrt-1);
//		 
//		 int rem;
//		 int count=0;
//		 int sum=0;
//		 int twopowzero = (int)Math.pow(2, 4);
//		 
//		 int prod=1;
//		 int c=2;
//		 while(n!=0)
//		 {
//		 rem=n%10;
//		 n=n/10;
//		 if(count ==0)
//		 {
//		 	twopowzero=1;
//		 	sum=sum+twopowzero*rem;
//		 	count++;
//		 }
//		 else {prod=1;
//		 	for(int i=1;i<=count;i++)
//		 		{prod=prod*c;}
//		 	
//		 	sum+=prod*rem;
//		 	count++;
//		 }
//		 }
//		 System.out.println(sum);
		 
//		 a[0]=s.nextInt();
//		 for(int i=1;i<n;i++){
//			 int x=s.nextInt();
//			 a[i]=a[i-1]+x;
//	   }
//		 System.out.print(recur(a,0,a.length-1));
		 
//		int arr4[]={};
//		int[] array = {0, 8, 7, 6, 8, 8};
//		int x = 8;
//
//		int arr5[] = allindices(array, 0, x, arr4);
//
//		for (int i = 0; i < arr5.length; i++) {
//			System.out.println(arr5[i]);
//
//
//		}

		//		int space = 'c';
		//		System.out.println(space);
		String input = "AaaAb";
		String str = input.toUpperCase();
		System.out.println(str);
		//		System.out.println(input.substring(4, 0));
		//	System.out.println(removeConsecutiveDuplicates(input));	
		//		System.out.println(compress("aabbb"));

		/*	int n= 500000;//s.nextInt();
		long ans=0;
		long temp,count=0;
		if(n<=1)
		    {
		        ans=n;
		    }
		else
		{
    		while(n>0)
    		{



    		        temp=n%2;

        		        ans +=(long)temp*Math.pow(10,count) ;
        		        count++;

        		    n=n/2;


    		}
		}


		System.out.println(ans);
		 */


		//		findLargest(arr);
		//		wavePrint(arr);
		//		int n1= s.nextInt();
		//		String str="ABCDEEE";
		//		String apk = str;
		//		str+="a";
		//		System.out.println(str);
		//		System.out.println(apk);
//		int n1 = s.nextInt();
//		int arr1[] = new int[n1];
//
//		for (int i = 0; i < n1; i++) {
//			arr1[i] = s.nextInt();
//		}

//		int[] a = allindices(arr1,3);


		//		System.out.println(secondLargestElement(arr1));

//		for (int i = 0; i < 3; i++) {
//			System.out.println(a[i]);
//		}
		//		rotate(arr1, 2);

		//		int n2= s.nextInt();
		//		int arr2[] = new int[n2];
		//		for (int i = 0; i < n2; i++) {
		//			arr2[i] = s.nextInt();
		//		}

		//	  int arr[] = sumOfTwoArrays(arr1, arr2);
		//	  pushZerosAtEnd(arr);

		//	  for (int i = 0; i < arr1.length; i++) {
		//		System.out.print(arr1[i]);
		//	}

		//		    int t = s.nextInt(); 
		//		    
		//		    for (int i = 1; i <= t; i++) {
		//		    	int N=s.nextInt();
		//				int Q=s.nextInt();
		//				
		//				String Friend = s.next();
		//				String Mine = s.next();
		//				
		//				int FriendScore = s.nextInt();

		//		    	String W = s.next();
		//				
		//		    	System.out.println("Case #" + i + ": " + cypher(W));
		//		    }








		int N1 = s.nextInt();
		int N2 = s.nextInt();
		int N3 = s.nextInt();

		int a1[] = new int[N1];
		int b[] = new int[N2];
		int c1[] = new int[N3];

		for (int i = 0; i < N1; i++) {
			a1[i] = s.nextInt();
		}

		for (int i = 0; i < N2; i++) {
			b[i] = s.nextInt();

		}

		for (int i = 0; i < N3; i++) {
			c1[i] = s.nextInt();
		}

		int i=0,j=0,k=0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while(i<N1 && j<N2 && k<N3){
			if(a1[i]<b[j] && a1[i]<c1[k]){
				i++;
			}else if(b[j]<a1[i] && b[j]<c1[k]){
				j++;
			}else if(c1[k]<a1[i] && c1[k]<b[j]){
				k++;
			}else if(a1[i]==b[j] && a1[i]==c1[k]){
				list.add(a1[i]);
				i++;j++;k++;
			}

			else{
				if(a1[i]==b[j]){
					list.add(a1[i]);
					i++;j++;
				}else if(a1[i]==c1[k]){
					list.add(a1[i]);
					i++;k++;
				}else{
					list.add(b[j]);
					j++;k++;
				}
			}
		}

		//		for (int i = 0; i < a1.length; i++) {
		//			System.out.println(a1[i]);
		//		}

		//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//		ArrayList<Integer> list = new ArrayList<Integer>();
		//		for (int i = 0; i < a1.length; i++) {
		//			if(!map.containsKey(a1[i])){
		//				map.put(a1[i], 1);
		//			}else{
		//				map.put(a1[i], map.get(a1[i])+1 );
		//			}
		//		}
		//		
		//		
		//		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		//		    if(entry.getValue()>=2){
		//		    	list.add(entry.getKey());
		//		    }
		////			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		//		}

		//		int i=0;
		//		while(i<t.length()){
		//
		//			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0 ){
		//				K--;
		//				map.replace(t.charAt(i), map.get(t.charAt(i))-1);
		//			}
		//			i++;
		//		}
		//		
		System.out.println(list.size());
		//		Collections.sort(list);
		for (int i1 = 0; i1 < list.size(); i1++) {
			//			a1[i] = list.get(i);
			System.out.println(list.get(i1));
		}




		//		int i=0,j=0,k=0;
		//		ArrayList<Integer> list = new ArrayList<>();
		//		
		//		while(i<N1 && j<N2 && k<N3){
		//			if(a1[i]<a2[j]){
		//				i++;
		//			}
		//		}
		//		int maxLead=Integer.MIN_VALUE;
		//		int winner=0;
		//		int p1Total = 0;
		//		int p2Total = 0;
		//		while(N>0){
		//			int p1 = s.nextInt();
		//			int p2 = s.nextInt();
		//			p1Total += p1;
		//			p2Total += p2;
		//			
		//			if(Math.abs(p1Total-p2Total)>maxLead){
		//				
		//				maxLead = Math.abs(p1Total-p2Total);
		//				if(p1Total>p2Total){
		//					winner=1;
		//					
		//				}else{
		//					winner=2;
		//					
		//				}
		//			}
		//			
		//			N--;
		//		}
		//		System.out.println(winner + " " + maxLead);
	}







	//	private static String cypher(String w) {
	//		// TODO Auto-generated method stub
	//		String ans="";
	//		if(w.length()==2){
	//			for (int i = w.length()-1; i >= 0; i--) {
	//				ans+=w.charAt(i);
	//			}
	//		}
	//		else if(w.length()==3){
	//			if(w.charAt(0)==w.charAt(2) && w.charAt(0)==w.charAt(1)){
	//				return w;
	//			}else if(w.charAt(0)==w.charAt(2) && w.charAt(0)!=w.charAt(1)){
	//				return "AMBIGUOUS";
	//			}
	//
	//		}else{
	//			char[] a = new char[4];
	//			a[1]=w.charAt(0);
	//			a[2]=w.charAt(3);
	//			int count[] = new int[4];
	//			count[1]=a[1]-65;
	//			count[2]=a[2]-65;
	//
	//
	//			if(count[2]<3){
	//				a[0] = (char)(w.charAt(1) - count[2]);
	//
	//			}else{
	//				a[0] = (char)(w.charAt(1) - count[2] + 26);
	//			}
	//
	//			if(count[1]<3){
	//				a[3] = (char)(w.charAt(2) - count[1]);
	//			}else{
	//				a[0] = (char)(w.charAt(1) - count[2] + 26);
	//			}
	//
	//			for (int i = 0; i < a.length; i++) {
	//				ans+=a[i];
	//			}
	//		}
	//		return ans;
	//	}



	//	private static int MagicalThinking(int n, int q, String friend, String mine, int friendScore) {
	//		// TODO Auto-generated method stub
	//		int i=0;
	//		int matching = 0;
	//		int MyScore = 0;
	//		while(i<friend.length()){
	//			if(friend.charAt(i)==mine.charAt(i)){
	//				matching++;
	//			}
	//			i++;
	//		}
	//		//		int notMatching = q-matching;
	//
	//		if(friendScore<=matching){
	//			MyScore = q - matching + friendScore;
	//		}
	//		else{
	//			MyScore = q - friendScore + matching;
	//		}
	//		return MyScore;
	//	}

}
