package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GoodsDto;
import com.example.demo.service.GoodsService;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsRestController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{goodsNo}")
    public ResponseEntity<GoodsDto> getUserByuserNo(@PathVariable(name = "goodsNo") String goodsNo) {
        GoodsDto goodsDto = goodsService.getGoodsNamebygoodsNo(goodsNo);
        return ResponseEntity.ok(goodsDto);
    }
}
