package Domain;

import Behavior.Weapon.IWeaponBehavior;

public abstract class Character {

    private IWeaponBehavior weaponBehavior;



    public void setWeaponBehavior(IWeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public void fight(){
        weaponBehavior.useWeapon();
    }
}
