package org.amcodes.serverannotations.payload.annotationgroup;

import java.util.Set;

public class UserAnnotationGroupsResponse {
	private String email;
	private Set<AnnotationGroupSummary> annotationGroups;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<AnnotationGroupSummary> getAnnotationGroups() {
		return annotationGroups;
	}
	public void setAnnotationGroups(Set<AnnotationGroupSummary> annotationGroups) {
		this.annotationGroups = annotationGroups;
	}
	
}
