package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Teacher;
import services.CourseService;
import services.StudentService;
import services.TeacherService;

import java.util.List;
import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
        TeacherService teacherService= new TeacherService();
       StudentService studentService=new StudentService();
        CourseService courseService=new CourseService();

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


             if(input.equals("addteacher"))
             {break;}
             if(input.equals("deleteteacher"))
             {break;}
             if(input.equals("showteacher"))
             {
                  teacherService.printing();

             }
             if(input.equals("editeteacher"))
             {break;}

             if(input.equals("addstudent"))
             {break;}
             if(input.equals("deletestudent"))
             {break;}
             if(input.equals("showstudent"))
             {

                 studentService.printing();


             }
             if(input.equals("editestudent"))
             {break;}

             if(input.equals("addcourse"))
             {break;}
             if(input.equals("deletecourse"))
             {break;}
             if(input.equals("showscourse"))
             {
                 intinput=intscan.nextInt();
                 courseService.printing(intinput);
             }
             if(input.equals("editecourse"))
             {break;}

             if(input.equals("exit"))
             {break;}
               input=scan.nextLine();

         }






    }
}