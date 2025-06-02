package com.sk.dev.Controller;

import com.sk.dev.Service.SpaceFacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaceController {

    @Autowired
    private SpaceFacts spaceFacts;

    @GetMapping("/spacefact")
    public String getSpaceFact(Model model) {
        String url = spaceFacts.getAstronomyPictureOfDay();
        model.addAttribute("imageUrl", url);
        model.addAttribute("title", "Astronomy Pic of the Day");
        return "image-page";
    }
}
