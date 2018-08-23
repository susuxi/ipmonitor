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
        
    	NetworkInterface[] devices = JpcapCaptor.getDeviceList();  //��ȡ�����б�
        System.out.println("             interface name                             |     description");
        System.out.println("--------------------------------------------------------");
        for(NetworkInterface n : devices)  
        {  
        	//��ӡ������Ϣ
            System.out.println(i + n.name + "     |     " + n.description); 
            i++;
        }  
        System.out.println("--------------------------------------------------------");  
          
        System.out.println("������Ҫ�����������:   ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        System.out.println("��������ʱ��/s  ");
        int time = input.nextInt();
        
        JpcapCaptor jpcap = null;  
        int caplen = 1512;  
        boolean promiscCheck = true;  
          
        try{  
            jpcap = JpcapCaptor.openDevice(devices[num], caplen, promiscCheck, time*1000); //��ָ������׼������
        }catch(IOException e)  
        {  
            e.printStackTrace();  
        }  
          
        //ץ��      
        jpcap.processPacket(-1, new packet());
        int c=0;
        for(String s:sourceip){
        	System.out.println("Դip��ַ��"+s+" ����ip��"+countpacket[c]+"��");
        	c++;
        }
        
    }  
 
	
	
}  

