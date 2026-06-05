package threadLearning.commonConcurrencyProblem.visibilityProblem;

public class SampleVisibilityProblem {

	// Thread-unsafe
	private boolean running = true;

	void start() {
		new Thread(() -> {
			while (running) {
			}
			System.out.println("Stopped!");
		}).start();
	}

	// Change may not be visible to other thread
	void stop() {
		running = false;
	}

	public static void main(String[] args) throws InterruptedException {
		SampleVisibilityProblem t = new SampleVisibilityProblem();
		t.start();

		// Short pause before stopping
		Thread.sleep(100);

		// Thread may not see this without volatile
		t.stop();
	}
}
