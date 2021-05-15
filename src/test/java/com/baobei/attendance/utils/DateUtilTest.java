package com.baobei.attendance.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tcg
 * @date 2021/5/13
 */
class DateUtilTest {

    @Test
    void getPreDaysStartEndDate() throws ParseException, InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            threads.add(new Thread(() -> {
                try {
                    for (int i1 = 0; i1 < 10; i1++) {
                        System.out.println("前" + i1 + "天：" + DateUtil.getPreDaysStartEndDate(i1));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }));
        }
        System.out.println("双线程执行: ");
        ExecutorService exec2 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 6; i++) {
            exec2.execute(threads.get(i));
        }
        Thread.sleep(5000);
        exec2.shutdown();
    }


    @Test
    void getDiffDays() throws ParseException {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pre = simpleFormatter.parse("2021-05-15 12:00:00");
        System.out.println(DateUtil.getDiffDays(pre, new Date()));
    }

    @Test
    void listTest() {
//        List<Long> longs = new ArrayList<>(7);
//        System.out.println(longs.size());
        Long[] longs = new Long[7];
        System.out.println(longs.length);
    }
}