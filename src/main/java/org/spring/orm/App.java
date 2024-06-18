package org.spring.orm;

import org.spring.orm.dao.StudentDao;
import org.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Student student=new Student();

        System.out.println("*******************Welcome to ORM Student data project************************");

        boolean con=true;
        while (con)
            {
                System.out.println("Press 1 : To Add new Student");
                System.out.println("Press 2 : To search  Student By its Id");
                System.out.println("Press 3 : To display all Student");
                System.out.println("Press 4 : To Delete Student");
                System.out.println("Press 5 : To Update  Student");
                System.out.println("Press 6 : To Exit");

                try {

                    System.out.print("Enter your Choice : : ");

                    switch (Integer.parseInt( br.readLine()))
                    {
                        case 1:

                            // to insert data in table


                            System.out.println("*********Enter Student details*********\n");
                            System.out.print("Enter Student ID :  ");
                             student.setId(Integer.parseInt(br.readLine()));
                            System.out.print("\nEnter Student name :  ");
                             student.setName(br.readLine());
                            System.out.print("\nEnter Student City :  ");
                             student.setCity(br.readLine());

//                             int i=studentDao.insert(student);
//                            System.out.println("Number of row inserted : "+i);
                            break;

                        case 2:

                            //to fetch data by id

                            System.out.print("Enter Student ID :  ");
                            student=studentDao.fetchStudent((Integer.parseInt(br.readLine())));
                             System.out.println(student+"\n");
                            break;

                        case 3:

                            // to fetch all data

                            List<Student> students=studentDao.fetchAllStudent();
                            for (Student s:students)
                            {
                                System.out.println(s);
                            }
                            break;

                        case 4:

                            //to update data

                            System.out.println("*********Enter Student details*********\n");
                            System.out.print("Enter OLD Student ID :  ");
                            student.setId(Integer.parseInt(br.readLine()));
                            System.out.print("\nEnter New Student name :  ");
                            student.setName(br.readLine());
                            System.out.print("\nEnter New Student City :  ");
                            student.setCity(br.readLine());

                            studentDao.updateStudent(student);
                            break;

                        case 5:

                            //to delete Data
                            System.out.print("Enter Student ID :  ");

                            studentDao.deleteStudent(Integer.parseInt(br.readLine()));
                            break;

                        case 6:
                            con=false;
                            break;
                    }

                }
                catch (Exception e)
                {
                    System.out.println(" Invalid Input Please enter valid input ");
                    System.out.println(e.getMessage());

                }

            }

        System.out.println(" Thank you for using my application ");

    }
}
