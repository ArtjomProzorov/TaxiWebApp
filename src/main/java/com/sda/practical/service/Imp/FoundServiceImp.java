package com.sda.practical.service.Imp;

import com.sda.practical.dto.FoundItemDto;
import com.sda.practical.dto.LostItemDto;
import com.sda.practical.model.Driver;
import com.sda.practical.model.FoundItem;
import com.sda.practical.model.LostItem;
import com.sda.practical.model.Passenger;
import com.sda.practical.repository.FoundRepository;
import com.sda.practical.repository.LostRepository;
import com.sda.practical.service.FoundService;
import com.sda.practical.service.LostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoundServiceImp implements FoundService {

    @Autowired
    FoundRepository foundRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public FoundItemDto foundItem(FoundItemDto foundItemDto) {
        FoundItem foundItem = modelMapper.map(foundItemDto, FoundItem.class);
         foundRepository.save(foundItem);
         return foundItemDto;
    }

    @Override
    public List<FoundItemDto> getFoundItem() {
        List<FoundItem> foundItemList = foundRepository.findAll();
        return foundItemList.stream().map(found -> modelMapper.map(found, FoundItemDto.class)).collect(Collectors.toList());
    }
    }


