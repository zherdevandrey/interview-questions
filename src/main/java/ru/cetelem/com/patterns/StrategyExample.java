package ru.cetelem.com.patterns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StrategyExample {

    public static void main(String[] args) {
        JavaSuperDeveloper javaSuperDeveloper = new JavaSuperDeveloper();
        javaSuperDeveloper.setActivity(new Sleep());
        javaSuperDeveloper.justDoIt();
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Setter
class JavaSuperDeveloper{
    private Activity activity;

    public void justDoIt(){
        activity.executeActivity();
    }

}

interface Activity{

    void executeActivity();

}

class Sleep implements Activity{
    @Override
    public void executeActivity() {
        System.out.println("SLEEPING");
    }
}

class Work implements Activity{
    @Override
    public void executeActivity() {
        System.out.println("WORKING");
    }
}