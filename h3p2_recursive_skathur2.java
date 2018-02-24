//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class h3p2_recursive_skathur2{ 
  private static int counter=0;
 
public static void main(String[] args)
{  
    //int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224};
	//int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12};
	int[] p={5, 2, 4, 7, 10, 9, 8, 17, 224, 10, 14, 500, 12,10,24,5,13};
	long startTime = System.nanoTime();    
    int m = RecurssiveMatrixChain(p,1,p.length-1); 
    long estimatedTime = System.nanoTime() - startTime;
	System.out.println("Estimated Time:"+ " "+estimatedTime +" "+"nanosecs.");
	System.out.println("Number of scalar multiplications: "+ " "+m);
	System.out.println("Number of Recurssive calls:"+ " "+counter);
}	
public static int RecurssiveMatrixChain(int[] p, int i, int j)
  { counter=counter+1;
    if (i == j) return(0);
    int m= Integer.MAX_VALUE;
    for (int k=i; k<j; k++)
    {
      int q = RecurssiveMatrixChain(p, i, k) + RecurssiveMatrixChain(p, k+1, j) + p[i-1]*p[k]*p[j];
      if (q < m)
        m = q;
	    
    }
    return m;
  }
}