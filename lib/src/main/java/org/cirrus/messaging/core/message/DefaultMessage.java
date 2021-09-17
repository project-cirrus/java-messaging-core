package org.cirrus.messaging.core.message;

import com.google.common.base.Preconditions;
import org.immutables.value.Value;

@Value.Immutable
public abstract class DefaultMessage implements Message {

  private static final String NO_SUBSCRIPTION = null;
  private static final String INVALID_BODY_MESSAGE = "'body' must not be null";

  @Override
  public abstract String getSender();

  @Override
  public abstract String getReturnAddress();

  @Override
  @Value.Default
  public String getSubscription() {
    return NO_SUBSCRIPTION;
  }

  @Override
  public abstract String getBody();

  @Value.Check
  protected void checkBody() {
    Preconditions.checkNotNull(getBody(), INVALID_BODY_MESSAGE);
  }

  public static Builder newBuilder() {
    return ImmutableDefaultMessage.newBuilder();
  }

  public interface Builder {

    public abstract DefaultMessage build();

    public abstract Builder setSender(String sender);

    public abstract Builder setReturnAddress(String returnAddress);

    public abstract Builder setSubscription(String subscription);

    public abstract Builder setBody(String body);
  }
}
