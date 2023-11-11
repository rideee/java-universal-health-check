package ovh.rid.asn.iam;

import java.io.IOException;

public class HealthCheck {
    public static void main(String[] args) throws IOException {

        System.out.println("ASN-IAM Health Check (Java Implementation) made by Michał Kątnik");

//        SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "test123456");
//        System.out.println(cbea.runCommand("pwd"));

        String configDir = "./config";

        if (args.length != 0) {
            configDir = args[0];
        }

        String configServerTypesFile = String.format("%s/%s", configDir, "servers.json");

        ConfigParser config = new ConfigParser(configServerTypesFile);

        String serverType = "Backend";
        ServerType st = config.getServerTypesMap().get(serverType);

        System.out.printf("Server Type: %s\nConnection Method: %s\nCommand to run: %s\n", st.name, st.method, st.command);

    }
}