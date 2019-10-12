# Chosen Pattern: STATE PATTERN
The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

# Justification of Choice:
This design pattern was implemented as there is code in Stage.java which changes the behaviour of the class based on an internal state, this aligns perfectly with the intent of the state pattern. Specifically the code that handles the state of the game via an enum variable and logic found in methods mouseClicked/paint of the stage class was refactored.

# Improvements as a result of refactorization:
-Localized the behavior of each state into its own class. By encapsulating each state into a class, we localize any changes that will need to be made.
-Closed each state for modification, and yet left the stage class open to extension of behaviour by adding new state variables.
-Broke large conditional branch in mouseClicked() that was hard to read into appropriately encapsulated classes. This will mean that managing and maintaining the code is simplified.

# How the refactorization conforms with State Pattern Design principles
State transitions can be controlled by the State classes or by the Context classes.
The stage class appears to change its class through an internal state/behaviour.
Using the State Pattern will typically result in a greater number of classes in your design, this is evident after the refactorization as each value in the State enum had to be made into a class.