package Home2

interface ForestPart
{
    fun NewDay()
}

object forest: ForestPart {

    val trees: MutableList<Tree>
    val animals: MutableList<Animal>
    val numstes: Int = 6

    init {
        trees = mutableListOf()
        animals = mutableListOf()
    }

    public val numberOfTrees = trees.size

    override fun toString(): String {
        return trees.toString() + '\n' + animals.size + animals.toString()
    }

    fun newTree() {
        trees.add(
                when((Math.random() * 6).toInt()){
                    1 -> Spruce()
                    2 -> Pine()
                    3 -> Birch()
                    4 -> Maple()
                    5  -> Oak()
                    else -> Walnut()
        }
        )
    }

    fun addAnimals()
    {
        var animal: Animal
        for(tree in trees)
        {
            if (tree.trunk.IsLiving) {
                animal = when((Math.random() * 3).toInt()) {
                    1 -> Squirrel( if(tree.trunk is TrunkFoodLiving) tree.trunk as TrunkFoodLiving else tree.trunk as TrunkLiving)
                    2 -> FlyingSquirrel(if(tree.trunk is TrunkFoodLiving) tree.trunk as TrunkFoodLiving else tree.trunk as TrunkLiving)
                    else -> Woodpecker(if(tree.trunk is TrunkFoodLiving) tree.trunk as TrunkFoodLiving else tree.trunk as TrunkLiving)
                }
                tree.crown.animals.add(animal)
                animals.add(animal)

            }
            if (tree.roots.IsLiving) {
                animal = when((Math.random() * 2).toInt()) {
                    1 -> Chimunks(if(tree.roots is RootsFoodLiving) tree.roots as RootsFoodLiving else tree.roots as RootsLiving)
                    else -> Badgers(if(tree.roots is RootsFoodLiving) tree.roots as RootsFoodLiving else tree.roots as RootsLiving)
                }
                tree.crown.animals.add(animal)
                animals.add(animal)
            }
        }
    }

    override fun NewDay() {
       var toRemove : MutableList<Animal> = mutableListOf()
       for(step in 0..numstes)
       {
            for(animal in animals)
           {
               animal.place = when((Math.random() * 3).toInt()) {
                   1 -> trees[(Math.random() * trees.size).toInt()].crown
                   2 -> trees[(Math.random() * trees.size).toInt()].trunk
                   else -> trees[(Math.random() * trees.size).toInt()].roots
               }

               animal.Eat()
               for (otherAniimal in animal.place.animals)
               {
                   animal.Gen(0.7, otherAniimal)
               }
               animal.place.animals.add(animal)
           }
       }
        for (animal in animals)
        {
            animal.NewDay()
            if(animal.die)
            {
                toRemove.add(animal)
            }
        }
        animals.removeAll(toRemove)
        for (tree in trees)
        {
            tree.NewDay()
        }
    }


}

fun main(args: Array<String>){
    var i: Int = 1
    while (i < 100)
    {
        forest.newTree()
        i++
    }
    forest.addAnimals()
    println(forest)

    i = 0
    while (i < 100)
    {
        forest.NewDay()
        println(forest)
        i++
    }
}