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

public class SetudentService {

    public void save(Student student)
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


    public void deleted(List<Student > student, int id)
    {

        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("delete from student where idteacher= ?");

        )

        {
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }



    public void edite(List<Student > student, int id, String firstname, String LastName)
    {
        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("update  student set idteacher=?,FirstName=?,LastName=? where idteacher=?");
        )
        {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,firstname);
            preparedStatement.setString(3,LastName);
            preparedStatement.setInt(4,id);
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
            while(resultSet.next())
            {
                Student student=new Student();
                student.setId(resultSet.getInt("idstudent"));
                student.setFirstName(resultSet.getString("FirstName"));
                student.setLastName(resultSet.getString("LastName"));
                list.add(student);
                System.out.println(student);
            }



        }
        catch (SQLException sqlException){sqlException.printStackTrace();}





    }

}
