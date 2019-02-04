package homework.v3;


import homework.v3.da.*;
import homework.v3.entity.*;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
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
 * */
public class HomeWork {
    public static final String TEMP_RDA_OUT = "homework.parameters.ser";
    public static final String RESULT_PARAMETERS_RDA_JSON = "homework.result.ser.parameters.json";


    public static void main(String... args) throws Exception {

        String fileName = "homework.parameters.json";

        JsonParameterReader service = new JsonParameterReader();
        JsonFileClass business = null;
//        JsonFileClass business = new JsonFileClass();
        System.out.println("Значение business: " + business);
        System.out.println("Считываем данные из файла " + fileName);
        business = service.read(fileName);
        System.out.println("Данные считаны:");
        System.out.println(business);

        JsonParameterSerializeWriter mySerializer = new JsonParameterSerializeWriter();
        System.out.println("Записываем данные в файла " + TEMP_RDA_OUT);
        mySerializer.customSerializeWriter(business, TEMP_RDA_OUT);
        System.out.println("Данные записаны на диск в файл " + TEMP_RDA_OUT);

        /**
         * читаем из temp.out
         *
         * serializeReader -> objectMapper
         * temp.v1.out -> result_parameters.v1.json
         *
         * */


//
//
                fileName = TEMP_RDA_OUT;
//
//                Fallback business = null;
//                System.out.println("Значение business: " + business);
//                JsonParameterSerializeReader myReader = new JsonParameterSerializeReader();
//                System.out.println("Считываем данные из файла " + fileName);
//                business = myReader.customSerializeReader(fileName);
//                System.out.println("Данные считаны с диска из файл " + fileName);
//                System.out.println("Значение business: " + business);

        /*  Вручную создаем объект
        *
        *
        *
        *
        JsonParameters enrty = new JsonParameters();
        enrty.setDescription("sdasd");
        enrty.setList(false);
        enrty.setName("oooooooo");
        enrty.setType("nnnnnnn");
        Path p=new Path();
        p.setCode("коддддд");
        p.setValue("значениееееее");
        Bundle bundle= new Bundle();

        bundle.setPath( Arrays.asList(p));
        bundle.setValues(Arrays.asList("ADMIN","sdsasasdas"));
        enrty.setBundle(Arrays.asList(bundle));

        enrty.setRoles( Arrays.asList("ADMIN","sdsasasdas"));
        List<JsonParameters> myBusinesObj = new ArrayList<>();
        myBusinesObj.add(enrty);
        business.setVersion("111");
        business.setParameters(myBusinesObj);

        */


                ObjectMapper mapper = new ObjectMapper();
                System.out.println("Записываем данные в файла " + RESULT_PARAMETERS_RDA_JSON);
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_PARAMETERS_RDA_JSON), business);
                System.out.println("Данные записаны на диск в файл " + RESULT_PARAMETERS_RDA_JSON);

    }
}
