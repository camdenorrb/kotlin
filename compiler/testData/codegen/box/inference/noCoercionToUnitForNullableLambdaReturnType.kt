// !LANGUAGE: +NewInference

// FILE: TestJ.java

public class TestJ {
    public static <T> T id(T t) {
        return t;
    }
}

// FILE: test.kt

fun <T> nullableK(m: () -> T?) = m()
fun <T> inferred(e: T, l: () -> T): T = (l() as () -> T)()

fun box(): String {
//    val nullableK = (nullableK<Unit> { null }).toString()
//    if (nullableK != "null") return "fail 1: $nullableK"

    val inferred = (inferred({ TestJ.id(Unit) }) { { null } }).toString()
    if (inferred != "kotlin.Unit") return "fail 2: $inferred"

    return "OK"
}