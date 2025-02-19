/** C23727729 Khalid Roble**/
import java.util.Scanner;
import java.util.ArrayList;
public class DriverClass
{
    ArrayList<Flight> jet;
    ArrayList<Passenger> passy;

    public DriverClass()
    {
        passy = new ArrayList<Passenger>();
        jet = new ArrayList<Flight>();

        inputFlights();
        //testBooking();
        loopMenu();

    }

    public void inputFlights()/**3.    DriverClass: Input details for 5 flights */
    {
        String flightNumber = "";
        String twoletter = "";
        String day="";
        String destination="";

        Scanner kreisel = new Scanner(System.in);
        for(int i = 1; i<=5; i++)
        {
            do{
                /**3.1 Ask for Flight number */
                System.out.println("Give me a Flight-Number");
                flightNumber = kreisel.nextLine();
                twoletter = flightNumber.substring(0,2);

                /**3.1.1 Check if it starts with EI+3-numbers,if not but in a message */
                if(!twoletter.equalsIgnoreCase("EI"))
                {
                    System.out.println("The first two characters are not (EI) pls change it");
                }
                else if (flightNumber.length() !=5)
                {
                    System.out.println("The length is not correct fill only 5 characters");

                }
                else if(!(flightNumber.charAt(2)<'9' && flightNumber.charAt(2)>='0'))
                {
                    System.out.println("After (EI) their has to be 3 digits");
                }
                else if(!(flightNumber.charAt(3)<'9' && flightNumber.charAt(3)>='0'))
                {
                    System.out.println("After (EI) their has to be 3 digits");
                }

                else if(!(flightNumber.charAt(4)<'9' && flightNumber.charAt(4)>='0'))
                {
                    System.out.println("After (EI) their has to be 3 digits");
                }
            }while(!twoletter.equalsIgnoreCase("EI")|| flightNumber.length() !=5 || !(flightNumber.charAt(2)<'9' && flightNumber.charAt(2)>'0') || !(flightNumber.charAt(3)<'9' && flightNumber.charAt(3)>'0') || !(flightNumber.charAt(4)<'9' && flightNumber.charAt(4)>'0'));

            do{
                /**3.2 Ask for a day of the week. */
                System.out.println("Which day should that flight take off");
                day = kreisel.nextLine();

                /**3.2.1 Check if the days are valid, if not but in a message */
            }while(!day.equalsIgnoreCase("Monday") && !day.equalsIgnoreCase("Tuesday") && !day.equalsIgnoreCase("Wednesday") && !day.equalsIgnoreCase("Thursday") && !day.equalsIgnoreCase("Friday") && !day.equalsIgnoreCase("Saturday") && !day.equalsIgnoreCase("Sunday"));
            /**3.3 Ask for the destination */
            System.out.println("Where should that flight go: ");
            destination = kreisel.nextLine();

            Flight fli = new Flight(flightNumber, day, destination);
            jet.add(fli);
            System.out.println("Thanks !! ");
        }
    }

    public void loopMenu()
    {
        int number_menu = 0;
        Scanner kreisel = new Scanner(System.in);
        int food= 0;

        boolean check = false;
        do{

            menu();
            number_menu = kreisel.nextInt();
            kreisel.nextLine();

            switch(number_menu)
            {
                case 1:
                    booking();
                    break;

                case 2:
                    cancel();
                    break;

                case 3:
                    fullFlightSchedule();
                    break;

                case 4:
                    passengerWithFlightSchedule();
                    break;

                case 5:
                    foodFlights();
                    break;

                case 6:
                    foodPassenger();
                    break;

                case 7:
                    exit();
                    break;

                default: 

                    System.out.println(" YOU CAN ONLY PICK A NUMBER FROM 1-7");
                    System.out.println("PLEASE BEAR IN MIND");
                    System.out.println("     ");
                    System.out.println("     ");

                    break;
            }

        }  while(number_menu!=7);
    }

    public void menu()
    {
        Scanner kreisel = new Scanner(System.in);

        int number_menu=0;

        System.out.println("............MENU OF KREISELWAY-AIR............");
        System.out.println("1. Making a Booking..");
        System.out.println("2. Cancel a Booking..");
        System.out.println("3. Display Full Flight Schedule..");
        System.out.println("4. Diplay Passengers with Flight Bookings..");
        System.out.println("5. Flight Food Order..");
        System.out.println("6. Food Menu.");
        System.out.println("7. Exit System..  ");
        System.out.println(" ");
        System.out.println("WHICH NUMBER FROM THE MENU DO YOU LIKE TO PRESS ?");

    }

    public void testBooking(){
        Flight f = new Flight("EI123","monday","london");
        Flight sk = new Flight("EI121","Tuesday","Frankfurt");
        Flight md = new Flight("EI121","Wednesday","Brum");
        Flight nd = new Flight("EI121","Thursday","Kreisel");
        Flight kreisel = new Flight("EI121","Friday","Schwanheim");
        jet.add(f);
        jet.add(sk);
        jet.add(md);
        jet.add(nd);
        jet.add(kreisel);
    }

