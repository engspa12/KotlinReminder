package sam

fun main() {

}

fun example(){
    val runnable = object: Runnable{
        override fun run() {
            println("I'm a runnable")
        }
    }

    JavaRun.runNow(runnable)
}

fun exampleTwo(){
    JavaRun.runNow{
        println("Passing a lambda as a runnable")
    }
}