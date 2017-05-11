package com.zvz.mybatis.domain3;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by lilipo on 2017/3/28.
 */
public class MethodLogEntity implements Serializable {

    //主键ID
    private Integer id;
    //入参
    private String inStr;
    //出参
    private String outStr;
    //关键字
    private String keyStr;
    //入参时间
    private Timestamp inTime;
    //出参时间
    private Timestamp outTime;
    //状态  0 初始  1 正常  -1 异常
    private String state;
    //错误信息
    private String errStr;
    //方法名
    private String methodName;
    //调用Ip
    private String fromIp;
    //类型
    private String type;
    //出错时间
    private Timestamp errTime;
    //备注
    private String remarks;


    //入参时间
    private String inTimeStr;
    //出参时间
    private String outTimeStr;
    //出错时间
    private String errTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInStr() {
        return inStr;
    }

    public void setInStr(String inStr) {
        this.inStr = inStr;
    }

    public String getOutStr() {
        return outStr;
    }

    public void setOutStr(String outStr) {
        this.outStr = outStr;
    }

    public String getKeyStr() {
        return keyStr;
    }

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getErrStr() {
        return errStr;
    }

    public void setErrStr(String errStr) {
        this.errStr = errStr;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getErrTime() {
        return errTime;
    }

    public void setErrTime(Timestamp errTime) {
        this.errTime = errTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInTimeStr() {
        return inTimeStr;
    }

    public void setInTimeStr(String inTimeStr) {
        this.inTimeStr = inTimeStr;
    }

    public String getOutTimeStr() {
        return outTimeStr;
    }

    public void setOutTimeStr(String outTimeStr) {
        this.outTimeStr = outTimeStr;
    }

    public String getErrTimeStr() {
        return errTimeStr;
    }

    public void setErrTimeStr(String errTimeStr) {
        this.errTimeStr = errTimeStr;
    }

    @Override
    public String toString() {
        return "MethodLogEntity{" +
                "id=" + id +
                ", inStr='" + inStr + '\'' +
                ", outStr='" + outStr + '\'' +
                ", keyStr='" + keyStr + '\'' +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", state='" + state + '\'' +
                ", errStr='" + errStr + '\'' +
                ", methodName='" + methodName + '\'' +
                ", fromIp='" + fromIp + '\'' +
                ", type='" + type + '\'' +
                ", errTime=" + errTime +
                ", remarks='" + remarks + '\'' +
                ", inTimeStr='" + inTimeStr + '\'' +
                ", outTimeStr='" + outTimeStr + '\'' +
                ", errTimeStr='" + errTimeStr + '\'' +
                '}';
    }
}
