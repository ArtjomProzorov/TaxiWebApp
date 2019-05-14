package com.sda.practical.service.Imp;

import com.sda.practical.dto.DriverDto;
import com.sda.practical.exceptions.DriverLicenseAlreadyInUse;
import com.sda.practical.model.Driver;
import com.sda.practical.repository.DriverRepository;
import com.sda.practical.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements DriverService {

    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DriverServiceImp(DriverRepository driverRepository, ModelMapper modelMapper) {
        this.driverRepository = driverRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Driver isActive(Long id) {
        Driver driver = driverRepository.getOne(id);
        driver.setActive(true);

        return driverRepository.save(driver);
    }

    @Override
    public Driver deActive(Long id) {
        Driver driver = driverRepository.getOne(id);
        driver.setActive(false);

        return driverRepository.save(driver);
    }

    @Override
    public Driver saveDriver(DriverDto driverDto) throws DriverLicenseAlreadyInUse {
        Driver driver = modelMapper.map(driverDto,Driver.class);
        Driver driver1 = driverRepository.findByDrivingLicense(driverDto.getLicense());

        if(driver1 == null){

            return driverRepository.save(driver);

        }else throw new DriverLicenseAlreadyInUse(driver1.getLicense());


    }

}
