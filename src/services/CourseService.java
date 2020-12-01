package services;

import objects.Course;
import objects.Teacher;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    public void save(Course course)
    {
        try(
                Connection connection=ConnectionFactory.getconnection();
                PreparedStatement preparedStatement=connection
                        .prepareStatement("INSERT into Course (idteacher,idstudentId) values (?,?)");
                )
        {
            preparedStatement.setInt(1,course.getTeacherId());
            preparedStatement.setInt(2,course.getTeacherId());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }


    public void edite(List<Course> course, int idteacher,int idstudent, int newidteacher,int newidstudent)
    {
        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
              prepareStatement
                ("update  course set idteacher=?,idstudent=? where idteacher=? and where idstudent=?");
        )
        {
            preparedStatement.setInt(1,newidteacher);
            preparedStatement.setInt(2,newidstudent);
            preparedStatement.setInt(3,idteacher);
            preparedStatement.setInt(4,idstudent);
            preparedStatement.executeUpdate();

        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }
















    public void deleted(List<Course> course, int idteacher,int idstudent)
    {

        try(Connection connection= ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.
                    prepareStatement("delete from course where idteacher= ? and idstudent= ?");

        )

        {
            preparedStatement.setInt(1,idteacher);
            preparedStatement.setInt(1,idstudent);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){sqlException.printStackTrace();}

    }

public List<Course> loadall()
{
    try(
            Connection connection=ConnectionFactory.getconnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from Course");
            ResultSet resultSet=preparedStatement.executeQuery();

            )
    {

        List<Course> list=new ArrayList<>();
        while(resultSet.next())
        {
            Course course=new Course();
            course.setTeacherId(resultSet.getInt("idteacher"));
            course.setStudentId(resultSet.getInt("idstudent"));
            list.add(course);
        }
        return list;


    }
    catch (SQLException sqlException){sqlException.printStackTrace();}

         return null;

}



    public void printing()

    {
        /**********bigprobkem***********/
        try(
                Connection connection=ConnectionFactory.getconnection();
                PreparedStatement preparedStatement=connection.
                        prepareStatement("select * from Course c join Teacher t join student s " +
                                             "on c.idteacher=tidteacher and s.idstudent=c.s.idstudent" +
                                             " group by s.student");
                ResultSet resultSet=preparedStatement.executeQuery();

        )
        {

            List<Course> list=new ArrayList<>();
            while(resultSet.next())
            {
                Course course=new Course();
                course.setTeacherId(resultSet.getInt("idteacher"));
                course.setStudentId(resultSet.getInt("idstudent"));
                list.add(course);
                System.out.println(course);
            }



        }
        catch (SQLException sqlException){sqlException.printStackTrace();}



    }


}
