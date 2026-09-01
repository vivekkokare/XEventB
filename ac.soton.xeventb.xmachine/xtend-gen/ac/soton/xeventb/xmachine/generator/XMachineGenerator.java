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

import ac.soton.emf.translator.TranslatorFactory;
import ac.soton.eventb.emf.agent.AgentTypedVariable;
import ac.soton.eventb.emf.containment.Containment;
import ac.soton.eventb.emf.core.extension.coreextension.TypedVariable;
import ac.soton.eventb.emf.diagrams.DiagramOwner;
import ac.soton.xeventb.common.Utils;
import ac.soton.xeventb.xmachine.IContainmentGenerator;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CoreFactory;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachineFactory;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.persistence.EMFRodinDB;
import org.eventb.emf.persistence.EventBEMFUtils;
import org.eventb.emf.persistence.PersistencePlugin;
import org.eventb.emf.persistence.SaveResourcesCommand;
import org.rodinp.core.RodinCore;

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
    try {
      EObject _get = resource.getContents().get(0);
      final Machine mch = ((Machine) _get);
      String uriString = resource.getURI().toString();
      uriString = uriString.substring(0, uriString.lastIndexOf("bumx"));
      uriString = (uriString + "bum");
      final URI uri = URI.createURI(uriString);
      ResourceSet _resourceSet = resource.getResourceSet();
      final EMFRodinDB emfRodinDB = new EMFRodinDB(_resourceSet);
      final TransactionalEditingDomain editingDomain = emfRodinDB.getEditingDomain();
      final Resource rodinResource = emfRodinDB.getResource(uri);
      final RecordingCommand command = new RecordingCommand(editingDomain, "Set Contents") {
        @Override
        public void doExecute() {
          rodinResource.getContents().clear();
          rodinResource.getContents().add(0, mch);
          final Annotation rodinInternals = CoreFactory.eINSTANCE.createAnnotation();
          rodinInternals.setSource(PersistencePlugin.SOURCE_RODIN_INTERNAL_ANNOTATION);
          final EMap<String, String> rodinInternalDetails = rodinInternals.getDetails();
          rodinInternalDetails.put(
            XMachineGenerator.this.CONFIGURATION, 
            "org.eventb.core.fwd;ac.soton.xeventb.xmachine.base");
          mch.getAnnotations().add(rodinInternals);
          XMachineGenerator.this.translateTypedVariables(mch);
          XMachineGenerator.this.translateFormulae(mch);
          rodinResource.setModified(true);
          XMachineGenerator.this.generateShadowModels(emfRodinDB, uri, mch);
        }
      };
      boolean _canExecute = command.canExecute();
      if (_canExecute) {
        editingDomain.getCommandStack().execute(command);
      }
      boolean _isEmpty = mch.getExtensions().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        TranslatorFactory _factory = TranslatorFactory.getFactory();
        final TranslatorFactory factory = ((TranslatorFactory) _factory);
        String commandId = "ac.soton.eventb.emf.inclusion.commands.include";
        boolean _canTranslate = factory.canTranslate(commandId, mch.eClass());
        if (_canTranslate) {
          final NullProgressMonitor monitor = new NullProgressMonitor();
          factory.translate(editingDomain, mch, commandId, monitor);
        }
        String recordCommandId = "ac.soton.eventb.emf.record.generator.translateAllRecords";
        boolean _canTranslate_1 = factory.canTranslate(recordCommandId, mch.eClass());
        if (_canTranslate_1) {
          final NullProgressMonitor monitor_1 = new NullProgressMonitor();
          factory.translate(editingDomain, mch, recordCommandId, monitor_1);
        }
      }
      final SaveResourcesCommand saveCommand = new SaveResourcesCommand(editingDomain);
      final IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {
        @Override
        public void run(final IProgressMonitor monitor) {
          try {
            try {
              saveCommand.execute(monitor, null);
            } catch (final Throwable _t) {
              if (_t instanceof ExecutionException) {
                final ExecutionException e = (ExecutionException)_t;
                final Status status = new Status(IStatus.ERROR, "ac.soton.xeventb.xmachine", "Nothing", e);
                throw new CoreException(status);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final NullProgressMonitor monitor_2 = new NullProgressMonitor();
      boolean _canExecute_1 = saveCommand.canExecute();
      if (_canExecute_1) {
        final Resource[] emptyResource = {};
        RodinCore.run(wsRunnable, 
          this.getSchedulingRule(editingDomain.getResourceSet().getResources().<Resource>toArray(emptyResource)), monitor_2);
      }
      monitor_2.done();
      final ContainmentRegistry registry = ContainmentRegistry.getDefault();
      EList<AbstractExtension> _extensions = mch.getExtensions();
      for (final AbstractExtension ex : _extensions) {
        if ((ex instanceof Containment)) {
          final Containment ctmt = ((Containment) ex);
          final DiagramOwner owner = ctmt.getExtension();
          final Collection<IContainmentGenerator> generators = registry.getGenerators(owner);
          for (final IContainmentGenerator generator : generators) {
            generator.generate(mch, owner, editingDomain);
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void generateShadowModels(final EMFRodinDB emfRodinDB, final URI uri, final Machine mch) {
    final Collection<String> agents = this.getAgents(mch);
    agents.add("others");
    for (final String agent : agents) {
      this.generateShadowModel(emfRodinDB, uri, mch, agent);
    }
  }
  
  private void generateShadowModel(final EMFRodinDB emfRodinDB, final URI original_uri, final Machine mch, final String agent) {
    String uriString = original_uri.toString();
    uriString = uriString.substring(0, uriString.lastIndexOf(".bum"));
    uriString = (((uriString + "_") + agent) + ".bum");
    final URI uri = URI.createURI(uriString);
    final Resource rodinResource = emfRodinDB.getResource(uri);
    rodinResource.getContents().clear();
    final TransactionalEditingDomain editingDomain = emfRodinDB.getEditingDomain();
    final Machine copy = EcoreUtil.<Machine>copy(mch);
    rodinResource.getContents().add(0, copy);
    final String shadowVariable = ("H_" + agent);
    EventBEMFUtils.createVariable(editingDomain, copy, shadowVariable);
    final ArrayList<String> hiddenVariables = this.getHiddenVariables(copy, agent);
    final String shadow = IterableExtensions.join(hiddenVariables, " ↦ ");
    EventBEMFUtils.createInvariant(editingDomain, copy, "shadow", ((shadow + " ∈ ") + shadowVariable), false);
    Object _eGet = copy.eGet(
      CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN);
    final EList<EventBElement> orderedChildren = ((EList<EventBElement>) _eGet);
    for (final EventBElement child : orderedChildren) {
      if ((child instanceof Event)) {
        boolean _equals = ((Event)child).getName().equals("INITIALISATION");
        if (_equals) {
          EList<Action> _actions = ((Event)child).getActions();
          for (final Action action : _actions) {
            boolean _equals_1 = action.getName().equals("shadow_update");
            if (_equals_1) {
              String assignment = action.getAction();
              final String[] split_string = assignment.split(":∣");
              String lhs = split_string[0];
              String rhs = split_string[1];
              lhs = ((lhs + ", ") + shadowVariable);
              final ArrayList<String> shadowHiddenPrimedVariable = new ArrayList<String>();
              for (final String hiddenVariable : hiddenVariables) {
                shadowHiddenPrimedVariable.add((("shadow_" + hiddenVariable) + "\'"));
              }
              assignment = (((lhs + " :∣ ") + rhs) + " ∧ ");
              String shadowUpdate = "";
              String _shadowUpdate = shadowUpdate;
              String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(shadowHiddenPrimedVariable.toArray())), " ↦ ");
              shadowUpdate = (_shadowUpdate + _join);
              String _shadowUpdate_1 = shadowUpdate;
              shadowUpdate = (_shadowUpdate_1 + " ∣ ");
              for (final String hiddenVariable_1 : hiddenVariables) {
                rhs = rhs.replaceAll(hiddenVariable_1, ("shadow_" + hiddenVariable_1));
              }
              String _shadowUpdate_2 = shadowUpdate;
              shadowUpdate = (_shadowUpdate_2 + rhs);
              String _assignment = assignment;
              assignment = (_assignment + (((shadowVariable + "\' = {") + shadowUpdate) + "}"));
              action.setAction(assignment);
            }
          }
        } else {
          EList<Action> _actions_1 = ((Event)child).getActions();
          for (final Action action_1 : _actions_1) {
            boolean _equals_2 = action_1.getName().equals("shadow_update");
            if (_equals_2) {
              String assignment_1 = action_1.getAction();
              final String[] split_string_1 = assignment_1.split(":∣");
              String lhs_1 = split_string_1[0];
              String rhs_1 = split_string_1[1];
              lhs_1 = ((lhs_1 + ", ") + shadowVariable);
              String shadowUpdate_1 = "";
              final ArrayList<String> shadowHiddenVariable = new ArrayList<String>();
              final ArrayList<String> shadowHiddenPrimedVariable_1 = new ArrayList<String>();
              for (final String hiddenVariable_2 : hiddenVariables) {
                {
                  shadowHiddenVariable.add(("shadow_" + hiddenVariable_2));
                  shadowHiddenPrimedVariable_1.add((("shadow_" + hiddenVariable_2) + "\'"));
                }
              }
              assignment_1 = (((lhs_1 + " :∣ ") + rhs_1) + " ∧ ");
              String _shadowUpdate_3 = shadowUpdate_1;
              String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(shadowHiddenPrimedVariable_1.toArray())), " ↦ ");
              shadowUpdate_1 = (_shadowUpdate_3 + _join_1);
              String _shadowUpdate_4 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_4 + " ∣ ");
              String _shadowUpdate_5 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_5 + "∃ ");
              String _shadowUpdate_6 = shadowUpdate_1;
              String _join_2 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(shadowHiddenVariable.toArray())), ", ");
              shadowUpdate_1 = (_shadowUpdate_6 + _join_2);
              String _shadowUpdate_7 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_7 + " · ");
              String _shadowUpdate_8 = shadowUpdate_1;
              String _join_3 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(shadowHiddenVariable.toArray())), " ↦ ");
              shadowUpdate_1 = (_shadowUpdate_8 + _join_3);
              String _shadowUpdate_9 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_9 + " ∈ ");
              String _shadowUpdate_10 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_10 + shadowVariable);
              String _shadowUpdate_11 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_11 + " ∧ ");
              for (final String hiddenVariable_3 : hiddenVariables) {
                rhs_1 = rhs_1.replaceAll(hiddenVariable_3, ("shadow_" + hiddenVariable_3));
              }
              String _shadowUpdate_12 = shadowUpdate_1;
              shadowUpdate_1 = (_shadowUpdate_12 + rhs_1);
              String _assignment_1 = assignment_1;
              assignment_1 = (_assignment_1 + (((shadowVariable + "\' = {") + shadowUpdate_1) + "}"));
              action_1.setAction(assignment_1);
            }
          }
        }
      }
    }
    rodinResource.setModified(true);
  }
  
  public String shadowPrepend(final String e) {
    return ("shadow_" + e);
  }
  
  private ArrayList<String> getHiddenVariables(final Machine mch, final String agent) {
    Object _eGet = mch.eGet(
      CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN);
    final EList<EventBElement> orderedChildren = ((EList<EventBElement>) _eGet);
    final ArrayList<String> hidden_variables = new ArrayList<String>();
    for (final EventBElement child : orderedChildren) {
      if ((child instanceof AgentTypedVariable)) {
        boolean _contains = ((AgentTypedVariable)child).getAgents().contains(agent);
        boolean _not = (!_contains);
        if (_not) {
          hidden_variables.add(((AgentTypedVariable)child).getName());
        }
      }
    }
    return hidden_variables;
  }
  
  private Collection<String> getAgents(final Machine mch) {
    Object _eGet = mch.eGet(
      CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN);
    EList<EventBElement> orderedChildren = ((EList<EventBElement>) _eGet);
    final HashSet<String> agents = new HashSet<String>();
    int i = 0;
    while ((i < orderedChildren.size())) {
      {
        final EventBElement child = orderedChildren.get(i);
        if ((child instanceof AgentTypedVariable)) {
          agents.addAll(((AgentTypedVariable)child).getAgents());
        }
        i++;
      }
    }
    return agents;
  }
  
  /**
   * Utility method to translate typed variables of a machine to variables,
   * typing invariants and initialisation action.
   * 
   * @param ctx The input machine
   */
  private void translateTypedVariables(final Machine mch) {
    Object _eGet = mch.eGet(
      CorePackage.Literals.EVENT_BELEMENT__ORDERED_CHILDREN);
    EList<EventBElement> orderedChildren = ((EList<EventBElement>) _eGet);
    int i = 0;
    while ((i < orderedChildren.size())) {
      {
        final EventBElement child = orderedChildren.get(i);
        if ((child instanceof TypedVariable)) {
          final String name = ((TypedVariable)child).getName();
          final String type = ((TypedVariable)child).getType();
          final String value = ((TypedVariable)child).getValue();
          Variable vrb = MachineFactory.eINSTANCE.createVariable();
          vrb.setName(name);
          orderedChildren.add(i, vrb);
          i++;
          if ((type != null)) {
            Invariant inv = MachineFactory.eINSTANCE.createInvariant();
            inv.setName((name + "-typeof"));
            inv.setPredicate(((name + " ∈ ") + type));
            inv.setTheorem(false);
            orderedChildren.add(i, inv);
            i++;
          }
          if ((value != null)) {
            Event initialisation = null;
            EList<Event> _events = mch.getEvents();
            for (final Event event : _events) {
              String _name = event.getName();
              boolean _equals = Objects.equal(_name, "INITIALISATION");
              if (_equals) {
                initialisation = event;
              }
            }
            if ((initialisation == null)) {
              initialisation = MachineFactory.eINSTANCE.createEvent();
              initialisation.setName("INITIALISATION");
              orderedChildren.add(i, initialisation);
              i++;
            }
            Action act = MachineFactory.eINSTANCE.createAction();
            act.setName((name + "-init"));
            act.setAction(((name + " := ") + value));
            initialisation.getOrderedChildren().add(act);
          }
        }
        i++;
      }
    }
  }
  
  private ISchedulingRule getSchedulingRule(final Resource[] resources) {
    int _length = resources.length;
    boolean _equals = (_length == 0);
    if (_equals) {
      return null;
    } else {
      int _length_1 = resources.length;
      boolean _equals_1 = (_length_1 == 1);
      if (_equals_1) {
        return WorkspaceSynchronizer.getFile(resources[0]);
      } else {
        final IProject project = this.getProject(resources[0]);
        for (final Resource resource : resources) {
          IProject _project = this.getProject(resource);
          boolean _notEquals = (!Objects.equal(project, _project));
          if (_notEquals) {
            return ResourcesPlugin.getWorkspace().getRoot();
          }
        }
        return project;
      }
    }
  }
  
  private IProject getProject(final Resource resource) {
    final IFile file = WorkspaceSynchronizer.getFile(resource);
    IProject _elvis = null;
    IProject _project = null;
    if (file!=null) {
      _project=file.getProject();
    }
    if (_project != null) {
      _elvis = _project;
    } else {
      _elvis = null;
    }
    return _elvis;
  }
  
  /**
   * Utility method to translate formulae in the input machine to Event-B
   * mathematics.
   * 
   * @param mch
   * 		The input machine
   * @author htson
   * @since 2.0
   */
  private void translateFormulae(final Machine mch) {
    final EList<EObject> predElements = mch.getAllContained(
      CorePackage.Literals.EVENT_BPREDICATE, false);
    Utils.translatePredicates(predElements);
    final EList<EObject> exprElements = mch.getAllContained(
      CorePackage.Literals.EVENT_BEXPRESSION, false);
    Utils.translateExpressions(exprElements);
    final EList<EObject> asgnElements = mch.getAllContained(
      CorePackage.Literals.EVENT_BACTION, false);
    Utils.translateAssignments(asgnElements);
  }
}
