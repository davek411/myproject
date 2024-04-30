package tinkering;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceBinder;

public class BindingVerticle extends AbstractVerticle{

  private DatabaseService databaseService;

  @Override
  public void start(Promise<Void> promise) {
// Register the handler

    MessageConsumer<JsonObject> consumer;// = vertx.eventBus().consumer("serviceAddress");
    databaseService = new DatabaseServiceImpl(vertx);
//    databaseService = DatabaseService.create(vertx);
    consumer = new ServiceBinder(vertx)
      .setAddress("serviceAddress")
      .register(DatabaseService.class, databaseService);
    promise.complete();
  }
}
