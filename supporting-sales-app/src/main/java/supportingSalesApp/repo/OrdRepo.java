package supportingSalesApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import supportingSalesApp.model.AppUser;
import supportingSalesApp.model.Ord;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdRepo extends JpaRepository<Ord, Long> {
    Optional<Ord> findById(Long id);

    List<Ord> findAll();

    List<Ord> findByAppUser(AppUser appUser);

    boolean existsById(Long id);
}
