package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.example.exception.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PizzaService {
    private static final Logger logger = LogManager.getLogger(PizzaService.class);

    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;

    public PizzaService(List<Pizza> pizzaList){
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzas){

        List<Pizza> availablePizzas = getAvailablePizzas();

        if(getAvailablePizzas().containsAll(orderedPizzas)) {
            double sum = orderedPizzas.stream()
                    .map(Pizza::getPrice)
                    .reduce(0D, (current, price) -> current + price);
            Order order = new Order(orderList.size(), orderedPizzas, sum);

            orderList.add(order);
            logger.info(order);
            return order;
        }else{
            throw new PizzaNotFoundException();
        }
    }

    public List<Pizza> getAvailablePizzas(){

        //zwrocenie listy dostepnych pizz (filtrowanie po isAvaible)
        logger.info("Wywowalnie metody: getAvailablePizzas");
        return pizzaList.stream()
                .filter(Pizza::isAvailable)
                .collect(Collectors.toList());
    }
}
