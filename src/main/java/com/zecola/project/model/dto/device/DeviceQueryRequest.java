package com.zecola.project.model.dto.device;

import lombok.Data;

import java.io.Serializable;

/**
 * 设备查询请求
 */
@Data
public class DeviceQueryRequest implements Serializable {

    /**
     * 当前页码
     */
    private long current = 1;

    /**
     * 每页大小
     */
    private long pageSize = 10;

    /**
     * 设备ID
     */
    private String deviceId;

    private static final long serialVersionUID = 1L;
} 