# StateBasedTestCaseGeneration #

This repository is a self-containing ready to compile eclipse project.

### Main package expected to be selected when compiling ###

staterachinereader

### Limitations ###

1) Will deal with only first region of the state machine.
2) History, Deep History, Decision Pseudo States may Cause an Exception.
3) Assumes That the SUT is in the SUT package
4) Assumes That thet SUT.tests is the package for testing.
5) Code instrumentation required.

### What is Implemented? ###

#### Structural Coverage ####
1) All States Coverage (ASC) (Conformance Suite)
2) All (Legal) Transition Coverage (ALTC)
3) All Pairwise Transition Coverage (2-Tuple)
4) All Round-Trip Path Coverage (ARTPC)

#### Suite Coverage ####
1) Conformance using All (Legal) Transition Coverage (ALTC)
2) Sneak Path using All (Illegal) Transition Coverage (AITC)