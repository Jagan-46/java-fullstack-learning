public interface Animal {
    void eat();
    void sleep();
    void makeSound();
}
class Dog implements Animal{
    public void eat(){
        System.out.println("Dog is Eating Food");
    }
    public void sleep(){
        System.out.println("Dog is Sleeping");
    }
    public void makeSound(){
        System.out.println("Dog is making Sound Bow-Bow");
    }
}
class Bird implements Animal{
    public void eat(){
        System.out.println("Bird is eating Food");
    }
    public void sleep(){
        System.out.println("Bird is Sleeping");
    }
    public void makeSound(){
        System.out.println("Bird is making Sound Koo-Koo Koo-koo");
    }
}
class Main{
    public static void main(String[]args){
        Dog dog = new Dog();
        Bird bird = new Bird();
        Animal[] animals = {dog,bird};
        for(Animal animal : animals){
            animal.eat();
            animal.sleep();
            animal.makeSound();
        }
    }
}