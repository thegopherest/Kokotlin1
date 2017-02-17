package Home2

import Home2.Animal

interface TreePart
{
    var animals : MutableList<Animal>
    fun NewDay()
    {
        animals.clear()
    }
}

interface Food: TreePart
{
    var food : Int
    var canEat : Boolean
    val haveFood : Int

    override fun NewDay()
    {
        MakeFood()
        animals.clear()
        canEat = food > 0
    }

    fun MakeFood()
    {
        food += haveFood * (Math.random() * 2).toInt()
    }

    fun Eat():Boolean
    {
        if (canEat)
        {
            food--
            if (food == 0)
            {
                canEat = false
            }
            return true
        }
        return false
    }

}

interface Living: TreePart
{
    var livingAnimals: MutableList<Animal>
    override fun NewDay()
    {
        animals.clear()
        animals.addAll(livingAnimals)
    }

}

interface FoodLiving: Food, Living
{
    override fun NewDay()
    {
        MakeFood()
        animals.clear()
        canEat = food > 0
        animals.addAll(livingAnimals)
    }
}

open class Roots() : TreePart
{
    override final var animals: MutableList<Animal>
    init {
        animals = mutableListOf()
    }
}

class RootsLiving(override var livingAnimals : MutableList<Animal>) : Roots(), Living {}

open class RootsFood(override final val haveFood : Int = 1) : Roots(), Food
{
    override final var food : Int
    override final var canEat : Boolean

    init {
        food = haveFood
        canEat = haveFood > 0
    }

}
class RootsFoodLiving(haveFood: Int, override var livingAnimals : MutableList<Animal>) : RootsFood(haveFood), FoodLiving {}



open class Trunk() : TreePart
{
    override final var animals: MutableList<Animal>
    init {
        animals = mutableListOf()
    }
}

class TrunkFood(override final val haveFood : Int = 1) : Trunk(), Food
{
    override final var food: Int
    override final var canEat: Boolean

    init
    {
    food = haveFood
    canEat = haveFood > 0
    }
}

class TrunkLiving(override final var livingAnimals : MutableList<Animal>) : Trunk(), Living {}

open class Crown(): TreePart
{
    override final var animals: MutableList<Animal>
    init {
        animals = mutableListOf()
    }
}

class CrownFood(override final val haveFood : Int = 0) : Crown(), Food
{
    override final var food : Int
    override final var canEat : Boolean

    init {
        food = haveFood
        canEat = haveFood > 0
    }
}
abstract class Tree(val living: Double = 0.5, val haveWorms : Double = 0.5)
{
    var trunk : Trunk
    var crown : Crown
    var roots : Roots

    init {
        trunk = MakeTrunk()
        crown = MakeCrown()
        roots = MakeRoots()
    }

    open fun MakeTrunk(): Trunk
    {
        if (Math.random() > living) return TrunkLiving(AnimalsForTrunc())
        return Trunk()
    }

    fun AnimalsForTrunc() : MutableList<Animal>
    {
        return mutableListOf()
    }

    open fun MakeCrown() : Crown
    {
        return Crown()
    }

    open fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsLiving(AnimalsForRoots())
        return Roots()
    }

    fun  AnimalsForRoots() : MutableList<Animal>
    {
        return mutableListOf()
    }
}

class Spruce(living: Double, val haveFood: Int) : Tree(living)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood)
    }

    override fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots())
        return RootsFood(haveFood)
    }
}

class Pine(living: Double, val haveFood: Int) : Tree(living)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood)
    }
    override fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots())
        return RootsFood(haveFood)
    }
}

class Oak(living: Double) : Tree(living)
{

}

class Birch(living: Double) : Tree(living)
{

}

class Maple(living: Double, val haveFood: Int) : Tree(living)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood)
    }
}

class Walnut(living: Double, val haveFood: Int ) : Tree(living)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood)
    }
    override fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots())
        return RootsFood(haveFood)
    }
}