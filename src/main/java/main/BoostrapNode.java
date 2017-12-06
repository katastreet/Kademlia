package main;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;


import kademlia.JKademliaNode;
import kademlia.node.KademliaId;
import kademlia.node.Node;

public class BoostrapNode {
	public static void main(String[] args) throws IOException, InterruptedException {
		JKademliaNode kad1 = new JKademliaNode("Ram", new KademliaId("ASF45678947584567467"), 8080);
		System.out.println("Created Node Kad 1: " + new String(kad1.getNode().getNodeId().getBytes()));
		
		while(true) {
			List<Node> nodes = kad1.getRoutingTable().getAllNodes();
			if(nodes.size() > 1)
			{
				for (Node n: nodes) {
					if(!n.equals(kad1.getNode())) {
						System.out.println("new nodes connected");
						System.out.println(n.getSocketAddress().getAddress().getHostAddress() + "port:" + n.getSocketAddress().getPort());
					}}
				
				System.out.println("total no of nodes:" + nodes.size());
			}
			
			Thread.sleep(5000);
		}
//		
		
	}


}
