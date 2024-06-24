# StateBasedTestCaseGeneration #

This repository is a self-containing ready to compile eclipse project. The code utilizes a UML state-machine and generates JUnit test cases using the known N+ strategy.

### Main package expected to be selected when compiling ###

statemachinereader

### Limitations ###

* Will deal with only first region of the state machine.
* History, Deep History, Decision Pseudo States may Cause an Exception.
* Assumes That the SUT is in the SUT package
* Assumes That that SUT.tests is the package for testing.
* Code instrumentation required.
* Guards must be satisfied manually.

### What is Implemented? ###
* Reading of State Machine
* Transition Tree Generation
* Test case Generation according to various criteria
#### Following are the main functionalities of the project: ####

##### Junit4 Test Case Generation for #####
* All (Legal) Transitions Coverage (ALTC)
* All Round-Trip Path Coverage (ARTPC) (Not Done)
* Sneak Path Suite (Not Done)
