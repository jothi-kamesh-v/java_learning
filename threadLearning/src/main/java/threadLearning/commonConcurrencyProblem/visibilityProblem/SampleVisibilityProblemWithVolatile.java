package threadLearning.commonConcurrencyProblem.visibilityProblem;

public class SampleVisibilityProblemWithVolatile {

	// Adding 'volatile' ensures visibility across all threads
	private volatile boolean running = true;

	void start() {
		new Thread(() -> {
			while (running) {
				// The thread will now check Main Memory every single iteration
			}
			System.out.println("Stopped!");
		}).start();
	}

	void stop() {
		running = false;
	}

	public static void main(String[] args) throws InterruptedException {
		SampleVisibilityProblemWithVolatile t = new SampleVisibilityProblemWithVolatile();
		t.start();

		Thread.sleep(100); // Wait for background thread to loop

		t.stop(); // This change is immediately visible to the background thread
	}
}
