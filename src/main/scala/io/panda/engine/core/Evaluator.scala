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

package io.panda.engine.core

import io.panda.engine.unary.Num
import shapeless.<:!<

/// Type class
trait Evaluator[Expr <: Expression] {
  def evaluate(): Double
}

trait EvaluatorOps {
  implicit class EvaluatorSyntax[Op <: Expression](operator: Op) {
    def eval(implicit evaluator: Evaluator[Op]): Double = evaluator.evaluate()
  }
}

object Evaluator extends EvaluatorOps {
  def apply[Op <: Expression](implicit evaluator: Evaluator[Op]) = evaluator
}

/***********************************************************************
  *
  * New smarter not working version
  *
 ***********************************************************************/
trait _Evaluator[Expr <: Expression] {
  type Result <: _EvaluationResult
  def evaluate(): Result
}

trait _EvaluatorOps {
  // implicit class _EvaluatorSyntax[Op <: Expression, Result <: _EvaluationComplete](operator: Op) {
  //   def eval(implicit evaluator: _Evaluator[Result]): Double = {
  //     Evaluator
  //     evaluator.evaluate().result
  //   }
  // }
}

object _Evaluator extends _EvaluatorOps {
  type Aux[Expr <: Expression, Res] = _Evaluator[Expr] { type Result = Res }

  def apply[Op <: Expression](
    implicit evaluator: _Evaluator[Op]
  ): _Evaluator[Op] = evaluator
}

sealed trait _EvaluationResult {
  type Result <: Expression
}

trait _EvaluationResultOps {
  implicit class EvaluationResultSyntax[N <: Num, Res <: _EvaluationResult](result: Res) {
    def toDouble()(implicit ev: _EvaluationResult <:!< _EvaluationIncomplete[_, _]): Double =
      result.asInstanceOf[_EvaluationComplete[N]].toDouble()
  }
}

object _EvaluationResult extends _EvaluationResultOps {
  type Aux[Res <: Expression] = _EvaluationResult { type Result = Res }
}

trait _EvaluationComplete[Res <: Num] extends _EvaluationResult {
  override type Result = Res

  def toDouble(): Double
}

object _EvaluationComplete {
  type Aux[Res <: Expression] = _EvaluationResult { type Result = Res }
}

trait _EvaluationIncomplete[Op <: Expression, Res <: Expression] extends _EvaluationResult {
  override type Result = Res
}