    public void booking()/**4.     Make a booking */
    {
        String destination="";
        String day="";
        int seats = 0;
        String email ="";
        String passName = "";
        String passAddresse = "";
        Scanner kreisel = new Scanner(System.in);
        /**4.1 Ask for the destination */
        System.out.println("Where would you like to go:   ");
        destination = kreisel.nextLine();

        /**4.2 Ask for the day of the week */
        System.out.println("What day would you like to go:   ");
        day = kreisel.nextLine();
        boolean valid = false;
        boolean checkPassengerExist = false;
        Passenger bookPass = null;
        Flight md = null;

        for(Flight i: jet)
        {
            /**4.1.1 check if such destination exists. */
            /**4.2.1 check if such day already exists */
            /**4.3 Check if seats are available */
            if(destination.equalsIgnoreCase(i.getDestination())&& day.equalsIgnoreCase(i.getDay()) && (i.validateSeats()>0 && i.validateSeats()<=10) )
            {
                valid = true;
                /**4.4 Passenger should put in his email address. */
                System.out.println("Great what is your email address? ");
                email = kreisel.nextLine();

                if(passy.isEmpty())
                {
                    System.out.println("There is not bookings so this booking can be created" );
                    System.out.println("Enter your name: " );
                    passName = kreisel.nextLine();

                    System.out.println("Enter your address: " );
                    passAddresse = kreisel.nextLine();

                    bookPass = new Passenger(passName, email, passAddresse);
                    passy.add(bookPass);
                    i.book();
                    bookPass.setFlightAddress(i);
                    System.out.println("Your are booked on this ! " );
                }
                else{

                    for(Passenger gdk: passy)
                    {

                        if(gdk.getEmail().equalsIgnoreCase(email) )
                        {
                            /**4.5 if it matches and the passenger is not booked yet then book them in. */
                            checkPassengerExist = true;
                            md = gdk.getFlightAddress();
                            if (md == null)
                            {

                                gdk.setFlightAddress(i);
                            }
                            else{
                                /**4.6 Check if they are already, then put up a message. */
                                System.out.println("You already have a booking");
                                System.out.println("Sorry i can not book you in");
                            }
                            break;
                        }
                        else{
                            /**4.7 if there is no match and no booking either then create a new passenger. */
                            System.out.println("not match");
                            /**4.7.1 Ask the user for their name. */
                            System.out.println("Enter your name: " );
                            passName = kreisel.nextLine();

                            /**4.7.2 Ask the user for their address. */
                            System.out.println("Enter your address: " );
                            passAddresse = kreisel.nextLine();

                            /**4.7.3 Save passenger details in */
                            bookPass = new Passenger(passName, email, passAddresse, i);
                            /**4.7.4 Once fully booked increase seats in Flight type seatsbooked to +1. */
                            i.book();
                            System.out.println("Your are booked on this ! " );
                        }

                    } 
                    if(checkPassengerExist == false)
                    {
                        passy.add(bookPass);
                    }
                }

            }

        }

        if(valid==false )
        {
            System.out.println("Unfortunately,There is no such flight! ");
        }

    }    

    public void cancel()/**5.    Cancel Booking */
    {
        String email = "";
        String flightNumber ="";
        boolean valid = false;
        Passenger cancelP = null;
        Flight cancelFlight = null;

        Scanner kreisel = new Scanner(System.in);
        if(passy.isEmpty())
        {
            System.out.println("They are no bookings to be cancelled");
        }
        else{
            /**5.1 Ask the passenger for their email address. */
            System.out.println("What is your email address? ");
            email = kreisel.nextLine();

            for(Passenger i : passy)
            {
                /**5.1.1 Check if there is such an email that is connected with a flight. */
                if(i.getEmail().equalsIgnoreCase(email))
                {
                    valid = true;
                    cancelP = i;

                }

            }
            if(cancelP == null)
            {
                System.out.println("that kind of email: "+email+" is not been found" );
                valid = false;
            }
            else{
                cancelFlight = cancelP.getFlightAddress();

                if(cancelFlight==null)
                {
                    System.out.println("The email: "+email+" has no links with a flight");
                }

                do{
                    /**5.2 Flight number should be put in */
                    System.out.println("Enter flight number ");
                    flightNumber = kreisel.nextLine();
                    /**5.2.1 flight number is matched */
                    if(flightNumber.equalsIgnoreCase(cancelFlight.getFlightNumber()))
                    {

                        System.out.println("We found your flight number and we are cancel it out now"); 
                        /**5.3    seatsbooked should be -1 */
                        cancelFlight.cancelBook();
                        /**5.2.1.1 then flight identifier should be set to null */
                        cancelP.setFlightAddress(null);
                    }

                }while(!flightNumber.equalsIgnoreCase(cancelFlight.getFlightNumber()));
                if(!flightNumber.equalsIgnoreCase(cancelFlight.getFlightNumber()))
                {
                    /**5.2.2    if there is not match then put in a message */
                    System.out.println("Invalid flight number");
                }

                System.out.println("The bookin for the passenger "+email+" on flight:"+flightNumber+" is canceled");
            }
        }
    }

