/*
 KOTLIN PSI SPEC TEST (NEGATIVE)

 SECTIONS: constant-literals, boolean-literals
 PARAGRAPH: 1
 SENTENCE: [2] These are strong keywords which cannot be used as identifiers unless escaped.
 NUMBER: 21
 DESCRIPTION: The use of Boolean literals as the identifier (without backtick) in the catchBlock.
 NOTE: this test data is generated by FeatureInteractionTestDataGenerator. DO NOT MODIFY CODE MANUALLY!
 */

fun f() {
    try {} catch (true: Any) {}

    try {} catch (@a false: Any) {}
}
