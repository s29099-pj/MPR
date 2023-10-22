package org.carrental;

import org.carrental.model.Car;
import org.carrental.model.CarClass;
import org.carrental.model.CarStatus;
import org.carrental.repository.CarRepository;
import org.carrental.service.CarService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);

        Car car = new Car(null,"volkswagen", "model","123", CarClass.STANDARD, CarStatus.AVAILABLE);
        Car car2 = new Car(null,"audi", "aaa","322", CarClass.STANDARD, CarStatus.AVAILABLE);
        Car car3 = new Car(null,"skoda", "model4","133", CarClass.STANDARD, CarStatus.IN_REPAIR);


        carService.createCar(car);
        carService.createCar(car2);
        carService.createCar(car3);

        List<Car> availableCars = carService.getAvaibleCars();

        System.out.println(availableCars);

        Car invalidCar = new Car(null,"volkswagen", "glf",
                "12433", CarClass.STANDARD, CarStatus.IN_REPAIR);
        //carService.createCar(invalidCar);

    }
}