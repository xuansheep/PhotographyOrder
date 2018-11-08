package com.xuanss.pgo.admin.dao;

import com.xuanss.pgo.admin.domain.PgoTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.dao
 * @data 2018-11-5 21:30
 */

public interface TimeRepository extends JpaRepository<PgoTime, Long>, JpaSpecificationExecutor {

    PgoTime findTimeById(Long id);
}
