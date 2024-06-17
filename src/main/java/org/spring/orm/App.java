package org.spring.orm;

import org.spring.orm.dao.StudentDao;
import org.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

       // to insert data in table

       Student student=new Student(333,"Amit kumar","Delhi");
       int i=studentDao.insert(student);
        System.out.println("Number of row inserted : "+i);

        //to fetch data by id

//       Student students=studentDao.fetchStudent(555);
//        System.out.println(students);

        //to update data

//        Student student=new Student(111,"Rakhi Kumari","Lucknow");
//        studentDao.updateStudent(student);

        //to delete Data

  //      studentDao.deleteStudent(333);


        // to fetch all data

        List<Student> students=studentDao.fetchAllStudent();
        for (Student s:students)
        {
            System.out.println(s);
        }


    }
}
