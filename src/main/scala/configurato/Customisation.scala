package configurato

import enum.Enum

sealed trait Customisation

object Customisation {
  object general extends Customisation
  object cs extends Customisation

  implicit val enum: Enum[Customisation] = Enum.derived[Customisation]
}
