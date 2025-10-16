package network_Programming_ReverseEchoServer;
import java.util.*; 
import java.io.*;
import java.net.*;

/*We can access Start the server side program using the command Package name followed by class name with java to run
 * "java network_Programming_ReverseEchoServer.ReverseEchoServer"
 * and run client on differet command window
 */
public class ReverseEchoServer {
	
	public static void main(String[] args) throws Exception
	{
		//Creating a ServerSocket To Connect with Client
		ServerSocket ss=new ServerSocket(44444);
		
		//The Connection requst from the client is accpeted and stored it as a reference in variable
		Socket stk=ss.accept();
		
		//Geting input from the client using socket
		BufferedReader bfs=new BufferedReader(new InputStreamReader(stk.getInputStream()));
		
		//Connnecting to the PrintStream of Client
		PrintStream ps=new PrintStream(stk.getOutputStream());
		
		String msg;
		
		//Creating StringBuilder Because it has Reverse method already, instead of writing tha whole code 
		StringBuilder sb;
		
		do {
			
			//reading the input from client
			msg=bfs.readLine();
			
			//created a Object for StringBuilder Assgining msg to it
			sb=new StringBuilder(msg);
			sb.reverse();//Reversing the msg
			
			//Converting the msg into String Again(What type it is initially before making it string when it is reversed)
			msg=sb.toString();
			
			//Sending back it to Client
			ps.println(msg);
			
		}while(!msg.equals("dne"));//looping until the MSG is END
	}
}

/* we access the client side program using the command package name followed by class name with java to run 
 * "java network_Programming_ReverseEchoServer.client"
 */
class client 
{
	public static void main(String[] args) throws Exception
	{
		
	//Creating a socket for Connecting with server with current ip adrress as "localhost"
	Socket ss=new Socket("localhost",44444);
	
	//Reading input from Keyboard that is from "System"
	BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
	
	//Reading input from Socket about localhost and Port Number
	BufferedReader bfs=new BufferedReader(new InputStreamReader(ss.getInputStream()));
	
	/*Creating a print stream so that Information/Data can be trasnsferred as a stream between client and server or 
	 * Network Sockets
	 */
	PrintStream ps=new PrintStream(ss.getOutputStream());
	

	String msg;
	do {
		
		//reading the line from system
		msg=kb.readLine();
		
		//Straming it to Server
		ps.println(msg);
		
		//Reading the Returnred MSG from server
		msg=bfs.readLine();
		
		//Printing on Screen
		System.out.println("Msg Is "+msg);
		
	}while(!msg.equals("dne"));// Continue loop until the msg in END
	
}
}
