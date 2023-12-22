package com.myapplications.conferencedemo.controllers;

import com.myapplications.conferencedemo.models.Session;
import com.myapplications.conferencedemo.repositories.SessionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@DisplayName("Session controller validation unit test")
@AutoConfigureMockMvc
class SessionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SessionsController sessionsController;

    @MockBean
    private SessionRepository sessionRepository;

    //@Test
    //void contextLoads() {
    //}

    @Test
    public void allowSessionCreationTest() {

        Session session = new Session(){{
            setSession_name("A session name for testing purpose");
            setSession_description("A short dummy session");
            setSession_length(30);
        }};

        when(sessionsController.create(session)).thenReturn(session);

//        mockMvc.perform(post("/api/v1/sessions")).contentType(MediaType.APPLICATION_JSON)
//                .content(asJson)
//
//        Session sessionResult = ;
//
        assertThat(session).isNotNull();
        assertEquals("A short dummy session", session.getSession_description());

    }

}