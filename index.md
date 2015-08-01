---
layout: page
title: The Melange Metalanguage: Assemble and integrate your DSLs!
tagline: Assemble and Integrate your DSLs!
---
{% include JB/setup %}

![Melange workbench](../images/melange.png)

Melange is a language and platform for assembling and integrating multiple domain-specific languages (DSL).

Melange takes the form of a programming language where models are first-class citizens and languages are used to instantiate and manipulate them. By analogy with the class-based, object-oriented paradigm, Melange can be classified as a language-based, model-oriented programming language.

Melange embed a model-oriented type system that provides model polymorphism and substitutability, i.e. the possibility to manipulate a model through different interfaces and to define generic transformations that can be invoked on models written using different DSLs.

Melange is tightly integrated with the [Eclipse Modeling Framework](https://www.eclipse.org/modeling/emf/) ecosystem and relies on the Ecore implementation of the EMOF meta-language for the definition of the abstract syntax of DSLs through meta-modeling. Executable meta-modeling is supported by weaving operational semantics defined with the K3 meta-language.

Melange is bundled as a set of Eclipse plug-ins. Please refer to the [installation instructions](../download.html) for more information.

## Features

* __Executable metamodeling.__ Melange is tightly integrated with [K3](), a meta-language that leverages aspect-oriented modeling to weave operational semantics in metamodel definitions.
* __Language extension__ Using high-level operators (e.g. inheritance, merge), language definitions can be manipulated, extended or restrained to create new DSLs.
* __Model polymorphism__ Melange's type system supports model polymorphism and substitutability, and the definition of generic transformations that can be applied on models originating from different DSLs.
