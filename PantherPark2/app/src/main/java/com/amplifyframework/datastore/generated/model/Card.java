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

/** This is an auto generated class representing the Card type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Cards", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID"})
public final class Card implements Model {
  public static final QueryField ID = field("Card", "id");
  public static final QueryField CARD_NUMBER = field("Card", "CardNumber");
  public static final QueryField CARD_VERIFICATION_VALUE = field("Card", "CardVerificationValue");
  public static final QueryField EXP_DATE = field("Card", "ExpDate");
  public static final QueryField BILLING_NAME = field("Card", "BillingName");
  public static final QueryField USER_ID = field("Card", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String CardNumber;
  private final @ModelField(targetType="Int", isRequired = true) Integer CardVerificationValue;
  private final @ModelField(targetType="String", isRequired = true) String ExpDate;
  private final @ModelField(targetType="String", isRequired = true) String BillingName;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getCardNumber() {
      return CardNumber;
  }
  
  public Integer getCardVerificationValue() {
      return CardVerificationValue;
  }
  
  public String getExpDate() {
      return ExpDate;
  }
  
  public String getBillingName() {
      return BillingName;
  }
  
  public String getUserId() {
      return userID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Card(String id, String CardNumber, Integer CardVerificationValue, String ExpDate, String BillingName, String userID) {
    this.id = id;
    this.CardNumber = CardNumber;
    this.CardVerificationValue = CardVerificationValue;
    this.ExpDate = ExpDate;
    this.BillingName = BillingName;
    this.userID = userID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Card card = (Card) obj;
      return ObjectsCompat.equals(getId(), card.getId()) &&
              ObjectsCompat.equals(getCardNumber(), card.getCardNumber()) &&
              ObjectsCompat.equals(getCardVerificationValue(), card.getCardVerificationValue()) &&
              ObjectsCompat.equals(getExpDate(), card.getExpDate()) &&
              ObjectsCompat.equals(getBillingName(), card.getBillingName()) &&
              ObjectsCompat.equals(getUserId(), card.getUserId()) &&
              ObjectsCompat.equals(getCreatedAt(), card.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), card.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCardNumber())
      .append(getCardVerificationValue())
      .append(getExpDate())
      .append(getBillingName())
      .append(getUserId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Card {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("CardNumber=" + String.valueOf(getCardNumber()) + ", ")
      .append("CardVerificationValue=" + String.valueOf(getCardVerificationValue()) + ", ")
      .append("ExpDate=" + String.valueOf(getExpDate()) + ", ")
      .append("BillingName=" + String.valueOf(getBillingName()) + ", ")
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CardNumberStep builder() {
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
  public static Card justId(String id) {
    return new Card(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      CardNumber,
      CardVerificationValue,
      ExpDate,
      BillingName,
      userID);
  }
  public interface CardNumberStep {
    CardVerificationValueStep cardNumber(String cardNumber);
  }
  

  public interface CardVerificationValueStep {
    ExpDateStep cardVerificationValue(Integer cardVerificationValue);
  }
  

  public interface ExpDateStep {
    BillingNameStep expDate(String expDate);
  }
  

  public interface BillingNameStep {
    UserIdStep billingName(String billingName);
  }
  

  public interface UserIdStep {
    BuildStep userId(String userId);
  }
  

  public interface BuildStep {
    Card build();
    BuildStep id(String id);
  }
  

  public static class Builder implements CardNumberStep, CardVerificationValueStep, ExpDateStep, BillingNameStep, UserIdStep, BuildStep {
    private String id;
    private String CardNumber;
    private Integer CardVerificationValue;
    private String ExpDate;
    private String BillingName;
    private String userID;
    @Override
     public Card build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Card(
          id,
          CardNumber,
          CardVerificationValue,
          ExpDate,
          BillingName,
          userID);
    }
    
    @Override
     public CardVerificationValueStep cardNumber(String cardNumber) {
        Objects.requireNonNull(cardNumber);
        this.CardNumber = cardNumber;
        return this;
    }
    
    @Override
     public ExpDateStep cardVerificationValue(Integer cardVerificationValue) {
        Objects.requireNonNull(cardVerificationValue);
        this.CardVerificationValue = cardVerificationValue;
        return this;
    }
    
    @Override
     public BillingNameStep expDate(String expDate) {
        Objects.requireNonNull(expDate);
        this.ExpDate = expDate;
        return this;
    }
    
    @Override
     public UserIdStep billingName(String billingName) {
        Objects.requireNonNull(billingName);
        this.BillingName = billingName;
        return this;
    }
    
    @Override
     public BuildStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
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
    private CopyOfBuilder(String id, String cardNumber, Integer cardVerificationValue, String expDate, String billingName, String userId) {
      super.id(id);
      super.cardNumber(cardNumber)
        .cardVerificationValue(cardVerificationValue)
        .expDate(expDate)
        .billingName(billingName)
        .userId(userId);
    }
    
    @Override
     public CopyOfBuilder cardNumber(String cardNumber) {
      return (CopyOfBuilder) super.cardNumber(cardNumber);
    }
    
    @Override
     public CopyOfBuilder cardVerificationValue(Integer cardVerificationValue) {
      return (CopyOfBuilder) super.cardVerificationValue(cardVerificationValue);
    }
    
    @Override
     public CopyOfBuilder expDate(String expDate) {
      return (CopyOfBuilder) super.expDate(expDate);
    }
    
    @Override
     public CopyOfBuilder billingName(String billingName) {
      return (CopyOfBuilder) super.billingName(billingName);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
    }
  }
  
}
