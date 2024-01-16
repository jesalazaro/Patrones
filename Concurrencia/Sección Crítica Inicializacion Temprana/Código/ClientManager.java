//package CriticalSection;

public class ClientManager {

	public static void main(String[] args) {

		FileProcess proceso1 = new FileProcess("Thread 1 is wrtting");
		proceso1.start();
		FileProcess proceso2 = new FileProcess("Thread 2 is writting");
		proceso2.start();
		FileProcess proceso3 = new FileProcess("Thread 3 is wrtting");
		proceso3.start();
		FileProcess proceso4 = new FileProcess("Thread 4 is writting");
		proceso4.start();
	}
}

class FileProcess extends Thread {
	private String msgLog;

	public FileProcess(String msg) {
		this.msgLog = msg;
	}

	@Override
	public void run() {

		long t1r = 0, t2r = 0, t1f = 0, t2f = 0;

		t1r = System.nanoTime();
		Logger fileLogger = FileLogger.getFileLogger();
		t2r = System.nanoTime();
		System.out.println("Obtener registrador: " + (t2r - t1r));



		for (int i = 0; i < 100; i++) {
			t1f = System.nanoTime();
			fileLogger.log(msgLog);
			t2f = System.nanoTime();
			System.out.println("Escribir archivo: " + (t2f - t1f));
		}
	}
}
