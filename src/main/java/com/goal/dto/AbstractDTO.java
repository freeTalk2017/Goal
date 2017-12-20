package com.goal.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 抽象dto类，用于实现一些基础方法
 * @author lizhiwei
 *
 */
public abstract class AbstractDTO {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
