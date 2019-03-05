package classes


class TestKotlin{

    //const cannot be used inside a regular class, only inside object type classes and on top level
    //const val ARNI = "Cat"

    var width = 2
    var height: Int = 4
    var length: Int = 10

    var comb = 0

    constructor(data: Int){
        width = data
        comb = width * height * length
    }

    var volume: Int
        get() = comb
        set(value) {comb = value}

}