package com.example.demo.service;

import com.example.demo.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    String appRunType;

    public GoodsService(@Value("${app.run.type:local}") String appRunType) {
        this.appRunType = appRunType;
    }

    public GoodsDto getGoodsNamebygoodsNo(String goodsNo) {

        GoodsDto goodsDto = GoodsDto.builder()
                .goodsNo(goodsNo)
                .goodsName(appRunType + "-" + goodsNo)
                .build();
        return goodsDto;
    }
}
