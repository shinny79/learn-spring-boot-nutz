package com.example.demonutz;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NutzDaoConfig {

    private Ioc ioc;

    NutzDaoConfig() {
        ioc = new NutIoc(new JsonLoader("conf/ioc/dao.js"));
    }

    @Bean(name = "dao")
    public Dao ioc() {
        Dao dao = ioc.get(Dao.class, "dao");
        return dao;
    }

    @Bean(name = "dao2")
    public Dao ioc2() {
        Dao dao2 = ioc.get(Dao.class, "dao2");
        return dao2;
    }
}
