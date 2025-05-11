package repositories;

import core.Counselor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CounselorRepository extends JpaRepository<Counselor, String> {
    // Counselor-specific methods
    List<Counselor> findBySpecialization(String specialization);
}