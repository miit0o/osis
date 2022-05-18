package me.rustige.osis;

import java.io.IOException;
import java.net.InetAddress;

import static me.rustige.osis.osis.rcount;
import static me.rustige.osis.osis.urcount;

public class netScanner {

    public static InetAddress currHost;

    public static void checkHosts(String subnet) throws IOException {
        rcount = 0;
        osis.urcount = 0;
        int timeout = 500;
        for (int i = 1; i < 255; i++) {
            String host = subnet + "." + i;
            if (InetAddress.getByName(host).isReachable(timeout)) {
                currHost = InetAddress.getByName(host);
                System.out.println(host + " | " + currHost.getHostName());
                rcount++;
            } else {
                urcount++;
            }
        }
        System.out.println("Total scanned IPs: " + 254);
        System.out.println("Total reachable IPs: " + rcount);
        System.out.println("Total unreachable IPs: " + urcount);
    }
}
