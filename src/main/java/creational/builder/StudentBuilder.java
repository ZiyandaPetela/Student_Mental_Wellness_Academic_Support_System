// src/main/java/creational/builder/StudentBuilder.java
package creational.builder;

import core.Student;

public class StudentBuilder {
    private String studentId;
    private String email;
    private String academicYear;
    private String major;

    public StudentBuilder(String studentId, String email) {
        this.studentId = studentId;
        this.email = email;
    }

    public StudentBuilder setAcademicYear(String year) {
        this.academicYear = year;
        return this;
    }

    public StudentBuilder setMajor(String major) {
        this.major = major;
        return this;
    }

    public Student build() {
        Student student = new Student(studentId, email);
        student.setAcademicYear(academicYear);
        student.setMajor(major);
        return student;
    }
}