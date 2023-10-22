package org.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;


}
