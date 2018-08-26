package org.amcodes.serverannotations.service;

import java.util.Collections;
import java.util.List;

import org.amcodes.serverannotations.exception.BadRequestException;
import org.amcodes.serverannotations.model.Annotation;
import org.amcodes.serverannotations.model.AnnotationGroup;
import org.amcodes.serverannotations.model.User;
import org.amcodes.serverannotations.payload.PagedResponse;
import org.amcodes.serverannotations.payload.annotation.AnnotationGroupRequest;
import org.amcodes.serverannotations.payload.annotation.AnnotationGroupResponse;
import org.amcodes.serverannotations.payload.annotation.CreateAnnotationRequest;
import org.amcodes.serverannotations.payload.annotationgroup.CreateAnnotationGroupRequest;
import org.amcodes.serverannotations.payload.annotationgroup.UserAnnotationGroupsResponse;
import org.amcodes.serverannotations.repository.AnnotationGroupRepository;
import org.amcodes.serverannotations.repository.AnnotationRepository;
import org.amcodes.serverannotations.repository.UserRepository;
import org.amcodes.serverannotations.util.AppConstants;
import org.amcodes.serverannotations.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AnnotationService {
	
	@Autowired
	private AnnotationRepository annoRep;
	
	@Autowired
	private AnnotationGroupRepository annoGrRep;
	
	@Autowired
	private UserRepository userRep;
	
	public PagedResponse<UserAnnotationGroupsResponse> getAnnotationGroupsByUser(User user, int page, int size) {
		validatePageNumberAndSize(page, size);
		
		/*
		 * This links with jpa directly, we define the order of elements,
		 * and we call the repository and implement that order in the search
		 */
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		Page<AnnotationGroup> annoGroups = annoGrRep.findAll(pageable);
		
		if (annoGroups.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), annoGroups.getNumber(),
					annoGroups.getSize(), annoGroups.getTotalElements(),
					annoGroups.getTotalPages(), annoGroups.isLast());
		}
		
		//List<Long> annoGroupIds = annoGroups.map(AnnotationGroup::getId).getContent();
		List<UserAnnotationGroupsResponse> uagr = annoGroups.map(annoGr -> {
			return ModelMapper.mapUserToAnnoGroupResponse(user);
		}).getContent();
		
		return new PagedResponse<>(uagr, annoGroups.getNumber(),
				annoGroups.getSize(), annoGroups.getTotalElements(),
				annoGroups.getTotalPages(), annoGroups.isLast());
	}
	
	public AnnotationGroupResponse getAnnotationsByAnnotationGroup(AnnotationGroup annoGroup) {
		//Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
		//Page<Annotation> annos = annoRep.findAll(pageable);
		//if (annos.getNumberOfElements() == 0) {
			/*return new PagedResponse<>(Collections.emptyList(), annos.getNumber(),
					annos.getSize(), annos.getTotalElements(),
					annos.getTotalPages(), annos.isLast());*/
		//}
		//List<AnnotationGroupResponse> uagr = annos.map(anno -> {
		//	return ModelMapper.mapAnnoGroupToResponse(annoGroup);
		//}).getContent();
		
		/*AnnotationGroupResponse agResp = new AnnotationGroupResponse();
		agResp.*/
		return ModelMapper.mapAnnoGroupToResponse(annoGroup);
		
		/*return new PagedResponse<>(uagr, annos.getNumber(),
				annos.getSize(), annos.getTotalElements(),
				annos.getTotalPages(), annos.isLast());*/
		
	}
	
	public AnnotationGroup createAnnotationGroup(User user, CreateAnnotationGroupRequest req) {
		AnnotationGroup ag = new AnnotationGroup();
		
		ag.setColor(req.getColor());
		ag.setTitle(req.getTitle());
		ag.setTags(req.getTags());
		
		ag.setUser(user);
		
		return ag;
	}
	
	public Annotation createAnnotation(CreateAnnotationRequest req) {
		Annotation an = new Annotation();
		
		an.setAnnoGroup(annoGrRep.getOne(req.getAnnoGroupId()));
		an.setColor(req.getColor());
		an.setTags(req.getTags());
		an.setText(req.getText());
		an.setTitle(req.getTitle());
		
		return an;
	}
	
	private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
	
}
