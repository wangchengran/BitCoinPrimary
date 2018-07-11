package com.zhuo.service;

import java.io.File;
import java.util.List;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.wallet.Wallet;
import org.springframework.stereotype.Service;

@Service
public class CreateWalletService {
	
	public static void main(String[] args) {
		new CreateWalletService().createWallet();
	}
	
	@SuppressWarnings("deprecation")
	public void createWallet(){
		final NetworkParameters networkParameters = NetworkParameters.testNet();
		final File file = new File("test.wallet");
		Wallet wallet = null;
		try{
			wallet = new Wallet(networkParameters);
			for(int i = 0;i<5;i++){
				wallet.importKey(new ECKey());
			}
			wallet.saveToFile(file);
		}catch(Exception e){
			System.out.println("Unable to create wallet file.");
		}
		System.out.println();
//		ECKey firstKey = wallet.
		List<ECKey> keys = wallet.getImportedKeys();
		System.out.println(keys);
		System.out.println();
		
		ECKey firstKey = keys.get(0);
		System.out.println("First key in the wallet:"+firstKey);
		System.out.println("Complete content of the wallet:"+wallet);
		
		if(wallet.isPubKeyHashMine(firstKey.getPubKeyHash())){
			System.out.println("Yep,that is my key.");
		}else{
			System.out.println("No,that key didn't come from this wallet.");
		}
		
	}
	
}
//	
//	16:06:02.693 [main] WARN org.bitcoinj.core.Context - Implicitly creating context. This is a migration step and this message will eventually go away.
//	16:06:02.707 [main] INFO org.bitcoinj.core.Context - Creating bitcoinj 0.14.7 context.
//	16:06:08.813 [main] INFO org.bitcoinj.crypto.MnemonicCode - PBKDF2 took 5.642 s
//	16:06:08.947 [main] INFO org.bitcoinj.wallet.KeyChainGroup - Creating and activating a new HD chain: org.bitcoinj.wallet.DeterministicKeyChain@32a19277
//	
//	[ECKey{pub HEX=033e0bd017df576adea4ad2c72365081082930ace584e22b65b8f3fd0ac647692e, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}, ECKey{pub HEX=02cfed72718ebe7ced3a891d5ed31ab650e39b95d5259698b129442127acdf64cf, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}, ECKey{pub HEX=03e8b716eb7440f72322afbe23df56567203b193473e9c8b8f29f844e7fa9c802f, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}, ECKey{pub HEX=03506c5ff8a31ec7932ecab30b529053f885e8c79e67a349506f9b11a0580827bb, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}, ECKey{pub HEX=033423e012e94d881ffdeffc300412c753435e861fb2d7d28be2f614594f7d1248, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}]
//	
//	First key in the wallet:ECKey{pub HEX=033e0bd017df576adea4ad2c72365081082930ace584e22b65b8f3fd0ac647692e, creationTimeSeconds=1531209968, isEncrypted=false, isPubKeyOnly=false}
//	Complete content of the wallet:Wallet containing 0.00 BTC (spendable: 0.00 BTC) in:
//	  0 pending transactions
//	  0 unspent transactions
//	  0 spent transactions
//	  0 dead transactions
//	Last seen best block: 0 (time unknown): null
//	
//	Keys:
//	Earliest creation time: 2018-07-10T08:06:03Z
//	  addr:mpc5CSXRbkpVywaCF2UgrhYtP5wtPSV5aW  hash160:63b0f97120c0c1a84ebe4729357da5257fb9e4ff  creationTimeSeconds:1531209968
//	  addr:myysbh9ARqojFskjxrMLJwJbt319Sm5RAq  hash160:ca89933d27a1abd95f5457cfb232ee811e77b43a  creationTimeSeconds:1531209968
//	  addr:mzP83rrEL2dnM3U4CuUAAq8bF71UGFkysX  hash160:ceef349b58184d2bc28ff6d6e35ebe32d3ec5a45  creationTimeSeconds:1531209968
//	  addr:mnLKsKobnCXqpuNvURE61hvJQgGGao4KZs  hash160:4ac6504cda751f4856f98beb029d937748fe734f  creationTimeSeconds:1531209968
//	  addr:mxPvbymVvwCAFMRST8qhQTJq3ExNg7UmDN  hash160:b925d0a83a2324c821843a3945c658aa2da53e8f  creationTimeSeconds:1531209968
//	Seed birthday: 1531209963  [2018-07-10T08:06:03Z]
//	Key to watch:  tpubD9fDQi57Nuiic8rn3WhfdPF7UTh3ZXgFjgMdTs32JozYN4awuGcTvFFjaqXtdrKbkFWfEa2RRQLWd27U4nVtXQmcipentWCBU3HqbWbEj4k
//	
//	
//	Yep,that is my key.




