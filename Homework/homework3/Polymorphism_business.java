package alston.homework3;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism_business {

    public static void main(String[] args) {

        var merchandiselist = new ArrayList<Merchandise>();
        var employeeList = new ArrayList<Employee>();
        var employee = new Employee();
        var merchandise = new Merchandise();

        merchandise.setName("牛排");
        merchandise.setPrice(380);
        merchandiselist.add(merchandise);

        employee.setName("鮑伯");
        employee.setAge(38);
        employee.setPosition("老闆");
        employeeList.add(employee);

        var restaurant = new Restaurant(merchandiselist, employeeList);
        restaurant.merchandise();
        restaurant.employees();
    }

}

class Restaurant extends Business {

    public Restaurant () {
    }

    public Restaurant(List<Merchandise> merchandiseList, List<Employee> employees) {
        this.merchandiseList = merchandiseList;
        this.employees = employees;
    }

    @Override
    void merchandise() {
        for (Merchandise m : merchandiseList) {
            System.out.println("品名 : " + m.getName() + " 價格 : " + m.getPrice());
        }
    }

    @Override
    void employees() {
        for (Employee e : employees) {
            System.out.println("姓名 : " + e.getName() + " 年齡 : " + e.getAge() + " 職位 : " + e.getPosition());
        }
    }

}

class Bakery extends Business {

    public Bakery(String name) {

    }

    public Bakery(List<Merchandise> merchandiseList, List<Employee> employees) {
        this.merchandiseList = merchandiseList;
        this.employees = employees;
    }

    @Override
    void merchandise() {
        for (Merchandise m : merchandiseList) {
            System.out.println("品名 : " + m.getName() + " 價格 : " + m.getPrice());
        }
    }

    @Override
    void employees() {
        for (Employee e : employees) {
            System.out.println("姓名 : " + e.getName() + " 年齡 : " + e.getAge() + " 職位 : " + e.getPosition());
        }
    }

}

class Business {

    List<Merchandise> merchandiseList;
    List<Employee> employees;

    public Business () {}

    public Business(List<Merchandise> merchandiseList, List<Employee> employees) {
        this.merchandiseList = merchandiseList;
        this.employees = employees;
    }

    void merchandise() {
    }

    void employees() {
    }

}