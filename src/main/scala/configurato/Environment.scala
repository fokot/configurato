package configurato

import enum.Enum

sealed trait Environment

object Environment {
  object dev extends Environment
  object uat extends Environment

  implicit val enum: Enum[Environment] = Enum.derived[Environment]
}