// src/api/CounselorController.java
package api;

import core.Counselor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import services.CounselorService;

import java.util.List;

@RestController
@RequestMapping("/api/counselors")
public class CounselorController {
    
    private final CounselorService counselorService;
    
    @Autowired
    public CounselorController(CounselorService counselorService) {
        this.counselorService = counselorService;
    }
    
    @GetMapping
    public List<Counselor> getAllCounselors() {
        return counselorService.getAllCounselors();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Counselor> getCounselorById(@PathVariable String id) {
        return counselorService.getCounselorById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Counselor not found with id: " + id));
    }
    
    @GetMapping("/specialization/{specialization}")
    public List<Counselor> getCounselorsBySpecialization(@PathVariable String specialization) {
        return counselorService.getCounselorsBySpecialization(specialization);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Counselor createCounselor(@RequestBody Counselor counselor) {
        try {
            return counselorService.createCounselor(counselor);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public Counselor updateCounselor(@PathVariable String id, @RequestBody Counselor counselor) {
        try {
            return counselorService.updateCounselor(id, counselor);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCounselor(@PathVariable String id) {
        try {
            counselorService.deleteCounselor(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}