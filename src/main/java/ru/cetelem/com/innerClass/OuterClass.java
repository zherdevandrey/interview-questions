package ru.cetelem.com.innerClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuterClass {
    private int outerInt;
    private int shadowVar = 10;

    public void localClassTest(final int incomeParam){

        class LocalClass{
            int localVar = 10;
           // static int staticVar;
            void testLocalVar(){
                System.out.println(localVar);
                System.out.println(incomeParam);
            }

        }

        new LocalClass().testLocalVar();
    }

    @Getter
    @Setter
    public class NestedClass{
        private int nestedInt;
        private int shadowVar = 20;

        void test(){
            System.out.println(shadowVar);
            System.out.println(OuterClass.this.shadowVar);
        }
    }

    @Getter
    @Setter
    private class NestedClassChild extends NestedClass{

    }

    @Getter
    @Setter
    public static class StaticNestedClass{


    }


}

class Main{

    public static void main(String[] args) {

      //  OuterClass outerClass = new OuterClass();
      //  OuterClass.NestedClass nestedClass = outerClass.new NestedClass();
        //nestedClass.test();
       // OuterClass.NestedClassChild nestedClassChild = outerClass.new NestedClassChild();

      //  OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();

       // int nestedInt = nestedClass.getNestedInt();

        new OuterClass().localClassTest(123);

    }

}
