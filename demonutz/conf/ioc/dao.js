var ioc = {
    dataSource : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            depose : 'close'
        },
        fields : {
            url : "jdbc:mysql://localhost:3306/test",
            username : "root",
            password : "123456",
            maxWait: 15000, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
            defaultAutoCommit : false // 提高fastInsert的性能
        }
    },
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"dataSource"}] //引用主数据源
    },
    //--------------------------------------------------------
    // 第2数据库
    dataSource2 : {
        type : "com.alibaba.druid.pool.DruidDataSource",
        events : {
            depose : 'close'
        },
        fields : {
            url : "jdbc:mysql://localhost:3306/localtest",
            username : "root",
            password : "123456",
            maxWait: 15000, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程
            defaultAutoCommit : false // 提高fastInsert的性能
        }
    },
    dao2 : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"dataSource2"}] //引用主数据源
    }
}