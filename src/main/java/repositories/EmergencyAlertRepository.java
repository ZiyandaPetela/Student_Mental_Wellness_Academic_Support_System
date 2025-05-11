package repositories;

import core.EmergencyAlert;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyAlertRepository extends JpaRepository<EmergencyAlert, String> {
    // Alert-specific methods
    List<EmergencyAlert> findBySeverity(String severity);
    List<EmergencyAlert> findByEscalated(boolean escalated);
}