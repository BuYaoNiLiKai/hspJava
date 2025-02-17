package reflection_;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Code01_Basic {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("./src/reflection_/re.properties"));
        String classPath = prop.getProperty("classfullpath");
        String methodName = prop.getProperty("methodname");
        System.out.println("classpath: " + classPath);
        System.out.println("methodname: " + methodName);
        Class aclass = Class.forName(classPath);
        Cat cat = (Cat) aclass.newInstance();
        Method method = aclass.getMethod(methodName);
        method.invoke(cat);


    }
}
