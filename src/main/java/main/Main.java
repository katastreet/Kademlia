package main;

import java.io.IOException;

import kademlia.JKademliaNode;
import kademlia.KademliaNode;
import kademlia.node.KademliaId;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello world");
		try {
			KademliaNode kad1 = new JKademliaNode("OwnerName1", new KademliaId("ASF45678947584567463"), 12049);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
