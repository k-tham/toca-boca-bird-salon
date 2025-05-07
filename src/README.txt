Toca Boca Bird Salon~~~~  	(´｡• ω •｡`)
Kinglee Tham 

I will be implementing a game like Toca Boca Hair Salon, but for birds. This project will function more like a coloring book or
a dress-up game for now. The program takes the coordinates of user clicks to select from various options, which are all
stored as arrays. Most of the graphics will be implemented by drawing
png files using StdDraw. This game will not take command line arguments.


Final idea of how the game will go:
1. The user is welcomed into TBBS with a graphic and some sparkly sound effects using StdDraw and StdAudio.
2. The user selects a bird from various bird presets, such as the dove, lovebird, and finch. I have created a bird class 
as a general backbone for each bird preset in case I plan to add more birds later on. In the bird class, I have
methods to draw the birds and call the proper png files for drawing. 	(*¯︶¯*) Also, I have a bunch of variables such as "species" "name" "sprite" "personality" that will help the user decide on which bird. I'll print/draw the variables on screen. I can probably implement this by having the user hover over the bird, and then I'll clear the screen and redraw the birds once the user stops hovering.
3. The user will be prompted to select a style by clicking from presets in the bottom of the screen. The blank style will be drawn on the bird.
4. The user will be prompted to click from colors at the bottom of the screen. I will draw on top with the colored style.
5. The user will be prompted to select an accessory and click on the screen to place it. Then, it will draw the accessory.
6. Finally, the bird will "judge" the makeover. I will call the judge method, which basically compares each given style with the bird's personal style. I assigned each style a number and the method will basically compare the numbers to another number given the bird's personality. I will add sound effects according to whether the bird is happy or not with the style.

Things I have implemented:
- click sound effects and nearly all graphics
1. Welcome screen using StdDraw
2. Created bird presets, methods/classes, and drew all bird presets
3. Created style presets, methods/classes, and drew all of them in the menu. Also drew the style on the birds. I might tweak placement
4. Created dye presets, methods/classes, and drew all of them in the menu.
5. Created accessory graphics and the method to draw them in the menu


Things I haven't implemented:
- bird sound effects
1. No sound effects in welcome screen
2. No hover implementation to get information on each bird. I think I'll also add name tags above the birds
4. Did not draw dye presets on the birds
5. Did not draw accessory menu or draw accessory presets on the bird
6. Did not create anything for judgment yet. I plan to check for certain accessories, styles, and dye colors based on each bird's personality. For example, you score 1 point for green hair and 1 point for the orange hat. A score of 1 is ok, a score of 2 is good, and a score of 3 is excellent. Then, based on the rating, each bird gives feedback and I'll play audio.
