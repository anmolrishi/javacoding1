package august;

import java.util.Scanner;

/**
 * Created by aksha on 24-08-2017.
 */

   
public class nextPalindrome {

	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();

	        while (t-->0) {
	            
	            String input = s.next();
	            char c[] =  input.toCharArray();
	            for (int i = 0; i < c.length; i++) {
					System.out.print(c[i]);
				}
	         printint(nextpalin(getarr(c)));

	            }
	    }
	    public static int[]getarr(char[] num)
	    { int[] arr = new int[num.length];
	    for (int i = 0; i < num.length; i++) {
			arr[i]=num[i];
		}

	return arr;

	    }
	    public static void printint(int[]arr)
	    {
	        int result = 0;
	        for(int i = 0; i < arr.length; i++)
	        {result += Math.pow(10,i) * arr[arr.length - i - 1];}
	        System.out.println(result);


	    }

	        public static int[] nextpalin(int[]arr){

	        int count = 0;
	        int f=0;
	        int first=0;

	        int last=arr.length-1;
	        for(int i=0;i<arr.length;i++) {
	            if (arr[i] != 9) {
	                count = 1;
	            }}if(count ==0){
	            int []arr2=new int[arr.length+1];
	            arr2[0]=1;
	            arr2[arr2.length-1]=1;
	          return arr2;
	        } else {
	            arr[last]+=1;
	                for (int i = last ; i > 0; i--) {
	                   if (arr[last] > 9){
	                       arr[i] = arr[i] % 10;
	                    arr[i - 1] += 1;}}
	            while (f!=-1) {
	                if (arr[last] > arr[first]) {
	                    arr[last] = arr[first];
	                    arr[last - 1] += 1;
	                    for (int i = last - 1; i >= 0; i--) {
	                        if (arr[i] > 9) {
	                            arr[i] = arr[i] % 10;
	                            arr[i - 1] += 1;}}
	                } else {
	                    arr[last] = arr[first];}
	                f = checkpalin(arr);
	                if(f!=-1)
	                {first=f;
	                    last=arr.length-f-1;
	                }}
	           return arr; }}
	    public static int checkpalin(int[] arr) {
	        for (int i = 0; i < arr.length / 2; i++) {
	            if (arr[i] != arr[arr.length - i - 1]) {
	                return i;
	            }}
	        return -1;
	    }
}
