package threadExample;

import java.util.Hashtable;
import java.util.Random;

public class TaskThread extends Thread {
	private int id;
	private Hashtable<Integer, Integer> hashtable;

	public TaskThread(int id, Hashtable<Integer, Integer> hashtable) {
		this.id = id;
		this.hashtable = hashtable;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hashtable.put(id, new Random().nextInt(1000));
	}
}
