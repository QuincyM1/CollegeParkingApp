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

/** This is an auto generated class representing the Card type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Cards", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.OWNER, ownerField = "owner", identityClaim = "cognito:username", provider = "userPools", operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "User" }, provider = "userPools", operations = { ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.GROUPS, groupClaim = "cognito:groups", groups = { "Admins" }, provider = "userPools", operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE })
})
public final class Card implements Model {
  public static final QueryField ID = field("Card", "id");
  public static final QueryField CARD_NUMBER = field("Card", "CardNumber");
  public static final QueryField CARD_VERIFICATION_VALUE = field("Card", "CardVerificationValue");
  public static final QueryField EXP_DATE = field("Card", "ExpDate");
  public static final QueryField BILLING_NAME = field("Card", "BillingName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String CardNumber;
  private final @ModelField(targetType="String", isRequired = true) String CardVerificationValue;
  private final @ModelField(targetType="String", isRequired = true) String ExpDate;
  private final @ModelField(targetType="String", isRequired = true) String BillingName;
  private final @ModelField(targetType="Payment") @HasMany(associatedWith = "CardID", type = Payment.class) List<Payment> PaymentCard = null;
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
  
  public String getCardVerificationValue() {
      return CardVerificationValue;
  }
  
  public String getExpDate() {
      return ExpDate;
  }
  
  public String getBillingName() {
      return BillingName;
  }
  
  public List<Payment> getPaymentCard() {
      return PaymentCard;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Card(String id, String CardNumber, String CardVerificationValue, String ExpDate, String BillingName) {
    this.id = id;
    this.CardNumber = CardNumber;
    this.CardVerificationValue = CardVerificationValue;
    this.ExpDate = ExpDate;
    this.BillingName = BillingName;
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      CardNumber,
      CardVerificationValue,
      ExpDate,
      BillingName);
  }
  public interface CardNumberStep {
    CardVerificationValueStep cardNumber(String cardNumber);
  }
  

  public interface CardVerificationValueStep {
    ExpDateStep cardVerificationValue(String cardVerificationValue);
  }
  

  public interface ExpDateStep {
    BillingNameStep expDate(String expDate);
  }
  

  public interface BillingNameStep {
    BuildStep billingName(String billingName);
  }
  

  public interface BuildStep {
    Card build();
    BuildStep id(String id);
  }
  

  public static class Builder implements CardNumberStep, CardVerificationValueStep, ExpDateStep, BillingNameStep, BuildStep {
    private String id;
    private String CardNumber;
    private String CardVerificationValue;
    private String ExpDate;
    private String BillingName;
    @Override
     public Card build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Card(
          id,
          CardNumber,
          CardVerificationValue,
          ExpDate,
          BillingName);
    }
    
    @Override
     public CardVerificationValueStep cardNumber(String cardNumber) {
        Objects.requireNonNull(cardNumber);
        this.CardNumber = cardNumber;
        return this;
    }
    
    @Override
     public ExpDateStep cardVerificationValue(String cardVerificationValue) {
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
     public BuildStep billingName(String billingName) {
        Objects.requireNonNull(billingName);
        this.BillingName = billingName;
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
    private CopyOfBuilder(String id, String cardNumber, String cardVerificationValue, String expDate, String billingName) {
      super.id(id);
      super.cardNumber(cardNumber)
        .cardVerificationValue(cardVerificationValue)
        .expDate(expDate)
        .billingName(billingName);
    }
    
    @Override
     public CopyOfBuilder cardNumber(String cardNumber) {
      return (CopyOfBuilder) super.cardNumber(cardNumber);
    }
    
    @Override
     public CopyOfBuilder cardVerificationValue(String cardVerificationValue) {
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
  }
  
}
