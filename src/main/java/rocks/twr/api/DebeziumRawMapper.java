package rocks.twr.api;

import java.util.Map;

/**
 * Implement this and supply it to the engine in order to
 * convert a debezium record into a first class event.
 */
public interface DebeziumRawMapper {

    record MappedEvent(String topicName, byte[] key, byte[] value, Map<String, String> headers) {
    }

    MappedEvent map(String jsonKey, String jsonValue);
}
