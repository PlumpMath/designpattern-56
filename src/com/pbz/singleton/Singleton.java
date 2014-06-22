package com.pbz.singleton;

/**
 * 单例模式：确保一个类只有一个实例，并提供一个全局访问点
 * 应用场景：线程池、缓存、日志对象等。这些类对象只有一个实例，如果制造出多个会产生很多问题，例如：
 * 		程序异常、资源使用过量、或者结果不一致的结果
 * 实现：通过两种实现方式
 *
 */
public class Singleton {

	
	
	/*
	 * 第一种
	 * 如果应用程序总是创建并使用单件实例，或者在创建和运行时方面负担不重。
	 * 依赖jvm在加载这个类时马上创建此唯一的单例。jvm保证在任何线程访问uniqueInstance静态变量之前，一定先创建此实例
	 */

	//在静态初始化器中创建单例保证了线程安全
	private static Singleton uniqueInstance = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		
		return uniqueInstance;
	}

	
	/*
	 * 第二种
	 * 双重检查加锁，首先检查实例是否已经创建，如果尚未创建，才进行同步。
	 * 
	 */
	/*
	//volatile 保证当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地处理
	private volatile static Singleton uniqueInstance;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(uniqueInstance==null){
			synchronized (Singleton.class) {
				if(uniqueInstance==null){
					uniqueInstance = new Singleton();
				}
			}
		}
		
		return uniqueInstance;
	}
	*/
}
