package ipWatching;

import jpcap.PacketReceiver;
import jpcap.packet.*;

public class packet implements PacketReceiver{
	public void receivePacket(Packet packet){
		
	
	if(packet instanceof IPPacket )  //可过滤ip包如ipv4（&& ((IPPacket)packet).version == 4）
    {  
         
        IPPacket ip = (IPPacket)packet;//类型转换
        
        String protocol ="";  
        switch(new Integer(ip.protocol))  
        {  
        //判断协议类型
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
        //打印ip包信息
        System.out.println("协议：" + protocol);  
        System.out.print("源IP " + ip.src_ip.getHostAddress()+" 目的IP " + ip.dst_ip.getHostAddress());   
        System.out.println(" 源主机名： " + ip.src_ip+" 目的主机名： " + ip.dst_ip);  
        System.out.println("优先权：" + ip.priority);  
        System.out.println("区分服务：最大的吞吐量： " + ip.t_flag);  
        System.out.println("区分服务：最高的可靠性：" + ip.r_flag);  
        System.out.println("长度：" + ip.length);  
        System.out.println("标识：" + ip.ident);  
        System.out.println("DF:Don't Fragment: " + ip.dont_frag);  
        System.out.println("NF:Nore Fragment: " + ip.more_frag);  
        System.out.println("片偏移：" + ip.offset);  
        System.out.println("生存时间："+ ip.hop_limit);  
        System.out.println("---------------------------------------"+Main.count+"---------------------------------------------------");  
        //统计
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
