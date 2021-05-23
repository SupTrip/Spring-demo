package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/json")

public class PagesController {

    @GetMapping("/hello")

    public String Hello() {

        return "Hello World";
    }

    @GetMapping("/math/pi")
    public String PiVal() {

        return "3.14159";
    }


    @GetMapping("/flights")
    public List<Flight> getFlight() {
        Flight flight1 = new Flight();
        flight1.setId(10);
        flight1.setDestiation("London");
        Flight.PersonB  personB1 = new Flight.PersonB();
        personB1.setName("hihihi");

        Flight.PersonB  personB2 = new Flight.PersonB();
        personB2.setName("byebyebye");

        List<Flight.PersonB> myPersonList = new ArrayList<Flight.PersonB>();
        myPersonList.add(personB1);
        myPersonList.add(personB2);
        flight1.setPassenger(myPersonList);


        flight1.setDepartsOn(new Date(2014 - 1900, 5, 8));
        Flight flight2 = new Flight();
        flight2.setId(59);
        flight2.setDestiation("Tokyo");
        flight2.setDepartsOn(new Date(2014 - 1900, 5, 8));
        flight2.setPassenger(myPersonList);


        return Arrays.asList(flight1, flight2);

    }

    @GetMapping("/flightAsList")
    public List<FlightAsList> getFlightAsList(){
        FlightAsList flightAsList1 = new FlightAsList();
        FlightAsList flightAsList2 = new FlightAsList();
        FlightAsList.Ticket.Passenger myPassenger = new FlightAsList.Ticket.Passenger();
        myPassenger.firstName = "Some name";
        myPassenger.lastName = "Some other name";
        FlightAsList.Ticket myTicket = new FlightAsList.Ticket();
        myTicket.setPassenger(myPassenger);
        myTicket.setPrice(200);
        List<FlightAsList.Ticket> myTickets = new ArrayList<FlightAsList.Ticket>();
        myTickets.add(myTicket);
        flightAsList1.setDeparts(new Date());
        flightAsList1.setTickets(myTickets);

        FlightAsList.Ticket.Passenger myPassenger1 = new FlightAsList.Ticket.Passenger();
        myPassenger1.firstName = "Some other name";
        FlightAsList.Ticket myTicket1 = new FlightAsList.Ticket();
        myTicket1.setPassenger(myPassenger1);
        myTicket1.setPrice(400);
        List<FlightAsList.Ticket> myTickets1 = new ArrayList<FlightAsList.Ticket>();
        myTickets1.add(myTicket1);
        flightAsList2.setDeparts(new Date());
        flightAsList2.setTickets(myTickets1);




        return Arrays.asList(flightAsList1,flightAsList2);
    }

    @GetMapping("/flight1")
    public Flight1 getFlight1(){

        Flight1 flight1 = new Flight1();

        Flight1.Ticket.Passenger myPassenger = new Flight1.Ticket.Passenger();
        myPassenger.firstName = "Some name";
        myPassenger.lastName = "Some other name";

        Flight1.Ticket myTicket = new Flight1.Ticket();
        myTicket.setPassenger(myPassenger);
        myTicket.setPrice(200);
        List<Flight1.Ticket> myTickets  = new ArrayList<Flight1.Ticket>();

        myTickets.add(myTicket);

        flight1.setDeparts(new Date());
        flight1.setTickets(myTickets);
        return flight1;

    }

    @GetMapping("/person")
    public List<Person> getPerson() {
        Person person1 = new Person();
        person1.firstName = "Dwayne";
        person1.lastName = "Johnson";

        System.out.println("getting the json" + person1.firstName + person1.lastName);
        Person person2 = new Person();
        person2.firstName = "Kriti";
        person2.lastName = "sharma";

        return Arrays.asList(person1, person2);

    }





    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }


    static class Flight {
        private int id;
        private String destination;
        private Date departsOn;
        private List<PersonB> passenger;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestiation(String destination) {
            this.destination = destination;
        }

        @JsonFormat(pattern = "yyyy-MM-dd")
        public Date getDepartsOn() {
            return departsOn;
        }

        public void setDepartsOn(Date departsOn) {
            this.departsOn = departsOn;

        }

        public List<PersonB> getPassenger() {
            return passenger;
        }

        public void setPassenger(List<PersonB> passenger) {
            this.passenger = passenger;
        }

        static class PersonB {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }


        static class Flight1{
            private Date departs;
            private List<Ticket> tickets;
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
            public Date getDeparts() {
                return departs;
            }

            public void setDeparts(Date departs) {
                this.departs = departs;
            }

            public List<Ticket> getTickets() {
                return tickets;
            }

            public void setTickets(List<Ticket> tickets) {
                this.tickets = tickets;
            }
            static class Ticket{
                private  Passenger passenger;
                private int price;

                public Passenger getPassenger() {
                    return passenger;
                }

                public void setPassenger(Passenger passenger) {
                    this.passenger = passenger;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                private static class Passenger {
                   private String firstName;
                   private String lastName;

                    public String getFirstName() {
                        return firstName;
                    }

                    public void setFirstName(String firstName) {
                        this.firstName = firstName;
                    }

                    public String getLastName() {
                        return lastName;
                    }

                    public void setLastName(String lastName) {
                        this.lastName = lastName;
                    }
                }

            }



        }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class FlightAsList{
        private Date departs;
        private List<Ticket> tickets;
          @JsonFormat (pattern = "yyyy-MM-dd HH:mm")
            public Date getDeparts() {
                return departs;
            }

            public void setDeparts(Date departs) {
                this.departs = departs;
            }

            public List<Ticket> getTickets() {
                return tickets;
            }

            public void setTickets(List<Ticket> tickets) {
                this.tickets = tickets;
            }

            private static class Ticket {
              private Passenger passenger;
              private int price;

                public Passenger getPassenger() {
                    return passenger;
                }

                public void setPassenger(Passenger passenger) {
                    this.passenger = passenger;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }
                @JsonInclude(JsonInclude.Include.NON_NULL)

                static class Passenger {
                    private String firstName;
                    private String lastName;

                    public String getFirstName() {
                        return firstName;
                    }

                    public void setFirstName(String firstName) {
                        this.firstName = firstName;
                    }

                    public String getLastName() {
                        return lastName;
                    }

                    public void setLastName(String lastName) {
                        this.lastName = lastName;
                    }
                }
            }
        }

    }








