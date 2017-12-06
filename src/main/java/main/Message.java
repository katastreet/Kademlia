package main;

import java.io.IOException;

import kademlia.JKademliaNode;
import kademlia.message.SimpleMessage;
import kademlia.message.SimpleReceiver;
import kademlia.node.KademliaId;

public class Message {
	  public static void main(String[] args)
	    {
	        try
	        {
	            JKademliaNode kad1 = new JKademliaNode("Joshua", new KademliaId("12345678901234567890"), 7574);
	            JKademliaNode kad2 = new JKademliaNode("Crystal", new KademliaId("12345678901234567891"), 7572);

	            kad1.getServer().sendMessage(kad2.getNode(), new SimpleMessage("Some Message"), new SimpleReceiver());
	            kad1.getServer().printReceivers();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	    }

}
