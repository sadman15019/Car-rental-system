// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car{
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;  //variable name using camelcase naming   converntion, first charcter of every word is capital letter
    private boolean isAvailable;
    
    public Car(String carId, String brand, String model, double basePricePerDay, boolean isAvailble)
    {
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePricePerDay;  
        this.isAvailable=isAvailable;
        
    }
    public String getCarId()
    {
        return carId;
    }
    public String getBrand()
    {
        return brand;
    }
    public String getModel()
    {
        return model;
    }
    public double calculatePrice(int rentalDays)
    {
        return basePricePerDay*rentalDays;
    }
    public boolean isAvailable()
    {
        return isAvailable;
    }
    public void rent()  //this method is invoked if a car already has been rented
    {
        isAvailable=false;
    }
    public void returnCar()  //this method is invoked if a rented car is returned
    {
        isAvailable=true;
    }
    
}
class Customer{
    private String customerId;
    private String name;
    
    public Customer(String customerId, String name){
        this.customerId= customerId;
        this.name =name;
    }
    public String getCustomerId()
    {
       return customerId; 
    }
    public String getName()
    {
        return name;
    }
}
class Rental{
    private Car car;
    private Customer customer;
    private int days;
    
    public Rental(Car car, Customer customer, int days)
    {
        this.car=car;
        this.customer=customer;
        this.days=days;
    }
    public Car getCar()
    {
        return car;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public int getDays()
    {
        return days;
    }
}
class CarRentalSystem{
    private ArrayList <Car>cars;
    private ArrayList <Customer>customers;
    private ArrayList < Rental >rentals;
    
    public CarRentalSystem(){
         cars= new ArrayList < Car> ();
         customers=new ArrayList <Customer> ();
         rentals= new ArrayList < Rental > ();
    }
    public void addCar(Car car)
    {
        cars.add(car);
    }
    public void addCustomers(Customer cust)
    {
        customers.add(cust);
    }
    public void rentcar(Car car, Customer cust, int days)
    {
        if(car.isAvailable())
        {
            car.rent();
            rentals.add(new Rental(car,cust, days));
            System.out.println("Car is rented");
        }
        else
        {
           System.out.println("Car is not availble");   
        }
    }
    public void returncar(Car car, Customer cust)
    {
        car.returnCar();
        boolean f=false;
        for(Rental r: rentals)
        {
            if(r.getCar()==car && r.getCustomer()==cust)
            {
                rentals.remove(r);
                System.out.println("Car returned successfully");
                f=true;
                break;
            }
        }
        if(!f)
        {
            System.out.println("Wrong information. No such rental record");
        }
    }
}
    
public class Main {
    public static void main(String[] args) {
       
    }
}