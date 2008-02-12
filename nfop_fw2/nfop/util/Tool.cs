using System;
using System.Xml;
using System.Xml.Xsl;
using System.IO;
using java.io;
using org.xml.sax;
using org.apache.fop.apps;

namespace ApacheFop.Utility
{

class Tool
{

[STAThread]
public static void Main(string[] args)	{
    if ( 3 != args.Length ) {
        Console.WriteLine("usage: fop.exe xml xsl pdf"); 
    } else {
	    String xmlFile = args[0];
        String foFile = xmlFile + ".fo";
        String xslFile = args[1];
        String pdfFile = args[2];

	    System.Xml.Xsl.XslTransform xslt = new System.Xml.Xsl.XslTransform();
	    xslt.Load(new XmlTextReader(xslFile));
	    xslt.Transform(xmlFile, foFile);

        FileInputStream input = new FileInputStream(foFile);
        InputSource source = new InputSource(input);
        FileOutputStream output = new FileOutputStream(pdfFile);
        Driver driver = new Driver(source, output);
	    driver.setRenderer(Driver.RENDER_PDF);
	    driver.run();
        output.close();
    }
    Environment.Exit(0);
}

}

}
