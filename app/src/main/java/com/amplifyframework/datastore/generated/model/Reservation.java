package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasOne;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Reservation type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Reservations", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
@Index(name = "bySpot", fields = {"SpotID"})
public final class Reservation implements Model {
  public static final QueryField ID = field("Reservation", "id");
  public static final QueryField START_DATE_AND_TIME = field("Reservation", "StartDateAndTime");
  public static final QueryField END_DATE_AND_TIME = field("Reservation", "EndDateAndTime");
  public static final QueryField SPOT_ID = field("Reservation", "SpotID");
  public static final QueryField RESERVATION_PAYMENT_ID = field("Reservation", "reservationPaymentId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="DateAndTime") DateAndTime StartDateAndTime;
  private final @ModelField(targetType="DateAndTime") DateAndTime EndDateAndTime;
  private final @ModelField(targetType="ID", isRequired = true) String SpotID;
  private final @ModelField(targetType="Payment") @HasOne(associatedWith = "id", type = Payment.class) Payment Payment = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String reservationPaymentId;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public DateAndTime getStartDateAndTime() {
      return StartDateAndTime;
  }
  
  public DateAndTime getEndDateAndTime() {
      return EndDateAndTime;
  }
  
  public String getSpotId() {
      return SpotID;
  }
  
  public Payment getPayment() {
      return Payment;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  public String getReservationPaymentId() {
      return reservationPaymentId;
  }
  
  private Reservation(String id, DateAndTime StartDateAndTime, DateAndTime EndDateAndTime, String SpotID, String reservationPaymentId) {
    this.id = id;
    this.StartDateAndTime = StartDateAndTime;
    this.EndDateAndTime = EndDateAndTime;
    this.SpotID = SpotID;
    this.reservationPaymentId = reservationPaymentId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Reservation reservation = (Reservation) obj;
      return ObjectsCompat.equals(getId(), reservation.getId()) &&
              ObjectsCompat.equals(getStartDateAndTime(), reservation.getStartDateAndTime()) &&
              ObjectsCompat.equals(getEndDateAndTime(), reservation.getEndDateAndTime()) &&
              ObjectsCompat.equals(getSpotId(), reservation.getSpotId()) &&
              ObjectsCompat.equals(getCreatedAt(), reservation.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), reservation.getUpdatedAt()) &&
              ObjectsCompat.equals(getReservationPaymentId(), reservation.getReservationPaymentId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getStartDateAndTime())
      .append(getEndDateAndTime())
      .append(getSpotId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getReservationPaymentId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Reservation {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("StartDateAndTime=" + String.valueOf(getStartDateAndTime()) + ", ")
      .append("EndDateAndTime=" + String.valueOf(getEndDateAndTime()) + ", ")
      .append("SpotID=" + String.valueOf(getSpotId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("reservationPaymentId=" + String.valueOf(getReservationPaymentId()))
      .append("}")
      .toString();
  }
  
  public static SpotIdStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Reservation justId(String id) {
    return new Reservation(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      StartDateAndTime,
      EndDateAndTime,
      SpotID,
      reservationPaymentId);
  }
  public interface SpotIdStep {
    BuildStep spotId(String spotId);
  }
  

  public interface BuildStep {
    Reservation build();
    BuildStep id(String id);
    BuildStep startDateAndTime(DateAndTime startDateAndTime);
    BuildStep endDateAndTime(DateAndTime endDateAndTime);
    BuildStep reservationPaymentId(String reservationPaymentId);
  }
  

  public static class Builder implements SpotIdStep, BuildStep {
    private String id;
    private String SpotID;
    private DateAndTime StartDateAndTime;
    private DateAndTime EndDateAndTime;
    private String reservationPaymentId;
    @Override
     public Reservation build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Reservation(
          id,
          StartDateAndTime,
          EndDateAndTime,
          SpotID,
          reservationPaymentId);
    }
    
    @Override
     public BuildStep spotId(String spotId) {
        Objects.requireNonNull(spotId);
        this.SpotID = spotId;
        return this;
    }
    
    @Override
     public BuildStep startDateAndTime(DateAndTime startDateAndTime) {
        this.StartDateAndTime = startDateAndTime;
        return this;
    }
    
    @Override
     public BuildStep endDateAndTime(DateAndTime endDateAndTime) {
        this.EndDateAndTime = endDateAndTime;
        return this;
    }
    
    @Override
     public BuildStep reservationPaymentId(String reservationPaymentId) {
        this.reservationPaymentId = reservationPaymentId;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, DateAndTime startDateAndTime, DateAndTime endDateAndTime, String spotId, String reservationPaymentId) {
      super.id(id);
      super.spotId(spotId)
        .startDateAndTime(startDateAndTime)
        .endDateAndTime(endDateAndTime)
        .reservationPaymentId(reservationPaymentId);
    }
    
    @Override
     public CopyOfBuilder spotId(String spotId) {
      return (CopyOfBuilder) super.spotId(spotId);
    }
    
    @Override
     public CopyOfBuilder startDateAndTime(DateAndTime startDateAndTime) {
      return (CopyOfBuilder) super.startDateAndTime(startDateAndTime);
    }
    
    @Override
     public CopyOfBuilder endDateAndTime(DateAndTime endDateAndTime) {
      return (CopyOfBuilder) super.endDateAndTime(endDateAndTime);
    }
    
    @Override
     public CopyOfBuilder reservationPaymentId(String reservationPaymentId) {
      return (CopyOfBuilder) super.reservationPaymentId(reservationPaymentId);
    }
  }
  
}
