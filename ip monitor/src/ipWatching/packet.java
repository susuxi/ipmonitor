package ipWatching;

import jpcap.PacketReceiver;
import jpcap.packet.*;

public class packet implements PacketReceiver{
	public void receivePacket(Packet packet){
		
	
	if(packet instanceof IPPacket )  //�ɹ���ip����ipv4��&& ((IPPacket)packet).version == 4��
    {  
         
        IPPacket ip = (IPPacket)packet;//����ת��
        
        String protocol ="";  
        switch(new Integer(ip.protocol))  
        {  
        //�ж�Э������
        case 1:protocol = "ICMP";break;  
        case 2:protocol = "IGMP";break;  
        case 6:protocol = "TCP";break;  
        case 8:protocol = "EGP";break;  
        case 9:protocol = "IGP";break;  
        case 17:protocol = "UDP";break;  
        case 41:protocol = "IPv6";break;  
        case 89:protocol = "OSPF";break;  
        default : break;  
        }  
        //��ӡip����Ϣ
        System.out.println("Э�飺" + protocol);  
        System.out.print("ԴIP " + ip.src_ip.getHostAddress()+" Ŀ��IP " + ip.dst_ip.getHostAddress());   
        System.out.println(" Դ�������� " + ip.src_ip+" Ŀ���������� " + ip.dst_ip);  
        System.out.println("����Ȩ��" + ip.priority);  
        System.out.println("���ַ��������������� " + ip.t_flag);  
        System.out.println("���ַ�����ߵĿɿ��ԣ�" + ip.r_flag);  
        System.out.println("���ȣ�" + ip.length);  
        System.out.println("��ʶ��" + ip.ident);  
        System.out.println("DF:Don't Fragment: " + ip.dont_frag);  
        System.out.println("NF:Nore Fragment: " + ip.more_frag);  
        System.out.println("Ƭƫ�ƣ�" + ip.offset);  
        System.out.println("����ʱ�䣺"+ ip.hop_limit);  
        System.out.println("---------------------------------------"+Main.count+"---------------------------------------------------");  
        //ͳ��
        if(Main.sourceip.contains(ip.src_ip.getHostAddress())){
        	Main.countpacket[Main.sourceip.indexOf(ip.src_ip.getHostAddress())]++;
        }else{
        	Main.sourceip.add(ip.src_ip.getHostAddress());
            Main.countpacket[Main.sourceip.size()-1]=1;
        }
        Main.count++;
        
    }  
	}

	
}
