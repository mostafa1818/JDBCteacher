package datainput;

import objects.Teacher;

import java.util.Scanner;

public class InputDataForTeacher {
    public Teacher datainput()
    {
        Teacher teacher=new Teacher();
        Scanner scan =new Scanner(System.in);


        System.out.println("press firstname");
        String input=scan.nextLine();
        teacher.setFirstName(input);
        System.out.println("press last");
          input=scan.nextLine();
        teacher.setLastName(input);
        return teacher;
    }
}
