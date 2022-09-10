import Behavior.Weapon.AxeBehavior;
import Domain.Character;
import Domain.Knight;
import Domain.Troll;

public class main {
    public static void main(String[] args) {

        Character knight = new Knight();
        knight.fight();

        knight.setWeaponBehavior(new AxeBehavior());
        knight.fight();


        Character troll = new Troll();
        troll.fight();
    }
}
