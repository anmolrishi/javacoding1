package ieeeXtreme;

import java.util.Scanner;

public class octopuses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s= new Scanner(System.in);

		int n=s.nextInt();
		int m=s.nextInt();
		
		int[][] watches = new int[n][m];
		
		for (int i = 0; i < watches.length; i++) {
			for (int j = 0; j < watches[i].length; j++) {
				watches[i][j]=s.nextInt();
			}
		}
		int max=check(watches);
		int[][] watch = new int[n][m];
		
		for (int i = 0; i < watches.length; i++) {
			for (int j = 0; j < watches[i].length; j++) {
				watch[i][j]=watches[i][j];
			}
		}
		
		for (int i = 0; i < watches.length; i++) {
			for (int j = 0; j < watches[i].length; j++) {
				watch[i][j]++;
			}
			int a=check(watch);
			if(a>max){
				max=a;
			}
			for (int l = 0; l < watches.length; l++) {
				for (int j = 0; j < watches[l].length; j++) {
					watch[l][j]=watches[l][j];
				}
			}
			
			for (int j = 0; j < watches[i].length; j++) {
				watch[j][i]++;
				
			}
			a=check(watch);
			if(a>max){
				max=a;
			}
			for (int l = 0; l < watches.length; l++) {
				for (int j = 0; j < watches[l].length; j++) {
					watch[l][j]=watches[l][j];
				}
			}
			
		}
		System.out.println(max);
		
		
		}

	private static int check(int[][] watches) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < watches.length; i++) {
			for (int j = 0; j < watches[i].length; j++) {
				if(watches[i][j]==3 ||watches[i][j]==6 ||watches[i][j]==9 ||watches[i][j]==12 ){
					count++;
				}
			}
		}
		return count;
	}

	}
