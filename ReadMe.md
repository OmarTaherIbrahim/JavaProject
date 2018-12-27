# Educational Game JavaFX
## Vision
The project should be able to test kids in colors, shapes, Alphabets, Multiplication, Addition, Subtraction.
Also it should provide a Library so that the kids could learn, each of the topics should have a level so the kid could track process
and be provided with a motivation to learn.
## Interface and  interactions
### Main Menu
the main menu is where the user can access his __profile Screen__, __Learning Screen__, and the __Test/Quiz Screen__
### Profile Screen 
The Profile Screen Should have a The user's name , __his score__ in each __Topic__ 

### Learning Screen
The __Learning Screen__ should contain a button for each topic __Color Learning Screen__, __Shapes Learning Screen__, __Alphabets Learning Screen__, __Addition Learning Screen__,
__Subtraction Learning Screen__, __Multiplition Learning Screen__ (inorder).

#### Color Learning Screen
is the Screen where you can see a [listview with images](https://stackoverflow.com/questions/33592308/javafx-how-to-put-imageview-inside-listview) when clicking on an item
you will go to a __Color items Learning Screen__ which will have the color you clicked on opened.

the list of colors and their images will be from a database a coloumn for the text of the color, other for the location of the audio, and the last one for the location of the image
##### Color items Learning Screen
will contain  in the middle of the Image under it, a button that looks like audio button which will play the audio underit, a text with the name of the color 
+ which will be similar for shapes
+ but for Alphabets first the __Letter__ under it a __picture__, under it __text of the pic__, then a button for the __Audio__
#### Shapes  Learning Screen  & Alphabets Learning Screen
will have the same thing as the color but Alphabets has a differrent additional column which is the second text for the object related to the Alphabet.

#### Math learning Screens (addition, subtraction)
Will Two text boxes with a Sign(addion or subtractin ) in between them and a label that has the equal sign and label which will show the result 
and if any of the Two textFields aren't valid it will show unvalid

#### Math Learning Screens (Multiplicaton)
will have a list which is the Number from 1 to 10 , by pressing one you will go to the __Multiplication items Learning Screen__

##### Multiplication items Learning Screen
will have a list of the numbers in the table which number was clicked and on top the Table name in a text with buttons on side to go to next or prev table 
if no next table there is no button as is for prev.

### Test System
will have a test System for every topic  it will be buttons for each topic
+ the screen for alphabets for have a button :
  +  with an apple on it (which will display the Pic & you choose the letter)
  +  with an ABC on it  (which will display the letter & you will choose a pic)
+ the screen for colors and shapes has the same thing
+ the screen for the math's tests (multi) will have numbers from 1 to 10
+ the screen for the math's tests (sub,add) will have numbers from 1 to 3 which is the number of digits

+ each test will have 10 question at the end will have the ScoreScreen which will have 
    + the score out of 10
    + the current level in this topic and a [bar](https://www.youtube.com/watch?v=mi_f3RjRV78) for xp

[Colors palatte](https://flatuicolors.com/palette/au)