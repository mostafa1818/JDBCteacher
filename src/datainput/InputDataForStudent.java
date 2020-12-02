package datainput;

import objects.Student;


import java.util.Scanner;

public class InputDataForStudent {



        public Student datainput()
        {
            Student student=new Student();
            Scanner scan =new Scanner(System.in);


            System.out.println("press firstname");
            String input=scan.nextLine();
            student.setFirstName(input);
            System.out.println("press last");
            input=scan.nextLine();
            student.setLastName(input);
            return student;
        }


}
