package org.amcodes.serverannotations.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.amcodes.serverannotations.model.Annotation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
	Optional<Annotation> findById(Long annoId);
	Page<Annotation> findByCreatedBy(Long annogroupId, Pageable pageable);
	/*@Query("SELECT COUNT(ag.id) ")
	long countByAnnotationGroupId(Long userId);*/
	List<Annotation> findByIdIn(List<Long> annoIds);
	List<Annotation> findByIdIn(List<Long> annoIds, Sort sort);
}
