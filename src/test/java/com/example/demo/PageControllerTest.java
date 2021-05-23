package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@WebMvcTest(PagesController.class)
public class PageControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHello() throws Exception {

        RequestBuilder request = get("/json/hello");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void checkPi() throws Exception {
        RequestBuilder request = get("/json/math/pi");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.14159"));
    }

    @Test
    void checkPersonName() throws Exception {
        RequestBuilder request = get("/json/person");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));


    }

    @Test
    void checkFlight() throws Exception {
        RequestBuilder request = get("/json/flights");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(10)))
                .andExpect(jsonPath("$[0].destination", is("London")));


    }


    @Test
    public void testFlightAsList() throws Exception {
        RequestBuilder request = get("/json/flightAsList");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tickets[0].passenger.firstName"
                        , is("Some name")));

    }

    @Test
    public void testJsonObjectArray() throws Exception {
        RequestBuilder request = get("/json/flight1");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets[0].passenger.firstName"
                        , is("Some name")));
//
//        //.andExpect(jsonPath("$[0].passenger.firstName", is("Some other name")));
//    }

    }
}



