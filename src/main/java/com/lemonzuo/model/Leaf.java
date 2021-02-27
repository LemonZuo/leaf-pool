package com.lemonzuo.model;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author LemonZuo
 * @create 2020-03-28 14:48
 */
@Data
public class Leaf {
    private BigInteger id;
    private BigInteger leafId;
    private char type;
    private char isUse;
    private String leafKey;
}
