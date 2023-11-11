package ovh.rid.asn.iam;

import java.io.IOException;
import java.util.Map;

public class HealthCheck {
    public static void main(String[] args) throws IOException {

        System.out.println("ASN-IAM Health Check (Java Implementation) made by Michał Kątnik");

//        SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "test123456");
//        System.out.println(cbea.runCommand("pwd"));


        ConfigParser config = new ConfigParser("./config/serverTypes.json");

//        // Json2Array - iteration
//        for (ServerType srvType : config.getServerTypesArray()) {
//            System.out.printf("%s\t%s\t%s\n", srvType.name, srvType.method, srvType.command);
//        }

        // check if server type exists
        Map<String, ServerType> serverTypesMap = config.getServerTypesMap();

        String serverType = "Backend";

        ServerType st = config.getServerTypesMap().get(serverType);

        System.out.printf("Server Type: %s\nConnection Method: %s\nCommand to run: %s\n",
                st.name, st.method, st.command);



    }
}