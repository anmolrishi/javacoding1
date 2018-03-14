package icpc;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while (t-->0) {
			String input = s.next();
			int A=0,B=0,vA=0,vB=0;
			
			
			for (int j = 0; j < input.length(); j++) {
				vA=0;vB=0;
				if(input.charAt(j)=='A'){
					A++;
					j++;
					while(j<input.length() && input.charAt(j)!='B'){
						
						if(input.charAt(j)=='A'){
							A++;
							A+=vA;
							vA=0;
						}else{
							vA++;
						}
						j++;
					}
				}
				
				if(j<input.length() && input.charAt(j)=='B'){
					B++;
					j++;
					while(j<input.length() && input.charAt(j)!='A'){
						
						if(input.charAt(j)=='B'){
							B+=vB+1;
							vB=0;
						}else{
							vB++;
						}
						j++;
					}
					if(j<input.length() && input.charAt(j)=='A'){
						j--;
					}
				}
				
			}
			
//			boolean tribeA=false,tribeB=false;
//			while(i<input.length()){
//				if(input.charAt(i)=='A'){
//					A++;
//					if(tribeA){
//						A+=vA;
//						vA=0;
//						tribeA=false;
//					}else{
//						tribeA=true;
//					}
//				}
//				else if(tribeA){
//					vA++;
//				}
//				
//				else if(input.charAt(i)=='B'){
//					B++;
//					if(tribeB){
//						B+=vB;
//						vB=0;
//						tribeB=false;
//					}else{
//						tribeB=true;
//					}
//				}
//				else if(tribeB){
//					vB++;
//				}
//				i++;
//			}
//		
		System.out.println(A + " " + B);
		}
		
	}

}
