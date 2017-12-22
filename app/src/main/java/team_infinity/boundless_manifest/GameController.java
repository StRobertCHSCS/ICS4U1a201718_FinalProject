package team_infinity.boundless_manifest;

/**
 * Created by Acer on 2017-12-22.
 * the controller of the game
 * contains the
 */

public class GameController
{
    private static GameController controller;

    //static initilizer block
    static
    {
        controller = new GameController();
    }

    //the hero that is selected by the player
    int currentSelectedHero;

    //hide constructor
    private GameController(){}

    /**
     * getter method of the singleton instance
     * @return the singleton instance
     */
    public static GameController getInstance()
    {
        return controller;
    }

    public void setCurrentSelectedHero(int i){this.currentSelectedHero = i;}
    public int getCurrentSelectedHero(){return this.currentSelectedHero;}
}
