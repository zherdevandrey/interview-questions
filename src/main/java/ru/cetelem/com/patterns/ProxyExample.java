package ru.cetelem.com.patterns;

public class ProxyExample {
    
    public static void main(String[] args) {
        IService service = new ProxyCacheService();
        service.loadData();
    }

}

interface IService{

    void loadData();

}

class SlowService implements IService{

    @Override
    public void loadData() {
        System.out.println("load slow data");
    }
}

class ProxyCacheService implements IService{

    IService iService = new SlowService();

    @Override
    public void loadData() {
        System.out.println("ALL DATA IS CACHED");
        iService.loadData();
    }
}
