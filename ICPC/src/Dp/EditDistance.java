package Dp;

public class EditDistance {

	public static int ed(String s, String t) {
		if(s.length()==0){
			return t.length();
		}
		if(t.length()==0){
			return s.length();
		}
		
		if(s.charAt(0)== t.charAt(0)){
			return ed(s.substring(1),t.substring(1));
		}
		
		else{
			int insert = ed(s,t.substring(1));
			int delete = ed(s.substring(1),t);
			int sub = ed(s.substring(1),t.substring(1));
		
			return 1+Math.min(insert, Math.min(delete, sub));
		}
		

	}
	
	public static int edMemoization(String s, String t) {
		int[][] Storage = new int[s.length()][t.length()];
		
		for (int i = 0; i < Storage.length; i++) {
			for (int j = 0; j < Storage[i].length; j++) {
				Storage[i][j] = -1;
			}
		}
		
		return edMemoizationHelper(s,t,Storage);
	}
	
	private static int edMemoizationHelper(String s, String t, int[][] storage) {
		// TODO Auto-generated method stub
		int m = s.length()-1;
		int n = t.length()-1;
		
		if(m==0){
			storage[m][n]=n+1;
			return storage[m][n];
		}
		if(n==0){
			storage[m][n]=m+1;
			return storage[m][n];
		}
		
		
		if(storage[m][n]!=-1){
			return storage[m][n];
		}
		
		
		
		if(s.charAt(0) == t.charAt(0)){
			storage[m][n] = ed(s.substring(1),t.substring(1));
		}else{
			int i = edMemoizationHelper(s, t.substring(1), storage);
			int d = edMemoizationHelper(s.substring(1), t, storage);
			int sub = edMemoizationHelper(s.substring(1), t.substring(1), storage);
			
			storage[m][n] = 1+Math.min(i, Math.min(d, sub));
		}
		
		return storage[m][n];
	}

	public static void main(String[] args) {
		String s = "abcasdfasef";
		String t = "defasdfadsfopasdkpfo";
		System.out.println(edMemoization(s,t));
		System.out.println(ed(s,t));

	}
}
