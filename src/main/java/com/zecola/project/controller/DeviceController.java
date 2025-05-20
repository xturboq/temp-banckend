package com.zecola.project.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zecola.project.common.BaseResponse;
import com.zecola.project.common.ErrorCode;
import com.zecola.project.common.ResultUtils;
import com.zecola.project.exception.BusinessException;
import com.zecola.project.model.dto.device.DeviceAddRequest;
import com.zecola.project.model.dto.device.DeviceQueryRequest;
import com.zecola.project.model.entity.DeviceInfo;
import com.zecola.project.service.DeviceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 设备信息接口
 */
@RestController
@RequestMapping("/device")
@Slf4j
public class DeviceController {

    @Resource
    private DeviceInfoService deviceInfoService;

    /**
     * 分页获取设备信息列表
     *
     * @param deviceQueryRequest 查询参数
     * @return 设备信息分页数据
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<DeviceInfo>> listDeviceByPage(@RequestBody DeviceQueryRequest deviceQueryRequest) {
        if (deviceQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = deviceQueryRequest.getCurrent();
        long pageSize = deviceQueryRequest.getPageSize();
        if (current < 1 || pageSize < 1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Page<DeviceInfo> devicePage = deviceInfoService.listDeviceByPage(current, pageSize, deviceQueryRequest.getDeviceId());
        return ResultUtils.success(devicePage);
    }

    /**
     * 添加设备信息
     *
     * @param deviceAddRequest 添加设备请求
     * @return 设备ID
     */
    @PostMapping("/add")
    public BaseResponse<Long> addDevice(@RequestBody DeviceAddRequest deviceAddRequest) {
        if (deviceAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long deviceId = deviceInfoService.addDevice(deviceAddRequest);
        return ResultUtils.success(deviceId);
    }
} 