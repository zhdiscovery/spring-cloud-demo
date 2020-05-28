package com.zh.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "\t" + "paymentInfo_OK,id: " + id;
    }

    /**
     * 报错的方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int time = 2;
//        int error = 1 / 0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "\t" + "paymentInfo_Timeout,id: " + id + "\t耗时： " + time + "s";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "\t" + "8001系统繁忙，请稍后再试,id: " + id;
    }

}
