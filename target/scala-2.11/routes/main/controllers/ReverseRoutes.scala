
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Lashini/IIT notes/2nd year/OOP/CW/w1698510/Back-end(Java PlayFramework)/conf/routes
// @DATE:Thu Dec 13 13:08:21 IST 2018

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:7
  class ReverseLibrarySystemController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def BorrowItem(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "borrowitem")
    }
  
    // @LINE:7
    def SaveItem(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "saveitem")
    }
  
    // @LINE:13
    def AvailableSlots(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "availableSlots")
    }
  
    // @LINE:11
    def ReturnItem(isbn:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "returnItem/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("isbn", isbn)))
    }
  
    // @LINE:12
    def GenereateReport(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "report")
    }
  
    // @LINE:8
    def DeleteItem(isbn:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "deleteitem/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("isbn", isbn)))
    }
  
    // @LINE:9
    def DisplayItems(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "displayitems")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }


}
