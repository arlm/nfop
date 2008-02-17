/*
 * $Id: CommandLineArguments.cs,v 1.0 2008/02/17 mrbool Exp $
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
    public class CommandLineArguments
    {
        public const string USERCONFIG_KEY = "-c";
        public const string FO_KEY = "-fo";
        public const string XML_KEY = "-xml";
        public const string XSL_KEY = "-xsl";
        public const string PDF_KEY = "-pdf";
        public const string FOOUT_KEY = "-foout";
        protected string _USER_CONFIG_PARAM = null;

        protected System.Collections.Generic.Dictionary<string, string> _arguments = null;

        protected static System.Collections.Generic.Dictionary<string, string> validArguments = null;


        public CommandLineArguments(string[] args)
        {
            Parse(args);
        }

        public virtual System.Collections.Generic.Dictionary<string, string> GetValidArguments()
        {
            if (validArguments == null)
            {
                validArguments = new System.Collections.Generic.Dictionary<string, string>();
                validArguments.Add(USERCONFIG_KEY, USERCONFIG_KEY);
                validArguments.Add(FO_KEY        , FO_KEY);
                validArguments.Add(XML_KEY       , XML_KEY);
                validArguments.Add(XSL_KEY       , XSL_KEY);
                validArguments.Add(PDF_KEY       , PDF_KEY);
                validArguments.Add(FOOUT_KEY     , FOOUT_KEY);
            }

            return validArguments;
        }

        protected bool ParseShort(string[] tokens, System.Collections.Generic.Dictionary<string, string> arguments)
        {
            if (tokens.Length == 2)
            {
                string arg0 = PrepareToken(tokens[0]);
                string arg1 = PrepareToken(tokens[1]);

                if (IsEmptyToken(arg0) == false && IsEmptyToken(arg1) == false)
                {

                    if (arg0.ToLower().EndsWith(".fo")  && arg1.ToLower().EndsWith(".pdf"))
                    {
                        arguments.Add(FO_KEY, arg0);
                        arguments.Add(PDF_KEY, arg1);

                        return true;
                    }
                    else if (arg0.ToLower().EndsWith(".pdf") && arg1.ToLower().EndsWith(".fo"))
                    {
                        arguments.Add(PDF_KEY, arg0);
                        arguments.Add(FO_KEY, arg1);

                        return true;
                    }
                    else
                    {
                        arguments.Add(FO_KEY, arg0);
                        arguments.Add(PDF_KEY, arg1);

                        return true;
                    }
                }
            }

            return false;
        }

        protected void ParseFull(string[] tokens, System.Collections.Generic.Dictionary<string, string> arguments)
        {
            for (int token_index = 0; token_index < tokens.Length; token_index++)
            {
                string token = PrepareToken(tokens[token_index]);

                if (IsEmptyToken(token) == false)
                {
                    if (IsValidToken(token))
                    {
                        if (HasNextToken(token_index, tokens.Length))
                        {
                            token_index++;

                            string value = PrepareToken(tokens[token_index]);

                            if (IsEmptyToken(value) == false)
                            {
                                if (token == USERCONFIG_KEY)
                                {
                                    _USER_CONFIG_PARAM = value;
                                }
                                else
                                {
                                    arguments.Add(token, value);
                                }
                            }
                        }
                    }
                }
            }
        }

        public virtual void Parse(string[] tokens)
        {
            if (tokens != null)
            {
                if (tokens.Length > 0)
                {
                    int tokensLength = tokens.Length;

                    _arguments = new System.Collections.Generic.Dictionary<string, string>(tokensLength);

                    if (ParseShort(tokens, _arguments)==false)
                    {
                        ParseFull(tokens, _arguments);
                    }

                    if (HasArguments && HasUSERCONFIG==false)
                    { 
                      string NFOP_USER_CONFIG_PATH = PrepareToken(Environment.GetEnvironmentVariable("NFOP_USER_CONFIG_PATH"));

                      if (IsEmptyToken(NFOP_USER_CONFIG_PATH) == false)
                      {
                          this._USER_CONFIG_PARAM = NFOP_USER_CONFIG_PATH;
                      }

                    }
                }
            }

        }

        public virtual bool HasNextToken(int current_index, int tokensLength)
        {
            return current_index < tokensLength;
        }

        public virtual bool IsEmptyToken(string token)
        {
            return string.IsNullOrEmpty(token);
        }

        public virtual string PrepareToken(string token)
        {
            if (token != null)
            {
                return token.Trim().ToLower();
            }

            return token;
        }


        public System.Collections.Generic.Dictionary<string, string> Arguments
        {
            get { return _arguments; }
        }

        public virtual bool HasArguments
        {
            get
            {
                if (_arguments == null) return false;

                return _arguments.Count > 0;
            }
        }

        public bool IsValidToken(string key)
        {
            System.Collections.Generic.Dictionary<string, string> validArguments = GetValidArguments();

            return validArguments.ContainsKey(key);
        }

        protected virtual bool HasKeyAndValue(string key)
        {
            if (HasArguments)
            {
                if (_arguments.ContainsKey(key))
                {
                    return string.IsNullOrEmpty(_arguments[key]) == false;
                }
            }

            return false;
        }

        protected virtual string GetValue(string key)
        {
            if (HasKeyAndValue(key))
            {
                return _arguments[key];
            }

            throw new CommandLineArgumentException("error : command line argument", string.Format("command line parameter {0} is not set",key));
        }

        public bool HasUSERCONFIG
        {
            get
            {

                return string.IsNullOrEmpty(_USER_CONFIG_PARAM)==false;
            }
        }

        public bool HasFO
        {
            get
            {

                return HasKeyAndValue(FO_KEY);
            }
        }

        public bool HasXML
        {
            get
            {

                return HasKeyAndValue(XML_KEY);
            }
        }

        public bool HasXSL
        {
            get
            {

                return HasKeyAndValue(XSL_KEY);
            }
        }


        public bool HasPDF
        {
            get
            {

                return HasKeyAndValue(PDF_KEY);
            }
        }

        public bool HasFOOUT
        {
            get
            {

                return HasKeyAndValue(FOOUT_KEY);
            }
        }

        public string USERCONFIG
        {
            get
            {

                return _USER_CONFIG_PARAM;
            }
        }

        public string FO
        {
            get
            {

                return GetValue(FO_KEY);
            }
        }

        public string XML
        {
            get
            {

                return GetValue(XML_KEY);
            }
        }

        public string XSL
        {
            get
            {

                return GetValue(XSL_KEY);
            }
        }


        public string PDF
        {
            get
            {

                return GetValue(PDF_KEY);
            }
        }

        public string FOOUT
        {
            get
            {

                return GetValue(FOOUT_KEY);
            }
        }

        public override string ToString()
        {
            System.Text.StringBuilder output = new System.Text.StringBuilder();

            if (HasArguments)
            {
                if (this.HasUSERCONFIG)     output.AppendFormat("-c {0}{1}"     ,this.USERCONFIG, Environment.NewLine);
                if (this.HasFO)             output.AppendFormat("-fo {0}{1}"    ,this.FO        , Environment.NewLine);
                if (this.HasXML)            output.AppendFormat("-xml {0}{1}"   ,this.XML       , Environment.NewLine);
                if (this.HasXSL)            output.AppendFormat("-xsl {0}{1}"   ,this.XSL       , Environment.NewLine);
                if (this.HasFOOUT)          output.AppendFormat("-foout {0}{1}" ,this.FOOUT     , Environment.NewLine);
                if (this.HasPDF)            output.AppendFormat("-pdf {0}{1}"   ,this.PDF       , Environment.NewLine);
            }
            else
            {
                output.Append("no command line parameters.");
            }

            return output.ToString();
        }
    }
}
