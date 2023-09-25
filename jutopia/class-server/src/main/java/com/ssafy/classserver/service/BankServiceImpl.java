package com.ssafy.classserver.service;

import com.ssafy.classserver.dto.ProductDto;
import com.ssafy.classserver.jpa.entity.SavingProductsEntity;
import com.ssafy.classserver.jpa.repository.ClassRoomRepository;
import com.ssafy.classserver.jpa.repository.SavingProductsRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
public class BankServiceImpl implements BankService{

    ClassRoomRepository classRoomRepository;
    SavingProductsRepository savingProductsRepository;
    ModelMapper mapper;

    @Autowired
    public BankServiceImpl(ClassRoomRepository classRoomRepository, SavingProductsRepository savingProductsRepository) {
        this.classRoomRepository = classRoomRepository;
        this.savingProductsRepository = savingProductsRepository;
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        SavingProductsEntity productEntity = mapper.map(product, SavingProductsEntity.class);

        savingProductsRepository.save(productEntity);

        return new ModelMapper().map(productEntity, ProductDto.class);

    }
}
