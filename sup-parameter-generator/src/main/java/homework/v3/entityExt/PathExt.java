package homework.v3.entityExt;

import java.io.*;

public class PathExt implements Externalizable {

    public static final long SerialVersionUID = 1L;

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(code);
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        PathExt pathExt = (PathExt) in.readObject();
        this.code = pathExt.code;
        this.value = pathExt.value;
    }
}
