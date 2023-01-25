package com.example.day3spring.Controller;

import com.example.day3spring.ApiResponse;
import com.example.day3spring.Pojo.customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;

@RestController
@RequestMapping("/api/v1/customer")
public class customerController {
    static Scanner s= new Scanner(System.in);
    ArrayList<customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<customer> getCustomers() {
        return customers;
    }

    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody customer customer) {
        customers.add(customer);
        return new ApiResponse("customer has been added");
    }

    @PutMapping("/update/{index}")
    ApiResponse updateCustomer(@PathVariable int index, @RequestBody customer customer) {
        customers.set(index, customer);
        return new ApiResponse("customer has been updated");
    }


    @DeleteMapping("/delete/{index}")
    ApiResponse deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return new ApiResponse("Customer has been Deleted");
    }
    @PutMapping("/deposit/{index}")
    ApiResponse depositMoney(@PathVariable int index){
        System.out.println("please enter how much you want to deposit :");
        int money=s.nextInt();
        customers.get(index).setBalance(customers.get(index).getBalance()+money);
        return new ApiResponse("money has been added !");
    }
    @PutMapping("/withdraw/{index}")
    ApiResponse withdrawMoney(@PathVariable int index){
        System.out.println("please enter how much you want to wihdraw :");
        int money=s.nextInt();
        if(customers.get(index).getBalance()>money){
            customers.get(index).setBalance(customers.get(index).getBalance()-money);
            return new ApiResponse("money has been withdraw !");}
        else return new ApiResponse("your balance is less than your withdraw ");
    }
}
