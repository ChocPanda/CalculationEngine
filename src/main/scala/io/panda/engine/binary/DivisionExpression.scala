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

package io.panda.engine.binary

import io.panda.engine._
import shapeless.=:!=

final case class DivisionExpression[LOp <: Expression, ROp <: Expression]()
    extends BinaryExpression[LOp, ROp]

object DivisionExpression {
  implicit def evaluator[LOp <: Expression, ROp <: Expression](
    implicit evalL: Evaluator[LOp],
    evalR: Evaluator[ROp],
    ev: ROp =:!= Zero
  ): Evaluator[DivisionExpression[LOp, ROp]] = new Evaluator[DivisionExpression[LOp, ROp]] {
    override def evaluate() = evalL.evaluate() / evalR.evaluate()
  }
}
