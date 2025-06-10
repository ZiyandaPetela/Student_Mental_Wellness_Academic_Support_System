package api;

import core.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student", description = "Student management API")
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @Operation(summary = "Get all students", description = "Retrieves a list of all students in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all students",
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Student.class)))
    })
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @Operation(summary = "Get student by ID", description = "Retrieves a student by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Student found"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @Parameter(description = "Student ID", required = true) @PathVariable String id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }
    
    @Operation(summary = "Get students by academic year", description = "Returns a list of students in a specific academic year")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Students retrieved successfully")
    })
    @GetMapping("/academic-year/{year}")
    public List<Student> getStudentsByAcademicYear(
            @Parameter(description = "Academic year", required = true) @PathVariable String year) {
        return studentService.getStudentsByAcademicYear(year);
    }
    
    @Operation(summary = "Get students by major", description = "Returns a list of students with a specific major")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Students retrieved successfully")
    })
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(
            @Parameter(description = "Major", required = true) @PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }
    
    @Operation(summary = "Create new student", description = "Creates a new student in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Student created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student student) {
        try {
            return studentService.createStudent(student);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @Operation(summary = "Update a student", description = "Updates the data of an existing student by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Student updated successfully"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public Student updateStudent(
            @Parameter(description = "Student ID", required = true) @PathVariable String id,
            @RequestBody Student student) {
        try {
            return studentService.updateStudent(id, student);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @Operation(summary = "Delete a student", description = "Deletes a student by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(
            @Parameter(description = "Student ID", required = true) @PathVariable String id) {
        try {
            studentService.deleteStudent(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}