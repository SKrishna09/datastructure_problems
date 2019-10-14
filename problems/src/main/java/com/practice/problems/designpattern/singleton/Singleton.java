package com.practice.problems.designpattern.singleton;

public class Singleton {

	/* Singleton. Ensures only one instance of an object is created. */

	private static Singleton singleton = null;

	private Singleton() {

	}

	/*
	 * Note that the constructor of the Singleton class is made private, to
	 * make sure that there is no other way to instantiate the class. This example
	 * is known as lazy initialization – which means that it restricts the creation
	 * of the instance until it is requested for the first time.
	 */
	public static Singleton getInstance() {
		if (null == singleton)
			singleton = new Singleton();
		return singleton;
	}

	/*
	 * If we have two threads, and both of them call the getInstance() method, it is
	 * possible that two individual objects of the same class get created, due to
	 * different times of accessing the (instance==null) check. This is why we need
	 * to modify our implementation to make it thread-safe, and the simplest way of
	 * achieving this is by making the getInstance() class synchronized. This will
	 * make it impossible for one thread to access the method if another thread
	 * hasn’t finished with its execution.
	 */
	public static synchronized Singleton getInstanceSync() {
		if (null == singleton)
			singleton = new Singleton();
		return singleton;
	}

}
