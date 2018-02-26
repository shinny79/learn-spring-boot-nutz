package com.example.demonutz;

import com.example.demonutz.dao.data.Person;
import com.example.demonutz.dao.data.VirtualProduct;
import com.example.demonutz.dao.manager.PersonManager;
import com.example.demonutz.dao.manager.VirtualProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    private static Log LOG = LogFactory.getLog(TestController.class);

    @Autowired
    private PersonManager personManager;

    @GetMapping("insert")
    public String insert() {
        for (int i = 0; i < 10; i++) {
            personManager.addProduct();
        }
        LOG.debug("OK");
        return "ok";
    }

    @GetMapping("query")
    public List<Person> query(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "5", required = false) int limit

    ) {
        LOG.debug("query");
        return personManager.list(page, limit);
    }

    @RequestMapping("update")
    public String update(
            @RequestParam(value = "id", required = true) long id,
            @RequestParam(value = "name", required = true) String name
    ) {
        LOG.debug("update");
        personManager.update(id, name);
        return "test";
    }


}
