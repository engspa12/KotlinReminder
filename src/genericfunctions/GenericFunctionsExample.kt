package genericfunctions

import generics.*

fun main() {
    genericFunctionsExample()
    reifiedExample()

}

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water needs cleaning: ${aquarium.wSupply.needsProcessed}")
}

fun genericFunctionsExample(){
    val aquarium = Aquarium(TapWater())
    isWaterClean<TapWater>(aquarium)

    isSmallBuilding(Building(Brick()))
    isSmallBuilding(Building(Wood()))
}

class BigAquarium<out T: WaterSupply>(val waterSupply: T){

    fun addWater(){
        check(!waterSupply.needsProcessed){"water supply needs processed"}

        println("adding water from $waterSupply")
    }

    inline fun <reified R:WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

fun reifiedExample(){
    val aquarium = BigAquarium(LakeWater())

    println(aquarium.hasWaterSupplyOfType<TapWater>())

    println(aquarium.waterSupply.isOfType<LakeWater>())
    println(aquarium.waterSupply.isOfType<TapWater>())

    println(aquarium.hasWaterSupplyOfTypeOutsideClass<LakeWater>())
    println(aquarium.hasWaterSupplyOfTypeOutsideClass<TapWater>())

}

inline fun <reified T:WaterSupply> WaterSupply.isOfType() = this is T

inline fun <reified  R:WaterSupply> BigAquarium<*>.hasWaterSupplyOfTypeOutsideClass() = waterSupply is R

fun<T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>){
    if(building.actualMaterialsNeeded < 500) println("Small building")
    else println("Large building")
}




