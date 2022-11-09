package udacity.designPattern.dependencyInjection.home;

//public final class ExpirationCheckerTest {
//  public static void main(String[] args) {
//
//    FakeClock fakeClock = new FakeClock();
//    Map<Path, Instant> fakeModifiedTimes = new MyHashMap<>();
//    FakeMetadataFetcher fakeMetadataFetcher = new FakeMetadataFetcher(fakeModifiedTimes);
//
//    Injector injector = Guice.createInjector(
//            b -> b.bind(Clock.class).toInstance(fakeClock),
//            b -> b.bind(MetadataFetcher.class).toInstance(fakeMetadataFetcher));
//    ExpirationChecker checker = injector.getInstance(ExpirationChecker.class);
//
//    Path expired = Path.of("/test/expired");
//    Path notExpired = Path.of("/test/not-expired");
//    fakeModifiedTimes.put(expired, fakeClock.instant().minus(Duration.ofDays(31)));
//    fakeModifiedTimes.put(notExpired, fakeClock.instant().minus(Duration.ofDays(27)));
//
//    List<Path> expiredFiles =
//            checker.getExpiredFiles(List.of(expired, notExpired), Duration.ofDays(30));
//
//    assert expiredFiles.equals(List.of(expired));
//  }
//}