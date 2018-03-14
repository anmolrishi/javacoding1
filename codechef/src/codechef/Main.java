package codechef;

import java.util.*;



public class Main {


	public static int maximum(int x, int y) 
	{ 
		if(x>y) 
			return x; 
		else 
			return y;

	}


	public static  int maxPathSum(int arr1[], int arr2[]) 
	{
		int m=arr1.length;
		int n=arr2.length;
		int i = 0, j = 0;
		int fin = 0, sum1 = 0, sum2 = 0;
		while (i < m && j < n) 
		{
			if (arr1[i] < arr2[j])
				sum1 += arr1[i++];
			else if (arr1[i] > arr2[j])
				sum2 += arr2[j++];
			else
			{
				fin += maximum(sum1, sum2);
				sum1 = 0;
				sum2 = 0;

				while (i < m && j < n && arr1[i] == arr2[j]) 
				{
					fin = fin + arr1[i]; i++;
					j++;
					// System.out.print(fin+" ");
				}
			}
		}

		while (i < m)
		{ sum1 += arr1[i++];
		}         
		while (j < n)
		{    sum2 += arr2[j++]; }

		fin += maximum(sum1, sum2);

		return fin; 
	}


//	public static int findUnique(int[] arr){
//		int l=arr.length;
//		int ans=0;
//		Arrays.sort(arr);

		//	for (int i = 0; i < arr.length; i++) {
		//		System.out.println(arr[i]);
		//	}

//		for(int i=0;i<l-1;i+=2){
//
//			if(arr[i]!=arr[i+1]){
//				return arr[i];
//			}
//		}
//		return arr[arr.length-1];
		//	 {c=1;
		//	
		//	   for(int j=0;j<l;j++)
		//	     {if(arr[i]==arr[j])
		//	        {++c;
		//	         
		//	        }
		//	     }
		//	   
		//	    if(c==1)
		//	     { ans=arr[i];
		//	    }
		//	 }


//	}

	public static int count(int value,int[] a,int index,int n){

		if(value<0)
			return 0;

		if(index==n)
			return 0;

		if(value==0)
			return 1;

		else {

			return count(value-a[index],a,index,n)+count(value,a,index+1,n);
		}

	}
	
//	public static int[] arrange(int n){
//		int arr[] = new int[n];
//		int i,k=0;
//		for( i = 0; (2*i) + 1 <= arr.length; i++){
//		    
//		        arr[i] = (2*i)+1;
//		}
//		if(n % 2 != 0){
//		    n=n-1;
//		    i = n/2 + 1;
//		}else{
//		    i = n/2;
//		}
//		for( ; i<arr.length; i++){
//		    
//		        arr[i] = n-(2*k);
//		    k= k+1;
//		}
//		   return arr; 
//	}
	
