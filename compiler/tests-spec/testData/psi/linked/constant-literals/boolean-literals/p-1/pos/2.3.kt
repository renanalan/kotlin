/*
 KOTLIN PSI SPEC TEST (POSITIVE)

 SECTIONS: constant-literals, boolean-literals
 PARAGRAPH: 1
 SENTENCE: [2] These are strong keywords which cannot be used as identifiers unless escaped.
 NUMBER: 3
 DESCRIPTION: The use of Boolean literals as the identifier (with backtick) in the typeConstraint.
 NOTE: this test data is generated by FeatureInteractionTestDataGenerator. DO NOT MODIFY CODE MANUALLY!
 */

class A <`true`, `false`>
        where `true` : CharSequence,
              `false` : Comparable<`true`>

annotation class B <`false`>
        where `true` : CharSequence,
              @A<List<Nothing?>> @B `false` : Comparable<`true`>

annotation class C <`false`, `true`> where @property:C `false` : CharSequence, `true` : Comparable<`false`>

fun <`true`, `false`> d(): Boolean
        where `true` : Any,
              `false` : Iterable<*>,
              `true` : Collection<*>,
              `false` : MutableCollection<*>,
              `true` : Comparable<`false`> = `true` == `false`