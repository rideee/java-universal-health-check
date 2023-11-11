package ovh.rid.asn.iam;

import java.io.IOException;

public class HealthCheck {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws IOException {

        System.out.print(ANSI_BLUE);
        System.out.println("\nUniversal Health Check (Java Implementation) made by Michał Kątnik (github.com/rideee)\n");
        System.out.print(ANSI_RESET);

        String configDir = "./config";

        if (args.length != 0) {
            configDir = args[0];
        }

        String configServerTypesFile = String.format("%s/%s", configDir, "servers.json");

        ConfigParser config = new ConfigParser(configServerTypesFile);

        // Main loop
        for (Server srv : config.getServersArray()) {

            System.out.print(ANSI_YELLOW);
            System.out.printf("\nRunning health check for %s\n", srv.name);
            System.out.print(ANSI_RESET);
            System.out.printf("%s:%s\nServer type: %s, logging as %s\n\n", srv.ip, srv.port, srv.type, srv.username);

            ServerType st = config.getServerTypesMap().get(srv.type);
            System.out.printf("Server Type: %s\nConnection Method: %s\nCommand to run: %s\n", st.name, st.method, st.command);

            // SSHConnection cbea = new SSHConnection("192.168.1.200", 22, "rid", "test123456");
            // System.out.println(cbea.runCommand("pwd"));
        }
    }
}