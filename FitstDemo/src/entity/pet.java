package entity;

public class pet {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public pet() {
    }
}
