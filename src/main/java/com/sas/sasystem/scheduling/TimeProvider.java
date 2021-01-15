package com.sas.sasystem.scheduling;

import com.sas.sasystem.service.IIndicatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class TimeProvider {

    private static final Logger log = LoggerFactory.getLogger(TimeProvider.class);
    @Autowired
    private IIndicatorService indicatorService;

    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
    private static final long PERIOD_SECOND = 1000;

    public TimeProvider() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date date = calendar.getTime();
//        System.out.println(date);
//        System.out.println("before 方法比较："+date.before(new Date()));
        if (date.before(new Date())) {
            date = this.addDay(date, 1);
        }

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        indicatorService.update();
                        log.info("update");
                    }
                }, date, PERIOD_DAY
        );
    }

    public Date addDay(Date date, int num) {
        Calendar startDay = Calendar.getInstance();
        startDay.setTime(date);
        startDay.add(Calendar.DAY_OF_MONTH, num);
        return startDay.getTime();
    }

    @PostConstruct
    public void time() {
        log.info("TimeProvider START");
        new TimeProvider();
    }
}
