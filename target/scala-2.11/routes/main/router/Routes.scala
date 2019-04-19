
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Lashini/IIT notes/2nd year/OOP/CW/w1698510/Back-end(Java PlayFramework)/conf/routes
// @DATE:Thu Dec 13 13:08:21 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:7
  LibrarySystemController_1: controllers.LibrarySystemController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:7
    LibrarySystemController_1: controllers.LibrarySystemController
  ) = this(errorHandler, HomeController_0, LibrarySystemController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, LibrarySystemController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """saveitem""", """controllers.LibrarySystemController.SaveItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteitem/""" + "$" + """isbn<[^/]+>""", """controllers.LibrarySystemController.DeleteItem(isbn:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """displayitems""", """controllers.LibrarySystemController.DisplayItems"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """borrowitem""", """controllers.LibrarySystemController.BorrowItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """returnItem/""" + "$" + """isbn<[^/]+>""", """controllers.LibrarySystemController.ReturnItem(isbn:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """report""", """controllers.LibrarySystemController.GenereateReport"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """availableSlots""", """controllers.LibrarySystemController.AvailableSlots"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ Default path will just redirect to the computer list""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_LibrarySystemController_SaveItem1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("saveitem")))
  )
  private[this] lazy val controllers_LibrarySystemController_SaveItem1_invoker = createInvoker(
    LibrarySystemController_1.SaveItem,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "SaveItem",
      Nil,
      "POST",
      """""",
      this.prefix + """saveitem"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LibrarySystemController_DeleteItem2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteitem/"), DynamicPart("isbn", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LibrarySystemController_DeleteItem2_invoker = createInvoker(
    LibrarySystemController_1.DeleteItem(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "DeleteItem",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """deleteitem/""" + "$" + """isbn<[^/]+>"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LibrarySystemController_DisplayItems3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("displayitems")))
  )
  private[this] lazy val controllers_LibrarySystemController_DisplayItems3_invoker = createInvoker(
    LibrarySystemController_1.DisplayItems,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "DisplayItems",
      Nil,
      "GET",
      """""",
      this.prefix + """displayitems"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_LibrarySystemController_BorrowItem4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("borrowitem")))
  )
  private[this] lazy val controllers_LibrarySystemController_BorrowItem4_invoker = createInvoker(
    LibrarySystemController_1.BorrowItem,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "BorrowItem",
      Nil,
      "POST",
      """""",
      this.prefix + """borrowitem"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LibrarySystemController_ReturnItem5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("returnItem/"), DynamicPart("isbn", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LibrarySystemController_ReturnItem5_invoker = createInvoker(
    LibrarySystemController_1.ReturnItem(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "ReturnItem",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """returnItem/""" + "$" + """isbn<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_LibrarySystemController_GenereateReport6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("report")))
  )
  private[this] lazy val controllers_LibrarySystemController_GenereateReport6_invoker = createInvoker(
    LibrarySystemController_1.GenereateReport,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "GenereateReport",
      Nil,
      "GET",
      """""",
      this.prefix + """report"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_LibrarySystemController_AvailableSlots7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("availableSlots")))
  )
  private[this] lazy val controllers_LibrarySystemController_AvailableSlots7_invoker = createInvoker(
    LibrarySystemController_1.AvailableSlots,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LibrarySystemController",
      "AvailableSlots",
      Nil,
      "GET",
      """""",
      this.prefix + """availableSlots"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:7
    case controllers_LibrarySystemController_SaveItem1_route(params) =>
      call { 
        controllers_LibrarySystemController_SaveItem1_invoker.call(LibrarySystemController_1.SaveItem)
      }
  
    // @LINE:8
    case controllers_LibrarySystemController_DeleteItem2_route(params) =>
      call(params.fromPath[String]("isbn", None)) { (isbn) =>
        controllers_LibrarySystemController_DeleteItem2_invoker.call(LibrarySystemController_1.DeleteItem(isbn))
      }
  
    // @LINE:9
    case controllers_LibrarySystemController_DisplayItems3_route(params) =>
      call { 
        controllers_LibrarySystemController_DisplayItems3_invoker.call(LibrarySystemController_1.DisplayItems)
      }
  
    // @LINE:10
    case controllers_LibrarySystemController_BorrowItem4_route(params) =>
      call { 
        controllers_LibrarySystemController_BorrowItem4_invoker.call(LibrarySystemController_1.BorrowItem)
      }
  
    // @LINE:11
    case controllers_LibrarySystemController_ReturnItem5_route(params) =>
      call(params.fromPath[String]("isbn", None)) { (isbn) =>
        controllers_LibrarySystemController_ReturnItem5_invoker.call(LibrarySystemController_1.ReturnItem(isbn))
      }
  
    // @LINE:12
    case controllers_LibrarySystemController_GenereateReport6_route(params) =>
      call { 
        controllers_LibrarySystemController_GenereateReport6_invoker.call(LibrarySystemController_1.GenereateReport)
      }
  
    // @LINE:13
    case controllers_LibrarySystemController_AvailableSlots7_route(params) =>
      call { 
        controllers_LibrarySystemController_AvailableSlots7_invoker.call(LibrarySystemController_1.AvailableSlots)
      }
  }
}
