package homework.v3.da;

//import classwork.params.entity.template.v2.Fallback;

import homework.v3.entity.JsonFileClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonParameterSerializeReader {
	
	public JsonFileClass customSerializeReader(String filename) throws IOException, ClassNotFoundException {
		try (FileInputStream fos = new FileInputStream(filename)){
			try (ObjectInputStream oos = new ObjectInputStream(fos)){
				return (JsonFileClass)oos.readObject();
			}
		}
	}
	
}
