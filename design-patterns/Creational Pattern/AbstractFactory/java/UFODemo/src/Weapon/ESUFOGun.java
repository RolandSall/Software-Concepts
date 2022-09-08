package Weapon;// Here we define a basic component of a space ship
// Any part that implements the interface Weapon.ESWeapon
// can replace that part in any ship

public class ESUFOGun implements ESWeapon{

    // Entity.EnemyShip contains a reference to the object
    // Weapon.ESWeapon. It is stored in the field weapon

    // The Strategy design pattern is being used here

    // When the field that is of type Weapon.ESUFOGun is printed
    // the following shows on the screen

    public String toString(){
        return "20 damage";
    }

}