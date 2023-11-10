package ovh.rid.asn.iam;

import java.io.FileOutputStream;
import java.io.IOException;

public class HealthCheck {
    public static void main(String[] args) throws IOException {

        System.out.println("ASN-IAM Health Check (Java Implementation) made by Michał Kątnik");

        SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "d4rkV@rid");
        System.out.println(cbea.runCommand("pwd"));


        // Test obsługi plików
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("test.txt");
            outputStream.write("test".getBytes());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            outputStream.close();
        }


    }
}