/*
 * $Id: NFop.cs,v 1.0 2008/02/17 mrbool Exp $
 * ============================================================================
 *                    The Apache Software License, Version 1.1
 * ============================================================================
 * 
 * Copyright (C) 1999-2003 The Apache Software Foundation. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modifica-
 * tion, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. The end-user documentation included with the redistribution, if any, must
 *    include the following acknowledgment: "This product includes software
 *    developed by the Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself, if
 *    and wherever such third-party acknowledgments normally appear.
 * 
 * 4. The names "FOP" and "Apache Software Foundation" must not be used to
 *    endorse or promote products derived from this software without prior
 *    written permission. For written permission, please contact
 *    apache@apache.org.
 * 
 * 5. Products derived from this software may not be called "Apache", nor may
 *    "Apache" appear in their name, without prior written permission of the
 *    Apache Software Foundation.
 * 
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * APACHE SOFTWARE FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLU-
 * DING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 * 
 * This software consists of voluntary contributions made by many individuals
 * on behalf of the Apache Software Foundation and was originally created by
 * James Tauber <jtauber@jtauber.com>. For more information on the Apache
 * Software Foundation, please see <http://www.apache.org/>.
 */ 

using System;

namespace Fop.Net
{
    public class NFop
    {
        public static System.Xml.XmlDocument GetXml(string xmlFile)
        {
            System.Xml.XmlDocument doc = new System.Xml.XmlDocument();
            doc.Load(xmlFile);
            return doc;
        }

        public static System.Xml.Xsl.XslCompiledTransform GetXsl(string xslFile)
        {
            System.Xml.Xsl.XslCompiledTransform xslt = new System.Xml.Xsl.XslCompiledTransform();
            xslt.Load(xslFile);
            return xslt;
        }

        public static string GetFo(string foFile)
        {
            string fo = null;

            using (System.IO.StreamReader sr = System.IO.File.OpenText(foFile))
            {
                fo = sr.ReadToEnd();
            }

            return fo;
        }

        public static byte[] CreatePDF(string xmlFile, string xslFile)
        {
            return CreatePDF(xmlFile, xslFile, (org.apache.fop.apps.FileUrl)null);
        }

        public static byte[] CreatePDF(string xmlFile, string xslFile, org.apache.fop.apps.FileUrl configFile)
        {
            System.Xml.XmlDocument doc = GetXml(xmlFile);
            System.Xml.Xsl.XslCompiledTransform xslt = GetXsl(xslFile);
            return CreatePDF(doc, xslt, configFile);

        }

        //public static byte[] CreatePDF(string xmlFile, string xslFile, string foFile)
        //{
        //    System.Xml.XmlDocument doc = GetXml(xmlFile);
        //    System.Xml.Xsl.XslCompiledTransform xslt = GetXsl(xslFile);
        //    return CreatePDF(doc, xslt, foFile);

        //}


        public static byte[] CreatePDF(string xmlFile, string xslFile, string foFile, org.apache.fop.apps.FileUrl configFile)
        {
            System.Xml.XmlDocument doc = GetXml(xmlFile);
            System.Xml.Xsl.XslCompiledTransform xslt = GetXsl(xslFile);
            return CreatePDF(doc, xslt, foFile, configFile);
        }

        public static byte[] CreatePDF(System.Xml.XmlDocument doc, System.Xml.Xsl.XslCompiledTransform xslt, org.apache.fop.apps.FileUrl configFile)
        {
            string fo = CreateFO(doc, xslt);

            return CreatePDF(fo, configFile);
        }

        public static byte[] CreatePDF(System.Xml.XmlDocument doc, System.Xml.Xsl.XslCompiledTransform xslt, string foFile)
        {
            return CreatePDF(doc, xslt, foFile, (org.apache.fop.apps.FileUrl)null);
        }

        public static byte[] CreatePDF(System.Xml.XmlDocument doc, System.Xml.Xsl.XslCompiledTransform xslt, string foFile, org.apache.fop.apps.FileUrl configFile)
        {
            string fo = CreateFO(doc, xslt);

            CreateFile(System.Text.Encoding.UTF8.GetBytes(fo), foFile);

            return CreatePDF(fo, configFile);
        }

