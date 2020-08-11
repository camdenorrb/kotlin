// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_VARIABLE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER -UNUSED_EXPRESSION

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (POSITIVE)
 *
 * SPEC VERSION: 1.4-rfc+0.3-591
 * MAIN LINK: declarations, classifier-declaration, data-class-declaration -> paragraph 7 -> sentence 2
 * SECONDARY LINKS: declarations, classifier-declaration, data-class-declaration -> paragraph 5 -> sentence 2
 * NUMBER: 2
 * DESCRIPTION:  correct explicit implementation is available ( final fun in open class)
 */



// TESTCASE NUMBER: 1
open class Base1() {
   override final public fun toString(): String = TODO()
}

data class Data1(val x: Int = 1, val y: String = ""): Base1()

fun case1(d: Data1){
    d.<!DEBUG_INFO_CALL("fqName: Data1.toString; typeCall: function")!>toString()<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.String")!>d.toString()<!>
}

// TESTCASE NUMBER: 2
open class Base2() {
    override final fun toString(): String = TODO()
}

data class Data2(val x: Int = 2, val y: String = ""): Base2()

fun case2(d: Data2){
    d.<!DEBUG_INFO_CALL("fqName: Data2.toString; typeCall: function")!>toString()<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.String")!>d.toString()<!>
}