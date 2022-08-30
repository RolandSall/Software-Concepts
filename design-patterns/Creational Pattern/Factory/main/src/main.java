import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        String shipType = "U";
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip enemyShip = shipFactory.makeEnemyShip(shipType);

        if (enemyShip != null)
            doStuff(enemyShip);
    }

    private static void doStuff(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}
