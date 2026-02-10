class Student {
    String name;
    int rollNo;
    int age;

    Student(String n, int r, int a) {
        name = n;
        rollNo = r;
        age = a;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Age: " + age);
    }
}

public class studentinfo {
    public static void main(String[] args) {
        Student s1 = new Student("Aaryan", 101, 20);
        Student s2 = new Student("Sahil", 102, 21);

        s1.displayInfo();
        System.out.println();
        s2.displayInfo();
    }
}
