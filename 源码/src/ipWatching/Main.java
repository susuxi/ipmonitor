package ipWatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import jpcap.*;  

  
public class Main {  
      public static ArrayList<String> sourceip = new ArrayList<>();
      public static int[] countpacket = new int[50];
      public static int count=1;
    public static void main(String[] args)  
    {  
    	int i=0;
        
    	NetworkInterface[] devices = JpcapCaptor.getDeviceList();  //获取网口列表
        System.out.println("             interface name                             |     description");
        System.out.println("--------------------------------------------------------");
        for(NetworkInterface n : devices)  
        {  
        	//打印网口信息
            System.out.println(i + n.name + "     |     " + n.description); 
            i++;
        }  
        System.out.println("--------------------------------------------------------");  
          
        System.out.println("输入你要监测的网口序号:   ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        System.out.println("请输入监测时间/s  ");
        int time = input.nextInt();
        
        JpcapCaptor jpcap = null;  
        int caplen = 1512;  
        boolean promiscCheck = true;  
          
        try{  
            jpcap = JpcapCaptor.openDevice(devices[num], caplen, promiscCheck, time*1000); //打开指定网口准备捕获
        }catch(IOException e)  
        {  
            e.printStackTrace();  
        }  
          
        //抓包      
        jpcap.processPacket(-1, new packet());
        int c=0;
        for(String s:sourceip){
        	System.out.println("源ip地址："+s+" 捕获ip包"+countpacket[c]+"个");
        	c++;
        }
        
    }  
 
	
	
}  

