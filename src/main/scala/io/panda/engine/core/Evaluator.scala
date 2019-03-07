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

/// Type class
trait Evaluator[Expr <: Expression] {
  def evaluate(): Double
}

trait EvaluatorOps {
  implicit class EvaluatorSyntax[Op <: Expression](operator: Op) {
    // @implicitNotFound("Couldn't evaluate A")
    def eval(implicit evaluator: Evaluator[Op]): Double = evaluator.evaluate()
  }
}

object Evaluator extends EvaluatorOps {
  def apply[Op <: Expression](implicit evaluator: Evaluator[Op]) = evaluator
}
