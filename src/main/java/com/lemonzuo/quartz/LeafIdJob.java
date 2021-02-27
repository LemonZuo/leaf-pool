package com.lemonzuo.quartz;

import com.lemonzuo.mapper.LeafMapper;
import com.lemonzuo.model.Leaf;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

/**
 * @author LemonZuo
 * @create 2020-03-28 15:50
 *
 * 获取LeafId定时任务
 */
public class LeafIdJob extends QuartzJobBean {
    private LeafMapper mapper;

    @Autowired
    public void setMapper(LeafMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Leaf leaf = new Leaf();
        RestTemplate template = new RestTemplate();
        String url = "http://106.13.199.192:8082/leaf/api/snowflake/get/leafId";
        String leafIdStr = template.getForObject(url, String.class);
        BigInteger leafId = new BigInteger(leafIdStr);
        leaf.setLeafId(leafId);
        leaf.setType('0');
        leaf.setLeafKey("leafId");
        mapper.insertLeaf(leaf);
    }
}
