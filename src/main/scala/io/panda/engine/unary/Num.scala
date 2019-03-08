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

package io.panda.engine.unary

import io.panda.engine._

trait Num extends Expression

object Zero extends Num

object Num {
  implicit val evaluator: _Evaluator.Aux[Zero, _EvaluationComplete[Zero]] =
    new _Evaluator[Zero] {
      override type Result = _EvaluationComplete[Zero]

      override def evaluate() = new _EvaluationComplete[Zero] {
        override def toDouble() = 0.0
      }
    }
}

trait Succ[Prev <: Num] extends Num

object Succ {
  implicit def evaluator[Prev <: Num](
    implicit prevEvaluator: _Evaluator.Aux[Prev, _EvaluationComplete[Prev]]
  ): _Evaluator.Aux[Succ[Prev], _EvaluationComplete[Succ[Prev]]] =
    new _Evaluator[Succ[Prev]] {
      override type Result = _EvaluationComplete[Succ[Prev]]

      override def evaluate() = new _EvaluationComplete[Succ[Prev]] {
        override def toDouble() = prevEvaluator.evaluate().toDouble() + 1.0
      }
    }
}
