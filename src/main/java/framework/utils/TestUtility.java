package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtility {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/test.properties";
    private static Properties property;

    private TestUtility() {
    }

    public static void setTestUtility() {
        try {
            LoggerUtility.info("Создение утиллиты для файла config");
            FileInputStream fis = new FileInputStream(PATH_TO_PROPERTIES);
            property = new Properties();
            property.load(fis);
        } catch (IOException var1) {
            LoggerUtility.error("ОШИБКА: Файл config отсутствует");
            throw new RuntimeException();
        }
    }

    public static String getStringValue(String key) {
        LoggerUtility.info("Получение тесктового значения '" + key + "' из файла config ");
        return property.getProperty(key);
    }

    public static int getIntValue(String key) {
        LoggerUtility.info("Получение целого значения '" + key + "' из файла config ");
        return Integer.parseInt(property.getProperty(key));
    }
}
