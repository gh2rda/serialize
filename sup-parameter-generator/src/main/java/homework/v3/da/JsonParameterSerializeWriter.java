package homework.v3.da;

//import classwork.params.entity.template.v2.Fallback;

import homework.v3.entity.JsonFileClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JsonParameterSerializeWriter {
	
	public void customSerializeWriter(JsonFileClass parameters, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
				oos.writeObject(parameters);
			}
		}
	}
	
}
