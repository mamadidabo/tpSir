package fr.istic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ElectronicDevice_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getBrand(fr.istic.shared.ElectronicDevice instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.ElectronicDevice.class, instance, "brand");
  }
  
  private static void setBrand(fr.istic.shared.ElectronicDevice instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.ElectronicDevice.class, instance, "brand", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getId(fr.istic.shared.ElectronicDevice instance) {
    return (java.lang.Long) ReflectionHelper.getField(fr.istic.shared.ElectronicDevice.class, instance, "id");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setId(fr.istic.shared.ElectronicDevice instance, long value) 
  {
    ReflectionHelper.setField(fr.istic.shared.ElectronicDevice.class, instance, "id", value);
  }
  
  private static java.lang.String getName(fr.istic.shared.ElectronicDevice instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.ElectronicDevice.class, instance, "name");
  }
  
  private static void setName(fr.istic.shared.ElectronicDevice instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.ElectronicDevice.class, instance, "name", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, fr.istic.shared.ElectronicDevice instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setBrand(instance, streamReader.readString());
    setId(instance, streamReader.readLong());
    setName(instance, streamReader.readString());
    
  }
  
  public static fr.istic.shared.ElectronicDevice instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new fr.istic.shared.ElectronicDevice();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, fr.istic.shared.ElectronicDevice instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getBrand(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return fr.istic.shared.ElectronicDevice_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    fr.istic.shared.ElectronicDevice_FieldSerializer.deserialize(reader, (fr.istic.shared.ElectronicDevice)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    fr.istic.shared.ElectronicDevice_FieldSerializer.serialize(writer, (fr.istic.shared.ElectronicDevice)object);
  }
  
}
