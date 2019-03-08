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

trait Nat extends Expression

object Zero extends Nat

object Nat {
  implicit val evaluator: Evaluator[Zero] =
    new Evaluator[Zero] {
      override def evaluate() = 0.0
    }
}

trait Succ[Prev <: Nat] extends Nat

object Succ {
  implicit def evaluator[Prev <: Nat](implicit evaluator: Evaluator[Prev]): Evaluator[Succ[Prev]] =
    new Evaluator[Succ[Prev]] {
      override def evaluate() = evaluator.evaluate() + 1.0
    }
}
