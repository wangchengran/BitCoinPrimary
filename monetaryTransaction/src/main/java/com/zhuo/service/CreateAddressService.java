package com.zhuo.service;


import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressService {

	public static void main(String[] args) {
		System.out.println(new CreateAddressService().createAddress());
	}
	
	public String createAddress(){
		String net = "test";
		ECKey key = new ECKey();
		
		System.out.println("新创建key:"+key);
		
		final NetworkParameters networkParameters;
		if(net.equals("")){
			networkParameters = NetworkParameters.prodNet();
		}else{
			networkParameters = NetworkParameters.testNet();
		}
		
		Address address = key.toAddress(networkParameters);
		System.out.println("On the " + net + " network, we can use this address:\n" + address);
		return address.toString();
	}
//	新创建key:ECKey{pub HEX=0382e364f30e7848132e36341ae7e98af6c1da588fc4ec1b600d47ca297d52b3f6, creationTimeSeconds=1531207401, isEncrypted=false, isPubKeyOnly=false}
//	On the test network, we can use this address:
//	mjjhmSQuTYQT7RiNMgCjF42HMc5CNvwhox
//	mjjhmSQuTYQT7RiNMgCjF42HMc5CNvwhox
}
