public class MatrixClass{
  public static int[][] m;        
  public static int[][] s;         
  private static int counter=0;
 
public static void main(String[] args)
{  
    int p[]={5, 2, 4, 7};
    int n = p.length-1;  
    m= new int[n+1][n+1]; 
    s= new int[n+1][n+1];
    
    for(int l=2; l<=n; l++)
    {
      for (int i=1; i<=n-l+1; i++)
      {
        int j=i+l-1;  
        m[i][j] = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++)
        { 
          counter=counter+1;
          int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
          if (q < m[i][j])
          {
            m[i][j] = q;
            s[i][j] = k;
          }
        }
      }
    }
    long startTime = System.nanoTime();    
    long estimatedTime = System.nanoTime() - startTime;
    System.out.println("Estimated Time:"+ " "+estimatedTime +" "+"nanosecs.");
	System.out.println("Number of scalar multiplications: "+ " "+m[1][n]);
    System.out.println("Number of multiplications matrix :");
    printarray(m,n);
    System.out.println("Parenthization matrix :");
    printarray(s,n);
    System.out.println("Order of matrix is given by :");
    MCM(s,1,n);
    System.out.println();
    System.out.println("Number of Recurssive calls:"+ " "+counter);
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
public static void MCM(int[][] s, int i, int j)
{
    if (i == j) 
    System.out.print("A" + i);
    else
    {
      System.out.print("(");
      MCM(s, i, s[i][j]);
      MCM(s, s[i][j]+1, j);
      System.out.print(")");
}
}
}

