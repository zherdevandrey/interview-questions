package ru.cetelem.com.generic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("iphone", BigDecimal.valueOf(100));

        Phone phone = new Phone("s5");

        Camera camera = new Camera(10);
        SuperCamera superCamera = new SuperCamera(11);

        List<Product> products = Arrays.asList(product);
        List<Phone> phones = Arrays.asList(phone);
        List<Camera> cameras = Arrays.asList(camera);
        List<Camera> superCameras = Arrays.asList(superCamera);

        Product foundProduct = find(phones, camera);

        System.out.println(foundProduct.getName());

        find2(products, phone);

        copy(phones, products);

        find3(Arrays.asList(""), new Product());
    }




    public static void test2(List<? extends Phone> list){
        System.out.println("");
    }

    public static void copy(List<? extends Product> src, List<? super Product> dest){
        dest.addAll(src);
    }

    public static Product find(List<? extends Product> list, Product product){
        return list.stream()
                .filter(item -> item.getName().equals(product.getName()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public static <T> T find2(List<T> list, T t){
        return t;
    }

    public static void find3(List<?> list, Product product){

    }

}
