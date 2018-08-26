package org.amcodes.serverannotations.payload.annotationgroup;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.User;

public class CreateAnnotationGroupRequest {
	@NotBlank
	@Size(max=200)
	private String title;
	
	private String color;
	
	private Set<String> tags;
	
	private Long userId;
	
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
