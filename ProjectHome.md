Swing Toolkit is an easy way to create windows, forms, etc.

**Getting started**

The easiest way to get your hands into the API is by exploring the components factories. They provide the simplest methods for creating and initializing AWT/Swing components.

**Using Templates**

The easiest way to start creating windows is by the use of the different templates bundled in the project. They require little coding from the user and are perfect for most of the requirements.

_First steps with a template_

Once you've chosen a template, you must subclassify it and implement all abstract methods inherited from the template. After that there's nothing else to do, you're ready to go. Don't worry, templates require few lines of code when subclassifying.

**Using Generic Windows**

This should be your choise when you have to create a more complex window and none of the templates are useful. In comparison, this is a much more complex mechanism, since it requires some knowledge from you and more effort to come up with the window you need.

**Synchronization**

A simple mechanism of synchronization has been developed to provide a basic level of interaction and synchronization between different windows.

**Component Factories**

This project also includes a serie of factories to create AWT and Swing component, and perform some basic configurations on them.

**Validator**

A Service of validation allows you to automatically perform basic validation of the input provided by the user. You can choose from different Decorators, to decide how errors are displayed (inline, with dialog messages, etc.).

**Annotations**

SwingToolkit has its own set of annotations, so you can annotate fields and specify some level of validation.

**J2SE**

This project is platform-independent and doesn't need any 3rd-party library.