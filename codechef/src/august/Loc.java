package august;

import java.util.Scanner;

public class Loc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int i = 0; i < N; i++) 
		{
			String input = s.next();
			
			System.out.println(princess(input));
			
		}
	}

	private static String princess(String input) {
		// TODO Auto-generated method stub
		int j=1;
//		if (input.length()==2){
//			if(input.charAt(0)==input.charAt(1)){
//				return "YES";
//			}else{
//				return "NO";
//			}
//		}
		while(j<input.length()){
			if(input.charAt(j) == input.charAt(j-1) || (j-2>=0 && input.charAt(j) == input.charAt(j-2))){
				return"YES";
				
			}
			j++;
		}
		return "NO";
	}

}
