package org.carrental.service;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.ValidationException;
import org.carrental.model.Car;
import org.carrental.model.CarStatus;
import org.carrental.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car createCar(Car car){
        if (car.getMake().isBlank()){
            throw new ValidationException("Cannot be blank", "make");
        }
        if(car.getVin().length() != 3){
            throw new ValidationException("max length is 3", "vin");
        }

        carRepository.create(car);

        return car;
    }

    public Car GetById(Integer id){
        Optional<Car> car = carRepository.getById(id);
        return car.orElseThrow(() -> new CarNotFoundException("Car does not exist"));
    }

    public List<Car> getAvaibleCars(){
        return carRepository.getByStatus(CarStatus.AVAILABLE);
    }

    public Car updateModel (Integer id, String model) {
        if (model.isBlank()) throw new ValidationException("cannot be blaknk","model");
        return carRepository.updateModel(id,model).orElseThrow(()-> new CarNotFoundException("car does not exist"));

    }

}
