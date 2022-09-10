package Domain;

import Behavior.Weapon.SwordBehavior;

public class Knight extends Character{


    public Knight() {
        setWeaponBehavior(new SwordBehavior());
    }
}
