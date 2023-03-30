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

/** This is an auto generated class representing the UntitledModel type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "UntitledModels", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class UntitledModel implements Model {
  public static final QueryField ID = field("UntitledModel", "id");
  public static final QueryField UNTITLEDFIELD = field("UntitledModel", "untitledfield");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String untitledfield;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getUntitledfield() {
      return untitledfield;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private UntitledModel(String id, String untitledfield) {
    this.id = id;
    this.untitledfield = untitledfield;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      UntitledModel untitledModel = (UntitledModel) obj;
      return ObjectsCompat.equals(getId(), untitledModel.getId()) &&
              ObjectsCompat.equals(getUntitledfield(), untitledModel.getUntitledfield()) &&
              ObjectsCompat.equals(getCreatedAt(), untitledModel.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), untitledModel.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUntitledfield())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("UntitledModel {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("untitledfield=" + String.valueOf(getUntitledfield()) + ", ")
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
  public static UntitledModel justId(String id) {
    return new UntitledModel(
      id,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      untitledfield);
  }
  public interface BuildStep {
    UntitledModel build();
    BuildStep id(String id);
    BuildStep untitledfield(String untitledfield);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String untitledfield;
    @Override
     public UntitledModel build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new UntitledModel(
          id,
          untitledfield);
    }
    
    @Override
     public BuildStep untitledfield(String untitledfield) {
        this.untitledfield = untitledfield;
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
    private CopyOfBuilder(String id, String untitledfield) {
      super.id(id);
      super.untitledfield(untitledfield);
    }
    
    @Override
     public CopyOfBuilder untitledfield(String untitledfield) {
      return (CopyOfBuilder) super.untitledfield(untitledfield);
    }
  }
  
}
