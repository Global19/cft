/*******************************************************************************
 * Copyright (c) 2016 Pivotal Software, Inc. and others 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution. 
 * 
 * The Eclipse Public License is available at 
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * and the Apache License v2.0 is available at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * You may elect to redistribute this code under either of these licenses.
 *  
 *  Contributors:
 *     Pivotal Software, Inc. - initial API and implementation
 ********************************************************************************/
package org.eclipse.cft.server.core.internal.client;

import org.cloudfoundry.client.lib.CloudFoundryOperations;
import org.eclipse.cft.server.core.internal.CloudFoundryServer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * 
 *
 * @deprecated Only used for v1 client support. Use {@link CloudServerRequest}
 * for wrapper client support
 */
abstract public class BehaviourRequest<T> extends LocalServerRequest<T> {

	protected final CloudFoundryServerBehaviour behaviour;

	public BehaviourRequest(String label, CloudFoundryServerBehaviour behaviour) {
		super(label);
		this.behaviour = behaviour;
	}

	@Override
	protected CloudFoundryOperations getClient(IProgressMonitor monitor) throws CoreException {
		return this.behaviour.getClient(monitor);
	}

	@Override
	protected CloudFoundryServer getCloudServer() throws CoreException {
		return this.behaviour.getCloudFoundryServer();
	}

}