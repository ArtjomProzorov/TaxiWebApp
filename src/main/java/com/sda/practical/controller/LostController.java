package com.sda.practical.controller;


import com.sda.practical.dto.LostItemDto;
import com.sda.practical.model.LostItem;
import com.sda.practical.service.LostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lost-item")
public class LostController {

    @Autowired
    final private LostService lostService;

    public LostController(LostService lostService) {
        this.lostService = lostService;
    }

    @PostMapping(value = "/add")
    public LostItemDto addLostItem(@RequestBody LostItemDto lostItemDto) {
        return lostService.lostItemSubmit(lostItemDto);
    }

}
