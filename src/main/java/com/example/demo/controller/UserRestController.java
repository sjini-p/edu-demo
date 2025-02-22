package com.example.demo.controller;

import com.example.demo.dto.GoodsDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserWithGoodsDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * packageName    : com.example.demo.controller
 * fileName       : UserRestController
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userNo}")
    public ResponseEntity<UserDto> getUserByuserNo(@PathVariable(name = "userNo") String userNo) {
        UserDto userDto = userService.getUserByuserNo(userNo);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/withGoods/{userNo}")
    public ResponseEntity<UserWithGoodsDto> getWithGoodsByUserNo(@PathVariable(name = "userNo") String userNo) {
        
        String userName = "User-" + userNo;

        String goodsDomain = "http://k8s-edu-goods-service.k8s-edu-goods.svc.cluster.local/api/v1/goods/";
        //String goodsDomain = "http://localhost:8080/api/v1/goods/";
        String goodsUrl = goodsDomain + userNo;

        RestTemplate restTemplate = new RestTemplate();

        GoodsDto goodsDto = restTemplate.getForObject(goodsUrl, GoodsDto.class);

        UserWithGoodsDto userWithGoodsDto = new UserWithGoodsDto();
        userWithGoodsDto.setUserNo(userNo);
        userWithGoodsDto.setUserName(userName);
        userWithGoodsDto.setGoodsNo(goodsDto.getGoodsNo());
        userWithGoodsDto.setGoodsName(goodsDto.getGoodsName());

        return ResponseEntity.ok(userWithGoodsDto);
    }
}
