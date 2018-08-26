package org.amcodes.serverannotations.controller;

import java.net.URI;

import javax.validation.Valid;

import org.amcodes.serverannotations.exception.UnauthorizedException;
import org.amcodes.serverannotations.model.Annotation;
import org.amcodes.serverannotations.model.AnnotationGroup;
import org.amcodes.serverannotations.model.User;
import org.amcodes.serverannotations.payload.ApiResponse;
import org.amcodes.serverannotations.payload.PagedResponse;
import org.amcodes.serverannotations.payload.annotation.AnnotationGroupResponse;
import org.amcodes.serverannotations.payload.annotation.CreateAnnotationRequest;
import org.amcodes.serverannotations.payload.annotationgroup.CreateAnnotationGroupRequest;
import org.amcodes.serverannotations.payload.annotationgroup.UserAnnotationGroupsResponse;
import org.amcodes.serverannotations.repository.AnnotationGroupRepository;
import org.amcodes.serverannotations.repository.AnnotationRepository;
import org.amcodes.serverannotations.repository.UserRepository;
import org.amcodes.serverannotations.security.CurrentUser;
import org.amcodes.serverannotations.security.UserPrincipal;
import org.amcodes.serverannotations.service.AnnotationService;
import org.amcodes.serverannotations.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/annotationgroups")
public class AnnotationGroupController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnnotationGroupRepository anGrRepository;
	
	@Autowired
	private AnnotationRepository anRepository;
	
	@Autowired
	private AnnotationService annServ;
	
	/*
	 * This method response in pages because the user can has a lot of annotations groups and
	 * 	is absurd show all them because, in generally, annotation groups 
	 * 	isn't related among them.
	 * 
	 */
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public PagedResponse<UserAnnotationGroupsResponse> getAnnotationGroups(
												 @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
												 @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		UserPrincipal usrp = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User usr = userRepository.getOne(usrp.getId());
		return annServ.getAnnotationGroupsByUser(usr, page, size);
	}
	
	
	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> createAnnotationGroup(@Valid @RequestBody CreateAnnotationGroupRequest cagReq) {
		UserPrincipal usrp = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User usr = userRepository.getOne(usrp.getId());
		AnnotationGroup ag = annServ.createAnnotationGroup(usr, cagReq);
		anGrRepository.save(ag);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{annotationGroupId}")
				.buildAndExpand(ag.getId()).toUri();
		return ResponseEntity.created(location)
				.body(new ApiResponse(true, "Annotation Group created successfully."));
	}
	
	@GetMapping("/{annotationGroupId}")
	@PreAuthorize("hasRole('USER')")
	public AnnotationGroupResponse getAnnotationsOfAnnotationGroup(@CurrentUser User user,
												@PathVariable Long annotationGroupId) {
		if (!userRepository.existsAnnotationGroupInUser(user.getId(), annotationGroupId)) {
			throw new UnauthorizedException("Annotation group not exists or it isn't yours.");
		}
		return annServ.getAnnotationsByAnnotationGroup(anGrRepository.getOne(annotationGroupId));
	}
	
	@PostMapping("/{annotationGroupId}")
	@PreAuthorize("hasRole('USER')")
	public AnnotationGroupResponse createAnnotation(@Valid @RequestBody CreateAnnotationRequest caReq) {
		Annotation a = annServ.createAnnotation(caReq);
		anRepository.save(a);
		/*URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{annotationGroupId}")
				.buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(location)
				.body(new ApiResponse(true, "Annotation created successfully."));*/
		return annServ.getAnnotationsByAnnotationGroup(anGrRepository.getOne(a.getAnnoGroup().getId()));
	}
	
}
