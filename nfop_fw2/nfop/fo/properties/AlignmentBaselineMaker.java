
package org.apache.fop.fo.properties;

import java.util.Hashtable;
import org.apache.fop.datatypes.*;
import org.apache.fop.fo.*;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

public class AlignmentBaselineMaker extends  LengthProperty.Maker implements AlignmentBaseline {



  protected final static EnumProperty s_propAUTO = new EnumProperty(AUTO);

  protected final static EnumProperty s_propBASELINE = new EnumProperty(BASELINE);

  protected final static EnumProperty s_propBEFORE_EDGE = new EnumProperty(BEFORE_EDGE);

  protected final static EnumProperty s_propTEXT_BEFORE_EDGE = new EnumProperty(TEXT_BEFORE_EDGE);

  protected final static EnumProperty s_propMIDDLE = new EnumProperty(MIDDLE);

  protected final static EnumProperty s_propCENTRAL = new EnumProperty(CENTRAL);

  protected final static EnumProperty s_propAFTER_EDGE = new EnumProperty(AFTER_EDGE);

  protected final static EnumProperty s_propTEXT_AFTER_EDGE = new EnumProperty(TEXT_AFTER_EDGE);

  protected final static EnumProperty s_propIDEOGRAPHIC = new EnumProperty(IDEOGRAPHIC);

  protected final static EnumProperty s_propALPHABETIC = new EnumProperty(ALPHABETIC);

  protected final static EnumProperty s_propHANGING = new EnumProperty(HANGING);

  protected final static EnumProperty s_propMATHEMATICAL = new EnumProperty(MATHEMATICAL);

  protected final static EnumProperty s_propINHERIT = new EnumProperty(INHERIT);


    static public Property.Maker maker(String propName) {
	return new AlignmentBaselineMaker(propName);
    }

    protected AlignmentBaselineMaker(String name) {
	super(name);

    }


   public boolean isInherited() { return false; }

    public Property checkEnumValues(String value) {
    
      if (value.equals("auto")) { return s_propAUTO; }
    
      if (value.equals("baseline")) { return s_propBASELINE; }
    
      if (value.equals("before-edge")) { return s_propBEFORE_EDGE; }
    
      if (value.equals("text-before-edge")) { return s_propTEXT_BEFORE_EDGE; }
    
      if (value.equals("middle")) { return s_propMIDDLE; }
    
      if (value.equals("central")) { return s_propCENTRAL; }
    
      if (value.equals("after-edge")) { return s_propAFTER_EDGE; }
    
      if (value.equals("text-after-edge")) { return s_propTEXT_AFTER_EDGE; }
    
      if (value.equals("ideographic")) { return s_propIDEOGRAPHIC; }
    
      if (value.equals("alphabetic")) { return s_propALPHABETIC; }
    
      if (value.equals("hanging")) { return s_propHANGING; }
    
      if (value.equals("mathematical")) { return s_propMATHEMATICAL; }
    
      if (value.equals("inherit")) { return s_propINHERIT; }
    
	return super.checkEnumValues(value);
    }

    private Property m_defaultProp=null;
  
    public Property make(PropertyList propertyList) throws FOPException {
      
        if (m_defaultProp == null) {
            m_defaultProp=make(propertyList, "auto", propertyList.getParentFObj());
	}
        return m_defaultProp;
	
    }

}
