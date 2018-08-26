package org.amcodes.serverannotations.payload.annotation;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.AnnotationGroup;

public class CreateAnnotationRequest {
	@Size(max=1000)
	private String text;
	
	@Column(name="color", columnDefinition = "String default #000000")
	private String color;
	
	@NotBlank
	@Size(max=200)
	private String title;
	
	private Set<String> tags;
	
	private Long annoGroupId;

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

	public Long getAnnoGroupId() {
		return annoGroupId;
	}

	public void setAnnoGroupId(Long annoGroupId) {
		this.annoGroupId = annoGroupId;
	}
	
	
}
