package ovh.rid.asn.iam;

public class ServerType {
    String name;
    String method;
    String command;

    public ServerType(String name, String method, String command) {
        this.name = name;
        this.method = method;
        this.command = command;
    }
}
