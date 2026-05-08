class MethodOverridingDemo {
    public static void main(String[] args) {
        DerivedClass obj = new DerivedClass();
        obj.greet();
    }
}

class BaseClass {
    void greet() {
        System.out.println("Hello from BaseClass");
    }
}

class DerivedClass extends BaseClass {
    @Override
    void greet() {
        System.out.println("Hello from DerivedClass — overridden!");
    }
}
