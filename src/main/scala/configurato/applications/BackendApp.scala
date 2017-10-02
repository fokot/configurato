package configurato.applications

import configurato.{Customisation, Environment}
import configurato.Customisation._
import configurato.Environment._
import com.typesafe.config.ConfigFactory.parseString

object BackendApp extends ConfigGenerator {

  val configForAll = parseString(
    """
       a = aaa
       b = 42
    """)

  val devEnvironment = parseString(
    """
       shit-url = "http://shit-in-test.com/shit"
       x-url = "http://x-in-test.com/xxx"
    """)

  val uatEnvironment = parseString(
    """
       shitUrl = "http://shit.com/shit"
       x-url = "http://x.com:88888/xxx"
    """)


  val generalCustomisation = parseString(
    """
       k = fff
       x = xxx12
    """)

  val csCustomisation = parseString(
    """
       k = fff
       x = xxx12
    """)

  // FIXME write this to files
  // FIXME check if there are duplicate configuration keys
  override def generateConfig(e: Environment, c: Customisation): Unit = (e, c) match {
    case (`dev`, `general`) => configForAll withFallback devEnvironment withFallback generalCustomisation resolve
    case (`dev`, `cs`) => configForAll withFallback devEnvironment withFallback csCustomisation resolve
    case (`uat`, `cs`) => configForAll withFallback uatEnvironment withFallback csCustomisation resolve
    case _ => throw new RuntimeException(s"Configuration $e.$c for `backend-app` was not defined")
  }
}
