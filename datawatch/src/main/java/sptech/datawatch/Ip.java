package sptech.datawatch;

import java.net.*;

public class Ip {
  public String getIp() {
    try {
      InetAddress ip = InetAddress.getLocalHost();
      return ip.getHostAddress();
    } catch (UnknownHostException e) {
      return null;
    }
  }
}