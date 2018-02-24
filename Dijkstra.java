public class Dijkstra {
    private static int d[]=null;
     private static int usp[]=null;
     private static  int pi[]=null;
	     
    public static int [][] Dijkstra_alg( int n, int e, int mat[][], int s)
	    {
	    	 //Write your code here to calculate shortest paths and usp values from source to all vertices
			 //This method will have four inputs (Please see testcase file)
			 //This method should return a two dimensional array as output (Please see testcase file) 
			 d=new int[n+1];
			 usp=new int[n+1];
			 pi=new int[n+1];
			 for (int i=1; i<=n; i++)
			 {
			 d[i]=Integer.MAX_VALUE;
			 pi[i]=-1;
			 usp[i]=0;
			 
			 
			 }
			 d[s]=0;
			 usp[s]=1;
			int Sarray[]=new int[n+1];
			boolean dq[]=new boolean[n+1];
			int i=1;
			for(int count=1;count<=n; count++)
			{
				int u=extractMinimum(d,dq);
			
				dq[u]=true;
			Sarray[i]=u;
			i=i+1;
			for( int j=0; j<mat.length;j++)
			{
			
				
				if(mat[j][1]==u)
				{	if(!containInG(mat[j][0],Sarray))
					{ 
					Relax(u,mat[j][0],mat[j][2]);
					}
				}else if (mat[j][0]==u)
				{	if(!containInG(mat[j][1],Sarray))
					{
					Relax(u,mat[j][1],mat[j][2]);
					}
				}
			}
			
			
		}
		int print[][]=new int [n][2];
		for(int j=0;j<n;j++)
		{   print[j][0]=d[j+1];
		    print[j][1]=usp[j+1];
			int l=j+1;
		    System.out.println(" Shortest path weight from source to vertex "+ l + " "+"is" + " "+ d[j+1]);
		    System.out.println(" usp is "+ usp[j+1]);
		}
		return print;
		}
		
		public static void Relax( int u,  int v ,int wuv)
     	{
		if( d[u] + wuv < d[v]){
			d[v]= d[u] +wuv;
			pi[v]=u;
			usp[v]=usp[u];
		
		}
	   else if(d[u] + wuv == d[v])
	   {
	   usp[v]=0;
	   }	   	   
       }
	   
		 private static int extractMinimum(int dist[], boolean dq[])
    {    
       int minimum = Integer.MAX_VALUE, index=-1;
 
        for (int i = 1; i < dist.length; i++)
            if (dq[i] == false && dist[i] <= minimum)
            {
                minimum = dist[i];
                index = i;
            }
        return index;
    }
 
		
	 private static boolean containInG( int x, int[] a) {

        boolean output = false;

        for(int i : a){
            if(i == x){
                output = true;
                break;
            }
        }

        return output;
    }
	
	
	    
	    
	    
}