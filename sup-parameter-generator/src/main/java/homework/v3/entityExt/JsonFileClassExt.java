package homework.v3.entityExt;

import org.codehaus.jackson.annotate.JsonGetter;

import java.io.*;
import java.util.List;

public class JsonFileClassExt implements Externalizable {

    public static final long SerialVersionUID = 1L;

    private String version;
    public List<JsonParametersExt> parameters;

    @Override
    public String toString() {
        return this.version + "\n" + this.parameters;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @JsonGetter("version")
    public String getVersion() {
        return this.version;
    }

    @JsonGetter("parameters")
    public void setParameters(List<JsonParametersExt> parameters) {
        this.parameters = parameters;
    }

    public List<JsonParametersExt> setParameters() {
        return this.parameters;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(version);
        out.writeObject(parameters);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        JsonFileClassExt jsonFileClassExt = new JsonFileClassExt();
        jsonFileClassExt = (JsonFileClassExt) in.readObject();
        this.setVersion(jsonFileClassExt.version);
        this.setParameters(jsonFileClassExt.parameters);
//        this.version = jsonFileClassExt.version;
//        this.parameters = jsonFileClassExt.parameters;

    }
}
