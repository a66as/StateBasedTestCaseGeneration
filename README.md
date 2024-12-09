# StateBasedTestCaseGeneration #


### Limitations ###

* Will deal with only first region of the state machine.
* History, Deep History, Decision Pseudo States may cause an exceptions.
* Assumes state observability and a flattened state-machine

### What is Implemented? ###
* Running manually written unit test
* Transition Tree Generation from statemachine
* Test case Generation for conformance and sneak paths
* Ability to make edits to generated tests
* Running generated and manual unit tests on mutants

##### How to Run the Code Play Ground? #####
* Clone the `master` branch
* Install and open Docker Desktop (preferable version: 4.31.1), make sure that the engine is up and running.
* Open `/StateBasedTestCaseGeneration/demo/` in terminal
* Run the following commands in terminal
  * `docker build -t capsule .` (to build the image)
  * `docker run -d -v my_src_volume:/src -v my_models_volume:/Models -v my_jarfile_lib_volume:/jarfile_lib  -p 8080:8080 --name capsule_container capsule` (to run the container)
  * `docker logs -f capsule_container` (to get logs of container)
* The app should be up and running, navigate to `http://localhost:8080/` in your browser
* If you want to stop/start the app use `docker stop/start capsule_container`

> [!NOTE]
> Tutorial for students is [available](https://youtu.be/8nbEoI6xXMQ).








