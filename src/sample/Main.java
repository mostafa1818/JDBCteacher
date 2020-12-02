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
        /*create object*/
        TeacherService teacherService= new TeacherService();
        StudentService studentService=new StudentService();
        CourseService courseService=new CourseService();
        InputDataForTeacher inputDataForTeacher=new InputDataForTeacher();
        InputDataForStudent inputDataForStudent=new InputDataForStudent();
        InputDataForCourse inputDataForCourse=new InputDataForCourse();




        Scanner scan =new Scanner(System.in);
        Scanner intscan =new Scanner(System.in);

        int  intinput;
        int  intinput2;
        int  intinput3;
        int  intinput4;
        /*menu*/
        System.out.println("menu:\naddteacher     deleteteacher     showteacher     editeteacher" +
                "\naddstudent     deletestudent     showstudent     editestudent" +
                "\naddcourse      deletecourse      showcourse      showallcourse   editecourse");




        System.out.println("press command");
        /*scan command*/
        String input=scan.nextLine();
        /*choise from menu*/
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
                 case "showallcourse":

                     courseService.printingall();
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
