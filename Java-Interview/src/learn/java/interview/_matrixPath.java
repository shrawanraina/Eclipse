package learn.java.interview;

/*Given a matrix 
		int mat[][] = {{5,6,1,2},
					   {8,7,8,9},
					   {6,8,3,10}};
					   Print out the longest string of integers (path) where the digits only differ
					   by 1... Eg in the  above matrix, the longest path is 5,6,7,8,9,10 which means 
					   the path to be returned are co-ordinates 
					   (0,0),(0,1),(1,1),(1,2),(1,3),(2,3)

*/

class Point{
	public int i;
	public int j;
	Point(int a, int b){
		this.i = a;
		this.j = b;
	}
}

public class _matrixPath {

	// This function prints the longest path co-ordinates... Can be stored in a data structure and returned
	public static void path(int [][]dp, int max, int i, int j){
		System.out.println("Path: "+i+" "+j);
		while(max >1 && (i>0 || j>0)){
			if(i>0 && dp[i-1][j] - dp[i][j] == -1){
				max--;
				i--;
				System.out.println("Path: "+i+" "+j);
			}else if(j>0 && dp[i][j-1] - dp[i][j] == -1){
				max--;
				j--;
				System.out.println("Path: "+i+" "+j);
			}else{
				System.out.println("Path: 0 0");
				i--;j--;max--;
			}
		}
	}
/*
 //This creates a matrix dp which is used to store the path using increments eg for above matrix, we will create a 
  * weight matrix as follows: 
  	1 2 1 2 
	1 3 4 5 
	1 4 1 6 
	The code also stores the longest weight - 6 and its co-ordinates which will be used to backtrack and recreate the path
 */
	public static int[][] path(int mat[][]){ 		
			
		int x=0; int y=0;
		
		int dp[][] = new int[mat.length][mat[0].length];

		int max = 0;
		for(int a=0; a<mat.length; a++){
			for(int b=0; b<mat[0].length; b++){
				dp[a][b] = 1;
			}
		}
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				if(i==0 && j==0)
					continue;
				if(i>0 && Math.abs(mat[i-1][j] - mat[i][j])==1){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+1);
					if(max < dp[i][j])
					{x = i; y = j;}
					max = Math.max(max, dp[i][j]);
					//System.out.println(i+" "+j);

				}
				if(j > 0 && Math.abs(mat[i][j-1] - mat[i][j]) == 1){
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
					if(max < dp[i][j])
					{x = i; y = j;}
					max = Math.max(max,  dp[i][j]);
					//System.out.println(i+" "+j);

				}				
			}
		}
		System.out.println();
		System.out.println(max);
		Point p = new Point(x,y);
		System.out.println("Ending Point: "+p.i+" "+p.j);
		//recreate_path(x,y, max,dp, k);
		path(dp,max,x,y); // send the intermediate matrix to recreate the path to location with highest weight location.
		return dp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int mat[][] = {{1,3,2,6,8},{2,4,1,-1,7},{3,5,0,1,8}};
		int mat[][] = {{5,6,1,2},
					   {8,7,8,9},
					   {6,8,3,10}};
		int dp[][] = path(mat);
		for(int i=0;i<dp.length;i++){
			for(int j=0; j<dp[0].length; j++){
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
