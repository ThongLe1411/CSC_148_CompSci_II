import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args){
//        Product first = new Product("iPhone", 989.9, 3);
//        System.out.println(first.toString());

        Scanner console = new Scanner(System.in);
        Scanner fileReader;
        String fileName;
        File file;


        String[] data;
        String[] properties;
        Product[] product;

        System.out.println("Enter the input file: ");
        fileName = console.nextLine();
        try{
            file = new File(fileName);
            fileReader = new Scanner(file);

            int numberOfProducts = fileReader.nextInt();
            fileReader.nextLine(); // consume the rest of the line after the int

            data = new String[numberOfProducts];
            properties = new String[3];
            product = new Product[numberOfProducts];

            for(int i = 0; i < data.length; i++){
                data[i] = fileReader.nextLine();

                properties = data[i].split(",");

                product[i] = new Product(properties[0],
                        Double.parseDouble(properties[1]),
                        Integer.parseInt(properties[2]));
            }

            for(int i = 0; i < product.length; i++){
                System.out.println(product[i].toString());
                System.out.println();
            }

            //search for the most valuable product, highest unit price, Total inventory value

            int indexMax = indexOfMostValuable(product);
            double mostValue = product[indexMax].getQuantity()*product[indexMax].getUnitPrice();


            System.out.printf("The most valuable product is " + product[indexMax].getName() +
                    " with inventory value of %.2f \n", mostValue);

            int indexHighUnit = indexOfHighestUnit(product);
            double highestUnit = product[indexHighUnit].getUnitPrice();
            System.out.println(product[indexHighUnit].getName() + " has the highest unit price of " + highestUnit);


            System.out.println("The total inventory value is " + totalValue(product));
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot find file " + fileName);
            System.out.println("Exitting");
            return;
        }
    }
    public static int indexOfMostValuable(Product[] product){
        int indexMax = 0;
        double currentMax = product[0].getQuantity()*product[0].getUnitPrice();

        for(int i = 0; i < product.length; i++){
            if(product[i].getQuantity()*product[i].getUnitPrice() > currentMax){
                currentMax = product[i].getQuantity()*product[i].getUnitPrice();
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static int indexOfHighestUnit(Product[] product){
        double currentHighUnit = product[0].getUnitPrice();
        int indexHighUnit = 0;

        for(int i = 0; i< product.length; i++){
            if(product[i].getUnitPrice() > currentHighUnit){
                currentHighUnit = product[i].getUnitPrice();
                indexHighUnit = i;
            }
        }
        return indexHighUnit;
    }
    public static double totalValue(Product[] product){
        double totalValue = 0;

        for(int i = 0; i < product.length; i++){

            totalValue += product[i].getQuantity()*product[i].getUnitPrice();
        }

        return totalValue;
    }
}
