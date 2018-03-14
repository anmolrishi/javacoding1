package august;

import java.util.HashMap;
import java.util.Set;

public class Mapp {
	
	
		public static void PairSum(int[] arr1, int size) {
		    int v=0;
		    HashMap<Integer,Integer> map=new HashMap<>();
		    for(int i=0;i<arr1.length;i++){
		    if(map.containsKey(arr1[i])){
		       v=map.get(arr1[i]);
		       map.put(arr1[i],v+1);
		       
		    }
		    else{
		        map.put(arr1[i],1);
		        
		    }
		    
		    }
		    
		    

		    Set<Integer> keys = map.keySet();  //get all keys
		    for(Integer i: keys)
		    {
		        System.out.println(map.get(i));
		    }
		    
		    for(int i=0;i<arr1.length;i++){
		        if(map.containsKey(-arr1[i]) && map.containsKey(arr1[i])){
		            if(arr1[i]> -arr1[i]){
		            System.out.print(-arr1[i]+" ");
		            System.out.println(arr1[i]);}
		            else{
		                   System.out.print(arr1[i]+" ");
		                System.out.println(-arr1[i]);
		            }
//		           v=map.get(arr1[i]); 
//		           map.put(arr1[i],v-1);
//		           v=map.get(-arr1[i]); 
//		           map.put(-arr1[i], v-1);
		        }
		        
		        
		    }
		
		}
		
		public static void intersection(int[] arr1, int[] arr2){
			  HashMap<Integer,Integer> max1 = new HashMap<>();
		      for(int i=0;i<arr1.length;i++){
		          if(max1.containsKey(arr1[i])){
		            max1.put(arr1[i],max1.get(arr1[i])+1); 
		          }else{
		           	max1.put(arr1[i],1); 
		          }
		        }
		      
		      for(int i=0;i<arr2.length;i++){
		        if(max1.containsKey(arr2[i])){
		          System.out.println(arr2[i]);
		          max1.put(arr1[i],max1.get(arr1[i])-1);
		        }
		      }
			}

		public static void findPairsDifferenceK(int[] input, int k){
	      	HashMap<Integer,Integer> map=new HashMap<>();
			int no=0;
			for(int i=0;i<input.length;i++)
			{
			    if(!map.containsKey(input[i]))
			    {
			        map.put(input[i],1);
			    }
			    else
			    {
			        map.put(input[i],map.get(input[i])+1);
			    }
			}
	      
	      for(int i = 0 ; i < input.length ; i++){
	        no=k+input[i];
	        if(map.containsKey(no)){
	          int c = map.get(no);
	          if(no==input[i])
	          {
	            c=c*(c-1)/2;
	            while(c>0){
	            if(no <= input[i])
			        { 
			            System.out.println(no+" "+input[i]);
		
			        }
			        else
			        {
			            System.out.println(input[i]+" "+no);
			        }
	            
	            c--;
	                //map.put(input[i] , 0);
	              
	    
	         
	          }
	           map.remove(input[i]);
	            continue;
	          }
	          
	          while(c>0){
	            if(no <= input[i])
			        { 
			            System.out.println(no+" "+input[i]);
		
			        }
			        else
			        {
			            System.out.println(input[i]+" "+no);
			        }
	            
	            c--;
	          }
	          
	          if(map.get(input[i]) > 1){
	            map.put(input[i] , map.get(input[i]) - 1);
	          }
	          else{
	            map.remove(input[i]);
	          }
	          
	        }
	      }
	         
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//int[] a = {2,-2,2};
//PairSum(a, a.length);
		int[] input = {1,1,2,3,1,3,4};
	findPairsDifferenceK(input, 1);
//		PairSum(input,input.length);
	}

}
