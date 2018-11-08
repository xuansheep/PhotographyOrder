package com.xuanss.pgo.admin.service;

import com.xuanss.pgo.admin.domain.PgoTime;

import java.util.List;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.service
 * @data 2018-11-5 21:27
 */

public interface TimeService {

    /**
     * 查询预订时间列表
     */
    List<PgoTime> findAllTime();
}
