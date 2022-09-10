package Behavior.Weapon;

public class CrossbowBehavior implements IWeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Shoot Arrows");
    }
}
