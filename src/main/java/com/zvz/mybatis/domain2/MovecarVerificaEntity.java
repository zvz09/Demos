package com.zvz.mybatis.domain2;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by lilipo on 2017/4/25.
 * 2、	验证码表
 */
public class MovecarVerificaEntity implements Serializable {
    private static final long serialVersionUID = 5150774810253993863L;
    private Integer id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 是否有效
     */
    private Integer isvalid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 发送时间
     */
    private Timestamp sendtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }
}
