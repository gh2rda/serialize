package homework.v3;


import homework.v3.da.*;
import homework.v3.entity.*;
import homework.v3.entityExt.*;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 */
public class HomeWork {
    public static final String TEMP_RDA_OUT = "homework.parameters.ser";
    public static final String TEMP_RDA_OUT_EXTER = "homework.parameters.exter";

    public static final String RESULT_PARAMETERS_RDA_JSON = "homework.result.ser.parameters.json";
    public static final String RESULT_PARAMETERS_RDA_JSON_EXTER = "homework.result.exter.parameters.json";


    public static void main(String... args) throws Exception {
// исходный файл JSON
        String fileName = "homework.parameters.json";

//чтение исходного файла в память(создаем объекты)
        JsonParameterReader service = new JsonParameterReader();
        JsonFileClass business = null;
        JsonFileClassExt businessExt = null;

        System.out.println("Значение business: " + business);
        System.out.println("Считываем данные из файла " + fileName);
        business = service.read(fileName);
        businessExt = service.readExt(fileName);

        System.out.println("Данные считаны:");
        System.out.println(business);
        System.out.println(businessExt);

// сериализация стандартная
        JsonParameterSerializeWriter mySerializer = new JsonParameterSerializeWriter();
        System.out.println("Записываем данные в файл " + TEMP_RDA_OUT);
        mySerializer.customSerializeWriter(business, TEMP_RDA_OUT);
        System.out.println("Данные записаны на диск в файл " + TEMP_RDA_OUT);

// сериализация exter
        System.out.println("Записываем данные в файл " + TEMP_RDA_OUT_EXTER);
        mySerializer.customSerializeExtWriter(businessExt, TEMP_RDA_OUT_EXTER);
        System.out.println("Данные записаны на диск в файл " + TEMP_RDA_OUT_EXTER);

// очищаем переменную
//чтение сохраненного состояния из файла в память(инициализируем объект)
        business = null;
        System.out.println("Значение business: " + business);

        JsonParameterSerializeReader myReader = new JsonParameterSerializeReader();
        System.out.println("Считываем данные из файла " + TEMP_RDA_OUT);
        business = myReader.customSerializeReader(TEMP_RDA_OUT);
        System.out.println("Данные считаны с диска из файл " + TEMP_RDA_OUT);
        System.out.println("Значение business: " + business);

//пишем состояние объекта в JSON
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Записываем данные в файл " + RESULT_PARAMETERS_RDA_JSON);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_PARAMETERS_RDA_JSON), business);
        System.out.println("Данные записаны на диск в файл " + RESULT_PARAMETERS_RDA_JSON);

// Ext вариант очищаем переменную
//чтение сохраненного состояния из файла в память(инициализируем объект)
        businessExt = null;
        System.out.println("Значение businessExt: " + businessExt);

        JsonParameterSerializeReader myReaderExt = new JsonParameterSerializeReader();
        System.out.println("Считываем данные из файла " + TEMP_RDA_OUT_EXTER);
        businessExt = myReaderExt.customSerializeExtReader(TEMP_RDA_OUT_EXTER);
        System.out.println("Данные считаны с диска из файл " + TEMP_RDA_OUT_EXTER);
        System.out.println("Значение businessExt: " + businessExt);

//пишем состояние объекта в JSON
//        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Записываем данные в файл " + RESULT_PARAMETERS_RDA_JSON_EXTER);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_PARAMETERS_RDA_JSON_EXTER), businessExt);
        System.out.println("Данные записаны на диск в файл " + RESULT_PARAMETERS_RDA_JSON_EXTER);

//        System.out.println("2 вар Читаем из файла " + TEMP_RDA_OUT_EXTER);
//        FileInputStream fileInputStream = new FileInputStream(TEMP_RDA_OUT_EXTER);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        business = (JsonFileClass) objectInputStream.readObject();
//        System.out.println("Данные считаны\n" + business.toString());
////пишем состояние объекта в JSON
//
//        System.out.println("Записываем данные в файл " + RESULT_PARAMETERS_RDA_JSON_EXTER);
//        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_PARAMETERS_RDA_JSON_EXTER), business);
//        System.out.println("2 вар Данные записаны на диск в файл " + RESULT_PARAMETERS_RDA_JSON_EXTER);

    }
}
