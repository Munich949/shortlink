package com.dlnu.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dlnu.shortlink.project.dao.entity.LinkStatsTodayDO;
import org.apache.ibatis.annotations.Param;

/**
 * 短链接今日统计持久层
 */
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {

    void shortLinkTodayState(@Param("linkTodayStats") LinkStatsTodayDO linkStatsTodayDO);
}
