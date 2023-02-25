package de.tum.in.ase;
import java.util.Scanner;

public class Game {
    //TODO: implement the constructor, getters and setters for all the attributes
        private GameBoard gameBoard;
        private  Hero hero;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Game(int sizeX, int sizeY){
        ///GameBoard gameBoard = new GameBoard(sizeX,sizeY);
        this.hero= new Hero();
        this.gameBoard = new GameBoard(sizeX, sizeY);

    }

    public void moveLeft(){
        int x = hero.getPosX();
        int y = hero.getPosY();

        if (x > 0){
            hero.setPosX( x-1 );
            gameBoard.set(x, y,'_');
            gameBoard.set(x-1, y,'H');
        }else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }
    }

    //TODO: implement the move methods
    public void moveRight(){
        int x = hero.getPosX();
        int y = hero.getPosY();
        if( x < gameBoard.getSizeX()-1 ){
            hero.setPosX( x+1 );
            gameBoard.set( x, y,'_');
            gameBoard.set(x+1, y,'H');
        }else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }
    }

    public void moveUp(){
        int x = hero.getPosX();
        int y = hero.getPosY();
        if( y > 0){
            hero.setPosY( y-1 );
            gameBoard.set( x, y,'_');
            gameBoard.set( x,y-1,'H');
        }else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }
    }

    public void moveDown(){
        int x = hero.getPosX();
        int y = hero.getPosY();
        if ( y < gameBoard.getSizeY()-1 ){
            hero.setPosY( y+1 );
            gameBoard.set( x, y, '_');
            gameBoard.set( x,y+1,'H');
        }else {
            System.out.println("The next move in this direction is outside of the game board, please try another move!");
        }
    }

    //TODO: implement a boolean method "isWon()" which checks if the game has ended (the player has won)
    public boolean isWon(){
        if (hero.getPosX() == gameBoard.getSizeX() -1 && hero.getPosY() == gameBoard.getSizeY() - 1 ){
            return true;
        }return false;
    }

    //TODO: finally runGame()
    public void runGame(){

        Scanner scanner = new Scanner(System.in);

        while(!isWon()){
            this.gameBoard.printGameBoard();
            System.out.println("Please enter the first letter of the desired direction:");
            String move = scanner.nextLine();
            switch (move) {
                case "u" -> moveUp();
                case "d" -> moveDown();
                case "l" -> moveLeft();
                case "r" -> moveRight();
                default -> System.out.println("This input is not recognized, please enter again!");
            }
        }
        System.out.println("Hero has reached the goal!");


    }
    //You can run your game on main after you've implemented runGame()
    public static void main(String[] args) {
        Game game = new Game(-2, 3);
        game.runGame();


        //GameBoard gb = new GameBoard(3,5);
        //gb.printGameBoard();


    }


}
