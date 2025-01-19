package com.dlnu.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dlnu.shortlink.project.dao.entity.LinkNetworkStatsDO;
import org.apache.ibatis.annotations.Param;

/**
 * 访问网络监控持久层
 */
public interface LinkNetworkStatsMapper extends BaseMapper<LinkNetworkStatsDO> {

    /**
     * 记录访问设备监控数据
     */
    void shortLinkNetworkStats(@Param("linkNetworkStats") LinkNetworkStatsDO linkNetworkStatsDO);
}
