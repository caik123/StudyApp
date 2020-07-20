package com.example.study;

import com.example.study.test.Car;
import com.example.study.test.ICar;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCar(){
        Car car = new Car();
        if(car instanceof ICar){
            car.run();
        }
    }
}