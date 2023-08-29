package com.testngtask;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Order {
	@Test(priority=0)
	public static void launch3() {
		System.out.println("c");
	}
	@Test(priority=1)
	public static void launch4() {
		System.out.println("d");
	}
	@Test
	public static void launch5() {
		System.out.println("e");
	}
	@BeforeTest()
	public static void launch1() {
		System.out.println("a");
	}
	@BeforeClass()
	public static void launch2() {
		System.out.println("b");
	}
	

}
