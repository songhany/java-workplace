package udacity.reflection.customAnnotations.home;

public interface UnitTest {
  default void beforeEachTest() {}
  default void afterEachTest() {}
}
