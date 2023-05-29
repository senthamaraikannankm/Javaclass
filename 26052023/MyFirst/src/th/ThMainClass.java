package th;


class ThreadA implements Runnable {

	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {

				Thread.sleep(1000);

				System.out.println("i= " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThMainClass {

	public static void main(String[] args) {
		System.out.println("Main Started");

		ThreadA ta = new ThreadA();
		Thread t = new Thread(ta);
		t.start();
		System.out.println("Main Ends");
	}

}