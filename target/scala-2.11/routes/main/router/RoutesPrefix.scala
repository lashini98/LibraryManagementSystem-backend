
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Lashini/IIT notes/2nd year/OOP/CW/w1698510/Back-end(Java PlayFramework)/conf/routes
// @DATE:Thu Dec 13 13:08:21 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
