/**
 * Copyright (c) 2016,2020 University of Southampton.
 * 
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *    University of Southampton - initial API and implementation
 */
package ac.soton.xeventb.xmachine.generator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.persistence.EMFRodinDB;

/**
 * <p>
 * Generating Rodin Machine from the XMachine.
 * </p>
 * 
 * @author htson - Initial implementation
 * @author Dana (0.0.6) - Implementation for machine inclusion (0.0.6)
 * @author asiehsalehi (2.0) - Implementation for record extension (2.0)
 * @author htson (2.0) - Introduce generator for containment via extension points (2.0)
 * @author htson (2.0) - Serialised the configuration ac.soton.xeventb.xmachine.base (2.0)
 * @author htson (2.1) - Serialisation for typed variables
 * @version 2.0
 * @since 2.1
 */
@SuppressWarnings("all")
public class XMachineGenerator extends AbstractGenerator {
  private final String CONFIGURATION = "configuration";
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getSchedulingRule(Resource[]) is undefined"
      + "\nThe method translateTypedVariables(Machine) is undefined"
      + "\nThe method translateFormulae(Machine) is undefined");
  }
  
  private void generateShadowModels(final EMFRodinDB emfRodinDB, final URI uri, final Machine mch) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getAgents(Machine) is undefined"
      + "\nadd cannot be resolved");
  }
  
  private void generateShadowModel(final EMFRodinDB emfRodinDB, final URI original_uri, final Machine mch, final String agent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getHiddenVariables(Machine, String) is undefined"
      + "\njoin cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved");
  }
}
