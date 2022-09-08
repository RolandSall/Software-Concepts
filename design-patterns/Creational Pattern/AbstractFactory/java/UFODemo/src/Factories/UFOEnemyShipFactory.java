package Factories;// This factory uses the Entity.EnemyShipFactory interface
// to create very specific UFO Enemy Ship

// This is where we define all of the parts the ship
// will use by defining the methods implemented
// being Weapon.ESWeapon and Engine.ESEngine

// The returned object specifies a specific weapon & engine

import Engine.ESEngine;
import Engine.ESUFOEngine;
import Entity.EnemyShipFactory;
import Weapon.ESUFOGun;
import Weapon.ESWeapon;

public class UFOEnemyShipFactory implements EnemyShipFactory {

    // Defines the weapon object to associate with the ship

    public ESWeapon addESGun() {
        return new ESUFOGun(); // Specific to regular UFO
    }

    // Defines the engine object to associate with the ship

    public ESEngine addESEngine() {
        return new ESUFOEngine(); // Specific to regular UFO
    }
}
