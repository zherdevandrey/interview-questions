package ru.cetelem.com.annotations;

@Service(name = "veryLazyService")
public class LazyService {

    @Init
    public void lazyInitService(){
        System.out.println("lazy init");
    }


    public void test(){
        System.out.println("JUST SIMPLE TEST METHOD");
    }

}
