/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.j2k.ast

import org.jetbrains.jet.j2k.CommentConverter

class MethodCallExpression(
        val methodExpression: Expression,
        val arguments: List<Expression>,
        val typeArguments: List<Type>,
        override val isNullable: Boolean,
        val lambdaArgument: LambdaExpression? = null
) : Expression() {

    override fun toKotlinImpl(commentConverter: CommentConverter): String {
        val builder = StringBuilder()
        builder.append(operandToKotlin(methodExpression, commentConverter))
        builder.append(typeArguments.toKotlin(commentConverter, ", ", "<", ">"))
        if (arguments.isNotEmpty() || lambdaArgument == null) {
            builder.append("(").append(arguments.map { it.toKotlin(commentConverter) }.makeString(", ")).append(")")
        }
        if (lambdaArgument != null) {
            builder.append(lambdaArgument.toKotlin(commentConverter))
        }
        return builder.toString()
    }

    class object {
        public fun buildNotNull(receiver: Expression?,
                                methodName: String,
                                arguments: List<Expression> = listOf(),
                                typeArguments: List<Type> = listOf(),
                                lambdaArgument: LambdaExpression? = null): MethodCallExpression
                = build(receiver, methodName, arguments, typeArguments, false, lambdaArgument)

        public fun buildNullable(receiver: Expression?,
                                 methodName: String,
                                 arguments: List<Expression> = listOf(),
                                 typeArguments: List<Type> = listOf(),
                                 lambdaArgument: LambdaExpression? = null): MethodCallExpression
                = build(receiver, methodName, arguments, typeArguments, true, lambdaArgument)

        public fun build(receiver: Expression?,
                         methodName: String,
                         arguments: List<Expression>,
                         typeArguments: List<Type>,
                         isNullable: Boolean,
                         lambdaArgument: LambdaExpression? = null): MethodCallExpression {
            val identifier = Identifier(methodName, false)
            return MethodCallExpression(if (receiver != null) QualifiedExpression(receiver, identifier) else identifier,
                                        arguments,
                                        typeArguments,
                                        isNullable,
                                        lambdaArgument)
        }
    }
}
