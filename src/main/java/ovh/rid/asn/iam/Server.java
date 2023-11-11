package ovh.rid.asn.iam;

public class Server {
    String name;
    String type;
    String ip;
    String port;
    String username;
    String password;
    String key;
    String passphrase;


    public Server(String name, String type, String ip, String port, String username, String password, String key, String passphrase) {
        this.name = name;
        this.type = type;
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.key = key;
        this.passphrase = passphrase;
    }
}
