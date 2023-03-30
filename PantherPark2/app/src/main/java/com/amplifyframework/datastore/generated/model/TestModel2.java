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

/** This is an auto generated class representing the TestModel2 type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "TestModel2s", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class TestModel2 implements Model {
  public static final QueryField ID = field("TestModel2", "id");
  public static final QueryField NAME = field("TestModel2", "name");
  public static final QueryField ACCOUNTNUM = field("TestModel2", "accountnum");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="Int") Integer accountnum;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public Integer getAccountnum() {
      return accountnum;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private TestModel2(String id, String name, Integer accountnum) {
    this.id = id;
    this.name = name;
    this.accountnum = accountnum;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      TestModel2 testModel2 = (TestModel2) obj;
      return ObjectsCompat.equals(getId(), testModel2.getId()) &&
              ObjectsCompat.equals(getName(), testModel2.getName()) &&
              ObjectsCompat.equals(getAccountnum(), testModel2.getAccountnum()) &&
              ObjectsCompat.equals(getCreatedAt(), testModel2.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), testModel2.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getAccountnum())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("TestModel2 {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("accountnum=" + String.valueOf(getAccountnum()) + ", ")
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
  public static TestModel2 justId(String id) {
    return new TestModel2(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      accountnum);
  }
  public interface BuildStep {
    TestModel2 build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep accountnum(Integer accountnum);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private Integer accountnum;
    @Override
     public TestModel2 build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new TestModel2(
          id,
          name,
          accountnum);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep accountnum(Integer accountnum) {
        this.accountnum = accountnum;
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
    private CopyOfBuilder(String id, String name, Integer accountnum) {
      super.id(id);
      super.name(name)
        .accountnum(accountnum);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder accountnum(Integer accountnum) {
      return (CopyOfBuilder) super.accountnum(accountnum);
    }
  }
  
}
