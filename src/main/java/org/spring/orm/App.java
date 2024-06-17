package org.spring.orm;

import org.spring.orm.dao.StudentDao;
import org.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao= context.getBean("studentDao", StudentDao.class);
       Student student=new Student(555,"hament kumar","Lucknow");
       int i=studentDao.insert(student);
        System.out.println("Number of row inserted : "+i);

    }
}
