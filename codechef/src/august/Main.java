package august;

import java.util.Scanner;

public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();

		for (int i = 1; i <= t; i++) {

			String Str = s.next();
			String Str2 = s.next();
			chefs(Str,Str2);
		}
	}

	
	private static void chefs(String s, String t) {
		// TODO Auto-generated method stub
		int i;
        int y = 0;
        int temp=0;
        int count = 0, j = 0;
        int a[] = new int[256];
        for (i = 0; i < t.length(); i++) {
            a[t.charAt(i)]++;
        }
        for (i = 0; i < s.length(); i++) {

                count += a[s.charAt(i)];


            a[s.charAt(i)] = 0;
        }

        for (i = 0; i < t.length(); i++) {
            a[t.charAt(i)]=0;
        }
        for (i = 0; i < t.length(); i++) {
            a[t.charAt(i)]++;
        }
       for (i = 0; i < s.length(); i++) {
           if (a[s.charAt(i)] == 0) {
               j=1;
           break;} }

//        }
//        for (i = 0; i < s.length(); i++) {
//            a[s.charAt(i)]=0;
//        }
        for (i = 0; i < t.length(); i++) {
            a[t.charAt(i)]=0;
        }
        for (i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
                          }
        for (i = 0; i < a.length; i++){
        if (a[i]>1) { y+=1;
        }}


        for (i = 0; i < t.length(); i++) {
        if (a[t.charAt(i)]>1)      {

            temp+=1 ;
            a[t.charAt(i)]=0;

        }
        }

        if (count == t.length() && j == 1) {
            System.out.println("A");
        } else if (y > temp) {
            System.out.println("A");
        } else {
            System.out.println("B");}
    }



private static char[] chef(long[] input, int d) {
	// TODO Auto-generated method stub
	return null;
}

private static long chefmover(long[] input,int d) {
	// TODO Auto-generated method stub
	long total=0; long ans=0; long y=0;

	for (int i = 0; i < input.length; i++) {
		total+=input[i];
	}
	y=total/input.length;
	if(total%input.length!=0){
		return -1;
	}



	for(int k=0;k<input.length-d;k++)
	{if (input[k]-y>0){
		ans+=input[k]-y;
		input[k+d]+=input[k]-y;	 

	}
	else {
		ans+=y-input[k];
		input[k+d]-=y-input[k];
	}
	}

	for(int u=input.length-d;u<input.length;u++)
	{
		if
		(input[u]!=y)
		{return -1;}

	}

	return ans;

}

private static boolean check(int[] input, double sum) {
	// TODO Auto-generated method stub
	for (int i = 0; i < input.length; i++) {
		if(input[i]!=sum){
			return false;
		}
	}
	return true;
}

private static String rainbow(int[] input) {
	// TODO Auto-generated method stub
	int n=input.length;
	//		for (int i = 0; i < input.length; i++) {
	//			System.out.println(input[i]);
	//		}

	int t = (int) Math.random();
	for (int i = 0; i <= n/2; i++) {
		if(input[i] != input[n-i-1]){
			return "no";
		}
	}
	int c=1;
	for (int i = 0; i <= input.length/2; i++) {

		if(c>7){
			return "no";
		}

		if(c == input[i] && c+1 == input[i+1]){
			c++;
		}else if(c==input[i]){
			continue;
		}else{
			return "no";
		}
	}
	if(c!=7){
		return "no";
	}
	return "yes";
}

}
