# Refactored structure:
Essentially the stage class acts as a state machine which stores the different states as instance variables and a variable known as currentState which determines the current state the game is in.

The currentState.handle() and currentState.handleCpu() methods are called upon in the Stage class in the appropriate methods Stage.mouseClicked() and Stage.Paint() respectively. This means that the different state classes will execute the appropriate behaviour using their own handler methods as the currentState changes. This ensures that all State behaviour is encapsulated within the states and simply called upon in stage.java.


As the CPUMoving state is called differently (reoccuringly in state)

# Abstract class vs interface (from textb00k)
Given we had no common functionality to put into an abstract class, we went with an interface. In your own implementation, you might want to consider an abstract class. Doing so has the benefit of allowing you to add methods to the abstract class later, without breaking the concrete state implementations.

We’ve got a lot of duplicate code in the Sold and Winning states and we might want to clean those up. How would we do it? We could make State into an abstract class and build in some default behavior for the methods; after all, error messages like, “You already inserted a quarter,” aren’t going to be seen by the customer. So all “error response” behavior could be generic and inherited from the abstract State class.