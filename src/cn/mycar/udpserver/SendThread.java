package cn.mycar.udpserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

//发送消息线程
public class SendThread  extends Thread{

	//UDPIp
	private String ServerIp="115.29.240.46";

	//端口
	private int port=6000;

	private  DatagramSocket socket;

	public SendThread(DatagramSocket socket) {
		this.socket=socket;
	}

	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		sendExecute(socket, ServerIp, port);

	}
	public static void sendExecute( DatagramSocket socket,String ServerIp,int port) {
		try {
			while(true) {
				Scanner jp=new Scanner(System.in);
				String str=jp.nextLine();
				if(null!=str) {
					DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName(ServerIp), port);
					socket.send(datagramPacket);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
