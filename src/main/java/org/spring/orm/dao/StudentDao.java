package org.spring.orm.dao;

import org.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    // to Insert or save data
    @Transactional
    public int insert(Student student)
    {
        int i= (int) hibernateTemplate.save(student);
        return i;
    }

    //to get or read single object from database
    public Student fetchStudent(int id)
    {
        return hibernateTemplate.get(Student.class,id);
    }

    //to get or read all object from database
    public List<Student> fetchAllStudent()
    {
        return hibernateTemplate.loadAll(Student.class);
    }

    //to deleting the data
    @Transactional
    public void deleteStudent(int id)
    {
        Student student=hibernateTemplate.get(Student.class,id);
        hibernateTemplate.delete(student);
    }

    //to update data

    @Transactional
    public void updateStudent(Student student)
    {
        hibernateTemplate.update(student);
    }


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
