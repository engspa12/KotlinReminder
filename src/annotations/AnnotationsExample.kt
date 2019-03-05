

package annotations

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

fun main() {
    labels()
}


fun labels(){

    loop@ for(i in 1..100){
        for(j in 1..100){
            if(i > 10) break@loop
            println("Again " + i + " - " + j)
        }
    }
}

@ImAPlant class Plant{
    fun trim(){}
    fun fertilize(){}

    @get: OnGet
    val isGrowing: Boolean = true

    @set: OnSet
    var needsFood: Boolean = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections(){
    val classObj = Plant::class
    for(method in classObj.declaredMemberFunctions){
        println(method.name)
    }
}

fun reflectionsTwo(){
    val classObj = Plant::class

    //Print all annotations
    for(annotation in classObj.annotations){
        println(annotation.annotationClass.simpleName)
    }

    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated.apply {
        println("Found a plant annotation!")
    }

}



