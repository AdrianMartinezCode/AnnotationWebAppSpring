package org.amcodes.serverannotations.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.amcodes.serverannotations.model.AnnotationGroup;
import org.amcodes.serverannotations.model.User;
import org.amcodes.serverannotations.payload.annotation.AnnotationGroupResponse;
import org.amcodes.serverannotations.payload.annotation.AnnotationSummary;
import org.amcodes.serverannotations.payload.annotationgroup.AnnotationGroupSummary;
import org.amcodes.serverannotations.payload.annotationgroup.UserAnnotationGroupsResponse;

public class ModelMapper {
	public static UserAnnotationGroupsResponse mapUserToAnnoGroupResponse(User user) {
		UserAnnotationGroupsResponse uagr = new UserAnnotationGroupsResponse();
		uagr.setEmail(user.getEmail());
		Set<AnnotationGroupSummary> annoGroups = user.getAnnoGroups().stream().map(annoGroup ->{
			AnnotationGroupSummary ags = new AnnotationGroupSummary();
			ags.setColor(annoGroup.getColor());
			ags.setTags(new HashSet<String>(annoGroup.getTags()));
			ags.setTitle(annoGroup.getTitle());
			return ags;
		}).collect(Collectors.toSet());
		uagr.setAnnotationGroups(annoGroups);
		return uagr;
	}
	
	public static AnnotationGroupResponse mapAnnoGroupToResponse(AnnotationGroup annoGroup) {
		AnnotationGroupResponse agr = new AnnotationGroupResponse();
		agr.setColor(annoGroup.getColor());
		agr.setTitle(annoGroup.getTitle());
		Set<AnnotationSummary> annos = annoGroup.getAnnos().stream().map(anno -> {
			AnnotationSummary as = new AnnotationSummary();
			as.setColor(anno.getColor());
			as.setTags(new HashSet<String>(anno.getTags()));
			as.setText(anno.getText());
			as.setTitle(anno.getTitle());
			return as;
		}).collect(Collectors.toSet());
		agr.setAnnotations(annos);
		return agr;
	}
}
