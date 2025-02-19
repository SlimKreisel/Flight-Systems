/** C23727729 Khalid Roble */

public class Passenger
{
    private String name;
    private String email;
    private String address;
    private Flight flightAddress;
    /**2.2 Create standard operations */
    public Passenger()
    {
        this.name= "";
        this.email = "";
        this.address = "";
        this.flightAddress = null;

    }
    public Passenger(String name, String email, String address)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.flightAddress = null;

    }
    public Passenger(String name, String email, String address, Flight flightAddress)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.flightAddress = flightAddress;

    }
    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAddress()
    {
        return this.address;

    }

    public Flight getFlightAddress()
    {
        return this.flightAddress;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setFlightAddress(Flight flightAddress)
    {
        this.flightAddress = flightAddress;
    }

    public String toString()
    {
        String sentence = "";
        sentence = "Passenger name:" +this.name+ "\n\n" +
        "Passenger email address:" +this.email+ "\n\n"+
        "Passenger address: "+this.address+"\n\n" +
        "Flight Details:"+this.flightAddress+"\n\n";

        return sentence;
    }

}
