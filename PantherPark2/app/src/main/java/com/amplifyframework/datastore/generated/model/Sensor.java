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

/** This is an auto generated class representing the Sensor type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Sensors", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
public final class Sensor implements Model {
  public static final QueryField ID = field("Sensor", "id");
  public static final QueryField MODEL_NUMBER = field("Sensor", "ModelNumber");
  public static final QueryField SERIAL_NUMBER = field("Sensor", "SerialNumber");
  public static final QueryField STATUS = field("Sensor", "Status");
  public static final QueryField SENSOR_SPOT_ID = field("Sensor", "sensorSpotId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int") Integer ModelNumber;
  private final @ModelField(targetType="Int") Integer SerialNumber;
  private final @ModelField(targetType="Int", isRequired = true) Integer Status;
  private final @ModelField(targetType="Spot") @HasOne(associatedWith = "id", type = Spot.class) Spot Spot = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String sensorSpotId;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Integer getModelNumber() {
      return ModelNumber;
  }
  
  public Integer getSerialNumber() {
      return SerialNumber;
  }
  
  public Integer getStatus() {
      return Status;
  }
  
  public Spot getSpot() {
      return Spot;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  public String getSensorSpotId() {
      return sensorSpotId;
  }
  
  private Sensor(String id, Integer ModelNumber, Integer SerialNumber, Integer Status, String sensorSpotId) {
    this.id = id;
    this.ModelNumber = ModelNumber;
    this.SerialNumber = SerialNumber;
    this.Status = Status;
    this.sensorSpotId = sensorSpotId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Sensor sensor = (Sensor) obj;
      return ObjectsCompat.equals(getId(), sensor.getId()) &&
              ObjectsCompat.equals(getModelNumber(), sensor.getModelNumber()) &&
              ObjectsCompat.equals(getSerialNumber(), sensor.getSerialNumber()) &&
              ObjectsCompat.equals(getStatus(), sensor.getStatus()) &&
              ObjectsCompat.equals(getCreatedAt(), sensor.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), sensor.getUpdatedAt()) &&
              ObjectsCompat.equals(getSensorSpotId(), sensor.getSensorSpotId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getModelNumber())
      .append(getSerialNumber())
      .append(getStatus())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getSensorSpotId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Sensor {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("ModelNumber=" + String.valueOf(getModelNumber()) + ", ")
      .append("SerialNumber=" + String.valueOf(getSerialNumber()) + ", ")
      .append("Status=" + String.valueOf(getStatus()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("sensorSpotId=" + String.valueOf(getSensorSpotId()))
      .append("}")
      .toString();
  }
  
  public static StatusStep builder() {
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
  public static Sensor justId(String id) {
    return new Sensor(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      ModelNumber,
      SerialNumber,
      Status,
      sensorSpotId);
  }
  public interface StatusStep {
    BuildStep status(Integer status);
  }
  

  public interface BuildStep {
    Sensor build();
    BuildStep id(String id);
    BuildStep modelNumber(Integer modelNumber);
    BuildStep serialNumber(Integer serialNumber);
    BuildStep sensorSpotId(String sensorSpotId);
  }
  

  public static class Builder implements StatusStep, BuildStep {
    private String id;
    private Integer Status;
    private Integer ModelNumber;
    private Integer SerialNumber;
    private String sensorSpotId;
    @Override
     public Sensor build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Sensor(
          id,
          ModelNumber,
          SerialNumber,
          Status,
          sensorSpotId);
    }
    
    @Override
     public BuildStep status(Integer status) {
        Objects.requireNonNull(status);
        this.Status = status;
        return this;
    }
    
    @Override
     public BuildStep modelNumber(Integer modelNumber) {
        this.ModelNumber = modelNumber;
        return this;
    }
    
    @Override
     public BuildStep serialNumber(Integer serialNumber) {
        this.SerialNumber = serialNumber;
        return this;
    }
    
    @Override
     public BuildStep sensorSpotId(String sensorSpotId) {
        this.sensorSpotId = sensorSpotId;
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
    private CopyOfBuilder(String id, Integer modelNumber, Integer serialNumber, Integer status, String sensorSpotId) {
      super.id(id);
      super.status(status)
        .modelNumber(modelNumber)
        .serialNumber(serialNumber)
        .sensorSpotId(sensorSpotId);
    }
    
    @Override
     public CopyOfBuilder status(Integer status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder modelNumber(Integer modelNumber) {
      return (CopyOfBuilder) super.modelNumber(modelNumber);
    }
    
    @Override
     public CopyOfBuilder serialNumber(Integer serialNumber) {
      return (CopyOfBuilder) super.serialNumber(serialNumber);
    }
    
    @Override
     public CopyOfBuilder sensorSpotId(String sensorSpotId) {
      return (CopyOfBuilder) super.sensorSpotId(sensorSpotId);
    }
  }
  
}
