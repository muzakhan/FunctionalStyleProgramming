package org.java.sample;

import lombok.AllArgsConstructor;

public class Test {

	public static void main(String[] args) {
		Printer p = new Printer();

		Thread even = new Thread(new EvenOddTask(p, true, 10));
		Thread odd = new Thread(new EvenOddTask(p, false, 10));
		even.start();
		odd.start();

	}
}

@AllArgsConstructor
class EvenOddTask implements Runnable {

	Printer printer;
	boolean isEvenNumber;
	int max;

	@Override
	public void run() {

		int number = isEvenNumber ? 2 : 1;
		while (number <= max) {
			if (isEvenNumber) {
				printer.printEven(number);
			} else {
				printer.printOdd(number);
			}
			number += 2;
		}

	}
}

class Printer {

	private volatile boolean isOdd;

	public synchronized void printEven(int number) {
		while (!isOdd) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(number);
		isOdd = false;
		this.notify();

	}

	public synchronized void printOdd(int number) {
		while (isOdd) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(number);
		isOdd = true;
		this.notify();
	}
}
