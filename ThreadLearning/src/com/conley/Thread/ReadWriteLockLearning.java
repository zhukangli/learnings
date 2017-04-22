package com.conley.Thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockLearning {
	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	private static int i = 0;
	public static void main(String[] args) {
		new Thread(
				new Runnable() {
					public void run() {
						for(int j=0;j<10;j++){
							i++;
							System.out.println(i);
							try {
								Thread.sleep(new Random().nextInt() * 1000);
							} catch (InterruptedException e) {

								e.printStackTrace();
							}
						}
					}
				}).start();

		new Thread(
				new Runnable() {
					public void run() {
						for(int j=0;j<10;j++){
							i--;
							System.out.println(i);
							try {
								Thread.sleep(new Random().nextInt() * 1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

				}).start();
	}




}
