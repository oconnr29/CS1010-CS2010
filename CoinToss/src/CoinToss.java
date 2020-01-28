import java.util.Random;
public class CoinToss {
	public static void main(String[] args) {
	    int count;
	    int heads = 0;
		int tails = 0;
		int toss = 0;
		Random generator = new Random();

	    for (count = 0; (count < 10000); count++)
	    {
	    	toss = generator.nextInt(2);
	    	if (toss == 0)
	    	{
	    	  tails = tails+1;
	    	}
	    	else
	    	{
	    		 heads = heads+1;
	    	}
	    }
	    String lastFlip;
	    if (toss == 0)
	    {
	    	lastFlip = "head";
	    }
	    else
	    {
	    	lastFlip = "tail";
	    }
	    System.out.println("You Got " + tails + "tails, and "+ heads + "heads. Also the last flip was " + lastFlip + "s.");   
	}

}
