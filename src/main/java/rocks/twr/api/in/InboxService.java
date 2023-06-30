package rocks.twr.api.in;

/** called the inbox service, because it is used to do stuff with incoming records, but actually writes to the outbox
 * table so that we get the right order and delivery guarantees that we need */
public interface InboxService {

    void retryEvent(Object record/* so we have key, value and headers*/);
    void retryEvent(Object record, long delayUntilEpochMs);
    void pauseEvent(Object record, long delayUntilEpochMs);

    // TODO if you throw an exception here, you get the same record immediately again.
    // no thats crap, you want any kind of failure to lead to us retrying later.
    // so the framework needs to be e.g. a quarkus kafka interceptor! which is able to catch your exceptions
    // and react to them by writing to the outbox in a new tx

    // TODO under the hood we really only need one table, coz functionally its the same thing regardless of in- or outbox.

    // TODO i want to offer embedded debezium, but i also want to support you if you don't want to use debezium,
    // so i need to jave an input topic as originally conceived.
}
