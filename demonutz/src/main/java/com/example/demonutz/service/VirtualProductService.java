package com.example.demonutz.service;/**
 * @(#)VirtualProductService, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.example.demonutz.dao.data.VirtualProduct;
import com.example.demonutz.dao.manager.VirtualProductManager;
import org.nutz.dao.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authoer hzdongxiani
 */
@Service
public class VirtualProductService {

    @Autowired
    private VirtualProductManager virtualProductManager;

    public VirtualProduct get(String serviceType) {
        return virtualProductManager.get(serviceType);
    }

    public QueryResult list(String shop, String category, int pageSize, int pageNum) {
        return virtualProductManager.list(shop, category, pageSize, pageNum);
    }
}