	public static String replace(String input)
	{
		String s="";
		
	if(input.length()==1)
	
	{return s+input.charAt(0);}
	
	if(input=="pi")
	
	{return "3.14";}
	
	if(input.charAt(0)=='p' && input.charAt(1)=='i')
	
	{s=s+"3.14";
	s=s+replace(input.substring(2,input.length()));
	}
	
	else if(input.length()>=1)
	
	{s=s+input.charAt(0);
	s=s+replace(input.substring(1,input.length()));}
	

	
	
	
	return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(replace("HELLOpipi ksa"));
		Scanner s = new Scanner(System.in);
	
//		int n=s.nextInt();
//		long ans=0;
//		int i=0;
//		while(n!=0){
//			ans += (long)((n%2) * Math.pow(10, i));
//			n = n/2;
//			i++;
//		}
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(i);
//		System.out.println(ans);

		//		int value=s.nextInt();
		//		int[] a = new int[n];
		//		
		//		for(int i=0;i<n;i++){
		//			a[i]=s.nextInt();
		//		}
		//		
		//		System.out.println(count(value,a,0,n));
		//		int arr[] = {0,1,0,1,0,1,0};
		//		boolean swapped = true;
		//	    int j = 0;
		//	    int tmp;
		//	    while (swapped) {
		//	        swapped = false;
		//	        j++;
		//	        for (int i = 0; i < arr.length - j; i++) {
		//	            if (arr[i] > arr[i + 1]) {
		//	                tmp = arr[i];
		//	                arr[i] = arr[i + 1];
		//	                arr[i + 1] = tmp;
		//	                swapped = true;
		//	            }
		//	        }
		//	    }



		//	    for (int i = 0; i < arr.length; i++) {
		//			System.out.println(arr[i]);
		//		}

		//		int[] arr1= {1,2,1,5,2};
		//		int[] arr2= {100};
		//		System.out.println(maxPathSum(arr1, arr2));
		//		System.out.println(findUnique(arr1));
		//		Scanner scan = new Scanner(System.in);
		//		int K = scan.nextInt();
		//		String s = scan.next();
		//		String t = scan.next();
		//		
		//		HashMap<Character, Integer> map = new HashMap<>();
		//		
		//		for (int i = 0; i < s.length(); i++) {
		//			if(!map.containsKey(s.charAt(i))){
		//				map.put(s.charAt(i), 1);
		//			}else{
		//				map.replace(s.charAt(i), map.get(s.charAt(i))+1 );
		//			}
		//		}
		//		int i=0;
		//		while(K>0 && i<t.length()){
		//			
		//			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0 ){
		//				K--;
		//				map.replace(t.charAt(i), map.get(t.charAt(i))-1);
		//			}
		//			i++;
		//		}
		//			
		//			if(K>0){
		//				System.out.println("NO");
		//			}
		//			else{
		//				System.out.println("YES");
		//			}
		//		
		//		
		//		System.out.println(map.toString());


		//		int sa = s.nextInt();
		//		int E = s.nextInt();
		//		int W = s.nextInt();
		//		int i;
		//		i = sa;
		//		while(i<=E)
		//		{
		//		    double cel  =  (5.0/9) * (i-32);
		//		    System.out.println(i + "\t" + (int)cel);
		//		    i = i + W;
		//		}
		//		



		// Write your code here


		//	
		//		Scanner scan = new Scanner(System.in);
		//		int t=scan.nextInt();
		//		while(t>0)
		//		{
		//			int n=scan.nextInt();
		//			int[] a=new int[n];
		//			for(int i=0;i<n;i++)
		//			{
		//				a[i]=scan.nextInt();
		//			}
		//			System.out.println(); 
		//			t--;
		//		}

		//		Scanner in = new Scanner(System.in);
		////	    int t = in.nextInt(); 
		//	    
		//	    int a=42;
		//	    double basic=293;
		//	    double pf=(11*basic)/100;
		//	    System.out.println(pf);
		//	    
		//		Scanner s= new Scanner(System.in);

		//		Scanner sc = new Scanner(System.in);
		//		int n=sc.nextInt();
		//		int t1=0;
		//		int t2=1;
		//		int f=1;
		//		if(n==0){
		//			System.out.println(t1);
		//		}
		//		else if(n==1){
		//			System.out.println(t2);
		//		}
		//		else{
		//		for(int i=2;i<=n-1;i++){
		//			
		//			t1=t2;
		//			t2=f;
		//			f=t1+t2;
		//		}
		//		System.out.println(f);
		//		}

		//		int n,p;
		//		Scanner s=new Scanner(System.in);
		//		n=s.nextInt();
		//		for(int i=2;i<=n;i++)
		//		{
		//			p=0;
		//			for(int j=2;j<i/2;j++)
		//			{
		//				if(i%j==0)
		//					p=1;
		//			}
		//			if(p==0){
		//				System.out.println(i);
		//
		//			}
		//		}
		//		int[] a= {7,1,5,2,6,8,0};
		////		System.out.println(lengthOfConsecutiveNumbers(a));
		//		
		//		int x=5;
		//		double d=7.64;
		//		
		//		System.out.println(d%x);


		//		double basic=s.nextInt();
		//		String str=s.next();
		//		char grade=str.charAt(0);
		//		double allow=0;
		//	    double hra=basic/5;
		//	    System.out.println(hra);
		//		double da=basic/2;
		//		if (grade=='A'){
		//		    allow=1700;
		//		}
		//		else if(grade=='B'){
		//		    allow=1500;
		//		}
		//		else{
		//		    allow=1300;
		//		}
		//        double pf=(11*basic)/100;
		//        double total=(basic+hra+da+allow-pf);
		//        total+=0.5;
		//        int tot=(int)total;
		//        System.out.println(tot);


		//	    for (int i = 1; i <= t; i++) {
		//	  
		//	    	int N = in.nextInt();
		//	    	int M = in.nextInt();
		//	    	System.out.println(knights(N,M));
		//	    }

		//			    Scanner in = new Scanner(System.in);
		//			    int t = in.nextInt(); 
		//			    
		//			    for (int i = 1; i <= t; i++) {
		//			    	int N = in.nextInt();
		//			    	System.out.println("Case #" + i + ": " + beautifulNumbers(N));
		//			    }
		//	    
		//		printFahrenheitTable(0, 100, 20);

		/*	Scanner s = new Scanner(System.in);
		String str = s.next();
		char c =str.charAt(0);

		if(c>=65 && c<=90){
		    System.out.println(1);
		}else if(c>=97 && c<=122){
		    System.out.println(0);
		}else{
		    System.out.println(-1);
		}*/
		//		boolean a[] = new boolean[5];
		//		
		//		for (int i = 0; i < a.length; i++) {
		//			System.out.println(a[i]);
		//		}
		//		Scanner s = new Scanner(System.in);
		//		String str = s.next();
		//		char c =str.charAt(0);
		//		int i = c;
		//		if(i>=65 && i<=90){
		//		    System.out.println(1);
		//		}if(i>=97 && i<=122){
		//		    System.out.println(0);
		//		}else{
		//		    System.out.println(-1);
		//		}
	}

