/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.platform.engine.discovery;

import static org.junit.platform.commons.meta.API.Usage.Experimental;

import org.junit.platform.commons.meta.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

/**
 * A {@link DiscoverySelector} that selects the name of a <em>classpath resource</em>
 * so that {@link org.junit.platform.engine.TestEngine TestEngines} can load resources
 * from the classpath &mdash; for example, to load XML or JSON files from the classpath,
 * potentially within JARs.
 *
 * @since 1.0
 * @see ClasspathRootSelector
 * @see #getClasspathResourceName()
 */
@API(Experimental)
public class ClasspathResourceSelector implements DiscoverySelector {

	private final String classpathResourceName;

	ClasspathResourceSelector(String classpathResourceName) {
		boolean startsWithSlash = classpathResourceName.startsWith("/");
		this.classpathResourceName = (startsWithSlash ? classpathResourceName.substring(1) : classpathResourceName);
	}

	/**
	 * Get the name of the selected classpath resource.
	 *
	 * <p>The name of a <em>classpath resource</em> must follow the semantics
	 * for resource paths as defined in {@link ClassLoader#getResource(String)}.
	 *
	 * @see ClassLoader#getResource(String)
	 * @see ClassLoader#getResourceAsStream(String)
	 * @see ClassLoader#getResources(String)
	 */
	public String getClasspathResourceName() {
		return this.classpathResourceName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("classpathResourceName", this.classpathResourceName).toString();
	}

}
