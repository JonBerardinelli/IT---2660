
public class Serving {
    private String flavor;
    private String servingSize;
    private String number;
    
    public Serving()
    {
        this.flavor = "";
        this.servingSize = "";
        this.number = "";
    }
    
    public Serving(String n, String a, String num)
    {
        this.flavor = n;
        this.servingSize = a;
        this.number = num;
    }
    
    public String toString()
    {
        return("The pancakes flavor is " + flavor + "\n" +
                "The serving size is " + servingSize + "\n" + 
                "The number of pancakes are " + number + ".\n");
    }
    
    public Serving deepCopy()
    {
    	Serving clone = new Serving(flavor, servingSize, number);
        return clone;
    }

}
