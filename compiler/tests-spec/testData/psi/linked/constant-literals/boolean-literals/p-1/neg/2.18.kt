/*
 * KOTLIN PSI SPEC TEST (NEGATIVE)
 *
 * SECTIONS: constant-literals, boolean-literals
 * PARAGRAPH: 1
 * SENTENCE: [2] These are strong keywords which cannot be used as identifiers unless escaped.
 * NUMBER: 18
 * DESCRIPTION: The use of Boolean literals as the identifier (without backtick) in the typeAlias.
 * NOTE: this test data is generated by FeatureInteractionTestDataGenerator. DO NOT MODIFY CODE MANUALLY!
 */

typealias true = Boolean

private typealias false<T> = List<T>

internal typealias true<false> = Map<true<false>, List<true>>
