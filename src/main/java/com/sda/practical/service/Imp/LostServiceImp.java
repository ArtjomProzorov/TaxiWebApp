package com.sda.practical.service.Imp;

import com.sda.practical.dto.LostItemDto;
import com.sda.practical.model.LostItem;
import com.sda.practical.repository.LostRepository;

import com.sda.practical.service.LostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LostServiceImp implements LostService {

    @Autowired
    LostRepository lostRepository;

    @Autowired
    ModelMapper modelMapper;




    @Override
    public LostItemDto lostItemSubmit(LostItemDto lostItemDto) {
        LostItem lostItem = modelMapper.map(lostItemDto, LostItem.class);
        lostRepository.save(lostItem);
        return lostItemDto;
    }

    @Override
    public List<LostItemDto> getLostItem() {
        List<LostItem> lostServiceList = lostRepository.findAll();
        return lostServiceList.stream().map(user -> modelMapper.map(user, LostItemDto.class)).collect(Collectors.toList());
    }
}
