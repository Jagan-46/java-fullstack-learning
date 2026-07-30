import java.util.*;
public class Product {
    int productId;
    String productName;
    double price;
    public Product(int productId,String productName,double price){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
    }
    public void displayProducts(){
        System.out.println("ProductId= "+productId+" ProductName= "+productName+" Price= "+price);
    }
    public static void main(String[]args){
        HashMap<Integer,Product> products = new HashMap<>();
        products.put(1,new Product(1,"Laptop",47000));
        products.put(2,new Product(2,"Phone",30000));
        products.put(3,new Product(3,"Smart Watch",15000));
        for(Product product : products.values()){
            product.displayProducts();
        }
    }
}