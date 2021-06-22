package ru.cetelem.com.patterns;

public class AdapterExample {

    public static void main(String[] args) {
        new CardAdapter().loadData();
    }

    interface LoadData{
        void loadData();
    }

    static class MemoryCard{

        public void insert(){
            System.out.println("CARD IS INSERTED");
        }

        public void load(){
            System.out.println("DATA IS LOADED");
        }
    }

    static class CardAdapter extends MemoryCard implements LoadData{

        @Override
        public void loadData() {
            insert();
            load();
        }
    }

}
