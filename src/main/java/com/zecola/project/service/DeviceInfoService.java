package com.zecola.project.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zecola.project.model.dto.device.DeviceAddRequest;
import com.zecola.project.model.entity.DeviceInfo;

/**
 * 设备信息服务
 */
public interface DeviceInfoService extends IService<DeviceInfo> {

    /**
     * 分页查询设备信息
     *
     * @param current 当前页码
     * @param pageSize 每页大小
     * @param deviceId 设备ID
     * @return 分页数据
     */
    Page<DeviceInfo> listDeviceByPage(long current, long pageSize, String deviceId);

    /**
     * 添加设备信息
     *
     * @param deviceAddRequest 添加设备请求
     * @return 设备ID
     */
    Long addDevice(DeviceAddRequest deviceAddRequest);
}
