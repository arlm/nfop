/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.apache.avalon.framework.logger;

/**
 * Utility class to allow construction of easy components that will perform logging.
 *
 * @author <a href="mailto:peter@apache.org">Peter Donald</a>
 */
public abstract class AbstractLogEnabled
    implements LogEnabled
{
    ///Base Logger instance
    private Logger    m_logger;

    /**
     * Set the components logger.
     *
     * @param logger the logger
     */
    public void enableLogging( final Logger logger )
    {
        m_logger = logger;
    }

    /**
     * Helper method to allow sub-classes to aquire logger.
     * This method exists rather than exposing a member variable
     * because it protects other users against future changes. It
     * also means they do not have to use our naming convention.
     *
     * <p>There is no performance penalty as this is a final method
     * and will be inlined by the JVM.</p>
     *
     * @return the Logger
     */
    protected final Logger getLogger()
    {
        return m_logger;
    }

    /**
     * Helper method to setup other components with same logger.
     *
     * @param component the component to pass logger object to
     */
    protected void setupLogger( final Object component )
    {
        setupLogger( component, (String)null );
    }

    /**
     * Helper method to setup other components with logger.
     * The logger has the subcategory of this components logger.
     *
     * @param component the component to pass logger object to
     * @param subCategory the subcategory to use (may be null)
     */
    protected void setupLogger( final Object component, final String subCategory )
    {
        Logger logger = m_logger;

        if( null != subCategory )
        {
            logger = m_logger.getChildLogger( subCategory );
        }

        setupLogger( component, logger );
    }

    /**
     * Helper method to setup other components with logger.
     *
     * @param component the component to pass logger object to
     * @param logger the Logger
     */
    protected void setupLogger( final Object component, final Logger logger )
    {
        if( component instanceof LogEnabled )
        {
            ((LogEnabled)component).enableLogging( logger );
        }
    }
}
