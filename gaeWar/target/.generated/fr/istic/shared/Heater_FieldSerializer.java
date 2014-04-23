package fr.istic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Heater_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getConsommation(fr.istic.shared.Heater instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.Heater.class, instance, "consommation");
  }
  
  private static void setConsommation(fr.istic.shared.Heater instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Heater.class, instance, "consommation", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getId(fr.istic.shared.Heater instance) {
    return (java.lang.Long) ReflectionHelper.getField(fr.istic.shared.Heater.class, instance, "id");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setId(fr.istic.shared.Heater instance, long value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Heater.class, instance, "id", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, fr.istic.shared.Heater instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setConsommation(instance, streamReader.readString());
    setId(instance, streamReader.readLong());
    
  }
  
  public static fr.istic.shared.Heater instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new fr.istic.shared.Heater();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, fr.istic.shared.Heater instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getConsommation(instance));
    streamWriter.writeLong(getId(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return fr.istic.shared.Heater_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    fr.istic.shared.Heater_FieldSerializer.deserialize(reader, (fr.istic.shared.Heater)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    fr.istic.shared.Heater_FieldSerializer.serialize(writer, (fr.istic.shared.Heater)object);
  }
  
}
