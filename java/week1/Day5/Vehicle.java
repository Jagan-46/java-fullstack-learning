interface Vehicle {
    void start();
    void stop();
    void honk();
}
class Car implements Vehicle{
    public void start(){
        System.out.println("Car Engine Started");
    }
    public void stop(){
        System.out.println("Car Engine Stopped");
    }
    public void honk(){
        System.out.println("Car horn sounds");
    }
}
class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike Engine Started");
    }

    public void stop() {
        System.out.println("Bike Engine Stopped");
    }

    public void honk() {
        System.out.println("Bike bell rings");
    }
}
    class Main {
        public static void main(String[] args) {
            Car car = new Car();
            Bike bike = new Bike();
            Vehicle[] vehicles = {car, bike};
            for (Vehicle vehicle : vehicles) {
                vehicle.start();
                vehicle.stop();
                vehicle.honk();
            }
        }
    }