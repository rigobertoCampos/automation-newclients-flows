package testSuites.hooks;

import io.cucumber.java.Before;
import starter.ConstantReader;

public class CommonHooks {
    @Before("@signup")
    public void setUp(){
        ConstantReader.getInstance().readFile();
    }
}
