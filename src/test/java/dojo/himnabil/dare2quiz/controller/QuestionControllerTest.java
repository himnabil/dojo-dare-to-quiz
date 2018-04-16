package dojo.himnabil.dare2quiz.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import static org.junit.Assert.*;

public class QuestionControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = new MockMvcBuilder().build();
    }

    @Test
    public void askQuestion() {

    }
}