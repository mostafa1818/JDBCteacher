package objects;

public class Course {
    private  int teacherId;
    private  int studentId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "teacherId=" + teacherId +
                ", studentId=" + studentId +
                '}';
    }
}