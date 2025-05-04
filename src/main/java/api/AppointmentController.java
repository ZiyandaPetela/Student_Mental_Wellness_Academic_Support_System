package api;

import core.Appointment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Appointment", description = "Appointment management API")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Operation(summary = "Get all appointments", description = "Returns a list of all appointments")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all appointments",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Appointment.class)))
    })
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @Operation(summary = "Get appointment by ID", description = "Retrieves an appointment by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment found"),
        @ApiResponse(responseCode = "404", description = "Appointment not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(
            @Parameter(description = "Appointment ID", required = true) @PathVariable String id) {
        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found with id: " + id));
    }

    @Operation(summary = "Get appointments by student ID", description = "Returns a list of appointments for a specific student")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointments retrieved successfully")
    })
    @GetMapping("/student/{studentId}")
    public List<Appointment> getAppointmentsByStudentId(
            @Parameter(description = "Student ID", required = true) @PathVariable String studentId) {
        return appointmentService.getAppointmentsByStudentId(studentId);
    }

    @Operation(summary = "Get appointments by counselor ID", description = "Returns a list of appointments for a specific counselor")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointments retrieved successfully")
    })
    @GetMapping("/counselor/{counselorId}")
    public List<Appointment> getAppointmentsByCounselorId(
            @Parameter(description = "Counselor ID", required = true) @PathVariable String counselorId) {
        return appointmentService.getAppointmentsByCounselorId(counselorId);
    }

    @Operation(summary = "Get appointments by status", description = "Returns a list of appointments based on status")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointments retrieved successfully")
    })
    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(
            @Parameter(description = "Appointment status", required = true) @PathVariable String status) {
        return appointmentService.getAppointmentsByStatus(status);
    }

    @Operation(summary = "Get appointments within a date range", description = "Returns a list of appointments within the specified date range")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointments retrieved successfully")
    })
    @GetMapping("/date-range")
    public List<Appointment> getAppointmentsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return appointmentService.getAppointmentsByDateRange(start, end);
    }

    @Operation(summary = "Create new appointment", description = "Creates a new appointment in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Appointment created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
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

    @Operation(summary = "Update appointment status", description = "Updates the status of an existing appointment")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment status updated successfully"),
        @ApiResponse(responseCode = "404", description = "Appointment not found"),
        @ApiResponse(responseCode = "400", description = "Invalid status provided")
    })
    @PatchMapping("/{id}/status")
    public Appointment updateAppointmentStatus(
            @Parameter(description = "Appointment ID", required = true) @PathVariable String id,
            @RequestBody Map<String, String> statusUpdate) {
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

    @Operation(summary = "Reschedule appointment", description = "Reschedules an appointment to a new date and time")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment rescheduled successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid date/time provided"),
        @ApiResponse(responseCode = "404", description = "Appointment not found")
    })
    @PatchMapping("/{id}/reschedule")
    public Appointment rescheduleAppointment(
            @Parameter(description = "Appointment ID", required = true) @PathVariable String id,
            @RequestBody Map<String, String> rescheduleRequest) {
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

    @Operation(summary = "Cancel appointment", description = "Cancels an appointment by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Appointment cancelled successfully"),
        @ApiResponse(responseCode = "404", description = "Appointment not found")
    })
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
