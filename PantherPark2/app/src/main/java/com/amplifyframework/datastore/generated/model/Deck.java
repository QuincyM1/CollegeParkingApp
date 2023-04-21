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

/** This is an auto generated class representing the Deck type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Decks", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Deck implements Model {
  public static final QueryField ID = field("Deck", "id");
  public static final QueryField DECK_NAME = field("Deck", "DeckName");
  public static final QueryField LEVELS = field("Deck", "Levels");
  public static final QueryField LATITUDE = field("Deck", "Latitude");
  public static final QueryField LONGITUDE = field("Deck", "Longitude");
  public static final QueryField SPOT_COUNT = field("Deck", "SpotCount");
  public static final QueryField ADDRESS = field("Deck", "Address");
  public static final QueryField WHO_IS_ALLOWED = field("Deck", "WhoIsAllowed");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String DeckName;
  private final @ModelField(targetType="Int") Integer Levels;
  private final @ModelField(targetType="String") String Latitude;
  private final @ModelField(targetType="String") String Longitude;
  private final @ModelField(targetType="Int", isRequired = true) Integer SpotCount;
  private final @ModelField(targetType="Spot") @HasMany(associatedWith = "DeckID", type = Spot.class) List<Spot> Spots = null;
  private final @ModelField(targetType="Address", isRequired = true) Address Address;
  private final @ModelField(targetType="String", isRequired = true) String WhoIsAllowed;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getDeckName() {
      return DeckName;
  }
  
  public Integer getLevels() {
      return Levels;
  }
  
  public String getLatitude() {
      return Latitude;
  }
  
  public String getLongitude() {
      return Longitude;
  }
  
  public Integer getSpotCount() {
      return SpotCount;
  }
  
  public List<Spot> getSpots() {
      return Spots;
  }
  
  public Address getAddress() {
      return Address;
  }
  
  public String getWhoIsAllowed() {
      return WhoIsAllowed;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Deck(String id, String DeckName, Integer Levels, String Latitude, String Longitude, Integer SpotCount, Address Address, String WhoIsAllowed) {
    this.id = id;
    this.DeckName = DeckName;
    this.Levels = Levels;
    this.Latitude = Latitude;
    this.Longitude = Longitude;
    this.SpotCount = SpotCount;
    this.Address = Address;
    this.WhoIsAllowed = WhoIsAllowed;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Deck deck = (Deck) obj;
      return ObjectsCompat.equals(getId(), deck.getId()) &&
              ObjectsCompat.equals(getDeckName(), deck.getDeckName()) &&
              ObjectsCompat.equals(getLevels(), deck.getLevels()) &&
              ObjectsCompat.equals(getLatitude(), deck.getLatitude()) &&
              ObjectsCompat.equals(getLongitude(), deck.getLongitude()) &&
              ObjectsCompat.equals(getSpotCount(), deck.getSpotCount()) &&
              ObjectsCompat.equals(getAddress(), deck.getAddress()) &&
              ObjectsCompat.equals(getWhoIsAllowed(), deck.getWhoIsAllowed()) &&
              ObjectsCompat.equals(getCreatedAt(), deck.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), deck.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDeckName())
      .append(getLevels())
      .append(getLatitude())
      .append(getLongitude())
      .append(getSpotCount())
      .append(getAddress())
      .append(getWhoIsAllowed())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Deck {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("DeckName=" + String.valueOf(getDeckName()) + ", ")
      .append("Levels=" + String.valueOf(getLevels()) + ", ")
      .append("Latitude=" + String.valueOf(getLatitude()) + ", ")
      .append("Longitude=" + String.valueOf(getLongitude()) + ", ")
      .append("SpotCount=" + String.valueOf(getSpotCount()) + ", ")
      .append("Address=" + String.valueOf(getAddress()) + ", ")
      .append("WhoIsAllowed=" + String.valueOf(getWhoIsAllowed()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static DeckNameStep builder() {
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
  public static Deck justId(String id) {
    return new Deck(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      DeckName,
      Levels,
      Latitude,
      Longitude,
      SpotCount,
      Address,
      WhoIsAllowed);
  }
  public interface DeckNameStep {
    SpotCountStep deckName(String deckName);
  }
  

  public interface SpotCountStep {
    AddressStep spotCount(Integer spotCount);
  }
  

  public interface AddressStep {
    WhoIsAllowedStep address(Address address);
  }
  

  public interface WhoIsAllowedStep {
    BuildStep whoIsAllowed(String whoIsAllowed);
  }
  

  public interface BuildStep {
    Deck build();
    BuildStep id(String id);
    BuildStep levels(Integer levels);
    BuildStep latitude(String latitude);
    BuildStep longitude(String longitude);
  }
  

  public static class Builder implements DeckNameStep, SpotCountStep, AddressStep, WhoIsAllowedStep, BuildStep {
    private String id;
    private String DeckName;
    private Integer SpotCount;
    private Address Address;
    private String WhoIsAllowed;
    private Integer Levels;
    private String Latitude;
    private String Longitude;
    @Override
     public Deck build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Deck(
          id,
          DeckName,
          Levels,
          Latitude,
          Longitude,
          SpotCount,
          Address,
          WhoIsAllowed);
    }
    
    @Override
     public SpotCountStep deckName(String deckName) {
        Objects.requireNonNull(deckName);
        this.DeckName = deckName;
        return this;
    }
    
    @Override
     public AddressStep spotCount(Integer spotCount) {
        Objects.requireNonNull(spotCount);
        this.SpotCount = spotCount;
        return this;
    }
    
    @Override
     public WhoIsAllowedStep address(Address address) {
        Objects.requireNonNull(address);
        this.Address = address;
        return this;
    }
    
    @Override
     public BuildStep whoIsAllowed(String whoIsAllowed) {
        Objects.requireNonNull(whoIsAllowed);
        this.WhoIsAllowed = whoIsAllowed;
        return this;
    }
    
    @Override
     public BuildStep levels(Integer levels) {
        this.Levels = levels;
        return this;
    }
    
    @Override
     public BuildStep latitude(String latitude) {
        this.Latitude = latitude;
        return this;
    }
    
    @Override
     public BuildStep longitude(String longitude) {
        this.Longitude = longitude;
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
    private CopyOfBuilder(String id, String deckName, Integer levels, String latitude, String longitude, Integer spotCount, Address address, String whoIsAllowed) {
      super.id(id);
      super.deckName(deckName)
        .spotCount(spotCount)
        .address(address)
        .whoIsAllowed(whoIsAllowed)
        .levels(levels)
        .latitude(latitude)
        .longitude(longitude);
    }
    
    @Override
     public CopyOfBuilder deckName(String deckName) {
      return (CopyOfBuilder) super.deckName(deckName);
    }
    
    @Override
     public CopyOfBuilder spotCount(Integer spotCount) {
      return (CopyOfBuilder) super.spotCount(spotCount);
    }
    
    @Override
     public CopyOfBuilder address(Address address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder whoIsAllowed(String whoIsAllowed) {
      return (CopyOfBuilder) super.whoIsAllowed(whoIsAllowed);
    }
    
    @Override
     public CopyOfBuilder levels(Integer levels) {
      return (CopyOfBuilder) super.levels(levels);
    }
    
    @Override
     public CopyOfBuilder latitude(String latitude) {
      return (CopyOfBuilder) super.latitude(latitude);
    }
    
    @Override
     public CopyOfBuilder longitude(String longitude) {
      return (CopyOfBuilder) super.longitude(longitude);
    }
  }
  
}
