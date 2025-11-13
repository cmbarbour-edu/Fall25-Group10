package Nat20.Network.sysadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysadminRepository extends JpaRepository<Sysadmin, Long> {
    
}
