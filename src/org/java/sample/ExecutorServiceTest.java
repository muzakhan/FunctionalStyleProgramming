package org.java.sample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	
	public static void main(String[] args) {
	    String[] s=new String[1];
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		Future<String[]> future =  executorService.submit(new Runnable() {
		    public void run() {
		    	System.out.println(Thread.currentThread());
		        System.out.println("Asynchronous task");
		        s[0]="Our Task gets completed successfully";
		    }
		},s);

		try {
			System.out.println(s[0]);
			System.out.println(Thread.currentThread());
			System.out.println(future.get()[0]);
			executorService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
