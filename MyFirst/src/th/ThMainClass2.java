 
package th;
class Thread1{

	public  void display() {
		
		synchronized(this) {
		try {
			for (int i = 1; i <= 6; i++) {
				Thread.sleep(1000);
				System.out.println("i= " + i);
			}
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		}
		
		System.out.println("synchronized area");
	}
}

class Thread2 extends Thread {
	Thread1 t1;
	public Thread2(Thread1 t1){
		this.t1=t1;
	}
	
	public void run() {
		t1.display();
	}
}
public class ThMainClass2 {

	public static void main(String[] args) {
		System.out.println("Main Started");

		Thread1 t1  = new Thread1();
		Thread2 t1a = new Thread2(t1);
		Thread2 t1b = new Thread2(t1);
		
		
		t1a.start();
		t1b.start();
		System.out.println("Main Ends");
	}

}