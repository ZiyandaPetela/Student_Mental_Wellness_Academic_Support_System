package repositories.inmemory;

import core.EmergencyAlert;
import repositories.EmergencyAlertRepository;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryEmergencyAlertRepository extends InMemoryRepository<EmergencyAlert, String> 
        implements EmergencyAlertRepository {
    
    @Override
    protected String getId(EmergencyAlert entity) {
        return entity.getAlertId();
    }
    
    @Override
    public List<EmergencyAlert> findBySeverity(String severity) {
        return storage.values().stream()
                .filter(alert -> severity.equals(alert.getSeverity()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<EmergencyAlert> findByEscalated(boolean escalated) {
        return storage.values().stream()
                .filter(alert -> escalated == alert.isEscalated())
                .collect(Collectors.toList());
    }
}