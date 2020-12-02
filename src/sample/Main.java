package sample;

import datainput.InputDataForCourse;
import datainput.InputDataForStudent;
import datainput.InputDataForTeacher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Teacher;
import services.CourseService;
import services.StudentService;
import services.TeacherService;

import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
        TeacherService teacherService= new TeacherService();
        StudentService studentService=new StudentService();
        CourseService courseService=new CourseService();
        InputDataForTeacher inputDataForTeacher=new InputDataForTeacher();
        InputDataForStudent inputDataForStudent=new InputDataForStudent();
        InputDataForCourse inputDataForCourse=new InputDataForCourse();


//        teacherService.deleted( teachers,1) ;

        //    teacherService.edite(teachers,3,"massod","deli");

//         for (Teacher teacher : teachers)
//            System.out.println(teacher.toString());

        Scanner scan =new Scanner(System.in);
        Scanner intscan =new Scanner(System.in);
        String input=scan.nextLine();
        int  intinput;
        int  intinput2;
        int  intinput3;
        int  intinput4;
        System.out.println("menu:\naddteacher\ndeleteteacher\n showteacher\nediteteacher");




        System.out.println("press command");

         while(true)
         {

             switch (input)
             {
                 case "addteacher":
                     teacherService.adding(inputDataForTeacher.datainput());
                     break;
                 case "deleteteacher":
                     System.out.println("press id of teacher");
                     intinput=intscan.nextInt();
                     teacherService.deleted(intinput);
                     break;
                 case "showteacher":
                     teacherService.printing();
                     break;
                 case "editeteacher":
                     teacherService.edite(inputDataForTeacher.DataInputForEdite());

                     break;
                 case "addstudent":
                     studentService.adding(inputDataForStudent.datainput());

                     break;
                 case "deletestudent":
                     System.out.println("press id of student");
                     intinput=intscan.nextInt();
                     studentService.deleted(intinput);

                     break;
                 case "showstudent":
                     studentService.printing();
                     break;
                 case "editestudent":
                     studentService.edite(inputDataForStudent.DataInputForEdite());
                     break;
                 case "addcourse":
                     courseService.adding(inputDataForCourse.datainput());

                     break;
                 case "deletecourse":
                     System.out.println("press id of teacher");
                     intinput=intscan.nextInt();
                     System.out.println("press id of student");
                     intinput2=intscan.nextInt();
                     courseService.deleted(intinput,intinput2);

                     break;
                 case "showcourse":
                     System.out.println("press id of teacher");
                     intinput=intscan.nextInt();
                     courseService.printing(intinput);
                     break;
                 case "editecourse":
                     System.out.println("press old id of teacher");
                     intinput=intscan.nextInt();
                     System.out.println("press old  id of student");
                     intinput2=intscan.nextInt();
                     System.out.println("press new id of teacher");
                     intinput3=intscan.nextInt();
                     System.out.println("press new  id of student");
                     intinput4=intscan.nextInt();

                     courseService.edite(intinput,intinput2,intinput3,intinput4);

                     break;
                 case "exit":
                      return;




             }
             input=scan.nextLine();

         }






    }
}
