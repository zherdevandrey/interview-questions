package ru.cetelem.com.patterns;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleTon {

    private static SingleTon singleTon;


    public static SingleTon get(){
        if (singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }

    private SingleTon() {
    }

    public static void main(String[] args) {

    }

}
