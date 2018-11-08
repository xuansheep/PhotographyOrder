package com.xuanss.pgo.admin.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.domain
 * @data 2018-11-6 12:01
 */
@Entity
@Table(name = "pgo_Order")
public class PgoOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobilePhone;
    private String photoObj;
    private String remarks;
    private Long tId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhotoObj() {
        return photoObj;
    }

    public void setPhotoObj(String photoObj) {
        this.photoObj = photoObj;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", photoObj='" + photoObj + '\'' +
                ", remarks='" + remarks + '\'' +
                ", tId=" + tId +
                '}';
    }
}
