package rocks.twr.api.out;

public interface OutboxService {

    void publishEvent(String topic, byte[] key, byte[] value);


}
