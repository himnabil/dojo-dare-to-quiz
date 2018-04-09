# dojo-dare-to-quiz

## Dare to quiz (the Game!)
 
An instance of a game run in a room of players, so a room is a set of players 

### Game start : 

Every player have the same amount of quizCoins 

### Game end : 

<i>n</i> players have no quizCoins   

rq : n is defined at the game start 

### Wining condition
a player have to own the highest quizCoins at the game end 

### Actions  
#### Ask 
the player A ask another player B a multi-choice question 

- A pay an amount M of quizCoins 
 
#### Answer
the player B answer S to a question asked by the player A
 
- if the answer S is correct
 
    - B receive the amount M payed by A,
    
- if the answer S is not correct 
    - B loose a fraction of the amount f.M payed by A 
    - A receive the total amount ( M + f.M )
    
         

## Rest API to implement the game

### Backlog 

US 1 : as a player I ask a question to another player ,( no persistence, no secuity , no check for player)

US 2 : as a player I answer the last question asked to me 

US 3 : as a player I know how much quizCoins I have 

US 4 : as a player I play in deferment rooms

US 5 : as an OPS I restart the system without loosing the state of rooms

US 6 : as an OPS I deploy multiple instance of the game api,

US 7 : as a user I create a room and set 
- the number n of players that have 0 Coins to end the game
- the amount of coins, every player start with 

then start the game when every player is ready

US 8 : as a user I see all available rooms 

US 9 : as a user I join an available room as player by choosing an available playerTag

US A : as a user I can't join a non available room

US B : as a player I see all playersTag in a room and the how mush coins each player have 

US C : as a player I can't ask a Q to an non existing player 

US D : as a player if a haven't answered to a Q it considered that it was incorrectly answered

US E : as a User I see my game history

US F : as a User I access the game through a secured way     

### Constraint

1) using ATDD approach
2) TDD
    1) writing unit test until it fails ( compilation error is a failing test)
    2) writing implementation until the unit test pass ( if UT pass do not add code in impl )
    3) repeat until you can't write failing unit test  
3) Peer programing / Mob programing 
 
