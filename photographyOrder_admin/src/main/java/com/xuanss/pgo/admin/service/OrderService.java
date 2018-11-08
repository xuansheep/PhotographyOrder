package com.xuanss.pgo.admin.service;

import com.xuanss.pgo.admin.domain.PgoOrder;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.service
 * @data 2018-11-6 12:09
 */

public interface OrderService {

    /**
     * 保存预订订单信息
     */
    void saveOrder(PgoOrder order);
}
