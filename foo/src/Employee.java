public class Employee {
    int age = 0;
    public String name = "Bob";
    double rate = 12.45;
    Address address;
    Wage wage;
    
    public Employee (String aName, int number, 
            String aStreet, String aCity, double ratePerHour,
            int hours) {
        name = aName;
        rate = ratePerHour;
        address = new Address(number, aStreet, aCity);
        wage = new Wage(hours);
    }
    
    // Inner class 
    class Address {
        int number = 0;
        String street = "";
        String city = "";
        
        Address (int num, String aStreet, String aCity) {
            number = num;
            street = aStreet;
            city = aCity;    
        }
        
        void printDetails() {
            System.out.println(number + " " + street + ", " + city);
        }
    }
    
    // Inner class
    class Wage {
        int hoursWorked = 0;
        
        Wage(int hours) {
            hoursWorked = hours;
        }
        void printDetails() {
            System.out.println("Pay packet = " + hoursWorked * rate);
        }
    }
    
    public static void main(String[] args) {
        Employee e = new Employee("John", 33, "High St", "Bath", 2.45, 36);
        e.printInformation();
    }

    public void printInformation() {
        System.out.println("\nFor Employee: " + name);
        address.printDetails();
        wage.printDetails();
    }
}