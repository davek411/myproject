package tinkering;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

@ProxyGen
@VertxGen
public interface DatabaseService {

  @GenIgnore
  static DatabaseService createProxy(Vertx vertx, String address) {
    return new DatabaseServiceVertxEBProxy(vertx, address);
  }
  //void save(String collection, JsonObject document);
  void save(String message);
}




