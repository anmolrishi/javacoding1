package IARCS;

public class Solution {
	
	
public static void merge(int[] input,int start,int mid,int end){
        
        int[] a = new int[mid -start+1];
        int[] b= new int[end-mid];
        
        for(int i=start;i<=mid;i++){
            a[i-start]=input[i];
        }
        
         for(int i=mid+1;i<=end;i++){
            b[i-(mid+1)]=input[i];
        }
        
        int n=a.length;
        int m=b.length;
        int i=0;
        int j=0;
        int k=start;
        
        while(i<n && j<m){
            
            if(a[i]<=b[j]){
            
            input[k]=a[i];
            i++;
            k++;
          }
          
          else{
              input[k]=b[j];
              j++;
              k++;
          }
    }
    
    
    while(i<n){
        
        input[k]=a[i];
        i++;
        k++;
    }
    
    while(j<m){
        input[k]=b[j];
        j++;
        k++;
    }
    
    }
    
    public static void recur(int[] input,int start,int end){
        
         if(start>=end){
         return;
        }
       int  mid=(start+end)/2;
        recur(input,start,mid);
        recur(input,mid+1,end);
        
        merge(input,start,mid,end);
        
    }
    
//	public static void quickSort(int[] input,int si,int ei){
//	    if(si>=ei){
//	        return;
//	    }
//	    int pivotPosition = partition(input,si,ei);
//	    quickSort(input,si,pivotPosition-1);
//	    quickSort(input,pivotPosition+1,ei);
//	}
//	public static int partition(int[] input,int si,int ei){
//	    int count=0;
//	    int x=input[si];
//	    for(int i=si+1;i<=ei;i++){
//	        if(x>=input[i]){
//	         count++;   
//	        }
//	    }
//	    int pivotpos=si+count;
//	    
//	    int temp=input[si];
//	    input[si]=input[pivotpos];
//	    input[pivotpos]=temp;
//	    
//	    int i=si;
//	    int j=ei;
//	    
//	    while(i<pivotpos && j>pivotpos){
//	        if(input[i]<=input[pivotpos]){
//	            i++;
//	            
//	        }
//	        if(input[j]>input[pivotpos]){
//	            j--;
//	        }
//	        if(input[i]>input[pivotpos] && input[j]<=input[pivotpos]){
//	            int temp1=input[i];
//	            input[i]=input[j];
//	            input[j]=temp1;
//	            i++;
//	            j--;
//	        }
//	        
//	    }
//	    return pivotpos;
//	}
//
//public static void quickSort(int[] input) {
//    quickSort(input,0,input.length-1);
//	
//}
    
	public static void mergeSort(int[] input){

     recur(input,0,input.length-1);
     
     
     
}
	
//	public static int partition(int[] input,int si , int ei ){
//	    int c = 0;
//	    for(int i = si+1; i <= ei ; i++){
//	        if(input[i] <= input[si]){
//	            c++;
//	        }
//	    }
//	    int pivot = si + c;
//	    
//	    int temp = input[si];
//	    input[si] = input[pivot];
//	    input[pivot] = temp;
//	    
//	    int i = si;
//	    int j = ei;
//	    
//	    while(i < pivot && j > pivot){
//	        
//	    	 
//	            
//	    	if(input[i] > input[pivot] && input[j] <= input[pivot]){
//	           
//	            temp = input[i];
//	            input[i] = input[j];
//	            input[j] = temp;
//	            i++;
//	            j--;
//	        }
//	          
//	    	 if(input[i] <= input[pivot]){
//	                i++;
//	            }
//	            if(input[j] > input[pivot]){
//	                j--;
//	            }
//	        
//	    }
//	    return pivot;
//	}
	
	private static void swap(int []arr,int a,int b )
	{
	    int temp=arr[a];
	    arr[a]=arr[b];
	    arr[b]=temp;
	    
	}
	
	private static int partition (int a[],int si,int ei)
	{
	    int pivot=a[si];
	    int count=0;
	    int z=si+1;
	    while(z<a.length)
	    {
	        if(a[z]<=pivot)
	        {
	            count++;
	           
	        }
	         z++;
	    }
	    
	    int pivotPos=si+count;
	    swap(a,si,pivotPos);
	    
	    int i=si;
	    int j=ei;
	    
	    while(i<pivotPos && j>pivotPos)
	    {
	        
	    	
	       if(a[i]<=a[pivotPos])
	       {
	           i++;
	       }
	       
	       if(a[j]>a[pivotPos])
	       {
	           j--;
	       }
	       
	       if(a[i]>a[pivotPos] && a[j]<=a[pivotPos])
	       {
	           swap(a,i,j);
	           i++;
	           j--;
	       }
	       
   
	    }
	    
	    return pivotPos;

	}
	public static void quickSortreal(int[] input,int si,int ei ) {
	    if(si >= ei){
	        return;
	    }
	    
	    int pp = partition(input , si , ei);
	    quickSortreal(input , si , pp - 1);
	     quickSortreal(input , pp + 1 , ei);
	}
	public static void quickSort(int[] input){
	    quickSortreal(input,0,input.length - 1);
	}
	
