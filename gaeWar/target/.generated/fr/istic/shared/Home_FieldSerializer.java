package fr.istic.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Home_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.util.List getConsommations(fr.istic.shared.Home instance) {
    return (java.util.List) ReflectionHelper.getField(fr.istic.shared.Home.class, instance, "consommations");
  }
  
  private static void setConsommations(fr.istic.shared.Home instance, java.util.List value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Home.class, instance, "consommations", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getId(fr.istic.shared.Home instance) {
    return (java.lang.Long) ReflectionHelper.getField(fr.istic.shared.Home.class, instance, "id");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setId(fr.istic.shared.Home instance, long value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Home.class, instance, "id", value);
  }
  
  private static fr.istic.shared.Person getPersonne(fr.istic.shared.Home instance) {
    return (fr.istic.shared.Person) ReflectionHelper.getField(fr.istic.shared.Home.class, instance, "personne");
  }
  
  private static void setPersonne(fr.istic.shared.Home instance, fr.istic.shared.Person value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Home.class, instance, "personne", value);
  }
  
  private static java.lang.String getRue(fr.istic.shared.Home instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.Home.class, instance, "rue");
  }
  
  private static void setRue(fr.istic.shared.Home instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Home.class, instance, "rue", value);
  }
  
  private static java.lang.String getVille(fr.istic.shared.Home instance) {
    return (java.lang.String) ReflectionHelper.getField(fr.istic.shared.Home.class, instance, "ville");
  }
  
  private static void setVille(fr.istic.shared.Home instance, java.lang.String value) 
  {
    ReflectionHelper.setField(fr.istic.shared.Home.class, instance, "ville", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, fr.istic.shared.Home instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setConsommations(instance, (java.util.List) streamReader.readObject());
    setId(instance, streamReader.readLong());
    setPersonne(instance, (fr.istic.shared.Person) streamReader.readObject());
    setRue(instance, streamReader.readString());
    setVille(instance, streamReader.readString());
    
  }
  
  public static fr.istic.shared.Home instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new fr.istic.shared.Home();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, fr.istic.shared.Home instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeObject(getConsommations(instance));
    streamWriter.writeLong(getId(instance));
    streamWriter.writeObject(getPersonne(instance));
    streamWriter.writeString(getRue(instance));
    streamWriter.writeString(getVille(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return fr.istic.shared.Home_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    fr.istic.shared.Home_FieldSerializer.deserialize(reader, (fr.istic.shared.Home)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    fr.istic.shared.Home_FieldSerializer.serialize(writer, (fr.istic.shared.Home)object);
  }
  
}
