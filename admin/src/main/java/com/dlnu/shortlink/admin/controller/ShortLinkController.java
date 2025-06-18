package com.dlnu.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dlnu.shortlink.admin.common.result.Result;
import com.dlnu.shortlink.admin.common.result.Results;
import com.dlnu.shortlink.admin.remote.ShortLinkRemoteService;
import com.dlnu.shortlink.admin.remote.dto.req.ShortLinkBatchCreateReqDTO;
import com.dlnu.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.dlnu.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.dlnu.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.dlnu.shortlink.admin.remote.dto.resp.ShortLinkBaseInfoRespDTO;
import com.dlnu.shortlink.admin.remote.dto.resp.ShortLinkBatchCreateRespDTO;
import com.dlnu.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.dlnu.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.dlnu.shortlink.admin.toolkit.EasyExcelWebUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接后管控制层
 */
@RestController
public class ShortLinkController {

    /**
     * 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 批量创建短链接
     */
    @SneakyThrows
    @PostMapping("/api/short-link/admin/v1/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
        }
    }

    /**
     * 修改短链接
     */
    @PutMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }
}
