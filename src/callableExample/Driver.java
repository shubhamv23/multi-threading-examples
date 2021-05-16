package callableExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		List<CallableTask> tasks = new ArrayList<>();
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());
		tasks.add(new CallableTask());

		List<Future<Integer>> results = executorService.invokeAll(tasks, 3, TimeUnit.SECONDS);
		for (Future<Integer> result : results) {
			try {
				System.out.println(result.get());
			} catch (ExecutionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
