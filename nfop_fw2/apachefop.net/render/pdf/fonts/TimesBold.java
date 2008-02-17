
package org.apache.fop.render.pdf.fonts;

import org.apache.fop.render.pdf.Font;
import org.apache.fop.render.pdf.CodePointMapping;

public class TimesBold extends Font {
    private final static String fontName = "Times-Bold";
    private final static String encoding = "WinAnsiEncoding";
    private final static int capHeight = 676;
    private final static int xHeight = 461;
    private final static int ascender = 676;
    private final static int descender = -205;
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
              width[0x42] = 667;
              width[0x43] = 722;
              width[0xc7] = 722;
              width[0x44] = 722;
              width[0x45] = 667;
              width[0xc9] = 667;
              width[0xca] = 667;
              width[0xcb] = 667;
              width[0xc8] = 667;
              width[0xd0] = 722;
              width[0x80] = 500;
              width[0x46] = 611;
              width[0x47] = 778;
              width[0x48] = 778;
              width[0x49] = 389;
              width[0xcd] = 389;
              width[0xce] = 389;
              width[0xcf] = 389;
              width[0xcc] = 389;
              width[0x4a] = 500;
              width[0x4b] = 778;
              width[0x4c] = 667;
      
              width[0x4d] = 944;
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
              width[0x50] = 611;
              width[0x51] = 778;
              width[0x52] = 722;
              width[0x53] = 556;
              width[0x8a] = 556;
              width[0x54] = 667;
              width[0xde] = 611;
              width[0x55] = 722;
              width[0xda] = 722;
              width[0xdb] = 722;
              width[0xdc] = 722;
              width[0xd9] = 722;
              width[0x56] = 722;
              width[0x57] = 1000;
              width[0x58] = 722;
              width[0x59] = 722;
              width[0xdd] = 722;
              width[0x9f] = 722;
              width[0x5a] = 667;
              width[0x8e] = 667;
              width[0x61] = 500;
              width[0xe1] = 500;
              width[0xe2] = 500;
              width[0xb4] = 333;
              width[0xe4] = 500;
              width[0xe6] = 722;
              width[0xe0] = 500;
              width[0x26] = 833;
              width[0xe5] = 500;
              width[0x5e] = 581;
              width[0x7e] = 520;
              width[0x2a] = 500;
              width[0x40] = 930;
              width[0xe3] = 500;
              width[0x62] = 556;
              width[0x5c] = 278;
              width[0x7c] = 220;
              width[0x7b] = 394;
              width[0x7d] = 394;
              width[0x5b] = 333;
              width[0x5d] = 333;
      
              width[0xa6] = 220;
              width[0x95] = 350;
              width[0x63] = 444;
      
              width[0xe7] = 444;
              width[0xb8] = 333;
              width[0xa2] = 500;
              width[0x88] = 333;
              width[0x3a] = 333;
              width[0x2c] = 250;
              width[0xa9] = 747;
              width[0xa4] = 500;
              width[0x64] = 556;
              width[0x86] = 500;
              width[0x87] = 500;
              width[0xb0] = 400;
              width[0xa8] = 333;
              width[0xf7] = 570;
              width[0x24] = 500;
      
      
              width[0x65] = 444;
              width[0xe9] = 444;
              width[0xea] = 444;
              width[0xeb] = 444;
              width[0xe8] = 444;
              width[0x38] = 500;
              width[0x85] = 1000;
              width[0x97] = 1000;
              width[0x96] = 500;
              width[0x3d] = 570;
              width[0xf0] = 500;
              width[0x21] = 333;
              width[0xa1] = 333;
              width[0x66] = 333;
      
              width[0x35] = 500;
      
              width[0x83] = 500;
              width[0x34] = 500;
      
              width[0x67] = 500;
              width[0xdf] = 556;
              width[0x60] = 333;
              width[0x3e] = 570;
              width[0xab] = 500;
              width[0xbb] = 500;
              width[0x8b] = 333;
              width[0x9b] = 333;
              width[0x68] = 556;
      
              width[0x2d] = 333;
              width[0x69] = 278;
              width[0xed] = 278;
              width[0xee] = 278;
              width[0xef] = 278;
              width[0xec] = 278;
              width[0x6a] = 333;
              width[0x6b] = 556;
              width[0x6c] = 278;
              width[0x3c] = 570;
              width[0xac] = 570;
      
              width[0x6d] = 833;
              width[0xaf] = 333;
      
              width[0xb5] = 556;
              width[0xd7] = 570;
              width[0x6e] = 556;
              width[0x39] = 500;
              width[0xf1] = 556;
              width[0x23] = 500;
              width[0x6f] = 500;
              width[0xf3] = 500;
              width[0xf4] = 500;
              width[0xf6] = 500;
              width[0x9c] = 722;
      
              width[0xf2] = 500;
              width[0x31] = 500;
              width[0xbd] = 750;
              width[0xbc] = 750;
              width[0xb9] = 300;
              width[0xaa] = 300;
              width[0xba] = 330;
              width[0xf8] = 500;
              width[0xf5] = 500;
              width[0x70] = 556;
              width[0xb6] = 540;
              width[0x28] = 333;
              width[0x29] = 333;
              width[0x25] = 1000;
              width[0x2e] = 250;
              width[0xb7] = 250;
              width[0x89] = 1000;
              width[0x2b] = 570;
              width[0xb1] = 570;
              width[0x71] = 556;
              width[0x3f] = 500;
              width[0xbf] = 500;
              width[0x22] = 555;
              width[0x84] = 500;
              width[0x93] = 500;
              width[0x94] = 500;
              width[0x91] = 333;
              width[0x92] = 333;
              width[0x82] = 333;
              width[0x27] = 278;
              width[0x72] = 444;
              width[0xae] = 747;
      
              width[0x73] = 389;
              width[0x9a] = 389;
              width[0xa7] = 500;
              width[0x3b] = 333;
              width[0x37] = 500;
              width[0x36] = 500;
              width[0x2f] = 278;
              width[0x20] = 250;
      
      
              width[0xa3] = 500;
              width[0x74] = 333;
              width[0xfe] = 556;
              width[0x33] = 500;
              width[0xbe] = 750;
              width[0xb3] = 300;
              width[0x98] = 333;
              width[0x99] = 1000;
              width[0x32] = 500;
              width[0xb2] = 300;
              width[0x75] = 556;
              width[0xfa] = 556;
              width[0xfb] = 556;
              width[0xfc] = 556;
              width[0xf9] = 556;
              width[0x5f] = 500;
              width[0x76] = 500;
              width[0x77] = 722;
              width[0x78] = 500;
              width[0x79] = 500;
              width[0xfd] = 500;
              width[0xff] = 500;
              width[0xa5] = 500;
              width[0x7a] = 444;
              width[0x9e] = 444;
              width[0x30] = 500;
   
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
  