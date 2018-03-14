package ieeeXtreme;

import java.util.Scanner;

public class pixels {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s= new Scanner(System.in);
		
		int t=s.nextInt();
		while(t-->0){
			int row=s.nextInt();
			int col=s.nextInt();
			
			int[][] photo = new int[row+2][col+2];
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					photo[i][j] = s.nextInt();
				}
			}
			
			int op1 = 1 + plus(photo,1,1);
			System.out.println(op1);
		}
	}

	private static int plus(int[][] photo,int i, int j) {
		// TODO Auto-generated method stub
		if(i>photo.length-1 || j>photo[i].length-1){
			return 0;
		}
		if(photo[i][j]==1){
			photo[i][j]=0;
			if(photo[i-1][j]==1){
				return plus(photo,i-1,j);
			}
			if(photo[i][j+1]==1){
				return plus(photo,i,j+1);
			}
			if(photo[i+1][j]==1){
				return plus(photo,i+1,j);
			}
			if(photo[i][j-1]==1){
				return plus(photo,i,j-1);
			}
			
		}
		return 0;
	}

}
