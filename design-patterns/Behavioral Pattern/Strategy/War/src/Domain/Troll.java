package Domain;

import Behavior.Weapon.CrossbowBehavior;

public class Troll extends Character{

    public Troll(){
        setWeaponBehavior(new CrossbowBehavior());
    }

}
