package threadExample;

import java.util.Hashtable;

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		TaskThread task1 = new TaskThread(1, hashtable);
		TaskThread task2 = new TaskThread(2, hashtable);
		TaskThread task3 = new TaskThread(3, hashtable);
		TaskThread task4 = new TaskThread(4, hashtable);
		TaskThread task5 = new TaskThread(5, hashtable);

		task1.start();
		task2.start();
		task3.start();
		task4.start();
		task5.start();

		task5.join();
		task4.join();
		task3.join();
		task2.join();
		task1.join();

		hashtable.entrySet()
				.stream()
				.map(entry -> entry.getKey() + " " + entry.getValue())
				.forEach(System.out::println);

	}
}
