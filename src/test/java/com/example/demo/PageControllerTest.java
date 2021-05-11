package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PagesController.class)
public class PageControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testHello() throws Exception{

        RequestBuilder request = get("/hello");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }
    @Test
    public void checkPi() throws  Exception{
        RequestBuilder request = get("/math/pi");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.14159"));
    }
}
