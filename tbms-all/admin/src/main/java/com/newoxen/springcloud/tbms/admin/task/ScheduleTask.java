package com.newoxen.springcloud.tbms.admin.task;


import com.newoxen.springcloud.tbms.admin.controller.SysUserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务演示
 */


@Component
@EnableScheduling
public class ScheduleTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    @Scheduled(cron = "3 0 0  * * ?")
    public void taskAutoLog(){
        LOGGER.info("【TASK】taskAutoLog======>live on......");
    }

    @Scheduled(initialDelay = 1000*10, fixedRate = 1000*3)
    public void taskStartLog(){
        LOGGER.info("【TASK】taskStartLog======>live on......");
    }


}
