import java.math.BigInteger;
import java.util.ArrayList;

public class ThreadTest {

	public static void main(String[] args) {
		double startTime=System.currentTimeMillis();
		ArrayList<BigInteger> list1=new ArrayList<BigInteger>();
		ArrayList<BigInteger> list2=new ArrayList<BigInteger>();
		
		BigInteger bi=BigInteger.valueOf(2);
		BigInteger bi2=BigInteger.valueOf(2);
		list1.add(bi);
		list2.add(bi2);
		Runnable r1 = new Runnable() {
			  public void run() {
				  
				  for(int j=0; j<1000; j++)
			    	  list1.set(0, list1.get(0).add(list1.get(0)));
			      
			  }
			};
			
		for(int g=0; g<20;g++)
		{
			new Thread(r1).start();
		}
		System.out.println("Time threaded: "+(System.currentTimeMillis()-startTime));
		
		startTime=System.currentTimeMillis();
		for(int g=0; g<20;g++)
		{
			
			for(int j=0; j<1000; j++)
			list2.set(0, list2.get(0).add(list2.get(0)));
		}
		System.out.println("Time single thread: "+(System.currentTimeMillis()-startTime));
		
		System.out.println(list2.get(0).toString());
		System.out.println(list2.get(0).toString());
		
	}

}
