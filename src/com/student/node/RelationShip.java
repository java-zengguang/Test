package com.student.node;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RelationShip {
	public String table();
	public String name();
	public String bizName();
	public RelationType type();

}
