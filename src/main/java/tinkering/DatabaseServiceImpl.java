package tinkering;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

import static java.lang.System.in;


public class DatabaseServiceImpl implements DatabaseService {

  private final Vertx vertx;

  public DatabaseServiceImpl(Vertx vertx) {
    this.vertx = vertx;
  }

//  private void registerConsumer() {
//    consumer.handler(message -> {
//      JsonObject document = message.body();
//      save(document);
//      message.reply("Document saved successfully!");
//    });
//  }

  public void save(JsonObject document) {
    //saving data by printing to console ;)
    System.out.println("Saving document: " + document.encodePrettily());
  }


  public void save(String message) {
    System.out.println(message);

  }

}

