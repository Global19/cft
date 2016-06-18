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
package org.eclipse.cft.server.core.internal;

import org.eclipse.cft.server.core.internal.client.CloudFoundryApplicationModule;
import org.eclipse.wst.server.core.IModule;

public class CFConsoleHandler {

	private final String prefix;

	public CFConsoleHandler(String prefix) {
		this.prefix = prefix;
	}

	public void printToConsole(IModule module, CloudFoundryServer server, String message) {
		printToConsole(module, server, message, false);
	}

	public void printErrorToConsole(IModule module, CloudFoundryServer server, String message) {
		printToConsole(module, server, message, true);
	}

	public void printToConsole(IModule module, CloudFoundryServer server, String message, boolean error) {
		if (server != null) {
			CloudFoundryApplicationModule appModule = server.getExistingCloudModule(module);

			if (appModule != null) {
				message = prefix + " - " + message + '\n'; //$NON-NLS-1$
				CloudFoundryPlugin.getCallback().printToConsole(server, appModule, message, false, error);
			}
		}
	}
}
