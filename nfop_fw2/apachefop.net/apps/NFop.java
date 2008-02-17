/*
 * $Id: NFop.java,v 1.0 2008/02/17 mrbool Exp $
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

package org.apache.fop.apps;

public class FileUrl
{
    private String _Url = String.Empty;

    public FileUrl(String url)
    {
        if (String.IsNullOrEmpty(url) == false)
        {
            _Url = url;
        }
    }

   public java.net.URL toUrl()throws java.net.MalformedURLException
    {
        return org.apache.fop.tools.URLBuilder.buildURL(_Url);
    }

    public String ToString()
    {		
        return _Url;
    }
}

/**
 * Summary description for NFop.
 */
public class NFop
{

		public NFop()
		{
		}

		public static byte[] CreatePDF(String fo, FileUrl configFile) throws java.lang.NullPointerException,
																			 java.io.IOException, 
																		     java.io.FileNotFoundException,
																		     java.net.MalformedURLException,
																		     org.apache.fop.apps.FOPException
		{
                boolean hasUserConfig = configFile != null;

                if (hasUserConfig && configFile.ToString()!=String.Empty)
                {
                  try
                  {
					  System.out.println("Looking for "+configFile+" ... ");
					  org.xml.sax.InputSource configFileInputSource = new org.xml.sax.InputSource(configFile.toUrl().openStream());
					  org.apache.fop.configuration.ConfigurationReader reader = new org.apache.fop.configuration.ConfigurationReader(configFileInputSource);
                      reader.start();
                  }
                                         
                  catch (Exception ex)
                  {
					  System.out.println("An error occurred while attempting to retrieve "+configFile+"\nError : "+ex.getClass().getName()+"\n");
                  }
                }

                java.io.StringReader stringReader = new java.io.StringReader(fo);
                org.xml.sax.InputSource input = new org.xml.sax.InputSource(stringReader);
                java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();

				org.apache.fop.apps.Driver driver = new org.apache.fop.apps.Driver(input, output);
				driver.setRenderer(org.apache.fop.apps.Driver.RENDER_PDF);
                driver.run();
				output.close();

				return output.toByteArray();

		}
	
}
