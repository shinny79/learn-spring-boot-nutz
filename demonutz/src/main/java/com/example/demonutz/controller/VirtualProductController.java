package com.example.demonutz.controller;/**
 * @(#)VirtualProductController, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.example.demonutz.dao.data.VirtualProduct;
import com.example.demonutz.service.VirtualProductService;
import org.nutz.dao.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoer hzdongxiani
 */
@RestController
@RequestMapping("product")
public class VirtualProductController extends AbstractAuthController {

    @Autowired
    private VirtualProductService virtualProductService;

    @GetMapping("get")
    public VirtualProduct get(
            @RequestParam(value = "st", required = false, defaultValue = "") String serviceType
    ) {
        return virtualProductService.get(serviceType);
    }

    @GetMapping("list")
    public QueryResult list(
            @RequestParam(value = "sp", required = false, defaultValue = "") String shop,
            @RequestParam(value = "cat", required = false, defaultValue = "") String category,
            @RequestParam(value = "ps", required = false, defaultValue = "100") int pageSize,
            @RequestParam(value = "pn", required = false, defaultValue = "1") int pageNum
    ) {
        return virtualProductService.list(shop, category, pageSize, pageNum);
    }
}
