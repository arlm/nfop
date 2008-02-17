
package org.apache.fop.fo.properties;

import java.util.Hashtable;
import org.apache.fop.datatypes.*;
import org.apache.fop.fo.*;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

public class ProvisionalDistanceBetweenStartsMaker extends  LengthProperty.Maker {




    static public Property.Maker maker(String propName) {
	return new ProvisionalDistanceBetweenStartsMaker(propName);
    }

    protected ProvisionalDistanceBetweenStartsMaker(String name) {
	super(name);

    }


   public boolean isInherited() { return true; }

    private Property m_defaultProp=null;
  
    public Property make(PropertyList propertyList) throws FOPException {
      
        if (m_defaultProp == null) {
            m_defaultProp=make(propertyList, "24pt", propertyList.getParentFObj());
	}
        return m_defaultProp;
	
    }

}
