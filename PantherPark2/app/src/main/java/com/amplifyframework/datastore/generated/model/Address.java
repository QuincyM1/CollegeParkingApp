package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the Address type in your schema. */
public final class Address {
  private final String Street;
  private final String City;
  private final String State;
  private final String ZipCode;
  public String getStreet() {
      return Street;
  }
  
  public String getCity() {
      return City;
  }
  
  public String getState() {
      return State;
  }
  
  public String getZipCode() {
      return ZipCode;
  }
  
  private Address(String Street, String City, String State, String ZipCode) {
    this.Street = Street;
    this.City = City;
    this.State = State;
    this.ZipCode = ZipCode;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Address address = (Address) obj;
      return ObjectsCompat.equals(getStreet(), address.getStreet()) &&
              ObjectsCompat.equals(getCity(), address.getCity()) &&
              ObjectsCompat.equals(getState(), address.getState()) &&
              ObjectsCompat.equals(getZipCode(), address.getZipCode());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getStreet())
      .append(getCity())
      .append(getState())
      .append(getZipCode())
      .toString()
      .hashCode();
  }
  
  public static StreetStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(Street,
      City,
      State,
      ZipCode);
  }
  public interface StreetStep {
    CityStep street(String street);
  }
  

  public interface CityStep {
    StateStep city(String city);
  }
  

  public interface StateStep {
    ZipCodeStep state(String state);
  }
  

  public interface ZipCodeStep {
    BuildStep zipCode(String zipCode);
  }
  

  public interface BuildStep {
    Address build();
  }
  

  public static class Builder implements StreetStep, CityStep, StateStep, ZipCodeStep, BuildStep {
    private String Street;
    private String City;
    private String State;
    private String ZipCode;
    @Override
     public Address build() {
        
        return new Address(
          Street,
          City,
          State,
          ZipCode);
    }
    
    @Override
     public CityStep street(String street) {
        Objects.requireNonNull(street);
        this.Street = street;
        return this;
    }
    
    @Override
     public StateStep city(String city) {
        Objects.requireNonNull(city);
        this.City = city;
        return this;
    }
    
    @Override
     public ZipCodeStep state(String state) {
        Objects.requireNonNull(state);
        this.State = state;
        return this;
    }
    
    @Override
     public BuildStep zipCode(String zipCode) {
        Objects.requireNonNull(zipCode);
        this.ZipCode = zipCode;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String street, String city, String state, String zipCode) {
      super.street(street)
        .city(city)
        .state(state)
        .zipCode(zipCode);
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
     public CopyOfBuilder zipCode(String zipCode) {
      return (CopyOfBuilder) super.zipCode(zipCode);
    }
  }
  
}
