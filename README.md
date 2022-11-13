## <Legends: Monsters and Heroes>

## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>

Hero.java: my most important class, including all the actions of hero is gonna to take, sell/buy/cast/equip/unequip/use/cast/level up/attack/be attacked/gain gold or experience/revive/regain some hp or mp
    HeroGroup.java: heroes are moving and fighting together
        Warriors.java / Sorcerers.java / Paladins.java

Monster.java:
    MonsterGroup: they produce at the same time
        Exoskeletons.java / Spirits.java / Dragons.java

Market.java: a singleton class, can only have one unique instance

Factory.java: produce any instance

Product.java: represent all the items in the market
    Weapons.java
    Armor.java
    Spells.java
        IceSpell.java / FireSpell.java / LightningSpell
    Potions.java

Grid.java: can generate map randomly with special color, each subclass can determine what should heroes do
    Cell.java: the unit in the grid
        CommonCell.java / MarketCell.java / InaccessibleCell.java
            Shape.java: the enum that represent the different function of cell

Controller.java: control the hero and monster to follow the step
Battle.java: include round

Function class:
    Reader.class: read file from txt and print the list
    Checker.class: all validations checking are in this class
    C.class: all the final variable I am gonna use, including color, format

Main.java: Just begin the game

## Notes
---------------------------------------------------------------------------
1.Group of heroes and group of monsters can fight together
2.Add unequip function
3.Market is using singleton pattern
4.Using Factory pattern to new all the objects in this game

## How to compile and run
---------------------------------------------------------------------------
Run the following instructions:
   javac *.java
   java Main

