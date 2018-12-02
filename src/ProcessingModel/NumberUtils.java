package ProcessingModel;

import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public final class NumberUtils {

    private static long[] primes;
    private static int lastPrimeIdx;

    static {
        primes = new long[]{2, 3, 5, 7, 11, 13, 17, 19};
        lastPrimeIdx = primes.length - 1;
    }

    public static LongSupplier makePrimeSupplier() {
        return new LongSupplier() {

            private int i = 0;
            @Override
            public long getAsLong() {
                while (i > lastPrimeIdx) {
                    //calculateNext();
                }
                return primes[i++];
            }
        };
    }

    public static LongStream makePrimeStreamTill(long n) {
        return NumberUtils.generate(makePrimeSupplier(), prime -> (prime<=n));
    }

    public static LongStream generate(LongSupplier supplier, LongPredicate predicate) {
        return LongStream.generate(supplier);
    }
}
