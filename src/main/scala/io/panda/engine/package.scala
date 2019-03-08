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

import io.panda.engine.core.{ _EvaluationResultOps, _EvaluatorOps, EvaluatorOps }

package object engine extends EvaluatorOps with _EvaluatorOps with _EvaluationResultOps {
  type Expression = io.panda.engine.core.Expression

  type _EvaluationResult = io.panda.engine.core._EvaluationResult
  val _EvaluationResult = io.panda.engine.core._EvaluationResult

  type _EvaluationComplete[Res <: Expression] = io.panda.engine.core._EvaluationComplete[Res]
  // val _EvaluationComplete = io.panda.engine.core._EvaluationComplete

  type _EvaluationIncomplete[Op <: Expression, Result <: Expression] =
    io.panda.engine.core._EvaluationIncomplete[Op, Result]
  // val _EvaluationIncomplete = io.panda.engine.core._EvaluationIncomplete

  type _Evaluator[Op <: Expression] = io.panda.engine.core._Evaluator[Op]
  val _Evaluator = io.panda.engine.core._Evaluator

  type Evaluator[Op <: Expression] = io.panda.engine.core.Evaluator[Op]
  val Evaluator = io.panda.engine.core.Evaluator

  type Plus[A <: Expression, B <: Expression] = io.panda.engine.binary.PlusExpression[A, B]
  val Plus = io.panda.engine.binary.PlusExpression

  type Sub[A <: Expression, B <: Expression] = io.panda.engine.binary.SubExpression[A, B]
  val Sub = io.panda.engine.binary.SubExpression

  type Product[A <: Expression, B <: Expression] = io.panda.engine.binary.ProductExpression[A, B]
  val Product = io.panda.engine.binary.ProductExpression

  type Mult[A <: Expression, B <: Expression] = io.panda.engine.binary.ProductExpression[A, B]
  val Mult = io.panda.engine.binary.ProductExpression

  type Div[A <: Expression, B <: Expression] = io.panda.engine.binary.DivisionExpression[A, B]
  val Div = io.panda.engine.binary.DivisionExpression

  type Negate[A <: Expression] = io.panda.engine.unary.NegateExpression[A]
  val Negate = io.panda.engine.unary.NegateExpression

  type Num = io.panda.engine.unary.Num
  val Num = io.panda.engine.unary.Num

  type Zero = io.panda.engine.unary.Zero.type
  val Zero = io.panda.engine.unary.Zero

  type Succ[Prev <: Num] = io.panda.engine.unary.Succ[Prev]
  val Succ = io.panda.engine.unary.Succ

  type One   = Succ[Zero]
  type Two   = Succ[One]
  type Three = Succ[Two]
  type Four  = Succ[Three]
  type Five  = Succ[Four]
  type Six   = Succ[Five]
  type Seven = Succ[Six]
  type Eight = Succ[Seven]
  type Nine  = Succ[Eight]
  type Ten   = Succ[Nine]

  private type Teen[A <: Num] = Ten Plus A
  type Eleven                 = Teen[One]
  type Twelve                 = Teen[Two]
  type Thirteen               = Teen[Three]
  type Fourteen               = Teen[Four]
  type Fifteen                = Teen[Five]
  type Sixteen                = Teen[Six]
  type Seventeen              = Teen[Seven]
  type Eighteen               = Teen[Eight]
  type Nineteen               = Teen[Nine]

  type _Twenty          = Ten Mult Two
  type Twenty[A <: Num] = _Thirty Plus A

  type _Thirty          = Ten Mult Three
  type Thirty[A <: Num] = _Thirty Plus A

  type Hundred                        = Ten Mult Ten
  type HundredAnd[A <: Num, B <: Num] = Mult[A, Hundred] Plus B

}
