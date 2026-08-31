public class Product {
    private String name;
    private int quantity;
    private double unitPrice;

    public Product(String name, double unitPrice, int quantity){
        this.name = name ;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product(){
        this("", 0, 0);

    }

    public Product(String name, double unitPrice){
        this(name, unitPrice, 0);
    }


    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    public String toString(){
        return String.format("Product: " + name +
                        "\nPrice: $ %.2f" + "\nQuantity: %d" + "\nTotal Value: %.2f"
                , unitPrice, quantity, unitPrice*quantity);
    }

}
