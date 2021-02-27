package com.lemonzuo.controller;

import com.lemonzuo.mapper.LeafMapper;
import com.lemonzuo.model.Leaf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

/**
 * @author LemonZuo
 * @create 2020-03-28 13:49
 */
@RestController
public class LeafController {
    @Autowired
    private LeafMapper mapper;

    @GetMapping("getLeafId")
    public Leaf createNewLeafId() {
        Leaf leaf = new Leaf();
        RestTemplate template = new RestTemplate();
        String url = "http://106.13.199.192:8082/leaf/api/snowflake/get/leafId";
        String leafIdStr = template.getForObject(url, String.class);
        BigInteger leafId = new BigInteger(leafIdStr);
        leaf.setLeafId(leafId);
        leaf.setType('0');
        leaf.setLeafKey("leafId");
        mapper.insertLeaf(leaf);
        return leaf;
    }
}
