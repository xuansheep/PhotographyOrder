package com.xuanss.pgo.admin.service.impl;

import com.xuanss.pgo.admin.dao.TimeRepository;
import com.xuanss.pgo.admin.domain.PgoTime;
import com.xuanss.pgo.admin.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.service.impl
 * @data 2018-11-5 21:41
 */
@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    /**
     * 查询预订时间列表
     * @return
     */
    @Override
    public List<PgoTime> findAllTime() {
        return timeRepository.findAll();
    }
}
