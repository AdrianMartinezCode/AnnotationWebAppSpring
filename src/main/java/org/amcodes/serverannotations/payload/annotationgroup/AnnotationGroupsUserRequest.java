package org.amcodes.serverannotations.payload.annotationgroup;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.amcodes.serverannotations.model.Annotation;
import org.amcodes.serverannotations.model.User;

/**
 * 
 * @author adrian
 *	
 *	That class is for a request by all annotationgroups of user.
 */
public class AnnotationGroupsUserRequest {
	
	@NotNull
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
