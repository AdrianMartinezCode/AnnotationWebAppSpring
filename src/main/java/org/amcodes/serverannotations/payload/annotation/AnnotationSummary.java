package org.amcodes.serverannotations.payload.annotation;

import java.util.Set;

public class AnnotationSummary {
	private String text;
	
	private String color;
	
	private String title;
	
	private Set<String> tags;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	
}
