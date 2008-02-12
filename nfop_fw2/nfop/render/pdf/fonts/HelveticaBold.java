
package org.apache.fop.render.pdf.fonts;

import org.apache.fop.render.pdf.Font;
import org.apache.fop.render.pdf.CodePointMapping;

public class HelveticaBold extends Font {
    private final static String fontName = "Helvetica-Bold";
    private final static String encoding = "WinAnsiEncoding";
    private final static int capHeight = 718;
    private final static int xHeight = 532;
    private final static int ascender = 718;
    private final static int descender = -207;
    private final static int firstChar = 32;
    private final static int lastChar = 255;
    private final static int[] width;
    private final CodePointMapping mapping
        = CodePointMapping.getMapping("WinAnsiEncoding");

    static {
        width = new int[256];
        
              width[0x41] = 722;
              width[0xc6] = 1000;
              width[0xc1] = 722;
              width[0xc2] = 722;
              width[0xc4] = 722;
              width[0xc0] = 722;
              width[0xc5] = 722;
              width[0xc3] = 722;
              width[0x42] = 722;
              width[0x43] = 722;
              width[0xc7] = 722;
              width[0x44] = 722;
              width[0x45] = 667;
              width[0xc9] = 667;
              width[0xca] = 667;
              width[0xcb] = 667;
              width[0xc8] = 667;
              width[0xd0] = 722;
              width[0x80] = 556;
              width[0x46] = 611;
              width[0x47] = 778;
              width[0x48] = 722;
              width[0x49] = 278;
              width[0xcd] = 278;
              width[0xce] = 278;
              width[0xcf] = 278;
              width[0xcc] = 278;
              width[0x4a] = 556;
              width[0x4b] = 722;
              width[0x4c] = 611;
      
              width[0x4d] = 833;
              width[0x4e] = 722;
              width[0xd1] = 722;
              width[0x4f] = 778;
              width[0x8c] = 1000;
              width[0xd3] = 778;
              width[0xd4] = 778;
              width[0xd6] = 778;
              width[0xd2] = 778;
              width[0xd8] = 778;
              width[0xd5] = 778;
              width[0x50] = 667;
              width[0x51] = 778;
              width[0x52] = 722;
              width[0x53] = 667;
              width[0x8a] = 667;
              width[0x54] = 611;
              width[0xde] = 667;
              width[0x55] = 722;
              width[0xda] = 722;
              width[0xdb] = 722;
              width[0xdc] = 722;
              width[0xd9] = 722;
              width[0x56] = 667;
              width[0x57] = 944;
              width[0x58] = 667;
              width[0x59] = 667;
              width[0xdd] = 667;
              width[0x9f] = 667;
              width[0x5a] = 611;
              width[0x8e] = 611;
              width[0x61] = 556;
              width[0xe1] = 556;
              width[0xe2] = 556;
              width[0xb4] = 333;
              width[0xe4] = 556;
              width[0xe6] = 889;
              width[0xe0] = 556;
              width[0x26] = 722;
              width[0xe5] = 556;
              width[0x5e] = 584;
              width[0x7e] = 584;
              width[0x2a] = 389;
              width[0x40] = 975;
              width[0xe3] = 556;
              width[0x62] = 611;
              width[0x5c] = 278;
              width[0x7c] = 280;
              width[0x7b] = 389;
              width[0x7d] = 389;
              width[0x5b] = 333;
              width[0x5d] = 333;
      
              width[0xa6] = 280;
              width[0x95] = 350;
              width[0x63] = 556;
      
              width[0xe7] = 556;
              width[0xb8] = 333;
              width[0xa2] = 556;
              width[0x88] = 333;
              width[0x3a] = 333;
              width[0x2c] = 278;
              width[0xa9] = 737;
              width[0xa4] = 556;
              width[0x64] = 611;
              width[0x86] = 556;
              width[0x87] = 556;
              width[0xb0] = 400;
              width[0xa8] = 333;
              width[0xf7] = 584;
              width[0x24] = 556;
      
      
              width[0x65] = 556;
              width[0xe9] = 556;
              width[0xea] = 556;
              width[0xeb] = 556;
              width[0xe8] = 556;
              width[0x38] = 556;
              width[0x85] = 1000;
              width[0x97] = 1000;
              width[0x96] = 556;
              width[0x3d] = 584;
              width[0xf0] = 611;
              width[0x21] = 333;
              width[0xa1] = 333;
              width[0x66] = 333;
      
              width[0x35] = 556;
      
              width[0x83] = 556;
              width[0x34] = 556;
      
              width[0x67] = 611;
              width[0xdf] = 611;
              width[0x60] = 333;
              width[0x3e] = 584;
              width[0xab] = 556;
              width[0xbb] = 556;
              width[0x8b] = 333;
              width[0x9b] = 333;
              width[0x68] = 611;
      
              width[0x2d] = 333;
              width[0x69] = 278;
              width[0xed] = 278;
              width[0xee] = 278;
              width[0xef] = 278;
              width[0xec] = 278;
              width[0x6a] = 278;
              width[0x6b] = 556;
              width[0x6c] = 278;
              width[0x3c] = 584;
              width[0xac] = 584;
      
              width[0x6d] = 889;
              width[0xaf] = 333;
      
              width[0xb5] = 611;
              width[0xd7] = 584;
              width[0x6e] = 611;
              width[0x39] = 556;
              width[0xf1] = 611;
              width[0x23] = 556;
              width[0x6f] = 611;
              width[0xf3] = 611;
              width[0xf4] = 611;
              width[0xf6] = 611;
              width[0x9c] = 944;
      
              width[0xf2] = 611;
              width[0x31] = 556;
              width[0xbd] = 834;
              width[0xbc] = 834;
              width[0xb9] = 333;
              width[0xaa] = 370;
              width[0xba] = 365;
              width[0xf8] = 611;
              width[0xf5] = 611;
              width[0x70] = 611;
              width[0xb6] = 556;
              width[0x28] = 333;
              width[0x29] = 333;
              width[0x25] = 889;
              width[0x2e] = 278;
              width[0xb7] = 278;
              width[0x89] = 1000;
              width[0x2b] = 584;
              width[0xb1] = 584;
              width[0x71] = 611;
              width[0x3f] = 611;
              width[0xbf] = 611;
              width[0x22] = 474;
              width[0x84] = 500;
              width[0x93] = 500;
              width[0x94] = 500;
              width[0x91] = 278;
              width[0x92] = 278;
              width[0x82] = 278;
              width[0x27] = 238;
              width[0x72] = 389;
              width[0xae] = 737;
      
              width[0x73] = 556;
              width[0x9a] = 556;
              width[0xa7] = 556;
              width[0x3b] = 333;
              width[0x37] = 556;
              width[0x36] = 556;
              width[0x2f] = 278;
              width[0x20] = 278;
      
      
              width[0xa3] = 556;
              width[0x74] = 333;
              width[0xfe] = 611;
              width[0x33] = 556;
              width[0xbe] = 834;
              width[0xb3] = 333;
              width[0x98] = 333;
              width[0x99] = 1000;
              width[0x32] = 556;
              width[0xb2] = 333;
              width[0x75] = 611;
              width[0xfa] = 611;
              width[0xfb] = 611;
              width[0xfc] = 611;
              width[0xf9] = 611;
              width[0x5f] = 556;
              width[0x76] = 556;
              width[0x77] = 778;
              width[0x78] = 556;
              width[0x79] = 556;
              width[0xfd] = 556;
              width[0xff] = 556;
              width[0xa5] = 556;
              width[0x7a] = 500;
              width[0x9e] = 500;
              width[0x30] = 556;
   
    }

    public String encoding() {
        return encoding;
    }
    
    public String fontName() {
        return fontName;
    }

    public int getAscender(int size) {
        return size * ascender;
    }

    public int getCapHeight(int size) {
        return size * capHeight;
    }

    public int getDescender(int size) {
        return size * descender;
    }

    public int getXHeight(int size) {
        return size * xHeight;
    }

    public int getFirstChar() {
        return firstChar;
    }

    public int getLastChar() {
        return lastChar;
    }

    public int width(int i,int size) {
        return size * width[i];
    }

    public int[] getWidths(int size) {
        int[] arr = new int[getLastChar()-getFirstChar()+1];
        System.arraycopy(width, getFirstChar(), arr, 0, getLastChar()-getFirstChar()+1);
        for( int i = 0; i < arr.length; i++) arr[i] *= size;
        return arr;
    }

    public char mapChar(char c) {
        char d = mapping.mapChar(c);
	if(d != 0)
            return d;
        else
	    return '#';
    }

}
  