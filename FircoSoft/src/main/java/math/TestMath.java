package math;

import org.testng.Assert;

public class TestMath {
    public static void main(String[] args) {
        Calculator cal = new Calculator();

        int result = cal.addition(20,30); // actual
        Assert.assertEquals(result,50);


       // System.out.println("Abdu wants to print the addition:    "+result);
    }
}







//// create the object  by calling the default constructor
//
//    //Calculator cal =  new Calculator();
//    // cal.addition // Because we missed the main method
//
//    public static void main(String[] args) {
//        Calculator cal = new Calculator();
//        //cal.addition(20,30);
//        int result = cal.addition(20,30); // actual
//        // What we are expected     50
//        // We are going to use the Assert to compare if we are correct or not
//        // Expected result should match or not ? Assertion this is the main goal of our job is
//        // We are using the Testng Assert
//
//        Assert.assertEquals(result,50);
//
//
//        System.out.println("Abdu wants to print the addition:    "+result);
//    }