package Home2

//import Home2.Animal

interface TreePart: ForestPart
{
    var animals : MutableList<Animal>

    val myTree : Tree
    val IsFood : Boolean
    get() = false

    val IsLiving : Boolean
    get() = false

    override fun NewDay()
    {
        animals.clear()
    }
    fun MakeFood()
    fun Eat() : Boolean
    {
        return false
    }


}

interface Food: TreePart
{
    var food : Int
    var canEat : Boolean
    val haveFood : Int

    override val IsFood: Boolean
        get() = true

    override fun NewDay()
    {
        MakeFood()
        animals.clear()
        canEat = food > 0
    }

    override fun MakeFood()
    {
        food += haveFood * (Math.random() * 2).toInt()
    }

    override fun Eat():Boolean
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
    override val IsLiving: Boolean
        get() = true

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

open class Roots(override val myTree: Tree) : TreePart
{
    override final var animals: MutableList<Animal>
    init {
        animals = mutableListOf()
    }
    override fun MakeFood(){}
}

class RootsLiving(override var livingAnimals : MutableList<Animal>, myTree: Tree) : Roots(myTree), Living {}

open class RootsFood(override final val haveFood : Int = 1, myTree: Tree) : Roots(myTree), Food
{
    override final var food : Int
    override final var canEat : Boolean

    override fun MakeFood()
    {
        super<Food>.MakeFood()
    }

    init
    {
        food = haveFood
        canEat = haveFood > 0
    }

}
class RootsFoodLiving(haveFood: Int, override var livingAnimals : MutableList<Animal>, myTree: Tree) : RootsFood(haveFood, myTree), FoodLiving {}



open class Trunk(override val myTree: Tree) : TreePart
{
    override final var animals: MutableList<Animal>
    init
    {
        animals = mutableListOf()
    }
    override fun MakeFood(){}
}

open class TrunkFood(override final val haveFood : Int = 1, myTree: Tree) : Trunk(myTree), Food
{
    override final var food: Int
    override final var canEat: Boolean

    init
    {
        food = haveFood
        canEat = haveFood > 0
    }

    override fun MakeFood() {
        super<Food>.MakeFood()
    }
}

class TrunkLiving(override final var livingAnimals : MutableList<Animal>, myTree: Tree) : Trunk(myTree), Living {}

class TrunkFoodLiving(haveFood: Int, override var livingAnimals : MutableList<Animal>, myTree: Tree): TrunkFood(haveFood, myTree), FoodLiving {}
open class Crown(override val myTree: Tree): TreePart
{
    override final var animals: MutableList<Animal>

    init
    {
        animals = mutableListOf()
    }

    override fun MakeFood(){}
}

class CrownFood(override final val haveFood : Int = 0, myTree: Tree) : Crown(myTree), Food
{
    override final var food : Int
    override final var canEat : Boolean

    init
    {
        food = haveFood
        canEat = haveFood > 0
    }

    override fun MakeFood()
    {
        super<Food>.MakeFood()
    }
}
abstract class Tree(val living: Double = 0.0, val haveWorms : Double = 0.0, val numWorms : Int = 2)
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
        if (Math.random() > living)
        {
            if (Math.random() > haveWorms) return  TrunkFoodLiving(numWorms, AnimalsForTrunc(), this)
            return TrunkLiving(AnimalsForTrunc(), this)
        }
        if (Math.random() > haveWorms) return  TrunkFood(numWorms, this)
        return Trunk(this)

    }

    fun AnimalsForTrunc() : MutableList<Animal>
    {
        return mutableListOf()
    }

    open fun MakeCrown() : Crown
    {
        return Crown(this)
    }

    open fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsLiving(AnimalsForRoots(), this)
        return Roots(this)
    }

    fun  AnimalsForRoots() : MutableList<Animal>
    {
        return mutableListOf()
    }
}

class Spruce(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{
    override fun MakeCrown() : CrownFood
    {
        return CrownFood(haveFood, this)
    }

    override fun MakeRoots() : RootsFood
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots(), this)
        return RootsFood(haveFood, this)
    }
}

class Pine(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood, this)
    }
    override fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots(), this)
        return RootsFood(haveFood, this)
    }
}

class Oak(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{

}

class Birch(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{

}

class Maple(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood, this)
    }
}

class Walnut(living: Double, haveWorms: Double, numWorms: Int, val haveFood: Int) : Tree(living, haveWorms, numWorms)
{
    override fun MakeCrown() : Crown
    {
        return CrownFood(haveFood, this)
    }
    override fun MakeRoots() : Roots
    {
        if (Math.random() > living) return RootsFoodLiving(haveFood, AnimalsForRoots(), this)
        return RootsFood(haveFood, this)
    }
}