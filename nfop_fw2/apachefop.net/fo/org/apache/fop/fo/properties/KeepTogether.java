
package org.apache.fop.fo.properties;


    public interface KeepTogether{
   
      public interface WithinPage extends GenericKeep.Enums.WithinPage {
      }
      
      public interface WithinLine extends GenericKeep.Enums.WithinLine {
      }
      
      public interface WithinColumn extends GenericKeep.Enums.WithinColumn {
      }
      
    }
