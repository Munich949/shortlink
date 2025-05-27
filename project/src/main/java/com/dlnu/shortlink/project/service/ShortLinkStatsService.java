package com.dlnu.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dlnu.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.dlnu.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.dlnu.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.dlnu.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 访问单个短链接指定时间内监控数据
     *
     * @param requestParam 获取短链接监控数据请求参数
     * @return 获取短链接监控返回参数
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 访问记录监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
