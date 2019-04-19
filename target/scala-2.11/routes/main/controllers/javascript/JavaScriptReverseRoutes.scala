
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Lashini/IIT notes/2nd year/OOP/CW/w1698510/Back-end(Java PlayFramework)/conf/routes
// @DATE:Thu Dec 13 13:08:21 IST 2018

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:7
  class ReverseLibrarySystemController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def BorrowItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.BorrowItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "borrowitem"})
        }
      """
    )
  
    // @LINE:7
    def SaveItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.SaveItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveitem"})
        }
      """
    )
  
    // @LINE:13
    def AvailableSlots: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.AvailableSlots",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "availableSlots"})
        }
      """
    )
  
    // @LINE:11
    def ReturnItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.ReturnItem",
      """
        function(isbn0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "returnItem/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("isbn", isbn0))})
        }
      """
    )
  
    // @LINE:12
    def GenereateReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.GenereateReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "report"})
        }
      """
    )
  
    // @LINE:8
    def DeleteItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.DeleteItem",
      """
        function(isbn0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteitem/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("isbn", isbn0))})
        }
      """
    )
  
    // @LINE:9
    def DisplayItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LibrarySystemController.DisplayItems",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "displayitems"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