	public static void printFahrenheitTable(int start, int end, int step) {
		int i=start;
		while(i<=end){
			System.out.println(i+" "+((i-32)*5)/9);
			i=i+step;
		}
	}

	private static int knights(int n, int m) {
		// TODO Auto-generated method stub
		//		int minKnights=0;
		if(n==1){
			return m;
		}
		else if(n==2){
			if(m==1){
				return 2;
			}
			else if(m==2 || m==3){
				return 4;
			}
			else{
				return m;
			}
		}
		else{
			if(m==1){
				return 3;
			}
			else if(m==2 || m==3){
				return 4;
			}
			else{
				return m;
			}
		}


	}

	public static boolean checkMember(int n){

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */

		int a = 0;
		int b = 1;
		int sum = 0;

		if(n < 0){
			return false;
		}else{

			while(a <= n){
				sum = a + b;
				a = b;
				b = sum;

				if(a == n){
					return true;
				}else{
					return false;
				}

			} //end of while loop
			return false;
		}
	}

	public  static int lengthOfConsecutiveNumber(int[] input){	
		// Write your code here
		ArrayList<Integer> list = new ArrayList<>(); 
		Arrays.sort(input);
		int i=0;
		list.add(input[0]);
		while(i<input.length){
			if(input[i]==input[i+1]-1){

			}
			//			else

		}
		return 0;
	}

	public static int lengthOfConsecutiveNumbers(int[] input){ // Write your code
		//		here 
		Stack Nos= new Stack(); 
		int min=input[0];
		int	minIndex=0;
		int count=0;

		while(count<input.length)
		{
			for(int i=1;i<input.length;i++)
			{
				if(input[i]<min)
				{
					min=input[i];
					minIndex=i; 
				}
			}
			Nos.push(min);

			input[minIndex]=Integer.MAX_VALUE;
		}

		int	ConsLength=1;
		int	MaxConsLength=1;

		while(Nos!=null && Nos.size()>1)
		{
			int te=(int)Nos.pop();
			int	top=(int)Nos.peek();

			if(top==te-1)
			{
				ConsLength=ConsLength+1;
			} 
			else 
			{
				MaxConsLength=Integer.max(MaxConsLength,ConsLength);
			} 
		} 
		return MaxConsLength;
	}

	private static int beautifulNumbers(int n) {
		// TODO Auto-generated method stub
		int c=2;
		int maxBase=0;
		int num=0;
		for (int i = 2; i <= n; i++) {
			String s = "";

			int temp=n;
			while(temp>0){
				if(temp%i != 1){
					break;
				}
				s +=  temp%i; 
				temp/=i;
			}

			boolean flag=true;
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)!='1'){
					flag=false;
				}
				c=j;
			}
			if(flag && num<c ){
				System.out.println(s);
				num=c;
				maxBase=i;
			}
		}
		return maxBase;
	}



	//	private static int diwaliLights(String s, int i, int j) {
	//		// TODO Auto-generated method stub
	//
	//
	//		char[] c = new char[j];
	//		
	//		int l=0;
	//		int t=0;
	//		while(l<j){
	//			if(t==s.length()){
	//				t=0;
	//			}
	//			c[l]=s.charAt(t);
	//			l++;
	//			t++;
	//		}
	//		
	//		i=i-1;
	//		j=j-1;
	////		for (int k = 0; k < c.length; k++) {
	////			System.out.println(c[k]);
	////		}
	//		int count=0;
	//		
	//		for (int k = i; k <= j; k++) {
	//			if(c[k]=='B'){
	//				count++;
	//			}
	//		}
	//		return count;
	//	}
	//
	//	
	////	2
	////	BBRB
	////	4 8 
	////	BBRB
	////	10 12
	//	private static int feast(int[] a) {
	//		// TODO Auto-generated method stub
	//		
	//		int posCount=0;
	//		int posSum=0;
	//		int negSum=0;
	//		for (int i = 0; i < a.length; i++) {
	//			if(a[i] >= 0){
	//				posCount++;
	//				posSum+=a[i];
	//			}
	//			else{
	//				negSum+=a[i];
	//			}
	//		}
	//		return posCount*posSum + negSum;
	//	}

}



