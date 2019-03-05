package classes

class InheritanceTest(): Fish() {

    override val friendly: Boolean
        get() = super.friendly

    override val size = if (friendly) 18 else 13

}