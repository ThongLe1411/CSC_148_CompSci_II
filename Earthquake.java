/**
 * TODO
 * Complete the Earthquake class. This class should contain instance variables that
 * store the center and the magnitude of the earthquake.
 * Provide the following:
 * A default constructor that sets the location to (0,0) and intensity to 0.
 * A constructor that allows the intensity to be set but defaults the location to (0,0).
 * A constructor that allows the location and intensity to be set.
 * Get and set methods for all instance variables. *SKIP* 
 * An implementation of toString that prints "Earthquake with epicenter (x,y) and magnitude z".
 * The magnitude should be rounded to one decimal place.
 * A compareIntensity instance method that takes an Earthquake object as the parameter and
 * returns a double representing how many times more powerful the calling object is than the
 * parameter. The Richter scale is a logarithmic scale, so each increase
 * of 1 on the Richter scale corresponds to a 10x increase in power.  For example, a 6.2
 * earthquake is 100 times more powerful than a 4.2 earthquake.
 */


public class Earthquake {
   private int x; 
   private int y; 
   private double magnitude; 
   
   public Earthquake(int x, int y, double magnitude){ 
       this.x = x; 
       this.y = y; 
       this.magnitude = magnitude; 
   }
   public Earthquake(double magnitude){
       this(0, 0, magnitude); 
       
   }
   public Earthquake(){
       this(0); //it does work !!!! 
       // points to the second constructor, which points to the first constructor; 
   }
   
   public double getMagnitude(){ // instance method that has access to the class's data field
       return magnitude; 
   }
   public void setMagnitude(double magnitude){
       this.magnitude = magnitude; 
   }
   
   public String toString(){
       return String.format("Earthquake with epicenter (%d,%d) and magnitude %.1f", x, y, magnitude); 
       //this method works like printf
   }
   
}
