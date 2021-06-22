package com.example.springpotroshitel;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Service
public class RandomIntBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            RandomIntInjector annotation = field.getAnnotation(RandomIntInjector.class);
            if (annotation != null){
                System.out.println("PHASE 2");
                int max = annotation.max();
                int min = annotation.min();
                Random random = new Random();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, min + random.nextInt(max - min) );
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            RandomIntInjector annotation = field.getAnnotation(RandomIntInjector.class);
            if (annotation != null){
                System.out.println("PHASE 3");
            }
        }
        return bean;
    }
}
