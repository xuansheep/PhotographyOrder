package com.xuanss.pgo.admin.controller;

import com.xuanss.pgo.admin.domain.PgoOrder;
import com.xuanss.pgo.admin.domain.PgoTime;
import com.xuanss.pgo.admin.service.OrderService;
import com.xuanss.pgo.admin.service.TimeService;
import com.xuanss.pgo.admin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.controller
 * @data 2018-11-5 21:21
 */
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private TimeService adminService;
    @Autowired
    private OrderService orderService;


    /**
     * 查询预定时间列表
     */
    @RequestMapping(value = "allTime")
    public List<PgoTime> findAllTime(){
        List<PgoTime> pgoTimeList = adminService.findAllTime();
        return pgoTimeList;
    }

    /**
     * 保存预定订单信息
     */
    @RequestMapping(value = "saveOrder", method = RequestMethod.POST)
    public Result saveOrder(@RequestBody PgoOrder order){
        try {
            orderService.saveOrder(order);
            return new Result(true,"预定成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"啊哦~ 出了点错误，请刷新重试。");
    }
}
