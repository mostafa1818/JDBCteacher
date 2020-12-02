package services;

import objects.Teacher;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {

    public void deleted(List<Teacher> teacher, int id)
    {

        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("delete from teacher where idteacher= ?");

        )

        {
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }

    public void edite(List<Teacher> teacher, int id, String firstname, String LastName)
    {
        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
          prepareStatement("update  teacher set idteacher=?,FirstName=?,LastName=? where idteacher=?");
        )
        {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,firstname);
            preparedStatement.setString(3,LastName);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();

        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }


    public void adding(Teacher teacher)
    {
        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("insert into Teacher(idteacher,FirstName, LastName) values(?,?,?)");
        )
        {
            preparedStatement.setInt(1,teacher.getId());
            preparedStatement.setString(2,teacher.getFirstName());
            preparedStatement.setString(3,teacher.getLastName());
            preparedStatement.executeUpdate();

        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }
    public List<Teacher> loadall()
    {
     try(
             Connection connection=ConnectionFactory.getconnection();
             PreparedStatement preparedStatement=connection.prepareStatement("select * from Teacher");
             ResultSet resultSet=preparedStatement.executeQuery()
             )
     {
         List<Teacher> list = new ArrayList<>();
           while(resultSet.next())
           {
               Teacher teacher=new Teacher();
               teacher.setId(resultSet.getInt("idteacher"));
                teacher.setFirstName(resultSet.getString("FirstName"));
                teacher.setLastName(resultSet.getString("LastName"));

                   list.add(teacher);
           }
         return list;

     }catch (SQLException sqlException){sqlException.printStackTrace();}

        return null;
    }
public void printing()

{

    try(
            Connection connection=ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from Teacher");
            ResultSet resultSet=preparedStatement.executeQuery()
    )
    {
        List<Teacher> list = new ArrayList<>();
        while(resultSet.next())
        {
            Teacher teacher=new Teacher();
            teacher.setId(resultSet.getInt("idteacher"));
            teacher.setFirstName(resultSet.getString("FirstName"));
            teacher.setLastName(resultSet.getString("LastName"));

            list.add(teacher);
            System.out.println(teacher);
        }



    }catch (SQLException sqlException){sqlException.printStackTrace();}






}





}
