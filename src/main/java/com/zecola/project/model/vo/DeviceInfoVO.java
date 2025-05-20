package com.zecola.project.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备信息视图
 */
@Data
public class DeviceInfoVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设定温度
     */
    private BigDecimal setTemperature;

    /**
     * 当前温度
     */
    private BigDecimal currentTemperature;

    /**
     * 通道1时间(秒)
     */
    private Integer channel1Time;

    /**
     * 通道2时间(秒)
     */
    private Integer channel2Time;

    /**
     * 通道3时间(秒)
     */
    private Integer channel3Time;

    /**
     * 通道4时间(秒)
     */
    private Integer channel4Time;

    /**
     * 记录时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
} 