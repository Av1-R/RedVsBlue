# Chosen Pattern:
STATE PATTERN
Intent/Definition: Encapsulate interchangeable behaviors and use delegation to decide which behavior to use.


# Justification of Choice:
I chose to implement the state pattern. This is due to the fact that the original assignment code was structured such that the behaviour of each state was handled by the logic in the stage.java class. This meant that the stage class was performing the state behaviour that could be more appropriately encapsulated using the design of the state pattern. Furthermore, the original structure also implemented a composite pattern in the sense that there was a State enum variable (this meant that stage "has a" state). The implication of this is that the original code reflects the composite nature of state pattern thus making it a good match for refactoring the code in question.  


# Improvements as a result of refactorization:
Closed each state for modification, and yet left the stage class open to extension of behaviour by adding new state variables.
Localized the behavior of each state into its own class. By encapsulating each state into a class, we localize any changes that will need to be made.


# How the refactorization conforms with State Pattern Design principles
State transitions can be controlled by the State classes or by the Context classes.
The currentState object appears to change its class through changing behaviour.
Using the State Pattern will typically result in a greater number of classes in your design, this is evident after the refactorization as each value in the State enum had to be made into a class.