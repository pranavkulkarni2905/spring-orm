package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student=new Student(102, "pranav ", "Pune");
		 * 
		 * int i = studentDao.saveStudent(student);
		 * System.out.println("record inserted done..."+i);
		 */
		Scanner scanner = new Scanner(System.in);
		boolean go = true;
		while (go) {

			System.out.println("---------- Welcome to spring ORM application ---------");
			System.out.println("Press 1 for Insert student");
			System.out.println("Press 2 for delet student");
			System.out.println("Press 3 for update student");
			System.out.println("Press 4 for Get single student");
			System.out.println("Press 5 for Get all students");
			System.out.println("Press 6 for EXIT");

			try {

				System.out.println("Enter Your Choice.....=>");
				int choice = scanner.nextInt();

				switch (choice) {

				case 1:

					System.out.println("Enter student id:");
					int id = scanner.nextInt();

					System.out.println("Enter student name:");
					String nameString = scanner.next();

					System.out.println("Enter student city:");
					String cityString = scanner.next();

					Student student = new Student(id, nameString, cityString);
					int i = studentDao.saveStudent(student);
					System.out.println("Student Inserted ... " + i);
					break;
				case 2:
					System.out.println("Enter student id :");
					int id1=scanner.nextInt();
					studentDao.deleteStudent(id1);
					System.out.println("Student Deleted...");
					
					break;
				case 3:
					System.out.println("Enter student id:");
					int id3=scanner.nextInt();
					Student student3=studentDao.getStudent(id3);
					System.out.println("Enter Student new Name:");
					String nameString2=scanner.next();
					System.out.println("Enter student new city:");
					String cityString2=scanner.next();
					
					Student stud1=new Student(id3,nameString2,cityString2);
					studentDao.updateStudent(stud1);
					System.out.println("Student Record updated....");
					break;
				case 4:
					System.out.println("Enter student id:");
					int id2=scanner.nextInt();
					Student student2 = studentDao.getStudent(id2);
					System.out.println("Student id:"+student2.getStudentId());
					System.out.println("Student Name:" +student2.getStudentName());
					System.out.println("Student City : "+student2.getStudentCity());
					break;
				case 5:
					System.out.println("StudId\tStudName\t\tStudCity");
					System.out.println("------------------------------------------------------------------------------------");
					List<Student> students = studentDao.getAllStudents();
					for(Student stud:students) {
						System.out.println(stud.getStudentId()+"\t"+stud.getStudentName()+"\t\t"+stud.getStudentCity());
						System.out.println("------------------------------------------------------------------------------------");

					}
					break;
				case 6:
					go = false;
					System.out.println("---- THANKYOU-----");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input try with other character..");
			}
		}
	}
}
