package com.sda.practical.service;

import com.sda.practical.dto.LostItemDto;
import com.sda.practical.model.LostItem;

import java.util.List;


public interface LostService {

    LostItemDto lostItemSubmit(LostItemDto lostItemDto);

    List<LostItemDto> getLostItem();

}
