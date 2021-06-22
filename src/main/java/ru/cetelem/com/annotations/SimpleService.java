package ru.cetelem.com.annotations;

@Service(name = "superSimpleService")
public class SimpleService {

    @Init
    public void initService(){
        System.out.println("simple init");
    }

    public void uhaha(){
        System.out.println("simple init");
    }

}
