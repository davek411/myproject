//package Calculator;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import Database.DatabaseService;
//import io.vertx.core.Future;
//import io.vertx.core.json.JsonObject;
//import io.vertx.ext.unit.Async;
//import io.vertx.ext.unit.TestContext;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//public class CalculateServiceImplTest {
//
//  @Mock
//  private DatabaseService databaseServiceMock;
//
//  @Test
//  public void testCalculateAndPassSuccess(TestContext context) {
//    final Async async = context.async();
//
//    MockitoAnnotations.initMocks(this);
//    CalculateServiceImpl calculateService = new CalculateServiceImpl(null); // Don't need Vertx for this test
//
//    // Mock database service behavior (replace with actual interaction in production)
//    Future<Void> futureVoid = Future.succeededFuture();
//    Mockito.when(databaseServiceMock.receiveandstore(Mockito.any())).thenReturn(futureVoid);
//
//    JsonObject message = new JsonObject()
//      .put("xvalue", "2.5")
//      .put("yvalue", "3.7")
//      .put("message", "Add values");
//
//    calculateService.calculateandpass(message)
//      .onSuccess(result -> {
//        assertEquals(6.2, result, 0.01);  // Assert result with a delta of 0.01
//        async.complete();
//      })
//      .onFailure(cause -> context.fail(cause));
//  }
//}
