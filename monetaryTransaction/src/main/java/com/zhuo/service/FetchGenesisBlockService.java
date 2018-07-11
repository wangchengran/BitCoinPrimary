package com.zhuo.service;

import java.net.InetAddress;

import org.bitcoinj.core.BlockChain;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Peer;
import org.bitcoinj.core.PeerAddress;
import org.bitcoinj.store.BlockStore;
import org.bitcoinj.store.MemoryBlockStore;
import org.springframework.stereotype.Service;

@Service
public class FetchGenesisBlockService {

	public static void main(String[] args) {
		
	}
	
	public void fetchGenesisBlock(){
		final NetworkParameters networkParameters = NetworkParameters.testNet();
		
		BlockStore blockStore = new MemoryBlockStore(networkParameters);
		
		BlockChain chain;
		
		try{
			chain = new BlockChain(networkParameters,blockStore);
			final Peer peer = new Peer(networkParameters,null, new PeerAddress(InetAddress.getLocalHost()),chain);
			peer.connectionOpened();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
//					try{
//						peer.
//					}catch()
				}
			}).start();;
		}catch(Exception e){
			
		}
		
	}
}
