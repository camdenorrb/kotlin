// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNREACHABLE_CODE
// SKIP_TXT

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 1.4-rfc+0.3-591
 * MAIN LINK: declarations, classifier-declaration, data-class-declaration -> paragraph 6 -> sentence 3
 * SECONDARY LINKS: declarations, classifier-declaration, data-class-declaration -> paragraph 5 -> sentence 1
 * NUMBER: 3
 * DESCRIPTION: componentN functions cannot be explicified
 */
// TESTCASE NUMBER: 1
data class Case1(<!CONFLICTING_JVM_DECLARATIONS!>val a: Int<!>, val b: String) {
    <!CONFLICTING_OVERLOADS!>fun component1(): Int<!> {
        return TODO()
    }
}

// TESTCASE NUMBER: 2
data class Case2(val a: Int, <!CONFLICTING_JVM_DECLARATIONS!>val b: String<!>) {
    <!CONFLICTING_OVERLOADS!>fun component2(): String<!> {
        return TODO()
    }
}

// TESTCASE NUMBER: 3
data class Case3(<!CONFLICTING_JVM_DECLARATIONS!>val a: Int<!>, <!CONFLICTING_JVM_DECLARATIONS!>val b: String<!>) {
    <!CONFLICTING_OVERLOADS!>fun component1(): Int<!> {
        return TODO()
    }

    <!CONFLICTING_OVERLOADS!>fun component2(): String<!> {
        return TODO()
    }
}


