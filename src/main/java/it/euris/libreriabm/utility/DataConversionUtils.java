package it.euris.libreriabm.utility;

public class DataConversionUtils {

  private DataConversionUtils(){}

  public static String numberToString(Number value){
    return value == null ? null : value.toString();
  }

  public static Long stringToLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }

}
