/*
 * $Id: NFopApp.cs,v 1.0 2008/02/17 mrbool Exp $
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

namespace NFopApp
{
   

    
    public class NFopApp
    {
        public static void PrintUsage()
        {
            Console.WriteLine(GetUsage());
        }

        public static string GetUsage()
        {
            System.Text.StringBuilder usageBuffer = new System.Text.StringBuilder();
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("nFop [options] [-fo|-xml] <infile> [-xsl file] [-foout | -pdf] <outfile>");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("[OPTIONS]");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-c cfg.xml        use additional configuration file cfg.xml");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("(you can set NFOP_USER_CONFIG_PATH environment variable and override it with -c parameter)");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("[INPUT]");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("infile            xsl:fo input file (the same as the next)");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-fo  infile       xsl:fo input file");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-xml infile       xml input file, must be used together with -xsl");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-xsl stylesheet   xslt stylesheet");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("[OUTPUT]");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-pdf outfile      input will be rendered as pdf file (outfile req'd)");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("-foout outfile    input will be rendered as fo file (outfile req'd)");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("[Examples]");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("nFop foo.fo foo.pdf");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("nFop -fo foo.fo -pdf foo.pdf (does the same as the previous line)");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("nFop -xsl foo.xsl -xml foo.xml -pdf foo.pdf");
            usageBuffer.AppendFormat(Environment.NewLine);
            usageBuffer.AppendFormat("nFop -xsl foo.xsl -xml foo.xml -foout foo.fo -pdf foo.pdf");
            usageBuffer.AppendFormat(Environment.NewLine);

            return usageBuffer.ToString();
        }

        public static bool CheckParameters(CommandLineArguments cmdLineArgs)
        {
            if (cmdLineArgs.HasArguments)
            {
                switch (cmdLineArgs.Arguments.Count)
                {
                    case 2: if (cmdLineArgs.HasFO  && cmdLineArgs.HasPDF) return true; break;
                    case 3: if (cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasPDF) return true; break;
                    case 4: if (cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasFOOUT && cmdLineArgs.HasPDF) return true; break;
                }
            }

            return false;
        }


        static void Main(string[] args)
        {
            int ExitCode = 0;

            try
            {
                CommandLineArguments cmdLineArgs = new CommandLineArguments(args);

                if (CheckParameters(cmdLineArgs))
                {
                    switch (cmdLineArgs.Arguments.Count)
                    {
                        case 2:

                            if (cmdLineArgs.HasUSERCONFIG && cmdLineArgs.HasFO && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_from_FO_with_CONFIG(cmdLineArgs.FO, cmdLineArgs.PDF, cmdLineArgs.USERCONFIG);
                            }
                            else if (cmdLineArgs.HasUSERCONFIG == false && cmdLineArgs.HasFO && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_from_FO(cmdLineArgs.FO, cmdLineArgs.PDF);
                            }

                            break;
                        case 3:

                            if (cmdLineArgs.HasUSERCONFIG && cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_from_XML_XSL_with_CONFIG(cmdLineArgs.XML, cmdLineArgs.XSL, cmdLineArgs.PDF, cmdLineArgs.USERCONFIG);
                            }
                            else if (cmdLineArgs.HasUSERCONFIG == false && cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_from_XML_XSL(cmdLineArgs.XML, cmdLineArgs.XSL, cmdLineArgs.PDF);
                            }

                            break;
                        case 4:

                            if (cmdLineArgs.HasUSERCONFIG && cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasFOOUT && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_and_FO_from_XML_XSL_with_CONFIG(cmdLineArgs.XML, cmdLineArgs.XSL, cmdLineArgs.FOOUT, cmdLineArgs.PDF, cmdLineArgs.USERCONFIG);
                            }
                            else if (cmdLineArgs.HasUSERCONFIG == false && cmdLineArgs.HasXML && cmdLineArgs.HasXSL && cmdLineArgs.HasFOOUT && cmdLineArgs.HasPDF)
                            {
                                Fop.Net.NFop.Create_PDF_and_FO_from_XML_XSL(cmdLineArgs.XML, cmdLineArgs.XSL, cmdLineArgs.FOOUT, cmdLineArgs.PDF);
                            }

                            break;
                    }
                }
                else
                {
                    PrintUsage();
                }
            }
            catch (System.IO.FileNotFoundException fileNotFoundException)
            {
                ExitCode = 1;
                Console.WriteLine(fileNotFoundException.Message);
            }
            catch (CommandLineArgumentException commandLineArgumentException)
            {
                ExitCode = 1;
                Console.WriteLine("{0}:\t{1}", commandLineArgumentException.Message, commandLineArgumentException.ParamName);
            }
            catch (Exception exception)
            {
                ExitCode = 1;
                Console.WriteLine("{0}{1}{2}", exception.Message, Environment.NewLine, exception.StackTrace);
            }

            Environment.Exit(ExitCode);
        }
    }
}
