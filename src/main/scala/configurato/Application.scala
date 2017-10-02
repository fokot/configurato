package configurato

import enum.Enum

sealed trait Application

object Application {
  object `frontend-app` extends Application
  object `backend-app` extends Application

  implicit val enum: Enum[Application] = Enum.derived[Application]
}