        public static string CreateFO(System.Xml.XmlDocument doc, System.Xml.Xsl.XslCompiledTransform xslt)
        {
            string fo = null;

            using (System.IO.StringReader stringReader = new System.IO.StringReader(doc.OuterXml))
            {
                using (System.Xml.XmlTextReader xmlTextReader = new System.Xml.XmlTextReader(stringReader))
                {
                    using (System.IO.StringWriter stringWriter = new System.IO.StringWriter())
                    {
                        using (System.Xml.XmlTextWriter xmlTextWriter = new System.Xml.XmlTextWriter(stringWriter))
                        {
                            xslt.Transform(xmlTextReader, xmlTextWriter);
                            stringWriter.Flush();
                            fo = stringWriter.ToString();
                        }
                    }
                }
            }

            return fo;
        }

        public static byte[] CreatePDF(string fo)
        {
            return CreatePDF(fo, (org.apache.fop.apps.FileUrl)null);
        }

        public static byte[] CreatePDF(string fo, org.apache.fop.apps.FileUrl configFile)
        {
            sbyte[] pdfByteArray = org.apache.fop.apps.NFop.CreatePDF(fo, configFile);

            CheckBuffer(pdfByteArray);

            if (pdfByteArray.Length > 0)
            {
                byte[] buffer = new byte[pdfByteArray.Length];

                Buffer.BlockCopy(pdfByteArray, 0, buffer, 0, buffer.Length);

                return buffer;
            }

            return null;

        }
        public static void CreateFile(byte[] buffer, string path)
        {
            CheckBuffer(buffer);
            CheckFile(path);

            using (System.IO.FileStream fs = new System.IO.FileStream(path, System.IO.FileMode.Create, System.IO.FileAccess.Write))
            {
                using (System.IO.BinaryWriter sw = new System.IO.BinaryWriter(fs))
                {
                    sw.Write(buffer);
                    sw.Flush();
                }
            }
        }

        public static void CheckBuffer(sbyte[] buffer)
        {
            if (buffer == null || buffer.Length == 0) throw new ArgumentException("No data will be written , output buffer is empty");
        }

        public static void CheckBuffer(byte[] buffer)
        {
            if (buffer == null || buffer.Length == 0) throw new ArgumentException("No data will be written , output buffer is empty");
        }

        public static void CheckFile(string path)
        {
            if (path == null) throw new ArgumentNullException("No data will be written, target file name is not specified");
            if (path == string.Empty) throw new ArgumentException("No data will be written, target file name is not specified");
            if (path.Trim() == string.Empty) throw new ArgumentException("No data will be written, target file name is not specified");

            if (System.IO.File.Exists(path))
            {
                if (new System.IO.FileInfo(path).IsReadOnly) throw new System.IO.IOException(string.Format("No data will be written, file {0} is read only", path));
            }
        }

        public static void Create_PDF_from_FO(string foFile, string pdfFile)
        {
            string fo = Fop.Net.NFop.GetFo(foFile);
            byte[] bytes = Fop.Net.NFop.CreatePDF(fo);
            Fop.Net.NFop.CreateFile(bytes, pdfFile);
        }

        public static void Create_PDF_from_FO_with_CONFIG(string foFile, string pdfFile, string cfgFile)
        {
            string fo = Fop.Net.NFop.GetFo(foFile);
            byte[] bytes = Fop.Net.NFop.CreatePDF(fo, new org.apache.fop.apps.FileUrl(cfgFile));
            Fop.Net.NFop.CreateFile(bytes, pdfFile);
        }

        public static void Create_PDF_from_XML_XSL(string xmlFile,string xslFile, string pdfFile)
        {
            byte[] bytes = Fop.Net.NFop.CreatePDF(xmlFile, xslFile);
            Fop.Net.NFop.CreateFile(bytes, pdfFile);
        }

        public static void Create_PDF_from_XML_XSL_with_CONFIG(string xmlFile, string xslFile, string pdfFile,string cfgFile)
        {
            byte[] bytes = Fop.Net.NFop.CreatePDF(xmlFile, xslFile, new org.apache.fop.apps.FileUrl(cfgFile));
            Fop.Net.NFop.CreateFile(bytes, pdfFile);
        }

        public static void Create_PDF_and_FO_from_XML_XSL(string xmlFile, string xslFile, string foFile, string pdfFile)
        {
            Create_PDF_and_FO_from_XML_XSL_with_CONFIG(xmlFile, xslFile, foFile, pdfFile, null);
        }

        public static void Create_PDF_and_FO_from_XML_XSL_with_CONFIG(string xmlFile, string xslFile,string foFile,string pdfFile, string cfgFile)
        {
            byte[] bytes = Fop.Net.NFop.CreatePDF(xmlFile, xslFile, foFile, new org.apache.fop.apps.FileUrl(cfgFile));
            Fop.Net.NFop.CreateFile(bytes, pdfFile);
        }

    }

}