	public static int sod(int input,int sum)
    {
        if(input==0)
        {
            return sum;
        }
        sum+=input%10;
        return sod(input/10,sum);
    }

	public static int sumOfDigits(int input){
		
		return sod(input,0);

	}
//public static int partition(int[] input,int si,int ei){
//        
//        int pivot=input[si];
//        int count=0;
//        for(int i=si+1;i<=ei;i++){
//            
//            if(input[i]<=pivot){
//                count++;
//            }
//        }
//        
//        pivot=si+count;
//        int i=si;
//        int j=ei;
//        
//        int k=0;
//        int l;
//        l=input[pivot];
//        input[pivot]=input[si];
//        input[si]=l;
//        
//        while(i<pivot && j>pivot){
//            
//            if(input[i]<=input[pivot]){
//                i++;
//            }
//            
//            else{
//                
//                for(int p=j;p>pivot;p--){
//                    if(input[p]<=input[pivot]){
//                        k=p;
//                        break;
//                    }
//                }
//                int temp;
//                temp=input[i];
//                input[i]=input[k];
//                input[k]=temp;
//                j=k--;
//                i++;
//                
//            }
//            
//            
//        }
//        
//       return pivot; 
//        
//        
//    }
	
	public static int[][] subsets(int input[]) {
return subsets(input , 0);
	}

	   
		public static int[][] subsets(int input[] , int startindex){
	    if(startindex == input.length){
	        int ans[][] = new int[1][0];
	        return ans;
	       
	    }
	    int smallans[][] = subsets(input , startindex+1);
	    int ans[][] = new int[2*smallans.length][];
	  
	  
	    int k = 0;
	    for(int i = 0;i < smallans.length;i++){
	        ans[k] = new int[smallans[i].length];
	        for(int j = 0; j < smallans[i].length; j++){
	            ans[k][j] = smallans[i][j];
	        }
	        k++;
	    }
//	    for(int i = 0;i<smallans.length;i++){
//	         ans[k] = new int[smallans[i].length +1];
//	        ans[k][0] = input[startindex];
//	        for(int j = 1 ; j<=smallans[i].length ;j++){
//	         ans[k][j] = smallans[i][j-1];   
//	        }
//	        k++;
//	    }
	    
	    for(int i = 0;i<smallans.length;i++){
	         ans[k] = new int[smallans[i].length +1];
	        ans[k][0] = input[startindex];
	        for(int j = 1 ; j<=smallans[i].length ;j++){
	         ans[k][j] = smallans[i][j-1];   
	        }
	        k++;
	    }
	    return ans;
	    
//		for (int i = 0; i<smallAns.length; i++)
//		{   a[i+smallAns.length]= new int[smallAns[i].length+1];
//			a[i+smallAns.length][0] = input[0];
//
//			for(int j=1;j<smallAns[i].length+1;j++)
//			{							
//				
//				a[i+smallAns.length][j] = smallAns[i][j-1];	
//			}
//
//		}
}
		
		public static int lastIndex(int input[], int x) {
			/* Your class should be named Solution
			 * Don't write main().
			 * Don't read input, it is passed as function argument.
			 * Return output and don't print it.
		 	 * Taking input and printing output is handled automatically.
			*/
			int n=input.length;
			
			
			    if(input.length==0)
			    {
			        return -1;
			    }
			   
			    if(input[0] ==x){
			    	return n ;
			    }
			
			
			int arr[]=new int[input.length-1];
			
			for(int i=1;i<=arr.length;i++)
			{   
			   arr[i-1]=input[i];
			   
			}
		
		    int ans= lastIndex(arr,x);
		    if(ans!=-1){
		    	 return ans;
		    }
		   
		    return -1;
		    
		}
		
		public static int[][] sub(int arr[],int start,int x)
		{
		    if(start==arr.length)
		    {
		        if(x==0)
		        {
		            int ans[][]=new int[1][0];
		            return ans;
		        }
		        else
		        {
		            int ans1[][]=new int[0][0];
		            return ans1;
		        }
		    }
		    
		    int smallans1[][] = sub(arr,start+1,x);
		    int smallans2[][] = sub(arr,start+1,x-arr[start]);
		    
		    int ans[][]=new int[smallans1.length+smallans2.length][];
		    int c=0;
		    
		    for(int i=0;i<smallans1.length;i++)
		    {
		        
		        ans[i]=smallans1[i];
		        c++;
		        
		    }
		    int k=0;
		    for(int i=0;i<smallans2.length;i++)
		    {
		        ans[c]=new int[smallans2[i].length+1];
		        ans[c][0]=arr[start];
		        
		        for(int j=0;j<smallans2[i].length;j++)
		        {
		            
		        ans[c][j+1] = smallans2[i][j];
		        
		        }
		        c++;
		    }
		   
		    return ans;
		}

		public static int[][] subsetsSumK(int input[], int k) {
			
			return sub(input,0,k);

		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {5,2,3,1,17,3};
//		System.out.println(lastIndex(input, 4));
//		quickSort(input);
		int a[][] = subsetsSumK(input, 6);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
//		System.out.println(sumOfDigits(243324));
	}

}
