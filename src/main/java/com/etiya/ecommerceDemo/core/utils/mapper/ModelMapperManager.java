package com.etiya.ecommerceDemo.core.utils.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper getMapper() {
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setAmbiguityIgnored(true);
        return modelMapper;
    }
}
