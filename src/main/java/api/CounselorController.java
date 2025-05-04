package api;

import core.Counselor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import services.CounselorService;

import java.util.List;

@RestController
@RequestMapping("/api/counselors")
@Tag(name = "Counselor", description = "Counselor management API")
public class CounselorController {

    private final CounselorService counselorService;

    @Autowired
    public CounselorController(CounselorService counselorService) {
        this.counselorService = counselorService;
    }

    @Operation(summary = "Get all counselors", description = "Returns a list of all counselors")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful retrieval",
                     content = @Content(mediaType = "application/json",
                     schema = @Schema(implementation = Counselor.class)))
    })
    @GetMapping
    public List<Counselor> getAllCounselors() {
        return counselorService.getAllCounselors();
    }

    @Operation(summary = "Get counselor by ID", description = "Retrieve a counselor by their unique ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Counselor found"),
        @ApiResponse(responseCode = "404", description = "Counselor not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Counselor> getCounselorById(
            @Parameter(description = "Counselor ID", required = true) @PathVariable String id) {
        return counselorService.getCounselorById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Counselor not found with id: " + id));
    }

    @Operation(summary = "Get counselors by specialization", description = "Returns counselors with a specific specialization")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Counselors retrieved successfully")
    })
    @GetMapping("/specialization/{specialization}")
    public List<Counselor> getCounselorsBySpecialization(
            @Parameter(description = "Specialization area", required = true) @PathVariable String specialization) {
        return counselorService.getCounselorsBySpecialization(specialization);
    }

    @Operation(summary = "Create a new counselor", description = "Adds a new counselor to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Counselor created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Counselor createCounselor(
            @Parameter(description = "Counselor object to be created", required = true)
            @RequestBody Counselor counselor) {
        try {
            return counselorService.createCounselor(counselor);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Operation(summary = "Update a counselor", description = "Updates the data of an existing counselor by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Counselor updated successfully"),
        @ApiResponse(responseCode = "404", description = "Counselor not found")
    })
    @PutMapping("/{id}")
    public Counselor updateCounselor(
            @Parameter(description = "Counselor ID", required = true) @PathVariable String id,
            @RequestBody Counselor counselor) {
        try {
            return counselorService.updateCounselor(id, counselor);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Operation(summary = "Delete a counselor", description = "Deletes a counselor by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Counselor deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Counselor not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCounselor(
            @Parameter(description = "Counselor ID", required = true) @PathVariable String id) {
        try {
            counselorService.deleteCounselor(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
