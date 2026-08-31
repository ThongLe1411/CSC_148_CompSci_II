import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EqTester {
    public static void main (String [] args) {
        Scanner console = new Scanner(System.in);
        Scanner fileReader;
        String filename;
        File file;
        double [][] data;
        
        System.out.println("Enter the input file:");
        filename = console.nextLine();
        
        try {
            file = new File(filename);
            fileReader = new Scanner(file);
            
            //First two entries in the data file are the number of rows and columns
            int rows = fileReader.nextInt();
            int columns = fileReader.nextInt();
            data = new double[rows][columns];
            //Fill array with data from file
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = fileReader.nextDouble();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot find file " + filename);
            System.out.println("Exiting");
            return;
        }
        
        //Print data to verify the read
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        
        //TODO
        //Use the locateEpicenter method to create an Earthquake object containing the
        //location and magnitude of the earthquake
        Earthquake e = locateEpicenter(data); 
        
        //TODO
        //Print the earthquake data using the Earthquake object
        System.out.println(e);
        
        //TODO
        //Prompt the user to enter two magnitudes for earthquakes using the Richter scale
        //Create two Earthquake objects with those two magnitudes
        //Use the compareIntensity method of the Earthquake class to complete the statement
        //"Earthquake 1 is N times as powerful as Earthquake 2".  N should be rounded to 3
        //decimal places.
        
    }
    
    //TODO
    public static Earthquake locateEpicenter(double [][] arr) {
        double max = 0; 
        int x = 0; 
        int y = 0; 
        max = arr[0][0];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] > max){
                    max = arr[i][j]; 
                    x = j; 
                    y = i; 
                }
            }
        }
        
        return new Earthquake(x, y, max);
    }
}
