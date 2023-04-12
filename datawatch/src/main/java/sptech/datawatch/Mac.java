package sptech.datawatch;

import java.net.*;
import java.util.*;

public class Mac {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                byte[] mac = iface.getHardwareAddress();
                if (mac != null) {
                    System.out.print("Endereço MAC: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                }
            }
        } catch (SocketException e) {
            System.out.println("Erro ao obter o endereço MAC: " + e.getMessage());
        }
    }
}


