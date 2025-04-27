package repositories;

import core.EmergencyAlert;
import java.util.List;

public interface EmergencyAlertRepository extends Repository<EmergencyAlert, String> {
    // Alert-specific methods
    List<EmergencyAlert> findBySeverity(String severity);
    List<EmergencyAlert> findByEscalated(boolean escalated);
}