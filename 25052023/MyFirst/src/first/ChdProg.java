package first;

class MyFirst {
	static int y;
	int z=90;
	
	public void display() {
		int x=89;
		System.out.println(" First class method 1 - "+x);
	}

	public void display1() {
		int x=89;
		System.out.println(" First class method 2 - "+x);
	}

	
}

class MySecond {
	static int y;
	int z=200;
	
	public void display() {
		int x=289;
		System.out.println(" Second class method 1 - "+x);
	}

	public void display1() {
		int x=289;
		System.out.println(" Second class method 2 - "+x);
	}

}

public class ChdProg{
	
	public static void main(String[] args) {
		int x=190;
	 
		MyFirst mf = new MyFirst();
		System.out.println("First class instance one - " + mf.z);
		mf.display();		
		mf.display1();
		
		
		MyFirst mf1 = new MyFirst();
		System.out.println("First class instance two - " + mf1.z);
		mf1.display();
		
		
		MySecond ms = new MySecond();
		
		System.out.println("Second class instance one - " + ms.z);
		ms.display();
		ms.display1();
		
		
		
		
	}	
}