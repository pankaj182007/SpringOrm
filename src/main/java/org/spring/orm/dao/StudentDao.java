package org.spring.orm.dao;

import org.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student)
    {
        int i= (int) hibernateTemplate.save(student);
        return i;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
