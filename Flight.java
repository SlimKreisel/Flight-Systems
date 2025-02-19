/** C23727729 Khalid Roble */

public class Flight
{
    private String flightNumber;
    private String day;
    private String destination;
    private int seatsbooked;
    private int food;
    /**1.1	Create standard operations  */
    public Flight()
    {
         this.flightNumber= "";
        this.day = "";
        this.destination = "";
        this.seatsbooked =0;
        this.food =0;
    }
    
    public Flight(String flightNumber,String day, String destination)
    {
        this.flightNumber = flightNumber;
        this.day = day;
        this.destination = destination;
        this.seatsbooked = 0;
        this.food = 0;
        
    }
    
    public Flight(String flightNumber,String day, String destination,int seatsbooked, int food)
    {
        this.flightNumber = flightNumber;
        this.day = day;
        this.destination = destination;
        this.seatsbooked = seatsbooked;
        this.food = food;
        
    }
    
    public String getFlightNumber()
    {
        return this.flightNumber;
    }
    
    public String getDay()
    {
        return this.day;
    }
    
    public String getDestination()
    {
        return this.destination;
    }
    
    public int getSeatsbooked()
    {
        return this.seatsbooked;
    }
    
    public int getFood()
    {
        return this.food;
    }
    
    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber = flightNumber;
    }
    
     public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
     public void setDay(String day)
    {
        this.day = day;
    }
    
     public void setSeatsbooked(int seatsbooked )
    {
        this.seatsbooked = seatsbooked;
    }
    
     public void setFood(int food)
    {
        this.food = food;
    }
    
    public void addFood()
    {
        this.food++;
    }
    
    /**1.2	calculate return number of free seats */
    public int validateSeats()
    {
        int numberAvalaible =0;
        
        numberAvalaible = 10-seatsbooked;
        
        
        return numberAvalaible;
    }
    
    /**1.3	EXTRA while I was coding: adding seats */
    public void book()
    {
        if(seatsbooked<10)
        {
            seatsbooked++;
            System.out.println("your seats been booked succesfully.");
            
        }
        else
        {
            System.out.println("There is no available seats");
        }
    }
    
    /**1.4	Cancelling a booking */
    public void cancelBook()
    {
        if(seatsbooked==0)
        {
            
            System.out.println("There is no available seats");
        }
        else
        {
            seatsbooked--;
            System.out.println("your seats been canceled successfully");
        }
    }
    public String toString()
    {
        return "Flight Number: " +this.flightNumber+ "\n" +
        "Flight day: "+this.day+ "\n" +
        "Flight destination: "+this.destination+ "\n" +
        "Flight seats booked: "+this.seatsbooked+ "\n" +
        "Number of food ordered in the Flight: " +this.food;
    }
}  