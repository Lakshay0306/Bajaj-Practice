class InheritanceDemo {
    public static void main(String[] args) {
        ChildClass obj = new ChildClass();
        obj.showCourse();
        obj.showTopic();
        obj.showLanguage();
    }
}

class ParentClass {
    void showCourse() {
        System.out.println("Course: Data Structures & Algorithms");
    }

    void showTopic() {
        System.out.println("Topic: Trees, Graphs, DP");
    }
}

class ChildClass extends ParentClass {
    void showLanguage() {
        System.out.println("Language: Java");
    }
}
