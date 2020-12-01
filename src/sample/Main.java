package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Teacher;
import services.TeacherService;

import java.util.List;

public class Main  {

    public static void main(String[] args) {
        TeacherService teacherService= new TeacherService();

        List<Teacher> teachers = teacherService.loadall();
//        teacherService.deleted( teachers,1) ;

        //    teacherService.edite(teachers,3,"massod","deli");

         for (Teacher teacher : teachers)
            System.out.println(teacher.toString());

    }
}
