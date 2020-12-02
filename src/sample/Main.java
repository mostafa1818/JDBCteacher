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

        System.out.println("press command");
//        teacherService.deleted( teachers,1) ;

        //    teacherService.edite(teachers,3,"massod","deli");

//         for (Teacher teacher : teachers)
//            System.out.println(teacher.toString());

         Scanner scan =new Scanner(System.in);
        Scanner intscan =new Scanner(System.in);
         String input=scan.nextLine();
       int  intinput;
         while(true)
         {

             switch (input)
             {
                 case "addteacher":
                     teacherService.adding(inputDataForTeacher.datainput());
                     break;
                 case "deleteteacher":

                     break;
                 case "showteacher":
                     teacherService.printing();
                     break;
                 case "editeteacher":

                     break;
                 case "addstudent":
                     studentService.adding(inputDataForStudent.datainput());

                     break;
                 case "deletestudent":

                     break;
                 case "showstudent":
                     studentService.printing();
                     break;
                 case "editestudent":

                     break;
                 case "addcourse":
                     courseService.adding(inputDataForCourse.datainput());

                     break;
                 case "deletecourse":

                     break;
                 case "showcourse":
                     System.out.println("press id of teacher");
                     intinput=intscan.nextInt();
                     courseService.printing(intinput);
                     break;
                 case "editecourse":

                     break;
                 case "exit":

                     break;
                 default:
                     input=scan.nextLine();

             }


         }






    }
}
