class MethodOverloadingDemo {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.display("Rahul", 205);
        emp.display("Rahul", 205, "Sector 45, Noida");
    }
}

class Employee {
    void display(String name, int empId) {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
    }

    void display(String name, int empId, String address) {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Address: " + address);
    }
}
