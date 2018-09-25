'''
Created on Sep 7, 2018

@author: Caitlin ☼
'''
from distutils.command.check import check

class Board(object):
    '''
    classdocs
    '''
    board = []
    turn = 0    # Is it W's (1)

    def __init__(self):
        '''
        Constructor
        '''
        self.board = [['|',1,'|',1,'|',1,'|',1],
                      [1,'|',1,'|',1,'|',1,'|'],
                      ['|',1,'|',1,'|',1,'|',1],
                      [0,'|',0,'|',0,'|',0,'|'],
                      ['|',0,'|',0,'|',0,'|',0],
                      [-1,'|',-1,'|',-1,'|',-1,'|'],
                      ['|',-1,'|',-1,'|',-1,'|',-1],
                      [-1,'|',-1,'|',-1,'|',-1,'|']]
        self.turn = -1
        
        
    def printBoard(self):
        print("The current board is:")
        for i in range(0,len(self.board)):
            printString = "\t"
            for j in range (0,len(self.board[i])):
                space = self.board[i][j]
                if isinstance(space, int):
                    if space == -1: letter = 'W'
                    elif space == 0: letter = '-'
                    elif space == 1: letter = 'B'
                else: letter = space                
                
                printString += letter + " "
            print(printString)
        print("It is %s's turn" % self.whoseTurn())
    
    def whoseTurn(self):
        if self.turn == -1: return 'W'
        else: return 'B'
    
    def movePiece(self):
        move = [int(s) for s in input("What is your move?").split(' ')]
        
        print(move)
        print(move[0])
        print(move[1])
        print(move[2])
        print(move[3])        
                
#         print((move[2] < len(self.board)))
#         print(move[3] < len(self.board[move[2]]))
#         print(move[2] >= 0)
#         print(move[3] >= 0)
#         print(move[0] < len(self.board))
#         print(move[1] < len(self.board[move[2]]))
#         print(move[0] >= 0)
#         print(move[1] >= 0)
        
        if self.checkValidMove(move): print("out of CheckVM")

    def checkValidMove(self,move):
        print((move[2] < len(self.board)))
        print(move[3] < len(self.board[move[2]]))
        print(move[2] >= 0)
        print(move[3] >= 0)
        print(move[0] < len(self.board))
        print(move[1] < len(self.board[move[2]]))
        print(move[0] >= 0)
        print(move[1] >= 0)
        
        if ((move[2] < len(self.board)) & (move[3] < len(self.board[move[2]])) & (move[2] >= 0 & move[3] >= 0) & (move[0] < len(self.board)) & (move[1] < len(self.board[move[2]])) & (move[0] >= 0 & move[1] >= 0)):  # if the piece selected and potential move are within bounds 
            if (self.turn <= self.board[5, 0]):   # if the piece matches the turn
                if   (move[2] == move[0] + self.turn) & \
                    ((move[3] == move[1] + 1) | (move[3] == move[1] - 1)) & \
                     self.board[move[2],move[3]] == 0:    # if the piece is being moved one to an appropriate empty space
                        print("it's good")
                elif (move[2] == move[0] + self.turn*2) & \
                    (((move[3] == move[1] + 2) & self.board[move[0] + self.turn,move[1] + 1] == self.turn*(-1))  | \
                     ((move[3] == move[1] - 2) & self.board[move[0] + self.turn,move[1] - 1] == self.turn*(-1))) & \
                     self.board[move[2,3]] == 0:
                        print("ooh got'em")
                else: 
                    print("Invalid move, bad coords")
            else: 
                print("Invalid move, self.turn > self.board[move[0,1]]")
        else: 
            print("Invalid move, out of bounds")
    
checkers = Board()
# checkers.movePiece()
print(len(checkers.board))
print(len(checkers.board[4]))
checkers.printBoard()
checkers.movePiece()



















