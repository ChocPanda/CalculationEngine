/*
 * Copyright 2018 com.github.chocpanda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.panda

import io.panda.engine.core.EvaluatorOps

package object engine extends EvaluatorOps {
  type Evaluator[Op <: Expression] = io.panda.engine.core.Evaluator[Op]
  val Evaluator = io.panda.engine.core.Evaluator

  type Expression = io.panda.engine.core.Expression

  type Plus[A <: Expression, B <: Expression] = io.panda.engine.binary.PlusExpression[A, B]
  val Plus = io.panda.engine.binary.PlusExpression

  type Sub[A <: Expression, B <: Expression] = io.panda.engine.binary.SubExpression[A, B]
  val Sub = io.panda.engine.binary.SubExpression

  type Product[A <: Expression, B <: Expression] = io.panda.engine.binary.ProductExpression[A, B]
  val Product = io.panda.engine.binary.ProductExpression

  type Div[A <: Expression, B <: Expression] = io.panda.engine.binary.DivisionExpression[A, B]
  val Div = io.panda.engine.binary.DivisionExpression

  type Negate[A <: Expression] = io.panda.engine.unary.NegateExpression[A]
  val Negate = io.panda.engine.unary.NegateExpression

  type Nat = io.panda.engine.unary.Nat
  val Nat = io.panda.engine.unary.Nat

  type Zero = io.panda.engine.unary.Zero.type
  val Zero = io.panda.engine.unary.Zero

  type Succ[Prev <: Nat] = io.panda.engine.unary.Succ[Prev]
  val Succ = io.panda.engine.unary.Succ

  type Dec[Exp <: Nat, Man <: Nat] = io.panda.engine.unary.Dec[Exp, Man]
  val Dec = io.panda.engine.unary.Dec
}
