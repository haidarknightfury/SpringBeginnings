package com.smartfox.notemaker.config.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NoteExistCondition implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		Environment env= context.getEnvironment();
		return env.containsProperty("note.exist");
	}

}
