package com.example.demonutz.manager;

import com.example.demonutz.data.Person;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.plugin.spring.boot.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager extends BaseService<Person> {

    @Autowired
    private Dao dao;

    public void addProduct() {
        Person person = new Person();
        person.setName("test");
        dao.insert(person);
    }

    public List<Person> list(int page, int limit) {
        List<Person> list = dao.query(Person.class, null,
                dao.createPager(page, limit));
        return list;
    }

    public int delete(long id) {
        return dao.delete(id);
    }

    public int update(long id, String name) {
        Person p = dao.fetch(Person.class, id);
        p.setName(name);
//        return updateFields(p, "^name$");
        return update(p);
    }
}
