package fr.istic.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class GreetingService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final Map<String, String> methodMapJava;
  private static final Map<String, String> signatureMapJava;
  
  static {
    methodMapJava = loadMethodsJava();
    signatureMapJava = loadSignaturesJava();
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadMethodsJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException/2345075298", "com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer");
    result.put("com.google.gwt.user.client.rpc.XsrfToken/4254043109", "com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer");
    result.put("fr.istic.shared.ElectronicDevice/3117473042", "fr.istic.shared.ElectronicDevice_FieldSerializer");
    result.put("[Lfr.istic.shared.ElectronicDevice;/2313749791", "fr.istic.shared.ElectronicDevice_Array_Rank_1_FieldSerializer");
    result.put("fr.istic.shared.Heater/373702945", "fr.istic.shared.Heater_FieldSerializer");
    result.put("[Lfr.istic.shared.Heater;/381836909", "fr.istic.shared.Heater_Array_Rank_1_FieldSerializer");
    result.put("fr.istic.shared.Home/3239232171", "fr.istic.shared.Home_FieldSerializer");
    result.put("[Lfr.istic.shared.Home;/3135577724", "fr.istic.shared.Home_Array_Rank_1_FieldSerializer");
    result.put("fr.istic.shared.Person/110504027", "fr.istic.shared.Person_FieldSerializer");
    result.put("[Lfr.istic.shared.Person;/262648486", "fr.istic.shared.Person_Array_Rank_1_FieldSerializer");
    result.put("java.lang.IllegalArgumentException/1755012560", "com.google.gwt.user.client.rpc.core.java.lang.IllegalArgumentException_FieldSerializer");
    result.put("java.lang.NumberFormatException/3305228476", "com.google.gwt.user.client.rpc.core.java.lang.NumberFormatException_FieldSerializer");
    result.put("java.lang.String/2004016611", "com.google.gwt.user.client.rpc.core.java.lang.String_FieldSerializer");
    result.put("java.util.ArrayList/4159755760", "com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer");
    result.put("java.util.Arrays$ArrayList/2507071751", "com.google.gwt.user.client.rpc.core.java.util.Arrays_ArrayList_FieldSerializer");
    result.put("java.util.Collections$EmptyList/4157118744", "com.google.gwt.user.client.rpc.core.java.util.Collections_EmptyList_FieldSerializer");
    result.put("java.util.Collections$SingletonList/1586180994", "com.google.gwt.user.client.rpc.core.java.util.Collections_SingletonList_FieldSerializer");
    result.put("java.util.LinkedList/3953877921", "com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer");
    result.put("java.util.Stack/1346942793", "com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer");
    result.put("java.util.Vector/3057315478", "com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer");
    return result;
  }
  
  @SuppressWarnings("deprecation")
  private static Map<String, String> loadSignaturesJava() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException", "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533");
    result.put("com.google.gwt.user.client.rpc.RpcTokenException", "com.google.gwt.user.client.rpc.RpcTokenException/2345075298");
    result.put("com.google.gwt.user.client.rpc.XsrfToken", "com.google.gwt.user.client.rpc.XsrfToken/4254043109");
    result.put("fr.istic.shared.ElectronicDevice", "fr.istic.shared.ElectronicDevice/3117473042");
    result.put("[Lfr.istic.shared.ElectronicDevice;", "[Lfr.istic.shared.ElectronicDevice;/2313749791");
    result.put("fr.istic.shared.Heater", "fr.istic.shared.Heater/373702945");
    result.put("[Lfr.istic.shared.Heater;", "[Lfr.istic.shared.Heater;/381836909");
    result.put("fr.istic.shared.Home", "fr.istic.shared.Home/3239232171");
    result.put("[Lfr.istic.shared.Home;", "[Lfr.istic.shared.Home;/3135577724");
    result.put("fr.istic.shared.Person", "fr.istic.shared.Person/110504027");
    result.put("[Lfr.istic.shared.Person;", "[Lfr.istic.shared.Person;/262648486");
    result.put("java.lang.IllegalArgumentException", "java.lang.IllegalArgumentException/1755012560");
    result.put("java.lang.NumberFormatException", "java.lang.NumberFormatException/3305228476");
    result.put("java.lang.String", "java.lang.String/2004016611");
    result.put("java.util.ArrayList", "java.util.ArrayList/4159755760");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer.concreteType(), "java.util.Arrays$ArrayList/2507071751");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer.concreteType(), "java.util.Collections$EmptyList/4157118744");
    result.put(com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer.concreteType(), "java.util.Collections$SingletonList/1586180994");
    result.put("java.util.LinkedList", "java.util.LinkedList/3953877921");
    result.put("java.util.Stack", "java.util.Stack/1346942793");
    result.put("java.util.Vector", "java.util.Vector/3057315478");
    return result;
  }
  
  public GreetingService_TypeSerializer() {
    super(methodMapJava, null, signatureMapJava, null);
  }
  
}
