package datainput;

import objects.Course;


import java.util.Scanner;

public class InputDataForCourse {




        public Course datainput()
        {
            Course course=new Course();
            Scanner scan =new Scanner(System.in);


            System.out.println("press firstname");
            int input=scan.nextInt();
            course.setTeacherId(input);
            System.out.println("press last");
            input=input=scan.nextInt();
            course.setStudentId(input);
            return course;
        }



}
