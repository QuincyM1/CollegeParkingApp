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

/** This is an auto generated class representing the User type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class User implements Model {
  public static final QueryField ID = field("User", "id");
  public static final QueryField F_NAME = field("User", "FName");
  public static final QueryField L_NAME = field("User", "LName");
  public static final QueryField USER_TYPE = field("User", "UserType");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String FName;
  private final @ModelField(targetType="String") String LName;
  private final @ModelField(targetType="String") String UserType;
  private final @ModelField(targetType="Card") @HasMany(associatedWith = "userID", type = Card.class) List<Card> UserCards = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getFName() {
      return FName;
  }
  
  public String getLName() {
      return LName;
  }
  
  public String getUserType() {
      return UserType;
  }
  
  public List<Card> getUserCards() {
      return UserCards;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private User(String id, String FName, String LName, String UserType) {
    this.id = id;
    this.FName = FName;
    this.LName = LName;
    this.UserType = UserType;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      User user = (User) obj;
      return ObjectsCompat.equals(getId(), user.getId()) &&
              ObjectsCompat.equals(getFName(), user.getFName()) &&
              ObjectsCompat.equals(getLName(), user.getLName()) &&
              ObjectsCompat.equals(getUserType(), user.getUserType()) &&
              ObjectsCompat.equals(getCreatedAt(), user.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), user.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFName())
      .append(getLName())
      .append(getUserType())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("User {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("FName=" + String.valueOf(getFName()) + ", ")
      .append("LName=" + String.valueOf(getLName()) + ", ")
      .append("UserType=" + String.valueOf(getUserType()) + ", ")
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
  public static User justId(String id) {
    return new User(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      FName,
      LName,
      UserType);
  }
  public interface BuildStep {
    User build();
    BuildStep id(String id);
    BuildStep fName(String fName);
    BuildStep lName(String lName);
    BuildStep userType(String userType);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String FName;
    private String LName;
    private String UserType;
    @Override
     public User build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new User(
          id,
          FName,
          LName,
          UserType);
    }
    
    @Override
     public BuildStep fName(String fName) {
        this.FName = fName;
        return this;
    }
    
    @Override
     public BuildStep lName(String lName) {
        this.LName = lName;
        return this;
    }
    
    @Override
     public BuildStep userType(String userType) {
        this.UserType = userType;
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
    private CopyOfBuilder(String id, String fName, String lName, String userType) {
      super.id(id);
      super.fName(fName)
        .lName(lName)
        .userType(userType);
    }
    
    @Override
     public CopyOfBuilder fName(String fName) {
      return (CopyOfBuilder) super.fName(fName);
    }
    
    @Override
     public CopyOfBuilder lName(String lName) {
      return (CopyOfBuilder) super.lName(lName);
    }
    
    @Override
     public CopyOfBuilder userType(String userType) {
      return (CopyOfBuilder) super.userType(userType);
    }
  }
  
}
