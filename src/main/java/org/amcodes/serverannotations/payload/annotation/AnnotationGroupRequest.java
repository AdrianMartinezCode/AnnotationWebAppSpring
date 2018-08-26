package org.amcodes.serverannotations.payload.annotation;

/**
 * 
 * @author adrian
 *
 *	That class is for a request for all annotations of a particular annotation group.
 */
public class AnnotationGroupRequest {
	private Long annotationGroupId;

	public Long getAnnotationGroupId() {
		return annotationGroupId;
	}

	public void setAnnotationGroupId(Long annotationGroupId) {
		this.annotationGroupId = annotationGroupId;
	}
	
	
}
