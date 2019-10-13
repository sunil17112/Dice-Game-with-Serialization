# Dice-Game-with-Serialization
In this Version 2.0 of your racing application, you have to extend your implementation to make it
more user-friendly and to ensure that the system is foolproof. These new set of requirements from
the gaming company are as following:
1. Your race track is now composed of 3 intermediate points: a) 25% of total tiles are
covered, b) 50% of total tiles are covered, and c) 75% of total tiles are covered. Whenever
either of these 3 checkpoints are reached, your implementation should ask the user if
he/she wants to continue or save the game. If a user selects the save option then your
implementation should save the current state of the game on disk and then exit instantly.
a. Assumption is that the race track is not too small, such that the player does not
move past the second checkpoint directly without even stopping near first
checkpoint. There is no hard limit to the track size, but during the demo we will
check the save options at least two checkpoints.

2. The player should be able to load a saved game from the disk. The game would simply
ask the player Name to load the correct game and resume from the saved state. After
resuming, if still some intermediate checkpoints are encountered then Save option should
be provided as mentioned in point-1 above. However, this time you can simply delete the
earlier saved session and only save the current session for this player login.
