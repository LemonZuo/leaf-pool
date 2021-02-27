package com.lemonzuo.mapper;

import com.lemonzuo.model.Leaf;
import org.springframework.stereotype.Repository;

/**
 * @author LemonZuo
 * @create 2020-03-28 13:46
 */
@Repository
public interface LeafMapper {
    /**
     * 新增
     * @param leaf
     */
    void insertLeaf(Leaf leaf);
}
