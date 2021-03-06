// TARGET_BACKEND: JVM
// FILE: Base.java

public interface Base {
    String getValue();

    default String test() {
        return getValue();
    }
}

// FILE: main.kt
// JVM_TARGET: 1.8

public interface BaseKotlin : Base {
}


class Fail : BaseKotlin {
    override fun getValue() = "Fail"
}

fun box(): String {
    val z = object : BaseKotlin by Fail() {
        override fun getValue() = "OK"
    }
    return z.test()
}
