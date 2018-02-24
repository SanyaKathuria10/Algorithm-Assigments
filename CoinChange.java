//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class CoinChange{

public static int NumberofCoins(int[] denomination,int value){
		 //Write your code here to find out minimum number of coins required to provide the change for given value.
         int MinNumberOfCoins[][]=new int[denomination.length][value+1];
		 for(int i=0;i<denomination.length;i++)
			{ for(int j=1;j<=value;j++)
				{
				if(i==0)
					 MinNumberOfCoins[i][j]=j;
				 else if(j>=denomination[i])
					 MinNumberOfCoins[i][j]=Math.min(MinNumberOfCoins[i-1][j], 1+MinNumberOfCoins[i][j-denomination[i]]);
				 else
					 MinNumberOfCoins[i][j]=MinNumberOfCoins[i-1][j];
				}
					 
			}
		 //This method will have a denomination array and an int which specifies the value as inputs(Please see testcase file)
		 //This method should return the number of coins
        return MinNumberOfCoins[denomination.length-1][value];
	}

}
