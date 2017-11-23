package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import kademlia.JKademliaNode;
import kademlia.KademliaNode;
import kademlia.dht.GetParameter;
import kademlia.dht.JKademliaStorageEntry;
import kademlia.exceptions.ContentNotFoundException;
import kademlia.node.KademliaId;
import kademlia.simulations.DHTContentImpl;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("retrieving node data");
		
			try {
				JKademliaNode kad1 = JKademliaNode.loadFromFile("Satyarth");
				/* Create a GetParameter object with the parameters of the content to retrieve */
				GetParameter gp = new GetParameter(kad1.getNode().getNodeId(),kad1.getOwnerId());   // Lets look for content by key        // And content from this owner
		
				/* Now we call get specifying the GetParameters and the Number of results we want */
				JKademliaStorageEntry storageEntry;
				
				try {
					storageEntry = kad1.get(gp);
					System.out.println(new String(storageEntry.getContent()));
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ContentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
