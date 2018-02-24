 public class h3p2_memoized_skathur2{  
  private static int counter=0;
  public static int m [][];
public static void main(String[] args)
{  
    //int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224};
	//int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12};
	int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12,10,24,5,13};
	long startTime = System.nanoTime();    
    int m = MemoizedMatrixChain(p); 
    long estimatedTime = System.nanoTime() - startTime;
	System.out.println("EstimatedTime:"+ " "+estimatedTime+ " " + "nanosecs.");
	System.out.println("Number of multiplications: "+ " "+m);
	System.out.println("Number of Recurssive calls:"+ " "+counter);
}	
 public static int MemoizedMatrixChain(int[] p)
  {
    int n = p.length-1;
    int m [][]= new int[n+1][n+1];
    for (int i=0; i<=n; i++)
    { for (int j=i; j<=n; j++)
    {
      m[i] [j] = Integer.MAX_VALUE;
    }
    }
    return LookupChain(m , p, 1, n);
  }

    public static int LookupChain(int[] [] m,int[] p, int i, int j)
  { 
    if (m[i] [j] < Integer.MAX_VALUE) 
    {
    return m[i] [j];
    }
    if (i == j)
	{
	m[i] [j] = 0;
	}
    else
    {
      for (int k=i; k<j; k++)
      { 
        int q = LookupChain(m, p, i, k) + LookupChain(m, p, k+1, j) + p[i-1]*p[k]*p[j];
        counter=counter+1;
        if (q <  m[i][j])
          m[i] [j] = q;
      }
    }
    return  (m[i][j]);
  }
}