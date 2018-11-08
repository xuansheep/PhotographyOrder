package com.xuanss.pgo.admin.service.impl;

import com.xuanss.pgo.admin.dao.OrderRepository;
import com.xuanss.pgo.admin.dao.TimeRepository;
import com.xuanss.pgo.admin.domain.PgoOrder;
import com.xuanss.pgo.admin.domain.PgoTime;
import com.xuanss.pgo.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.service.impl
 * @data 2018-11-6 12:10
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存预订订单信息
     * @param order
     * @return
     */
    @Override
    public void saveOrder(PgoOrder order){
        Object timeId = redisTemplate.boundListOps("time"+order.gettId()).rightPop();

        if (timeId==null){
            throw new RuntimeException("该时段已被预订");
        }else {
            //保存订单信息
            orderRepository.save(order);

            //修改时间段为已预定
            PgoTime pgoTimeInfo = timeRepository.findTimeById(order.gettId());
            pgoTimeInfo.setIsOrder(pgoTimeInfo.getIsOrder()-1);
            timeRepository.save(pgoTimeInfo);
        }
    }
}
