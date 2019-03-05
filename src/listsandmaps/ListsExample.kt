package listsandmaps

fun main(){
    val testList = listOf(11,12,13,14,15,16)
    println("1st: " + testList.reversed())

    val noon : (List<Int>) -> List<Int> = {
            list -> val result = mutableListOf<Int>()
            for (i in list.size-1 downTo 0){
                result.add(list.get(i))
            }
        result
    }

    println("2nd: " + reverseList(testList));
    println("3rd: " + noon(testList));


    val symptoms = mutableListOf("spots", "red spots", "not eating", "bloated", "belly up")

    symptoms.add("fungus")
    symptoms.remove("not eating")

    println(symptoms.contains("red"))
    println(symptoms.contains("red spots"))

    println(symptoms.subList(4, symptoms.size))

    println(listOf(1,5,3).sum())
    println(listOf("a", "b", "c").sumBy { it.length })
}



fun reverseList(list: List<Int>): List<Int>{

    val result = mutableListOf<Int>()

    for(i in 0..list.size - 1){
        result.add(list[list.size - i - 1])
    }

    return result
}