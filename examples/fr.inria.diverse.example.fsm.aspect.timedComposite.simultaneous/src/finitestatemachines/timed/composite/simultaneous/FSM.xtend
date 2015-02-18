package finitestatemachines.timed.composite.simultaneous

import FSM.interfaces.Context
import finitestatemachinescomposite.FinalState
import finitestatemachinescomposite.Fork
import finitestatemachinescomposite.InitialState
import finitestatemachinescomposite.Pseudostate
import finitestatemachinescomposite.State
import finitestatemachinescomposite.StateMachine
import finitestatemachinescomposite.Transition
import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import java.util.ArrayList
import java.util.List

import static extension finitestatemachines.timed.composite.simultaneous.StateAspect.*
import finitestatemachinescomposite.CompositeState

//
// *.*
// ASPECT
/**
 * StateMachineAspect: Aspects for the State Machine meta-class
 * Serves as the interpreter of the state machine (the controller of the )
 */
@Aspect(className=StateMachine)
class StateMachineAspect {
	
	public List<State> currentState = null;
	List<Transition> currentTransitions = null
	
	/**
	 * Evaluates the input and sequentially executes the steps in the state machine. 
	 */
	def public void eval (Context context, String filePath) {
		println("\nExecuting the state machine. Please wait for the results...\n")
		println(" ... executing input ...\n")
		
		var ArrayList<ArrayList<String>> events = context.events
		
		_self.currentState = _self.getInitialState()
		_self.currentState.get(0).eval(context)
		
		for(ArrayList<String> eventsGroup : events){
			println("  input item: " + eventsGroup + " time: " + (System.currentTimeMillis as int))
			_self.step(context, eventsGroup)
		}
		
		println("\n *.* Your results are ready! \n")
		(new Printer()).printFinalStateInConsole(_self)
		(new Printer()).printFinalStateInFile(_self, filePath)
	}
	
	/**
	 * Performs a step in the state machine i.e., reads an entry of the input stack and executes it.
	 * If there are several events in the same step they are executed in parallel. 
	 */
	def public void step(Context context, List<String> eventsGroup){
		_self.currentTransitions = new ArrayList<Transition>()

		var ArrayList<Thread> threads = new ArrayList<Thread>()
		for(String event : eventsGroup){
			var SimultaneousEventsThread thread = new SimultaneousEventsThread(event, _self, context)
			threads.add(thread)
			thread.start
		}
		
		var boolean threadsAlive = true
		while(threadsAlive){
			var int stillAlive = 0
			for(Thread _thread : threads){
				if(_thread.alive){stillAlive++}
			}
			if(stillAlive == 0)threadsAlive=false
		}
	}
	
	/**
	 * Returns the (unique?) initial state of the state machine. 
	 */
	def private List<State> getInitialState(){
		var ArrayList<State> answer = new ArrayList<State>()
		for(State state : _self.states){
			if(state instanceof InitialState) answer.add(state)
		}return answer
	}
	
	/**
	 * Removes a list of states from the currentStates list.
	 */
	def public synchronized void removeCurrentStates(List<State> statesToRemove){
		_self.currentState.removeAll(statesToRemove)
	}
	
	/**
	 * Removes a list of states from the currentStates list.
	 */
	def public synchronized void addCurrentStates(List<State> statesToAdd){
		for(State _state : statesToAdd){
			if(!_self.currentState.contains(_state))
				_self.currentState.add(_state)
		}
	}
}

//
// *.*
// ASPECT
/**
 * StateAspect: Implements the semantics of the concept State
 */
@Aspect(className=State)
class StateAspect {
	
	def public void eval(Context context) {
		_self.initialTime = (System.currentTimeMillis) as int
		Context.stateWorking(1000)
		_self.finalTime = (System.currentTimeMillis) as int
	}
}

@Aspect(className=CompositeState)
class CompositeStateAspect extends StateAspect {
	
	@OverrideAspectMethod
	def public void eval(Context context) {
		//Do nothing
	}
	
	/**
	 * Get all sub states
	 */
	def public List<State> getAllStates(){
		var ArrayList<State> attendedStates = new ArrayList<State>()
		var subStates = _self.regions.map[r | r.states].flatten
		while(!subStates.isEmpty){
			attendedStates.addAll(subStates)
			
			//Get sub states of subStates 
			var subComposite = subStates.filter[s|s instanceof CompositeState].map[s | s as CompositeState]
			subStates = subComposite.map[c|c.regions.map[r | r.states].flatten].flatten
		}
		return attendedStates
	}
}

@Aspect(className=Transition)
class TransitionAspect {
	
	int time = 0
	
	def public void process(Context context) {
		Context.stateWorking(_self.time)
	}
}