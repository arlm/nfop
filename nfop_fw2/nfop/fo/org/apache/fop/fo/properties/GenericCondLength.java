
package org.apache.fop.fo.properties;

import java.util.Hashtable;
import org.apache.fop.datatypes.*;
import org.apache.fop.fo.*;
import org.apache.fop.apps.FOPException;
import org.apache.fop.messaging.MessageHandler;

public class GenericCondLength extends  CondLengthProperty.Maker {



  public interface Enums {

  public interface Conditionality {

    int DISCARD =  Constants.DISCARD;

    int RETAIN =  Constants.RETAIN;

  }

  }

    final private static Property.Maker s_LengthMaker =
	new LengthProperty.Maker(
	     "conditional-length-template.length");
	
    static private class SP_ConditionalityMaker
	extends EnumProperty.Maker implements Enums.Conditionality {
	SP_ConditionalityMaker(String sPropName) {
	     super(sPropName);
        }

       protected final static EnumProperty s_propDISCARD = new EnumProperty(DISCARD);

       protected final static EnumProperty s_propRETAIN = new EnumProperty(RETAIN);

    public Property checkEnumValues(String value) {
    
      if (value.equals("discard")) { return s_propDISCARD; }
    
      if (value.equals("retain")) { return s_propRETAIN; }
    
	return super.checkEnumValues(value);
    }

    }
    final private static Property.Maker s_ConditionalityMaker =
	new SP_ConditionalityMaker(
	     "conditional-length-template.conditionality");
        

    static public Property.Maker maker(String propName) {
	return new GenericCondLength(propName);
    }

    protected GenericCondLength(String name) {
	super(name);

        m_shorthandMaker= getSubpropMaker("length");

    }


    Property.Maker m_shorthandMaker;

    public Property checkEnumValues(String value) {
	return m_shorthandMaker.checkEnumValues(value);
    }

    protected boolean isCompoundMaker() {
      return true;
    }

    protected Property.Maker getSubpropMaker(String subprop) {
    
	if (subprop.equals("length"))
	  return s_LengthMaker;
    
	if (subprop.equals("conditionality"))
	  return s_ConditionalityMaker;
    
	return super.getSubpropMaker(subprop);
    }

    protected Property setSubprop(Property baseProp, String subpropName,
	Property subProp) {
        CondLength val = baseProp.getCondLength();
	// Do some type checking???
	// Check if one of our subproperties???
	val.setComponent(subpropName, subProp, false);
	return baseProp;
    }

    public Property getSubpropValue(Property baseProp, String subpropName) {
      CondLength val = baseProp.getCondLength();
      return val.getComponent(subpropName);
    }

    private Property m_defaultProp=null;
    public Property make(PropertyList propertyList) throws FOPException {
        if (m_defaultProp == null) {
            m_defaultProp=makeCompound(propertyList, propertyList.getParentFObj());
	}
        return m_defaultProp;
    }


    protected Property makeCompound(PropertyList pList, FObj fo) throws FOPException {
	CondLength p = new CondLength();
	Property subProp;
    
	 // set default for subprop length
	 subProp = getSubpropMaker("length").make(pList,
	  getDefaultForLength(), fo);
	  p.setComponent("length", subProp, true);
    
	 // set default for subprop conditionality
	 subProp = getSubpropMaker("conditionality").make(pList,
	  getDefaultForConditionality(), fo);
	  p.setComponent("conditionality", subProp, true);
    
	return new CondLengthProperty(p);
    }

    
    
    protected String getDefaultForLength() {
      
	return "";
	
    }
    
    protected String getDefaultForConditionality() {
      
	return "";
	
    }
    

    /** Set the appropriate components when the "base" property is set. */
    public Property convertProperty(Property p, PropertyList pList,FObj fo)
	throws FOPException
    {
        if (p instanceof CondLengthProperty) return p;
	if (! (p instanceof EnumProperty)) {
	  // delegate to the subprop maker to do conversions
	  p = m_shorthandMaker.convertProperty(p,pList,fo);
        }
	if (p != null) {
	  Property prop = makeCompound(pList, fo);

	  CondLength pval = prop.getCondLength();

	  pval.setComponent("length", p, false);

          return prop;
        }
	else return null;

    }


}
