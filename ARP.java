import java.util.HashMap;
import java.util.Scanner;

public class ARP {
    public static void main(String[] args) {

        // Creating a mapping of IP addresses to MAC addresses (ARP Table)
        HashMap<String, String> arpTable = new HashMap<>();

        // Adding some static entries to the ARP table
        arpTable.put("192.168.1.1", "00-14-22-01-23-45");
        arpTable.put("192.168.1.2", "00-14-22-01-23-46");
        arpTable.put("192.168.1.3", "00-14-22-01-23-47");
        arpTable.put("192.168.1.4", "00-14-22-01-23-48");

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== ARP Protocol Simulation =====");
        System.out.print("Enter an IP Address to find its MAC Address: ");
        String ipAddress = scanner.nextLine();

        // Checking if the IP exists in the ARP table
        if (arpTable.containsKey(ipAddress)) {
            System.out.println("MAC Address for " + ipAddress + " is: " + arpTable.get(ipAddress));
        } else {
            System.out.println("IP Address not found in the ARP table. Sending ARP Request...");
            System.out.println("No Response. Entry not found!");
        }

        scanner.close();
    }
}
