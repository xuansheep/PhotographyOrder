package com.xuanss.pgo.admin.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.domain
 * @data 2018-11-5 21:39
 */
@Entity
@Table(name = "pgo_Time")
public class PgoTime implements Serializable {

    @Id
    private Long id;
    private String time;
    private int isOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(int isOrder) {
        this.isOrder = isOrder;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", isOrder='" + isOrder + '\'' +
                '}';
    }
}
