public abstract class Animal {
    public abstract void sound();
    public void sleep(){
        System.out.println("Animal is Sleeping");
    }
}
class Dog extends Animal{
    public void  sound(){
      System.out.println("Bow Bow");
    }
}
class Cat extends Animal {
    public void sound() {
        System.out.println("Meow Meow");
    }
    public static void main(String[] args) {
     Dog dog = new Dog();
     Cat cat = new Cat();
     dog.sound();
     dog.sleep();
     cat.sound();
     cat.sleep();
    }
}

