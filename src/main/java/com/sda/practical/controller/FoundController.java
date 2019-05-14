package com.sda.practical.controller;


import com.sda.practical.dto.FoundItemDto;
import com.sda.practical.service.FoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/item-found",consumes = {MediaType.APPLICATION_JSON_VALUE })
public class FoundController {

    @Autowired
    final private FoundService foundService;

    public FoundController(FoundService foundService) {
        this.foundService = foundService;
    }

    @PostMapping(value = "/add")
    public FoundItemDto addFoundItem(@RequestBody FoundItemDto foundItemDto) {
        return foundService.foundItem(foundItemDto);
    }




}
