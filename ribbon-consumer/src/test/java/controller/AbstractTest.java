package controller;

public abstract class AbstractTest {

    public final String test1(){
        return test2();
    }

    public abstract String test2();
}
