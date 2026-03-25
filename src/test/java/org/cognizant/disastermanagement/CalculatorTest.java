package org.cognizant.disastermanagement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;


    @BeforeEach
    public void initBeforeEveryMethod(){
        System.out.println("initBeforeEveryMethod");
        calculator=new Calculator();
    }

    @AfterEach
    public void destroybefore(){
        System.out.println("destroybefore");
        calculator=null;
    }


    @Test
    public void testAddMethod(){
        int result=calculator.add(4,5);
        assertEquals(9, result);
    }


    @Test
    public void testsubMethod(){

        int result=calculator.sub(5,4);
        assertEquals(1, result);
    }


    @Test
    public void testDivMethod(){
        Calculator calculator=new Calculator();

        // int result=calculator.div(4,0);
        // assertEquals(1, result);
        assertThrows(ArithmeticException.class, ()->{
            calculator.div(4,1);
        });

    }



}
