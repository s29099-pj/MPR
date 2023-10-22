package org.carrental.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private Integer id;
    private String make;
    private String model;
    private String vin;
    private CarClass carClass;
    private CarStatus status;

}
