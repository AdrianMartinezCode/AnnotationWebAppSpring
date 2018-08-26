package org.amcodes.serverannotations.repository;


import org.amcodes.serverannotations.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);
    
    /*
     * That query seeks if the annotation id is of the user.
     */
    @Query("select count(e) > 0 from AnnotationGroup e INNER JOIN User u where e.id = :annoGroupId and u.id = :userId")
    Boolean existsAnnotationGroupInUser(Long userId, Long annoGroupId);
}