package repositories;

import core.Counselor;
import java.util.List;

public interface CounselorRepository extends Repository<Counselor, String> {
    // Counselor-specific methods
    List<Counselor> findBySpecialization(String specialization);
}