package configurato.applications

import configurato.{Customisation, Environment}

trait ConfigGenerator {

  def generateConfig(e: Environment, c: Customisation): Unit
}