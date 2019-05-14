package com.sda.practical.service;

import com.sda.practical.dto.FoundItemDto;
import com.sda.practical.model.FoundItem;

import java.util.List;

public interface FoundService {

    FoundItemDto foundItem(FoundItemDto foundItemDto);

    List<FoundItemDto> getFoundItem();
}
