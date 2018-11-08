package com.xuanss.pgo.admin.utils;

import java.io.Serializable;

/**
 * @author xuhang
 * @package com.xuanss.pgo.admin.utils
 * @data 2018-11-6 13:54
 */

public class Result implements Serializable {

    private String message;
    private boolean success;

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result( boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
