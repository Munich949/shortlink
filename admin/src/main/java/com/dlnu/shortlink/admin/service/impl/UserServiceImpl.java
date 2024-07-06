package com.dlnu.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dlnu.shortlink.admin.common.convention.exception.ServiceException;
import com.dlnu.shortlink.admin.dao.entity.UserDO;
import com.dlnu.shortlink.admin.dao.mapper.UserMapper;
import com.dlnu.shortlink.admin.dto.resp.UserRespDTO;
import com.dlnu.shortlink.admin.enums.UserErrorCodeEnum;
import com.dlnu.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现层
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }
        return BeanUtil.copyProperties(userDO, UserRespDTO.class);
    }
}