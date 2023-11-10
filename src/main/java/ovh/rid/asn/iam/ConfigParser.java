package ovh.rid.asn.iam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ConfigParser {
    public String configFile;
    public String jsonString;
    public InputStream inputStream;

    private ServerType[] serverTypesArray;

    public ConfigParser(String configFile) throws IOException {
        this.configFile = configFile;

        this.inputStream = new FileInputStream(configFile);
        this.jsonString = IOUtils.toString(this.inputStream, StandardCharsets.UTF_8);

        this.parseServerTypes();
    }

    private void parseServerTypes() {
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("ServerTypes");

        Gson gson = new Gson();
        this.serverTypesArray = gson.fromJson(jsonArray, ServerType[].class);
    }

    public ServerType[] getServerTypesArray() {
        return serverTypesArray;
    }
}
