package com.xuanss.pgo.admin.dao;

import com.xuanss.pgo.admin.domain.PgoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.dao
 * @data 2018-11-6 12:10
 */

public interface OrderRepository extends JpaRepository<PgoOrder, Long> {
}
