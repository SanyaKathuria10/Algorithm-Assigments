public class h3p2_dp_skathur2{
  public static int[][] m;        
  public static int[][] s;         
 
public static void main(String[] args)
{  
    int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224};
	//int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12};
	//int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12,10,24,5,13};
    int n = p.length-1;  
    m= new int[n+1][n+1]; 
    s= new int[n+1][n+1];
    long startTime = System.nanoTime();   
    for(int l=2; l<=n; l++)
    {
      for (int i=1; i<=n-l+1; i++)
      {
        int j=i+l-1;  
        m[i][j] = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++)
        { 
          int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
          if (q < m[i][j])
          {
            m[i][j] = q;
            s[i][j] = k;
          }
        }
      }
    }
    
    long estimatedTime = System.nanoTime() - startTime;
    System.out.println("Estimated Time:"+ " "+estimatedTime +" "+"nanosecs.");
	System.out.println("Number of scalar multiplications: "+ " "+m[1][n]);
    System.out.println("Number of multiplications matrix :");
    printarray(m,n);
    System.out.println("Parenthization matrix :");
    printarray(s,n);
    System.out.println("Order of matrix is given by :");
    MatrixParenthesisOrder(s,1,n);
    System.out.println();
}
public static void printarray(int[][] s, int n) 
{
for(int i=1; i<=n; i++)
    {
	for(int j=0; j<=n; j++)
        {
        System.out.print(" " + s[i][j]);
	    }
	System.out.println();
    }
}	
public static void MatrixParenthesisOrder(int[][] s, int i, int j)
{
    if (i == j) 
    System.out.print("A" + i);
    else
    {
      System.out.print("(");
      MatrixParenthesisOrder(s, i, s[i][j]);
      MatrixParenthesisOrder(s, s[i][j]+1, j);
      System.out.print(")");
}
}
}

