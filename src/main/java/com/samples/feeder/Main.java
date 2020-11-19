package com.samples.feeder;

import com.samples.common.Car;
import com.samples.common.Cellphone;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger log = Logger.getLogger(Main.class.getName());
    private GigaSpace gigaSpace;

    private static final String SPACE_NAME = "demo";


    public Main() {
        SpaceProxyConfigurer configurer = new SpaceProxyConfigurer(SPACE_NAME);

        gigaSpace = new GigaSpaceConfigurer(configurer).gigaSpace();

    }

    public void write() {

        Car car = new Car();
        car.setModel("Honda");
        car.setName("Odyssey");
        car.setId(1);
        car.setCode("12341");
        gigaSpace.write(car);

        car = new Car();
        car.setModel("Toyota");
        car.setName("Camry");
        car.setId(2);
        car.setCode("12342");
        gigaSpace.write(car);

        car = new Car();
        car.setModel("Ford");
        car.setName("F-150");
        car.setId(3);
        car.setCode("12343");
        gigaSpace.write(car);

        Cellphone cellphone = new Cellphone();
        cellphone.setBrand("Apple");
        cellphone.setModel("iPhone 11");
        cellphone.setCode("671");
        cellphone.setId(1);
        cellphone.setName("Apple iphone 11");
        gigaSpace.write(cellphone);

        cellphone = new Cellphone();
        cellphone.setBrand("Samsung");
        cellphone.setModel("Galaxy S10");
        cellphone.setCode("672");
        cellphone.setId(2);
        cellphone.setName("Samsung Galaxy S10");
        gigaSpace.write(cellphone);

    }

    public static void main(String[] args) throws Exception{
        Main example = new Main();

        example.write();
    }

}
