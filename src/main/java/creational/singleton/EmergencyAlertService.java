package creational.singleton;

import core.EmergencyAlert;
public class EmergencyAlertService {
    private static EmergencyAlertService instance;
    private EmergencyAlertService() {}

    public static synchronized EmergencyAlertService getInstance() {
        if (instance == null) {
            instance = new EmergencyAlertService();
        }
        return instance;
    }

    public void handleAlert(EmergencyAlert alert) {
        System.out.println("Escalating alert: " + alert.getAlertId()); 
}
}