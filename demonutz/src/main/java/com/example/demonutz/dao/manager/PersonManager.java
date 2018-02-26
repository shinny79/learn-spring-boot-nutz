package com.example.demonutz.dao.manager;

import com.example.demonutz.dao.data.Person;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@IocBean
@Service
public class PersonManager {

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
        return dao.update(p);
    }
}
