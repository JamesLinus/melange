package fr.inria.diverse.melange.builder

import fr.inria.diverse.melange.metamodel.melange.Operator

abstract class OperatorBuilder<T extends Operator> extends AbstractBuilder {
	public T source

	new(T source) {
		super()
		this.source = source
	}
}
