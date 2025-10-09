package DesignPatterns.AdapterPattern;

public class SchoolStudentAdapter implements Student {
    private SchoolStudent schoolStudent;

    public SchoolStudentAdapter(SchoolStudent _schoolStudent)
    {
        this.schoolStudent = _schoolStudent;
    }

    @Override
    public String getFirstname() {
        return this.schoolStudent.getFirstname();
    }

    @Override
    public String getSurname() {
        return this.schoolStudent.getSurname();
    }

    @Override
    public String getAddress() {
        return this.schoolStudent.getAddress();
    }

    @Override
    public String toString() {
        return "SchoolStudentAdapter{" +
                "schoolStudent=" + schoolStudent +
                '}';
    }
}
