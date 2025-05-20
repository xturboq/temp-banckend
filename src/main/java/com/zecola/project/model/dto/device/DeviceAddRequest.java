package com.zecola.project.model.dto.device;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 添加设备请求
 */
@Data
public class DeviceAddRequest implements Serializable {

    /**
     * 设备ID
     */
    private String device_id;

    /**
     * 设定温度
     */
    private BigDecimal set_temperature;

    /**
     * 当前温度
     */
    private BigDecimal current_temperature;

    /**
     * 通道1时间(秒)
     */
    private Integer channel1_time;

    /**
     * 通道2时间(秒)
     */
    private Integer channel2_time;

    /**
     * 通道3时间(秒)
     */
    private Integer channel3_time;

    /**
     * 通道4时间(秒)
     */
    private Integer channel4_time;

    private static final long serialVersionUID = 1L;
} 