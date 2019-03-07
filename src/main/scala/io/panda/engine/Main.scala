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

package io.panda.engine

// import shapeless.tag.@@

object Main extends App {

  type One   = Succ[Zero]
  type Two   = Succ[One]
  type Three = Succ[Two]
  type Four  = Succ[Three]
  type Five  = Succ[Four]
  type Six   = Succ[Five]
  type Seven = Succ[Six]
  type Eight = Succ[Seven]
  type Nine  = Succ[Eight]

  type Ten            = Dec[One, Zero]
  type Eleven         = Dec[One, One]
  type Twelve         = Dec[One, Two]
  type Teen[A <: Nat] = Dec[One, A]
  type Thirteen       = Teen[Three]
  type Fourteen       = Teen[Four]
  type Fifteen        = Teen[Five]
  type Sixteen        = Teen[Six]
  type Seventeen      = Teen[Seven]
  type Eighteen       = Teen[Eight]
  type Nineteen       = Teen[Nine]

  type X = Div[Four, Five Sub Nine]

  println("Well atleast it compiled!")
  println(Evaluator[Four Plus Nineteen].evaluate())
}
