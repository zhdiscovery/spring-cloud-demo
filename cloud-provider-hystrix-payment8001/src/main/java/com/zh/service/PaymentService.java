package com.zh.service;

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
    public String paymentInfo_Timeout(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "\t" + "paymentInfo_Timeout,id: " + id + "\t耗时： " + time + "s";
    }

}
