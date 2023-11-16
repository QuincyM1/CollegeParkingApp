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

/** This is an auto generated class representing the Payment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Payments", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
@Index(name = "byCard", fields = {"CardID"})
public final class Payment implements Model {
  public static final QueryField ID = field("Payment", "id");
  public static final QueryField CARD_ID = field("Payment", "CardID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String CardID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getCardId() {
      return CardID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Payment(String id, String CardID) {
    this.id = id;
    this.CardID = CardID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Payment payment = (Payment) obj;
      return ObjectsCompat.equals(getId(), payment.getId()) &&
              ObjectsCompat.equals(getCardId(), payment.getCardId()) &&
              ObjectsCompat.equals(getCreatedAt(), payment.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), payment.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCardId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Payment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("CardID=" + String.valueOf(getCardId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CardIdStep builder() {
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
  public static Payment justId(String id) {
    return new Payment(
      id,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      CardID);
  }
  public interface CardIdStep {
    BuildStep cardId(String cardId);
  }
  

  public interface BuildStep {
    Payment build();
    BuildStep id(String id);
  }
  

  public static class Builder implements CardIdStep, BuildStep {
    private String id;
    private String CardID;
    @Override
     public Payment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Payment(
          id,
          CardID);
    }
    
    @Override
     public BuildStep cardId(String cardId) {
        Objects.requireNonNull(cardId);
        this.CardID = cardId;
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
    private CopyOfBuilder(String id, String cardId) {
      super.id(id);
      super.cardId(cardId);
    }
    
    @Override
     public CopyOfBuilder cardId(String cardId) {
      return (CopyOfBuilder) super.cardId(cardId);
    }
  }
  
}
