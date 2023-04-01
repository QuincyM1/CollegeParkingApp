package com.amplifyframework.datastore.generated.model;


import androidx.core.util.ObjectsCompat;

import java.util.Objects;
import java.util.List;

/** This is an auto generated class representing the DateAndTime type in your schema. */
public final class DateAndTime {
  private final Integer DayNum;
  private final Integer Month;
  private final Integer Year;
  private final Integer Hour;
  private final Integer Minute;
  private final Boolean IsAM;
  public Integer getDayNum() {
      return DayNum;
  }
  
  public Integer getMonth() {
      return Month;
  }
  
  public Integer getYear() {
      return Year;
  }
  
  public Integer getHour() {
      return Hour;
  }
  
  public Integer getMinute() {
      return Minute;
  }
  
  public Boolean getIsAm() {
      return IsAM;
  }
  
  private DateAndTime(Integer DayNum, Integer Month, Integer Year, Integer Hour, Integer Minute, Boolean IsAM) {
    this.DayNum = DayNum;
    this.Month = Month;
    this.Year = Year;
    this.Hour = Hour;
    this.Minute = Minute;
    this.IsAM = IsAM;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      DateAndTime dateAndTime = (DateAndTime) obj;
      return ObjectsCompat.equals(getDayNum(), dateAndTime.getDayNum()) &&
              ObjectsCompat.equals(getMonth(), dateAndTime.getMonth()) &&
              ObjectsCompat.equals(getYear(), dateAndTime.getYear()) &&
              ObjectsCompat.equals(getHour(), dateAndTime.getHour()) &&
              ObjectsCompat.equals(getMinute(), dateAndTime.getMinute()) &&
              ObjectsCompat.equals(getIsAm(), dateAndTime.getIsAm());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getDayNum())
      .append(getMonth())
      .append(getYear())
      .append(getHour())
      .append(getMinute())
      .append(getIsAm())
      .toString()
      .hashCode();
  }
  
  public static DayNumStep builder() {
      return new Builder();
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(DayNum,
      Month,
      Year,
      Hour,
      Minute,
      IsAM);
  }
  public interface DayNumStep {
    MonthStep dayNum(Integer dayNum);
  }
  

  public interface MonthStep {
    YearStep month(Integer month);
  }
  

  public interface YearStep {
    HourStep year(Integer year);
  }
  

  public interface HourStep {
    MinuteStep hour(Integer hour);
  }
  

  public interface MinuteStep {
    IsAmStep minute(Integer minute);
  }
  

  public interface IsAmStep {
    BuildStep isAm(Boolean isAm);
  }
  

  public interface BuildStep {
    DateAndTime build();
  }
  

  public static class Builder implements DayNumStep, MonthStep, YearStep, HourStep, MinuteStep, IsAmStep, BuildStep {
    private Integer DayNum;
    private Integer Month;
    private Integer Year;
    private Integer Hour;
    private Integer Minute;
    private Boolean IsAM;
    @Override
     public DateAndTime build() {
        
        return new DateAndTime(
          DayNum,
          Month,
          Year,
          Hour,
          Minute,
          IsAM);
    }
    
    @Override
     public MonthStep dayNum(Integer dayNum) {
        Objects.requireNonNull(dayNum);
        this.DayNum = dayNum;
        return this;
    }
    
    @Override
     public YearStep month(Integer month) {
        Objects.requireNonNull(month);
        this.Month = month;
        return this;
    }
    
    @Override
     public HourStep year(Integer year) {
        Objects.requireNonNull(year);
        this.Year = year;
        return this;
    }
    
    @Override
     public MinuteStep hour(Integer hour) {
        Objects.requireNonNull(hour);
        this.Hour = hour;
        return this;
    }
    
    @Override
     public IsAmStep minute(Integer minute) {
        Objects.requireNonNull(minute);
        this.Minute = minute;
        return this;
    }
    
    @Override
     public BuildStep isAm(Boolean isAm) {
        Objects.requireNonNull(isAm);
        this.IsAM = isAm;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(Integer dayNum, Integer month, Integer year, Integer hour, Integer minute, Boolean isAm) {
      super.dayNum(dayNum)
        .month(month)
        .year(year)
        .hour(hour)
        .minute(minute)
        .isAm(isAm);
    }
    
    @Override
     public CopyOfBuilder dayNum(Integer dayNum) {
      return (CopyOfBuilder) super.dayNum(dayNum);
    }
    
    @Override
     public CopyOfBuilder month(Integer month) {
      return (CopyOfBuilder) super.month(month);
    }
    
    @Override
     public CopyOfBuilder year(Integer year) {
      return (CopyOfBuilder) super.year(year);
    }
    
    @Override
     public CopyOfBuilder hour(Integer hour) {
      return (CopyOfBuilder) super.hour(hour);
    }
    
    @Override
     public CopyOfBuilder minute(Integer minute) {
      return (CopyOfBuilder) super.minute(minute);
    }
    
    @Override
     public CopyOfBuilder isAm(Boolean isAm) {
      return (CopyOfBuilder) super.isAm(isAm);
    }
  }
  
}
