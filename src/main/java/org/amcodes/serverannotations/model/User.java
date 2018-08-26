package org.amcodes.serverannotations.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="users", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
public class User extends DateAudit{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NaturalId
	@NotBlank
	@Size(max=200)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	@OneToMany
	private Set<AnnotationGroup> annoGroups = new HashSet<>();
	
	public User() {
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Set<AnnotationGroup> getAnnoGroups() {
		return annoGroups;
	}

	public void setAnnoGroups(Set<AnnotationGroup> annoGroups) {
		this.annoGroups = annoGroups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
