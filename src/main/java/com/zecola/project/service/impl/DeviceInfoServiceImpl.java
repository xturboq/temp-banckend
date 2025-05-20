package com.zecola.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zecola.project.common.ErrorCode;
import com.zecola.project.exception.BusinessException;
import com.zecola.project.mapper.DeviceInfoMapper;
import com.zecola.project.model.dto.device.DeviceAddRequest;
import com.zecola.project.model.entity.DeviceInfo;
import com.zecola.project.service.DeviceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 设备信息服务实现类
 */
@Service
public class DeviceInfoServiceImpl extends ServiceImpl<DeviceInfoMapper, DeviceInfo> implements DeviceInfoService {

    @Override
    public Page<DeviceInfo> listDeviceByPage(long current, long pageSize, String deviceId) {
        LambdaQueryWrapper<DeviceInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 如果设备ID不为空，添加设备ID查询条件
        if (StringUtils.isNotBlank(deviceId)) {
            queryWrapper.eq(DeviceInfo::getDevice_id, deviceId);
        }
        // 按创建时间倒序排序
        queryWrapper.orderByDesc(DeviceInfo::getCreate_time);
        return this.page(new Page<>(current, pageSize), queryWrapper);
    }

    @Override
    public Long addDevice(DeviceAddRequest deviceAddRequest) {
        if (deviceAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 校验设备ID是否存在
        String deviceId = deviceAddRequest.getDevice_id();
        if (StringUtils.isBlank(deviceId)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "设备ID不能为空");
        }
        // 转换为实体类
        DeviceInfo deviceInfo = new DeviceInfo();
        BeanUtils.copyProperties(deviceAddRequest, deviceInfo);
        // 保存数据
        boolean result = this.save(deviceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "添加设备信息");
        }
        return deviceInfo.getId();
    }
}




