package homework.v3.entity;

import org.codehaus.jackson.annotate.JsonGetter;

import java.io.*;
import java.util.List;

public class JsonFileClass implements Serializable {
//public class JsonFileClass implements Serializable, Externalizable {

    public static final long SerialVersionUID = 1L;

    private String version;
    public List<JsonParameters> parameters;

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
    public void setParameters(List<JsonParameters> parameters) {
        this.parameters = parameters;
    }

    public List<JsonParameters> setParameters() {
        return this.parameters;
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//
//        out.writeObject(this);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        JsonFileClass newJFC=(JsonFileClass) in.readObject();
//        this.parameters=newJFC.parameters;
//        this.version=newJFC.version;
//
//    }
}
