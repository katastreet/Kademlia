package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import kademlia.JKademliaNode;
import kademlia.KademliaNode;
import kademlia.dht.GetParameter;
import kademlia.dht.JKademliaStorageEntry;
import kademlia.dht.KadContent;
import kademlia.dht.KademliaStorageEntry;
import kademlia.exceptions.ContentNotFoundException;
import kademlia.node.KademliaId;
import kademlia.simulations.DHTContentImpl;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello world");
		try {
			JKademliaNode kad1 = new JKademliaNode("Satyarth", new KademliaId("ASF45678947584567463"), 8080);
			DHTContentImpl c = new DHTContentImpl(kad1.getOwnerId(), "My data");
	        kad1.put(c);
			try {
				/* Create a GetParameter object with the parameters of the content to retrieve */
				 GetParameter gp = new GetParameter(c.getKey(), DHTContentImpl.TYPE);

				try {
					gp.setOwnerId(c.getOwnerId());
					KademliaStorageEntry conte = kad1.get(gp);
					System.out.println("Content Found: " + new DHTContentImpl().fromSerializedForm(conte.getContent()));
		            System.out.println("Content Metadata: " + conte.getContentMetadata());
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ContentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
