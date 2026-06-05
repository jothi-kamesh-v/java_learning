package threadLearning.commonConcurrencyProblem.visibilityProblem;

public class SampleVisibilityProblemWithSynchronized {

	private boolean running = true;

	// 1. Synchronized Write
	synchronized void stop() {
		running = false;
	}

	// 2. Synchronized Read
	synchronized boolean isRunning() {
		return running;
	}

	void start() {
		new Thread(() -> {
			// The loop now calls the synchronized method
			while (isRunning()) {
				// Wait...
			}
			System.out.println("Stopped!");
		}).start();
	}

	public static void main(String[] args) throws InterruptedException {
		SampleVisibilityProblemWithSynchronized t = new SampleVisibilityProblemWithSynchronized();
		t.start();

		// Short pause before stopping
		Thread.sleep(100);

		// Thread may not see this without volatile
		t.stop();
	}
}
