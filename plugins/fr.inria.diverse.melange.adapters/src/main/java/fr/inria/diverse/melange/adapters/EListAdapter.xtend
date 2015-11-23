package fr.inria.diverse.melange.adapters

import com.google.common.collect.Iterators
import java.lang.reflect.InvocationTargetException
import java.util.Collection
import org.eclipse.emf.common.util.EList

/**
 * Adapter delegation pattern for manipulating a {@link EList EList} of
 * elements of type {@link F} as an EList of elements of type {@link E},
 * providing that we have an {@link ListAdapter#adapType adapter type} between
 * {@link F} and {@link E}.
 */
class EListAdapter<E, F> implements GenericAdapter<EList<F>>, EList<E>
{
	EList<F> adaptee
	Class<? extends GenericAdapter<F>> adapType

	def static <E, F> EListAdapter<E, F> newInstance(EList<F> a, Class<? extends GenericAdapter<F>> type) {
		return new EListAdapter<E, F>(a, type)
	}

	new(EList<F> a, Class<? extends GenericAdapter<F>> type) {
		adaptee = a
		adapType = type
	}

	override add(E e) {
		return adaptee.add(decapsulate(e))
	}

	override add(int index, E element) {
		adaptee.add(index, decapsulate(element))
	}

	override addAll(Collection<? extends E> c) {
		c.forEach[adaptee.add(decapsulate(it))]
		return true
	}

	override addAll(int index, Collection<? extends E> c) {
		c.forEach[it, i | adaptee.add(index + i, decapsulate(it))]
		return true
	}

	override clear() {
		adaptee.clear
	}

	override contains(Object o) {
		return adaptee.contains(o.decapsulate)
	}

	override containsAll(Collection<?> c) {
		return adaptee.containsAll(c.map[decapsulate].toList)
	}

	override get(int index) {
		try {
			val adap = adapType.newInstance
			adap.adaptee = adaptee.get(index)
			return adap as E
		} catch (InstantiationException e) {
			// ...
		} catch (IllegalAccessException e) {
			// ...
		}
	}

	override indexOf(Object o) {
		return adaptee.indexOf(o)
	}

	override isEmpty() {
		return adaptee.isEmpty
	}

	override iterator() {
		return Iterators.transform(adaptee.iterator, new IteratorTranslator<F, E>(adapType))
	}

	override lastIndexOf(Object o) {
		return adaptee.lastIndexOf(decapsulate(o))
	}

	override listIterator() {
		return new ListIteratorWrapper(
			Iterators.transform(adaptee.listIterator, new IteratorTranslator<F, E>(adapType))
		)
	}

	override listIterator(int index) {
		return new ListIteratorWrapper(
			Iterators.transform(adaptee.listIterator(index), new IteratorTranslator<F, E>(adapType))
		)
	}

	override remove(Object o) {
		return adaptee.remove(decapsulate(o))
	}

	override remove(int index) {
		try {
			val adap = adapType.newInstance
			adap.adaptee = adaptee.remove(index)
			return adap as E
		} catch (InstantiationException e) {
			// ...
		} catch (IllegalAccessException e) {
			// ...
		}
	}

	override removeAll(Collection<?> c) {
		return adaptee.removeAll(c)
	}

	override retainAll(Collection<?> c) {
		return adaptee.retainAll(c)
	}

	override set(int index, E element) {
		try {
			val adap = adapType.newInstance
			adap.adaptee = adaptee.set(index, decapsulate(element))
			return adap as E
		} catch (InstantiationException e) {
			// ...
		} catch (IllegalAccessException e) {
			// ...
		}
	}

	override size() {
		return adaptee.size
	}

	override subList(int fromIndex, int toIndex) {
		return new ListAdapter<E, F>(adaptee.subList(fromIndex, toIndex), adapType)
	}

	override toArray() {
		return adaptee.toArray
	}

	override <T> toArray(T[] a) {
		return adaptee.toArray(a)
	}

	def F decapsulate(Object e) {
		return (e as GenericAdapter<F>).adaptee
	}

	override move(int newPosition, E object) {
		adaptee.move(newPosition, (object as GenericAdapter<F>).adaptee)
	}

	override move(int newPosition, int oldPosition) {
		try {
			return adapType.declaredConstructors.head.newInstance(adaptee.move(newPosition, oldPosition)) as E
		} catch (InstantiationException e) {
			// ...
		} catch (IllegalAccessException e) {
			// ...
		} catch (InvocationTargetException e) {
			// ...
		}
	}

	override getAdaptee() {
		return adaptee
	}

	override setAdaptee(EList<F> a) {
		adaptee = a
	}
}
