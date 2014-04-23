package fr.istic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Person_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getEd(fr.istic.shared.Person instance) {
    return (java.util.List) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "ed");
  }
  
  private static void setEd(fr.istic.shared.Person instance, java.util.List value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "ed", value);
  }
  
  private static java.util.List getFriends(fr.istic.shared.Person instance) {
    return (java.util.List) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "friends");
  }
  
  private static void setFriends(fr.istic.shared.Person instance, java.util.List value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "friends", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getId(fr.istic.shared.Person instance) {
    return (java.lang.Long) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "id");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setId(fr.istic.shared.Person instance, long value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "id", value);
  }
  
  private static java.util.List getMaison(fr.istic.shared.Person instance) {
    return (java.util.List) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "maison");
  }
  
  private static void setMaison(fr.istic.shared.Person instance, java.util.List value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "maison", value);
  }
  
  private static java.lang.String getName(fr.istic.shared.Person instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "name");
  }
  
  private static void setName(fr.istic.shared.Person instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "name", value);
  }
  
  private static java.lang.String getPrenom(fr.istic.shared.Person instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.Person.class, instance, "prenom");
  }
  
  private static void setPrenom(fr.istic.shared.Person instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Person.class, instance, "prenom", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, fr.istic.shared.Person instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setEd(instance, (java.util.List) streamReader.readObject());
    setFriends(instance, (java.util.List) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setMaison(instance, (java.util.List) streamReader.readObject());
    setName(instance, streamReader.readString());
    setPrenom(instance, streamReader.readString());
    
  }
  
  public static fr.istic.shared.Person instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new fr.istic.shared.Person();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, fr.istic.shared.Person instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeObject(getEd(instance));
    streamWriter.writeObject(getFriends(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeObject(getMaison(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getPrenom(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return fr.istic.shared.Person_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    fr.istic.shared.Person_FieldSerializer.deserialize(reader, (fr.istic.shared.Person)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    fr.istic.shared.Person_FieldSerializer.serialize(writer, (fr.istic.shared.Person)object);
  }
  
}
