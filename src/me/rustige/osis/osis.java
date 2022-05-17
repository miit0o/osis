package me.rustige.osis;

import java.util.Scanner;

public class osis {

    public static String subnet;
    public static Scanner getInput = new Scanner(System.in);
    public static int rcount;
    public static int urcount;

    public static void main (String[] args) {
        System.out.println("Please enter subnet to be scanned:");
        subnet = getInput.nextLine();
        System.out.println("I'm going to start scanning. If nothing happens, that probably means I'm working hard, so please be patient.");
        System.out.println("Detected IPs:");
        try{
            netScanner.checkHosts(subnet);
        }catch(Exception e){

        }

    }
}
