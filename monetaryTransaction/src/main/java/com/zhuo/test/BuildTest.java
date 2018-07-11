package com.zhuo.test;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.TestNet3Params;

public class BuildTest {
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){
		NetworkParameters netParameters;
		netParameters = TestNet3Params.get();
		System.out.println(netParameters);
	}
}
