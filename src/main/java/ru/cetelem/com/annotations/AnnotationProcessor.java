package ru.cetelem.com.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {

    static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        inspect(LazyService.class);
    //    inspect(SimpleService.class);
     //   inspect(String.class);

        LazyService lazyService = (LazyService)map.get("LazyService");

        System.out.println("");

    }

    static void inspect(Class<?> service) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {


        if (service.isAnnotationPresent(Service.class)){
            Service annotation = service.getAnnotation(Service.class);
            Method[] methods = service.getDeclaredMethods();

            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (method.isAnnotationPresent(Init.class)){
                    Class<?> aClass = Class.forName(service.getName());
                    Object value = aClass.newInstance();
                    map.put(service.getSimpleName() ,value);
                    method.invoke(aClass);
                }else {
                    System.out.println("Not found");
                }
            }

            //String name = annotation.name();
            //System.out.println(name);
        }
    }
}
