package ProcessingModel;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public final class StreamUtils {

    public static LongStream makeFiboStream() {
        return LongStream.generate(FiboSupplier());
    }

    public static LongSupplier FiboSupplier() {

        return new LongSupplier() {

            int current = 1;
            int previous = 0;
            @Override
            public long getAsLong() {
                int result = current;
                current = current + previous;
                previous = result;
                return result;
            }
        };
    }

}
