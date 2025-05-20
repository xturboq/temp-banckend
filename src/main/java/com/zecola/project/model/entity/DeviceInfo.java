package com.zecola.project.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 设备状态记录表
 * @TableName device_info
 */
@Data
public class DeviceInfo {

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**
     * 记录时间
     */
    private Date create_time;
}