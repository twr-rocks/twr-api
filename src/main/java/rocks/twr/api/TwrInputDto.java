package rocks.twr.api;

import java.time.ZonedDateTime;

/**
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public class TwrInputDto<K, V> {
    K key;
    V value;
    ZonedDateTime completed;
    ZonedDateTime delayUntil;
    // TODO etc... what do we actually need in TWR?
}
