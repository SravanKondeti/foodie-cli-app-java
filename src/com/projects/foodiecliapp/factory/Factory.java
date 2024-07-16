package com.projects.foodiecliapp.factory;

import com.projects.foodiecliapp.controller.CustomerController;
import com.projects.foodiecliapp.controller.DishController;
import com.projects.foodiecliapp.controller.OrderController;
import com.projects.foodiecliapp.controller.RestaurantController;
import com.projects.foodiecliapp.repository.CustomerRepositoryImpl;
import com.projects.foodiecliapp.repository.DishRepositoryImpl;
import com.projects.foodiecliapp.repository.OrderRepositoryImpl;
import com.projects.foodiecliapp.repository.RestaurantRepositoryImpl;
import com.projects.foodiecliapp.service.CustomerServiceImpl;
import com.projects.foodiecliapp.service.DishServiceImpl;
import com.projects.foodiecliapp.service.OrderServiceImpl;
import com.projects.foodiecliapp.service.RestaurantServiceImpl;
import com.projects.foodiecliapp.util.CsvReader;

public class Factory {

    public static CsvReader getCsvReader(){ return Holder.csvReader; }

    public static CustomerRepositoryImpl getCustomerRepository(){
        return Holder.customerRepository;
    }
    public static CustomerServiceImpl getCustomerService(){
        return Holder.customerService;
    }
    public static CustomerController getCustomerController(){
        return Holder.customerController;
    }

    public static DishRepositoryImpl getDishRepository(){ return Holder.dishRepository;}
    public static DishServiceImpl getDishService(){ return Holder.dishService;}
    public static DishController getDishController(){ return Holder.dishController;}

    public static RestaurantRepositoryImpl getRestaurantRepository(){
        return Holder.restaurantRepository;
    }
    public static RestaurantServiceImpl getRestaurantService(){
        return Holder.restaurantService;
    }
    public static RestaurantController getRestaurantController(){
        return Holder.restaurantController;
    }

    public static OrderRepositoryImpl getOrderRepository(){
        return Holder.orderRepository;
    }
    public static OrderServiceImpl getOrderService(){
        return Holder.orderService;
    }
    public static OrderController getOrderController(){
        return Holder.orderController;
    }


    private static class Holder{

        private static final CsvReader csvReader = new CsvReader();

        private static final CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        private static final CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        private static final CustomerController customerController = new CustomerController(customerService);

        private static final DishRepositoryImpl dishRepository = new DishRepositoryImpl();
        private static final DishServiceImpl dishService = new DishServiceImpl(dishRepository);
        private static final DishController dishController = new DishController(dishService);

        private static final RestaurantRepositoryImpl restaurantRepository = new RestaurantRepositoryImpl();
        private static final RestaurantServiceImpl restaurantService = new RestaurantServiceImpl(restaurantRepository);
        private static final RestaurantController restaurantController = new RestaurantController(restaurantService);

        private static final OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
        private static final OrderServiceImpl orderService = new OrderServiceImpl(orderRepository);
        private static final OrderController orderController = new OrderController(orderService);
    }
}


