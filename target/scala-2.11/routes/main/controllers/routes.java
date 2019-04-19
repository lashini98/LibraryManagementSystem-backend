
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Lashini/IIT notes/2nd year/OOP/CW/w1698510/Back-end(Java PlayFramework)/conf/routes
// @DATE:Thu Dec 13 13:08:21 IST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseLibrarySystemController LibrarySystemController = new controllers.ReverseLibrarySystemController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseLibrarySystemController LibrarySystemController = new controllers.javascript.ReverseLibrarySystemController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
