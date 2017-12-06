package main;

import java.io.IOException;
import java.net.InetAddress;


import kademlia.JKademliaNode;
import kademlia.message.SimpleMessage;
import kademlia.message.SimpleReceiver;
import kademlia.node.KademliaId;
import kademlia.node.Node;

public class ConnectorNode {
	public static void main(String[] args) throws IOException {
		JKademliaNode kad2 = new JKademliaNode("Satyarth", new KademliaId(), 8085);
//		System.out.println(kad2.getNode().getSocketAddress().getAddress().getHostAddress());
		
		try {
		//finding the bootstrap node
		InetAddress hostIp = InetAddress.getByName("127.0.0.1");
		KademliaId hostId = new KademliaId("ASF45678947584567467");
		
		// bootstrap node is
 		Node kad1 =  new Node(hostId, hostIp, 8080);
 		kad2.bootstrap(kad1);
 		kad2.getServer().sendMessage(kad1, new SimpleMessage("i want to connect"), new SimpleReceiver());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Boostrap node didn't respond");
		}
 		
		
		
	}

}
