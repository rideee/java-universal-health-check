package ovh.rid.asn.iam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private final String serversJsonString;
    private final String serversConfigFile;
    private ServerType[] serverTypesArray;
    private Map<String, ServerType> serverTypesMap;
    private Server[] serversArray;

    public ConfigParser(String serversConfigFile) throws IOException {
        this.serversConfigFile = serversConfigFile;

        InputStream serversFileInputStream = new FileInputStream(serversConfigFile);
        this.serversJsonString = IOUtils.toString(serversFileInputStream, StandardCharsets.UTF_8);

        this.parseServerTypes();
        this.parseServers();
    }

    public String getServersConfigFileLocation() {
        return serversConfigFile;
    }

    public ServerType[] getServerTypesArray() {
        return this.serverTypesArray;
    }

    public Map<String, ServerType> getServerTypesMap() {
        return this.serverTypesMap;
    }

    public Server[] getServersArray() {
        return this.serversArray;
    }

    private void parseServerTypes() {
        JsonObject jsonObject = new Gson().fromJson(serversJsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("ServerTypes");

        Gson gson = new Gson();
        this.serverTypesArray = gson.fromJson(jsonArray, ServerType[].class);

        // Array to Map
        HashMap<String, ServerType> stMap = new HashMap<>();

        for (ServerType srvType : this.serverTypesArray) {
            stMap.put(srvType.name, srvType);
        }

        this.serverTypesMap = stMap;
    }


    private void parseServers() {
        JsonObject jsonObject = new Gson().fromJson(serversJsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("Servers");

        Gson gson = new Gson();
        this.serversArray = gson.fromJson(jsonArray, Server[].class);
    }

}
