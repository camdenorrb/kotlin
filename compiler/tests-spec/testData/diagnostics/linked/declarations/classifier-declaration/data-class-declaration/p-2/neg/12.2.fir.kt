// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_VARIABLE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER -UNUSED_EXPRESSION
// SKIP_TXT


// TESTCASE NUMBER: 1
data class A1(val a: Int, val b: C1) {
    var prop1: Int = 1
    val prop2: Int = 2
}

class C1

fun case1() {
    val x = A1(1, C1())
    x.<!UNRESOLVED_REFERENCE!>component0<!>() // nok
    x.component1()
    x.component2()
}

// TESTCASE NUMBER: 2
data class A2(val a: Int, val b: String = "s") {
    val prop2: Int = TODO()
    var prop1: Int

    init {
        prop1 = 1;
    }
}

fun case2() {
    val x = A2(1)
    x.<!UNRESOLVED_REFERENCE!>component0<!>() //nok
    x.component1()
    x.component2()
}

// TESTCASE NUMBER: 3
data class A3(val a: Int = 1, val b: String = "s") {
    var prop1: Int = 2
    val prop2: Int

    init {
        prop2 = 1;
    }
}

fun case3() {
    val x = A3()
    x.<!UNRESOLVED_REFERENCE!>component0<!>() //nok
    x.component1()
    x.component2()
}


// TESTCASE NUMBER: 4
data class A4(val a: CharSequence) {
    var prop1: Int
    val prop2: Int = 2

    init {
        prop1 = 1;
    }
}

fun case4() {
    val x = A4("")
    x.<!UNRESOLVED_REFERENCE!>component0<!>() //nok
    x.component1()
}

// TESTCASE NUMBER: 5
data class A5(val a: CharSequence = "") {
    var prop1: Int;
    var prop2: Int;

    init {
        prop1 = 1;
        prop2 = 1;
    }
}

fun case5() {
    val x = A5()
    x.<!UNRESOLVED_REFERENCE!>component0<!>() //nok
    x.component1()
}
