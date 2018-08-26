package org.amcodes.serverannotations.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.audit.UserDateAudit;

@Entity
@Table(name="annotations")
public class Annotation extends UserDateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=1000)
	private String text;
	
	@NotBlank
	private String color;
	
	@NotBlank
	@Size(max=200)
	private String title;
	
	@ElementCollection
	private Set<String> tags;
	
	@ManyToOne
	@JoinColumn(name = "annotationgroup_id", nullable = false)
	private AnnotationGroup annoGroup;
	
	public Annotation() {
	}
	public Annotation(String title, String color, Set<String> tags) {
		this.title = title;
		this.color = color;
		this.tags = tags;
	}
	public AnnotationGroup getAnnoGroup() {
		return annoGroup;
	}
	public void setAnnoGroup(AnnotationGroup annoGroup) {
		this.annoGroup = annoGroup;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
