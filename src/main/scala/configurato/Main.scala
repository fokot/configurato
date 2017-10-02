package configurato

import applications.{BackendApp, FrontendApp}

object Main {

  def main(args: Array[String]): Unit = {
    val a = Application.enum.decode(args(0)).right.getOrElse(throw new RuntimeException(s"not known application `${args(0)}`"))
    val e = Environment.enum.decode(args(1)).right.getOrElse(throw new RuntimeException(s"not known environment `${args(1)}`"))
    val c = Customisation.enum.decode(args(2)).right.getOrElse(throw new RuntimeException(s"not known customisation `${args(2)}`"))

    import Application._
    (a match {
        case `frontend-app` => FrontendApp
        case `backend-app` => BackendApp
    }).generateConfig(e, c)
  }
}
