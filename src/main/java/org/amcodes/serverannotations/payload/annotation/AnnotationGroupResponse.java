package org.amcodes.serverannotations.payload.annotation;

import java.util.Set;

public class AnnotationGroupResponse {
	private String title;
	private Set<AnnotationSummary> annotations;
	private String color;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<AnnotationSummary> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Set<AnnotationSummary> annotations) {
		this.annotations = annotations;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
