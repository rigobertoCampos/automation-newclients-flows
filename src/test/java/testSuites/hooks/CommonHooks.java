package testSuites.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import starter.ConstantReader;
import starter.IdCalculator;

public class CommonHooks {
    @Before("@signup")
    public void setUp(){
        ConstantReader.getInstance().readFile();
        IdCalculator.getInstance();
    }

    @Before("@passport")
    public void setUpPassport(){
        IdCalculator.getInstance().setPassport();
    }

    @Before
    public void hola(){
        System.out.println("esto viene de los hooks antes");
    }

    @After
    public void hola2(){
        System.out.println("esto viene de los hooks despues");
    }
}
