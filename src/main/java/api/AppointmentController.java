// src/api/AppointmentController.java
package api;

import core.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import services.AppointmentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    
    private final AppointmentService appointmentService;
    
    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found with id: " + id));
    }
    
    @GetMapping("/student/{studentId}")
    public List<Appointment> getAppointmentsByStudentId(@PathVariable String studentId) {
        return appointmentService.getAppointmentsByStudentId(studentId);
    }
    
    @GetMapping("/counselor/{counselorId}")
    public List<Appointment> getAppointmentsByCounselorId(@PathVariable String counselorId) {
        return appointmentService.getAppointmentsByCounselorId(counselorId);
    }
    
    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(@PathVariable String status) {
        return appointmentService.getAppointmentsByStatus(status);
    }
    
    @GetMapping("/date-range")
    public List<Appointment> getAppointmentsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return appointmentService.getAppointmentsByDateRange(start, end);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@RequestBody Map<String, Object> appointmentRequest) {
        try {
            String appointmentId = (String) appointmentRequest.get("appointmentId");
            LocalDateTime dateTime = LocalDateTime.parse((String) appointmentRequest.get("dateTime"));
            String studentId = (String) appointmentRequest.get("studentId");
            String counselorId = (String) appointmentRequest.get("counselorId");
            
            return appointmentService.createAppointment(appointmentId, dateTime, studentId, counselorId);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @PatchMapping("/{id}/status")
    public Appointment updateAppointmentStatus(@PathVariable String id, @RequestBody Map<String, String> statusUpdate) {
        try {
            String status = statusUpdate.get("status");
            if (status == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status must be provided");
            }
            
            return appointmentService.updateAppointmentStatus(id, status);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @PatchMapping("/{id}/reschedule")
    public Appointment rescheduleAppointment(@PathVariable String id, @RequestBody Map<String, String> rescheduleRequest) {
        try {
            String dateTimeStr = rescheduleRequest.get("dateTime");
            if (dateTimeStr == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New date/time must be provided");
            }
            
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
            return appointmentService.rescheduleAppointment(id, dateTime);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @PostMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelAppointment(@PathVariable String id) {
        try {
            appointmentService.cancelAppointment(id);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}