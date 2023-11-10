package ovh.rid.asn.iam;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HealthCheck {
    public static void main(String[] args) throws IOException {

        System.out.println("ASN-IAM Health Check (Java Implementation) made by Michał Kątnik");

//        SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "test123456");
//        System.out.println(cbea.runCommand("pwd"));


        // Test obsługi plików
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream("test.txt");
//            outputStream.write("test".getBytes());
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        } finally {
//            outputStream.close();
//        }

        // Json (Gson) parsing
        InputStream jsonConfig = new FileInputStream("config/serverTypes.json");

    }
}