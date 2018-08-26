package org.amcodes.serverannotations.repository;


import org.amcodes.serverannotations.model.Role;
import org.amcodes.serverannotations.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}