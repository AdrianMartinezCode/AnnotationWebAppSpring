package org.amcodes.serverannotations.repository;

import java.util.List;
import java.util.Optional;

import org.amcodes.serverannotations.model.Annotation;
import org.amcodes.serverannotations.model.AnnotationGroup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationGroupRepository extends JpaRepository<AnnotationGroup, Long>  {
	Optional<AnnotationGroup> findById(Long annogrId);
	List<AnnotationGroup> findByCreatedBy(Long userId, Pageable pageable);
	
}
