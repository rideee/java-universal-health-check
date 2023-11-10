package ovh.rid.asn.iam;

public class SSHConnection {

    private String IP;
    private int port;
    private String username;
    private String password;

    public SSHConnection(String IP, int port, String username, String password) {
        this.IP = IP;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String runCommand(String command) {
        return "Wywołana komenda: " + command;
    }
}
