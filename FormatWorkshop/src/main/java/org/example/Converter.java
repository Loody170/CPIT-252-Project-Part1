package org.example;

public interface Converter {

    public void getOptions();
    public  boolean checkConversion(String s);
    public void convert();

    public void init();
    public void passID(String id);
}



