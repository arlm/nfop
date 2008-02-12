
package org.apache.fop.fo.properties;

import java.util.Hashtable;
import org.apache.fop.datatypes.*;
import org.apache.fop.fo.*;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

public class TextAlignLastMaker extends  EnumProperty.Maker implements TextAlignLast {



  protected final static EnumProperty s_propCENTER = new EnumProperty(CENTER);

  protected final static EnumProperty s_propEND = new EnumProperty(END);

  protected final static EnumProperty s_propSTART = new EnumProperty(START);

  protected final static EnumProperty s_propJUSTIFY = new EnumProperty(JUSTIFY);


    static public Property.Maker maker(String propName) {
	return new TextAlignLastMaker(propName);
    }

    protected TextAlignLastMaker(String name) {
	super(name);

    }


   public boolean isInherited() { return true; }

    public Property compute(PropertyList propertyList) {
      Property computedProperty = null;
      Property correspondingProperty = propertyList.get("text-align");
      if (correspondingProperty != null) {
        int correspondingValue = correspondingProperty.getEnum();
        
        if (correspondingValue == TextAlign.JUSTIFY)
          computedProperty = new EnumProperty(START);
        else
        if (correspondingValue == TextAlign.END)
          computedProperty = new EnumProperty(END);
        else
        if (correspondingValue == TextAlign.START)
          computedProperty = new EnumProperty(START);
        else
        if (correspondingValue == TextAlign.CENTER)
          computedProperty = new EnumProperty(CENTER);
        else
        ;
      }
      return computedProperty;
    }

    public Property checkEnumValues(String value) {
    
      if (value.equals("center")) { return s_propCENTER; }
    
      if (value.equals("end")) { return s_propEND; }
    
      if (value.equals("start")) { return s_propSTART; }
    
      if (value.equals("justify")) { return s_propJUSTIFY; }
    
	return super.checkEnumValues(value);
    }

    private Property m_defaultProp=null;
  
    public Property make(PropertyList propertyList) throws FOPException {
      
        if (m_defaultProp == null) {
            m_defaultProp=make(propertyList, "start", propertyList.getParentFObj());
	}
        return m_defaultProp;
	
    }

}
