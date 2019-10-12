# Brief Explanation of Refactored Structure:
Essentially the stage class acts as a state machine which stores the different states as instance variables. A variable known as currentState determines the current state of the game by invoking the .handle and .handleCpu() methods in stage.mouseClicked and stage.paint() respectively. This means that the different state classes will execute the appropriate behaviour using their own handler methods as the currentState variable changes. This ensures that all State behaviour is encapsulated within the state classes and simply called upon in stage.java via currentState variable.

# Departure / Criticism:
Overall the state pattern is followed very closely with very few departures. Perhaps the most critisizable part of the refactorization is the fact that an interface is chosen to define the states and that the behaviour of CPUMoving is defined in its very own methods handleCpu() (this is because unlike the other states, the behaviour triggered by CPUMoving is constantly called upon by paint). Due to this, an empty version of the handleCpu() method HAS to be implemented in all the other states. Empty methods are an inelegant design choice, however the state pattern is fully implemented.

# Interface over Abstract Class
Although there is no strict rule over choosing one over the other I thought it might be appropriate to justify the choice. Given there was no common functionality between the states to put into an abstract class, I chose to implement an interface.
