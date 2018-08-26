package org.amcodes.serverannotations.payload.annotationgroup;

import java.util.Set;

import javax.persistence.Column;

public class AnnotationGroupSummary {
	private String title;
	
	private String color;
	
	private Set<String> tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	
}
