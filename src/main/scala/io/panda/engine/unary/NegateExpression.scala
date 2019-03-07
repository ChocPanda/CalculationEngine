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

final case class NegateExpression[Op <: Expression](override val operand: Op) extends UnaryExpression[Op]

object NegateExpression {
  implicit def evaluator[Op <: Expression](opEvaluator: Evaluator[Op]): Evaluator[NegateExpression[Op]] =
    new Evaluator[NegateExpression[Op]] {
      override def evaluate() = -(opEvaluator.evaluate())
    }
}
