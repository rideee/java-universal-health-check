package ovh.rid.asn.iam;

import java.io.IOException;

public class HealthCheck {
    public static void main(String[] args) throws IOException {

        System.out.println("ASN-IAM Health Check (Java Implementation) made by Michał Kątnik");

//        SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "test123456");
//        System.out.println(cbea.runCommand("pwd"));


        // Json (Gson) parsing
//        InputStream inStream = new FileInputStream("config/serverTypes.json");
//        String jsonString = IOUtils.toString(inStream, StandardCharsets.UTF_8);
//
//        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
//        JsonArray jsonArray = jsonObject.getAsJsonArray("ServerTypes");
//
//        Gson gson = new Gson();
//        ServerType[] serverTypes = gson.fromJson(jsonArray, ServerType[].class);
//
//        for(ServerType st : serverTypes) {
//            System.out.printf("%s %s %s", st.name, st.method, st.command);
//        }

        ConfigParser config = new ConfigParser("config/serverTypes.json");

        // Iteracja po obiektach z pliku json
        for (ServerType srvType : config.getServerTypesArray()) {
            System.out.printf("%s\t%s\t%s\n", srvType.name, srvType.method, srvType.command);
        }

    }
}