package com.xuanss.pgo.admin.utils;

import com.xuanss.pgo.admin.dao.TimeRepository;
import com.xuanss.pgo.admin.domain.PgoTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.utils
 * @data 2018-11-6 23:12
 */
@Component
public class TimeTask {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定时查询预订时段订单数，将剩余数存入redis中
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void pushTime(){
        //System.out.println(new Date());
        Specification<PgoTime> specification = new Specification<PgoTime>() {
            @Override
            public Predicate toPredicate(Root<PgoTime> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Path<Object> isOrder = root.get("isOrder");
                Predicate predicate = criteriaBuilder.notEqual(isOrder, "0");
                return predicate;
            }
        };
        List<PgoTime> timeList = timeRepository.findAll(specification);
        for (PgoTime pgoTime : timeList) {

            TimeId2RediaQueue(pgoTime);

        }
    }

    private void TimeId2RediaQueue(PgoTime pgoTime) {
        //先清空redis的预订次数信息，再重新存入队列
        redisTemplate.delete("time"+pgoTime.getId());
        for (int i = 0; i < pgoTime.getIsOrder(); i++) {
            redisTemplate.boundListOps("time"+pgoTime.getId()).leftPush(pgoTime.getId());
        }
    }

}
