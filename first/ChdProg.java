package first;

class MyFirst {
	static int y;
	int z=90;
	
	public void display() {
		int x=89;
		System.out.println("Welcome"+x);
	}

}


public class ChdProg{
	
	public static void main(String[] args) {
		int x=89;
		System.out.println("Hello World");
		System.out.println("Hello World" + x);
		MyFirst mf = new MyFirst();
		System.out.println("Hello World" + mf.z);
		mf.display();
	}	
}