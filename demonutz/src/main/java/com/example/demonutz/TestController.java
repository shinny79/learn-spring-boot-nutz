package com.example.demonutz;

import com.example.demonutz.data.Person;
import com.example.demonutz.manager.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TestController {
    private static Log LOG = LogFactory.getLog(TestController.class);

    @Autowired
    private ProductManager productManager;

    @GetMapping("insert")
    public String insert() {
        for (int i = 0; i < 10; i++) {
            productManager.addProduct();
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
        return productManager.list(page, limit);
    }

    @RequestMapping("update")
    public String update(
            @RequestParam(value = "id", required = true) long id,
            @RequestParam(value = "name", required = true) String name
    ) {
        LOG.debug("update");
        productManager.update(id, name);
        return "test";
    }


}
