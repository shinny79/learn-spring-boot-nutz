package com.example.demonutz.dao.manager;/**
 * @(#)ProductManager, 2018/2/26.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.example.demonutz.TestController;
import com.example.demonutz.dao.data.VirtualProduct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @authoer hzdongxiani
 */
@IocBean
@Service
public class VirtualProductManager extends AbstractDateManager<VirtualProduct> {
    private static Log LOG = LogFactory.getLog(TestController.class);

    @Autowired
    private Dao dao2;

    VirtualProductManager() {
        LOG.debug("VirtualProduct manager init");
    }

    public QueryResult list(String shop, String category,
            int pageSize, int pageNum) {
        Pager pager = dao2.createPager(pageNum, pageSize);
        List<VirtualProduct> list = dao2.query(VirtualProduct.class,
               Cnd.where("shop", "=", shop).and("category", "=", category),
               pager);
        pager.setRecordCount(dao2.count(VirtualProduct.class));
        return new QueryResult(list, pager);
    }

    public VirtualProduct get(String serviceType) {
        return dao2.fetch(VirtualProduct.class, Cnd.where("service_type", "=", serviceType));
    }

    public long count(String shop, String category) {
        return dao2.count(Long.class, Cnd.where("shop", "=", shop).and("category", "=", category));
    }
}
