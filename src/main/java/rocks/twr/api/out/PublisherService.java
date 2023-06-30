package rocks.twr.api.out;

import java.util.Map;

/**
 * Use to publish events, guaranteed to be sent if the current transaction is successfully committed,
 * and guaranteed to be published in the order in which you call this service.
 */
public interface PublisherService {
    void send(String key, Object value, Map<String, String> headers);

    // TODO dont forget to flush, so that order is guaranteed!
}
