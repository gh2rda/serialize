package homework.v3.entityExt;

import java.io.*;
import java.util.List;

public class BundleExt implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private List<PathExt> path;
    private List<String> values;

    public List<PathExt> getPath() {
        return path;
    }
    public void setPath(List<PathExt> path) {
        this.path = path;
    }

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(path);
        out.writeObject(values);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.path = (List<PathExt>) in.readObject();
        this.values = (List<String>) in.readObject();
    }
}
