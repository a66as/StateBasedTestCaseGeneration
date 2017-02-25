# StateBasedTestCaseGeneration #

This repository is a self-containing ready to compile eclipse project.

### Main package expected to be selected when compiling ###

staterachinereader

### Limitations ###

* Will deal with only first region of the state machine.
* History, Deep History, Decision Pseudo States may Cause an Exception.
* Assumes That the SUT is in the SUT package
* Assumes That thet SUT.tests is the package for testing.
* Code instrumentation required.
* Guards must be satisfied manually.

### What is Implemented? ###

Following are the main functionality of the project:

#### Structural Coverage ####
* All States Coverage (ASC) (Conformance Suite)
* All (Legal) Transition Coverage (ALTC)
* All Pairwise Transition Coverage (2-Tuple)
* All Round-Trip Path Coverage (ARTPC)

#### Suite Coverage ####
* Conformance using All (Legal) Transition Coverage (ALTC)
* Sneak Path using All (Illegal) Transition Coverage (AITC)