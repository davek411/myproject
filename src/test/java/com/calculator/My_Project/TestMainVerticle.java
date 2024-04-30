package com.calculator.My_Project;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ExtendWith(VertxExtension.class)
public class TestMainVerticle extends AbstractVerticle {

  private static final String[] VERTICLE_NAMES = {
    "Calculator.CalculatorVerticle",
    "Database.DatabaseVerticle",
    "com.calculator.My_Project.InputVerticle" // Update if DatabaseVerticle is not deployed
  };
  private static Vertx vertx;

  @BeforeAll
  public static void beforeAll(Vertx vertx) {
    TestMainVerticle.vertx = vertx;
  }

  @AfterAll
  public static void afterAll() {
    vertx.close();
  }

  @Test
  //@DisplayName("Test Verticle Deployment")
  public void testVerticleDeployment() throws Exception {
    CountDownLatch latch = new CountDownLatch(VERTICLE_NAMES.length);

    for (String verticleName : VERTICLE_NAMES) {
      DeploymentOptions options = new DeploymentOptions();

      vertx.deployVerticle(verticleName, options, res -> {
        if (res.succeeded()) {
          System.out.println("Verticle " + verticleName + " deployed successfully.");
          latch.countDown();
        } else {
          System.err.println("Failed to deploy verticle " + verticleName + ": " + res.cause().getMessage());
        }
      });
    }

//     Wait for all deployments to complete with a timeout
    if (!latch.await(1000, TimeUnit.MILLISECONDS)) {
      System.err.println("Timed out waiting for verticle deployment.");
    }
  }
}
