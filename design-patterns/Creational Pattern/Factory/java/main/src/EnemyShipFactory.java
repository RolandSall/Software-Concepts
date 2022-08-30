public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(String type) {
        if (type.equals("U"))
            return new UFOEnemyShip();
        else if (type.equals("R"))
            return new RocketEnemyShip();
        else if (type.equals("B"))
            return new BigUFOEnemyShip();
        else return null;
    }
}
