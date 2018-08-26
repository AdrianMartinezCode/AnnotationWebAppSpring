package org.amcodes.serverannotations.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.audit.UserDateAudit;
import org.hibernate.annotations.NaturalId;



@Entity
@Table(name="annotations_group", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"title"})
})
public class AnnotationGroup extends UserDateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NaturalId
	@NotBlank
	@Size(max=200)
	private String title;
	
	@NotBlank
	private String color;
	
	@ElementCollection
	private Set<String> tags;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany
	private Set<Annotation> annos = new HashSet<>();
	
	public Set<Annotation> getAnnos() {
		return annos;
	}
	public void setAnnos(Set<Annotation> annos) {
		this.annos = annos;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public AnnotationGroup() {
	}
	public AnnotationGroup(String title, String color, Set<String> tags) {
		this.title = title;
		this.color = color;
		this.tags = tags;
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
	
}
