package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the Address type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Addresses", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Address implements Model {
  public static final QueryField ID = field("Address", "id");
  public static final QueryField STREET = field("Address", "Street");
  public static final QueryField CITY = field("Address", "City");
  public static final QueryField STATE = field("Address", "State");
  public static final QueryField ZIP = field("Address", "Zip");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String Street;
  private final @ModelField(targetType="String") String City;
  private final @ModelField(targetType="String") String State;
  private final @ModelField(targetType="String") String Zip;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getStreet() {
      return Street;
  }
  
  public String getCity() {
      return City;
  }
  
  public String getState() {
      return State;
  }
  
  public String getZip() {
      return Zip;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Address(String id, String Street, String City, String State, String Zip) {
    this.id = id;
    this.Street = Street;
    this.City = City;
    this.State = State;
    this.Zip = Zip;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Address address = (Address) obj;
      return ObjectsCompat.equals(getId(), address.getId()) &&
              ObjectsCompat.equals(getStreet(), address.getStreet()) &&
              ObjectsCompat.equals(getCity(), address.getCity()) &&
              ObjectsCompat.equals(getState(), address.getState()) &&
              ObjectsCompat.equals(getZip(), address.getZip()) &&
              ObjectsCompat.equals(getCreatedAt(), address.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), address.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getStreet())
      .append(getCity())
      .append(getState())
      .append(getZip())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Address {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Street=" + String.valueOf(getStreet()) + ", ")
      .append("City=" + String.valueOf(getCity()) + ", ")
      .append("State=" + String.valueOf(getState()) + ", ")
      .append("Zip=" + String.valueOf(getZip()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
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
  public static Address justId(String id) {
    return new Address(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Street,
      City,
      State,
      Zip);
  }
  public interface BuildStep {
    Address build();
    BuildStep id(String id);
    BuildStep street(String street);
    BuildStep city(String city);
    BuildStep state(String state);
    BuildStep zip(String zip);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String Street;
    private String City;
    private String State;
    private String Zip;
    @Override
     public Address build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Address(
          id,
          Street,
          City,
          State,
          Zip);
    }
    
    @Override
     public BuildStep street(String street) {
        this.Street = street;
        return this;
    }
    
    @Override
     public BuildStep city(String city) {
        this.City = city;
        return this;
    }
    
    @Override
     public BuildStep state(String state) {
        this.State = state;
        return this;
    }
    
    @Override
     public BuildStep zip(String zip) {
        this.Zip = zip;
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
    private CopyOfBuilder(String id, String street, String city, String state, String zip) {
      super.id(id);
      super.street(street)
        .city(city)
        .state(state)
        .zip(zip);
    }
    
    @Override
     public CopyOfBuilder street(String street) {
      return (CopyOfBuilder) super.street(street);
    }
    
    @Override
     public CopyOfBuilder city(String city) {
      return (CopyOfBuilder) super.city(city);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder zip(String zip) {
      return (CopyOfBuilder) super.zip(zip);
    }
  }
  
}
