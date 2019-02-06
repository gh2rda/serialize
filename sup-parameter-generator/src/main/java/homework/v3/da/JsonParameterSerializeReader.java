package homework.v3.da;

import homework.v3.entity.JsonFileClass;
import homework.v3.entityExt.JsonFileClassExt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JsonParameterSerializeReader {

    public JsonFileClass customSerializeReader(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)) {
            try (ObjectInputStream oos = new ObjectInputStream(fos)) {
                return (JsonFileClass) oos.readObject();
            }
        }
    }

    public JsonFileClassExt customSerializeExtReader(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fos = new FileInputStream(filename)) {
            try (ObjectInputStream oos = new ObjectInputStream(fos)) {
                return (JsonFileClassExt) oos.readObject();
            }
//        System.out.println("Читаем из файла " + filename);
//        FileInputStream fileInputStream = new FileInputStream(filename);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        return (JsonFileClassExt) objectInputStream.readObject();
        }
    }
}


