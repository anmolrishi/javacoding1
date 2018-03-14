package Dp;

public class WorldSeries {

	public static double R(double p,int i, int j) {
		if(i==0){
			return 1;
		}
		else if(j==0){
			return 0;
		}
		else{
			return p*R(p,i-1,j) + (1-p)*R(p, i, j-1);
		}
	}
	
	public static double dp(double p, int i, int j) {
		double q=1-p;
		double[][] P = new double[i+1][j+1];
		
		
		for (int k = 0; k < P.length; k++) {
			P[k][0]=0;
		}
		for (int k = 0; k < P[0].length; k++) {
			P[0][k]=1;
		}
		
		for (int k = 1; k < P.length; k++) {
			for (int k2 = 1; k2 < P[k].length; k2++) {
				P[k][k2] = p*P[k-1][k2] + q*P[k][k2-1];
			}
		}
		
		
		return P[i][j];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(dp(3, 20, 20));
		System.out.println(R(0.2, 20, 20));
		
	}

}
