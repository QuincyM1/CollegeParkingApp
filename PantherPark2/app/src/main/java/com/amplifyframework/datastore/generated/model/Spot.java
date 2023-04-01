package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Spot type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Spots", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
@Index(name = "byDeck", fields = {"DeckID"})
public final class Spot implements Model {
  public static final QueryField ID = field("Spot", "id");
  public static final QueryField CODE = field("Spot", "Code");
  public static final QueryField HANDICAP_ONLY = field("Spot", "HandicapOnly");
  public static final QueryField RESERVATION_STATUS = field("Spot", "ReservationStatus");
  public static final QueryField DECK_ID = field("Spot", "DeckID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Code;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean HandicapOnly;
  private final @ModelField(targetType="Int") Integer ReservationStatus;
  private final @ModelField(targetType="ID", isRequired = true) String DeckID;
  private final @ModelField(targetType="Reservation") @HasMany(associatedWith = "SpotID", type = Reservation.class) List<Reservation> ReservedSpot = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getCode() {
      return Code;
  }
  
  public Boolean getHandicapOnly() {
      return HandicapOnly;
  }
  
  public Integer getReservationStatus() {
      return ReservationStatus;
  }
  
  public String getDeckId() {
      return DeckID;
  }
  
  public List<Reservation> getReservedSpot() {
      return ReservedSpot;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Spot(String id, String Code, Boolean HandicapOnly, Integer ReservationStatus, String DeckID) {
    this.id = id;
    this.Code = Code;
    this.HandicapOnly = HandicapOnly;
    this.ReservationStatus = ReservationStatus;
    this.DeckID = DeckID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Spot spot = (Spot) obj;
      return ObjectsCompat.equals(getId(), spot.getId()) &&
              ObjectsCompat.equals(getCode(), spot.getCode()) &&
              ObjectsCompat.equals(getHandicapOnly(), spot.getHandicapOnly()) &&
              ObjectsCompat.equals(getReservationStatus(), spot.getReservationStatus()) &&
              ObjectsCompat.equals(getDeckId(), spot.getDeckId()) &&
              ObjectsCompat.equals(getCreatedAt(), spot.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), spot.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCode())
      .append(getHandicapOnly())
      .append(getReservationStatus())
      .append(getDeckId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Spot {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Code=" + String.valueOf(getCode()) + ", ")
      .append("HandicapOnly=" + String.valueOf(getHandicapOnly()) + ", ")
      .append("ReservationStatus=" + String.valueOf(getReservationStatus()) + ", ")
      .append("DeckID=" + String.valueOf(getDeckId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CodeStep builder() {
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
  public static Spot justId(String id) {
    return new Spot(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Code,
      HandicapOnly,
      ReservationStatus,
      DeckID);
  }
  public interface CodeStep {
    HandicapOnlyStep code(String code);
  }
  

  public interface HandicapOnlyStep {
    DeckIdStep handicapOnly(Boolean handicapOnly);
  }
  

  public interface DeckIdStep {
    BuildStep deckId(String deckId);
  }
  

  public interface BuildStep {
    Spot build();
    BuildStep id(String id);
    BuildStep reservationStatus(Integer reservationStatus);
  }
  

  public static class Builder implements CodeStep, HandicapOnlyStep, DeckIdStep, BuildStep {
    private String id;
    private String Code;
    private Boolean HandicapOnly;
    private String DeckID;
    private Integer ReservationStatus;
    @Override
     public Spot build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Spot(
          id,
          Code,
          HandicapOnly,
          ReservationStatus,
          DeckID);
    }
    
    @Override
     public HandicapOnlyStep code(String code) {
        Objects.requireNonNull(code);
        this.Code = code;
        return this;
    }
    
    @Override
     public DeckIdStep handicapOnly(Boolean handicapOnly) {
        Objects.requireNonNull(handicapOnly);
        this.HandicapOnly = handicapOnly;
        return this;
    }
    
    @Override
     public BuildStep deckId(String deckId) {
        Objects.requireNonNull(deckId);
        this.DeckID = deckId;
        return this;
    }
    
    @Override
     public BuildStep reservationStatus(Integer reservationStatus) {
        this.ReservationStatus = reservationStatus;
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
    private CopyOfBuilder(String id, String code, Boolean handicapOnly, Integer reservationStatus, String deckId) {
      super.id(id);
      super.code(code)
        .handicapOnly(handicapOnly)
        .deckId(deckId)
        .reservationStatus(reservationStatus);
    }
    
    @Override
     public CopyOfBuilder code(String code) {
      return (CopyOfBuilder) super.code(code);
    }
    
    @Override
     public CopyOfBuilder handicapOnly(Boolean handicapOnly) {
      return (CopyOfBuilder) super.handicapOnly(handicapOnly);
    }
    
    @Override
     public CopyOfBuilder deckId(String deckId) {
      return (CopyOfBuilder) super.deckId(deckId);
    }
    
    @Override
     public CopyOfBuilder reservationStatus(Integer reservationStatus) {
      return (CopyOfBuilder) super.reservationStatus(reservationStatus);
    }
  }
  
}
