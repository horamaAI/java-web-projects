package com.myapplications.conferencedemo.controllers;

import com.myapplications.conferencedemo.models.Session;
import com.myapplications.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        System.out.println("Hello world");
        List<Session> sessions = sessionRepository.findAll();
        System.out.println("Size response : "+sessions.size());
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // return status 201
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        // also need to check for children records before deleting, so check cascading howto
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // it's a put, so expecting ALL attributes to be passed in, and ALL will be updated. Patch is the one that edits part of the elements
        // TODO add validation that all attributes are passed in, otherwise return status 400 bad payload
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id"); // 3rd argument is to ignore property "session_id" when copying, otherwise id will be updated with null
        return sessionRepository.saveAndFlush(existingSession);
    }

}
