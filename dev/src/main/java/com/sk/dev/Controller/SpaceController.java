package com.sk.dev.Controller;

import com.sk.dev.Service.SpaceFacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceController {

    @Autowired
    private SpaceFacts spaceFacts;

    @GetMapping("/spacefact")
    public String getSpaceFact() {
        return spaceFacts.getAstronomyPictureOfDay();
    }
}
