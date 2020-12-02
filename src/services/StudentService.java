package services;

import objects.Student;
import objects.Teacher;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public void adding(Student student)
    {
        try(
                Connection connection= ConnectionFactory.getconnection();
                PreparedStatement preparedStatement=
                   connection.prepareStatement
                        ("INSERT INTO Student (idstudent,FirstName, LastName) values(?,?,?)");

                )
        {
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getFirstName());
            preparedStatement.setString(3,student.getLastName());
            preparedStatement.executeUpdate();
        }
        catch(SQLException sqlException){sqlException.printStackTrace();}
    }


    public void deleted(  int id)
    {

        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("delete from student where idstudent= ?");

        )

        {
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }



    public void edite( Student   student )
    {
        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("update  student set idstudent=?,FirstName=?,LastName=? where idstudent=?");
        )
        {
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getFirstName());
            preparedStatement.setString(3,student.getLastName());
            preparedStatement.setInt(4,student.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }

    public List<Student> loadall( )
    {
        try(
                Connection connection=ConnectionFactory.getconnection();
                PreparedStatement preparedStatement=connection.prepareStatement("select  * from Student");
                ResultSet resultSet=preparedStatement.executeQuery();

                ){
            List<Student> list=new ArrayList<>();
            while(resultSet.next())
            {
                Student student=new Student();
                student.setId(resultSet.getInt("idstudent"));
                student.setFirstName(resultSet.getString("FirstName"));
                student.setLastName(resultSet.getString("LastName"));
                list.add(student);
            }

            return list;

        }
        catch (SQLException sqlException){sqlException.printStackTrace();}
        return null;

    }


    public void printing()

    {
        try(
                Connection connection=ConnectionFactory.getconnection();
                PreparedStatement preparedStatement=connection.prepareStatement("select  * from Student");
                ResultSet resultSet=preparedStatement.executeQuery();

        ){
            List<Student> list=new ArrayList<>();
            System.out.println("idteacher     FirstName     LastName");
            System.out.println("-------------------------------------");
            while(resultSet.next())
            {

                System.out.printf("%-15s%-15s%-15s",
                        resultSet.getInt("idstudent"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName")
                );
                System.out.println( );


            }



        }
        catch (SQLException sqlException){sqlException.printStackTrace();}





    }

}
