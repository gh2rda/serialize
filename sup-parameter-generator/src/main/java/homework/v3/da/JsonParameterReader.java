package homework.v3.da;

//import classwork.params.entity.template.v2.Fallback;
import homework.v3.entity.JsonFileClass;
import homework.v3.entityExt.JsonFileClassExt;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParameterReader {

    public JsonFileClass read(String url) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        final JsonFileClass fallback = mapper.readValue(new File(url), JsonFileClass.class);
        return fallback;
    }
    public JsonFileClassExt readExt(String url) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        final JsonFileClassExt fallback = mapper.readValue(new File(url), JsonFileClassExt.class);
        return fallback;
    }
    
}
