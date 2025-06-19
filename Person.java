public class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.printf("Name: %s | Age: %d | Gender: %s%n", name, age, gender);
    }
    
}
