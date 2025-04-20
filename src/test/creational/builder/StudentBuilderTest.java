// src/test/java/creational/builder/StudentBuilderTest.java
package test.creational.builder;

import core.Student;
import creational.builder.StudentBuilder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentBuilderTest {
    @Test
    void testStudentBuilder() {
        Student student = new StudentBuilder("S1001", "test@uni.edu")
            .setAcademicYear("Junior")
            .setMajor("CS")
            .build();

        assertAll(
            () -> assertEquals("S1001", student.getStudentId()),
            () -> assertEquals("Junior", student.getAcademicYear()),
            () -> assertEquals("CS", student.getMajor())
        );
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> 
            new StudentBuilder("S1002", "invalid-email")
        );
    }
}