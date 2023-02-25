package de.tum.in.ase;

public class GameBoard {
    // attributes
    private int sizeX;
    private int sizeY;
    private char[][] boardMatrix;
// getters and setters
    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public char[][] getBoardMatrix() {
        return boardMatrix;
    }

    public void setBoardMatrix(char[][] boardMatrix) {
        this.boardMatrix = boardMatrix;
    }
// GameBoard
    public GameBoard(int sizeX, int sizeY) {

        this.sizeX = Math.max(sizeX, 3);
        this.sizeY = Math.max(sizeY, 3);
        this.boardMatrix = new char[this.sizeX][this.sizeY];

        for(int x = 0; x < boardMatrix.length; x++){
            for(int y = 0; y < boardMatrix[x].length; y++) {
                boardMatrix[x][y] = '_';
            }
        }

        boardMatrix[0][0] = 'H';
        boardMatrix[this.sizeX-1][this.sizeY-1] = 'G';
    }

    public char get(int x , int y ){
        if ( (this.sizeX >= x && x >= 0) && (this.sizeY >= y && y >= 0)){
                return boardMatrix[x][y];
        }
        return '\0';
    }

    public void set( int x, int y, char value){
        if ( x < this.sizeX && y < this.sizeY ){
            boardMatrix[x][y] = value ;
        }
    }

    public void printGameBoard(){
        for (int i = 0; i < boardMatrix[0].length; i++) {
            for (char[] matrix : boardMatrix) {
                System.out.print(matrix[i] + " ");
            }
            System.out.println();
        }


    }





}
