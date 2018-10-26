package com.example.schedule.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AsyncService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *  周一至周五 每两秒执行一次任务
     */
    @Scheduled(cron = "*/2 * * * * MON-FRI")
    public void testAsyncJob(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
