Project realized by Catherine DUCHEMIN and Manon GERARD, students in applied sciences, civil engineering section.

We were inspired by the TP7 made by Thomas PIROTTIN.

There are 4 levels in the game.

Changes to the base game :

- We replaced the male character with a female character (tile source: https://opengameart.org/sites/default/files/Tiny32-Complete-Spritesheet_0.png).

- Our character shows 4 different profiles depending on the direction chosen by the player.

- We have introduced a move counter, which resets at each level.

- We have introduced two new types of self-designed tiles:
	- Magma: the game ends with a GameOver if the character enters a Magma tile ;
	- Lava: the character can cross a lava tile (same behavior as an empty tile), but the lava tile turns into a magma tile after being crossed.
	Given this behavior, a crate cannot go on lava.
	If the player or a crate ends up in magma, the level is failed but once the window close, the next level will start.