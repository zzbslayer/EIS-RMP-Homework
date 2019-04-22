package com.example.demo.Controller;

import com.example.demo.Utility.Geography.Geohash;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Geo")
public class GeoController {
    @GetMapping("")
    public String geohash(@RequestParam long longitude, @RequestParam long latitude){
        return Geohash.geohash(longitude, latitude, Geohash.DEFAULT_LENGTH);
    }
}
