package com.tts.mapsapp.controller;


import com.tts.mapsapp.model.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tts.mapsapp.service.MapService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class MapController {

    @Autowired
    private MapService mapService;

    public MapController(MapService mapService)
    {
        this.mapService = mapService;
    }

    @GetMapping("/home")
    public String getDefaultMap(Model model) {
        Location location = new Location();
        location.setCity("Shreveport");
        location.setState("Louisiana");
        mapService.addCoordinates(location);
        System.out.println(location);
        log.info("This is my location: {}", location);
        model.addAttribute(new Location());
        return "index.html";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
}
