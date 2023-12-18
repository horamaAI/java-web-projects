package com.myapplications.conferencedemo.controllers;

import com.myapplications.conferencedemo.models.Speaker;
import com.myapplications.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // return status 201
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        // also need to check for children records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker session) {
        // it's a put, so expecting ALL attributes to be passed in, and ALL will be updated. Patch is the one that edits part of the elements
        // TODO add validation that all attributes are passed in, otherwise return status 400 bad payload
        Speaker existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSpeaker, "speaker_id"); // 3rd argument is to ignore property "speaker_id" when copying
        return speakerRepository.saveAndFlush(existingSpeaker);

    }


}
