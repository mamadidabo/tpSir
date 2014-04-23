package fr.istic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Heater_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, fr.istic.shared.Heater[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static fr.istic.shared.Heater[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new fr.istic.shared.Heater[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, fr.istic.shared.Heater[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return fr.istic.shared.Heater_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    fr.istic.shared.Heater_Array_Rank_1_FieldSerializer.deserialize(reader, (fr.istic.shared.Heater[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    fr.istic.shared.Heater_Array_Rank_1_FieldSerializer.serialize(writer, (fr.istic.shared.Heater[])object);
  }
  
}
