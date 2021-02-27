package com.lemonzuo.config;

import com.lemonzuo.quartz.LeafIdJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LemonZuo
 * @create 2020-03-28 15:53
 */
@Configuration
public class QuartzConf {
    @Bean
    public JobDetail leafIdJobDetail(){
        JobDetail jobDetail = JobBuilder.newJob(LeafIdJob.class)
                .withIdentity("leafIdJob","leafIdJobGroup")
                .storeDurably()
                .build();
        return jobDetail;
    }
    @Bean
    public Trigger leafIdTrigger(){
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(leafIdJobDetail())
                .withIdentity("leafIdTrigger","leafIdTriggerGroup")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/15 * * * * ?"))
                .build();
        return trigger;
    }
}