    public void fullFlightSchedule() /**6.    Display Full Flight Schedule */
    {
        /** 6.1 Search if there is flights */
        for(Flight schedule : jet)
        {
            /**6.2 display this flight  */
            System.out.println(schedule.toString());
            System.out.println("\n\n");
        }

    }

    public void passengerWithFlightSchedule() /**7.    Display Passenger with Flight Booking */
    {
        /**7.1 Search if there is passenger */
        for(Passenger bdk:passy)
        {
            // passy!=null;
            if( bdk.getFlightAddress()!=null && passy!=null)
            {   
                /**7.2 If passengers has a booking, then display it */
                System.out.println(bdk.toString());

            }
            else
            {
                /**7.3 If not print a message */
                System.out.println("Booking not been found");
            }
        }
    }

    public void foodFlights() /**8.    Flight Food Order */
    {
        String destination = "";
        String day = "";
        int food = 0;
        String answer = "";
        Flight f = null;
        boolean valid = false;
        Scanner kreisel = new Scanner(System.in);
        /**8.1 Ask customer for destination and day */
        System.out.println(" Which Flight destination would you like to have food on:  ");
        destination = kreisel.nextLine();

        System.out.println("Which day is your prefered destination   ");
        day = kreisel.nextLine();

        for(Flight foods: jet)
        {
            /**8.1.1 search if there is such destination with day */
            if(destination.equalsIgnoreCase(foods.getDestination())&& day.equalsIgnoreCase(foods.getDay()))
            {
                valid = true;
                System.out.println("Perfect! ");

                System.out.println("Would you like to have food in your destination ?");
                answer = kreisel.nextLine();

                
                /**8.2 Ask user if they would like to have food (Yes or NO) */
                if(answer.equalsIgnoreCase("yes"))
                {
                    System.out.println("Perfect! ");
                    System.out.println("Good choice :) ");
                    System.out.println("We are now booking it.");
                    System.out.println("We booked it succesfully");
                    foods.addFood();

                }
                else if(answer.equalsIgnoreCase("no"))
                {
                    System.out.println("Very sorry to hear! ");
                }
                else
                {
                    System.out.println("Please only say YES or NO ");
                }

            }
        }
        if(valid==false)
        {
            System.out.println("There is not such a Flight.Please make sure you put in the corect details!"); 

        }

    }

    public void foodPassenger()/**9.    Food Menu */
    {
        String[] menu = {"Water", "Spirite", "Fanta","Spaghetti with meatsballs","Rice & Peas"};
        Double[] price = {1.50, 2.50, 3.00,12.50,13.00};

        int selection = 0;
        double total = 0.0;
        int quantity = 0;

        Scanner kreisel = new Scanner(System.in);

        /**9.1 Print a menu */
        for(int i=0; i <menu.length; i++)
        {
            System.out.println((i+1)+". "+menu[i]+"-"+"$"+price[i]);
        }
        /**9.2 select  food */
        do{
            System.out.println("Enter your menu number(1-"+menu.length+")");
            selection = kreisel.nextInt();
        }while(selection>5 && selection<0 );

        System.out.println("Enter the quantity");
        quantity = kreisel.nextInt();

        /**9.3 calculate and display total */
        switch(selection){
            case 1: total = price[0] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break;

            case 2: total = price[1] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break; 

            case 3: total = price[2] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break;

            case 4: total = price[3] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break;

            case 5: total = price[4] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break;

            case 6: total = price[5] * quantity;
                System.out.println("Your final total is: "+total+" $");
                break;

            default: System.out.println("Invalid selection");
                System.out.println("Item not been found");
                return ;
        }

    }

    public boolean exit() /**10.    Exit */
    {
        boolean check = true;
        /** 10.1 Print a message */
        System.out.println(" Thanks for the visit");
        System.out.println(" I hope you are coming back soon  !!");
        return check;

    }

    public Flight searchForFlight(String destination, String day)
    {
        Flight f = null;
        for(Flight search : jet)
        {
            if(destination.equalsIgnoreCase(search.getDestination()) && day.equalsIgnoreCase(search.getDay()) && (search.validateSeats()>0 && search.validateSeats()<=10))
            {
                f = search;
                return f;

            }
        }
        return null;
    }

    public Passenger searchForPassenger(String email)
    {
        Passenger f = null;
        for(Passenger search : passy)
        {
            if(email.equalsIgnoreCase(search.getEmail()) )
            {
                f = search;
                return f;

            }
        }
        return null;
    }
    
    public static void main(String[]args)
    {
        System.out.println("\f");
        new DriverClass();
    }
}
