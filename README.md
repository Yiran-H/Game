## <Legends: Monsters and Heroes>

## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>

Hero.java: my most important class, including all the actions of hero is gonna to take, sell/buy/cast/equip/unequip/use/cast/level up/attack/be attacked/gain gold or experience/revive/regain some hp or mp <br />
    HeroGroup.java: heroes are moving and fighting together <br />
        Warriors.java / Sorcerers.java / Paladins.java <br /><br />

Monster.java:<br />
    MonsterGroup: they produce at the same time<br />
        Exoskeletons.java / Spirits.java / Dragons.java<br /><br />

Market.java: a singleton class, can only have one unique instance<br /><br />

Factory.java: produce any instance<br /><br />

Product.java: represent all the items in the market<br />
    Weapons.java<br />
    Armor.java<br />
    Spells.java<br />
        IceSpell.java / FireSpell.java / LightningSpell<br />
    Potions.java<br /><br />

Grid.java: can generate map randomly with special color, each subclass can determine what should heroes do<br />
    Cell.java: the unit in the grid<br />
        CommonCell.java / MarketCell.java / InaccessibleCell.java<br />
            Shape.java: the enum that represent the different function of cell<br /><br />

Controller.java: control the hero and monster to follow the step<br />
Battle.java: include round<br /><br />

### Function class:
    Reader.class: read file from txt and print the list<br />
    Checker.class: all validations checking are in this class<br />
    C.class: all the final variable I am gonna use, including color, format<br /><br />

Main.java: Just begin the game<br /><br />

## Notes
---------------------------------------------------------------------------
1.Group of heroes and group of monsters can fight together<br />
2.Add unequip function<br />
3.Market is using singleton pattern<br />
4.Using Factory pattern to new all the objects in this game<br /><br />

## How to compile and run
---------------------------------------------------------------------------
Run the following instructions:<br />
   javac *.java<br />
   java Main<br />

