package org.apache.avalon.framework.logger;

public class ConsoleLogger implements Logger {

	public static final int LEVEL_INFO = 3;
	public static final int LEVEL_DEBUG = 5;

	public ConsoleLogger(int loggingLevel) {}

	private void print(String message) {
		System.out.println(message);
	}

	private void print(String message, Throwable throwable) {
		System.out.println(message);
		System.out.println(throwable.getMessage());
		throwable.printStackTrace(System.out);
	}

	/**
	 * Determine if messages of priority "debug" will be logged.
	 *
	 * @return true if "debug" messages will be logged
	 */
	public boolean isDebugEnabled() {
		return true;
	}
	public void debug( String message ) {
		if(isDebugEnabled())
			print(message);
	}
	/**
	 * Log a debug message.
	 *
	 * @param message the message
	 * @param throwable the throwable
	 */
	public void debug( String message, Throwable throwable ) {
		if(isDebugEnabled()) {
			print(message, throwable);
		}
	}

	/**
	 * Determine if messages of priority "info" will be logged.
	 *
	 * @return true if "info" messages will be logged
	 */
	public boolean isInfoEnabled() {
		return true;
	}

	/**
	 * Log a info message.
	 *
	 * @param message the message
	 */
	public void info( String message ) {
		if(isInfoEnabled())
			print(message);
	}
	/**
	* Log a info message.
	*
	* @param message the message
	* @param throwable the throwable
	*/
	public void info( String message, Throwable throwable ) {
		if(isInfoEnabled())
			print(message, throwable);
	}


	/**
	* Log a warn message.
	*
	* @param message the message
	*/
	public void warn( String message ) {
		if(isWarnEnabled()) {
			print(message);
		}
	}

	/**
	* Log a warn message.
	*
	* @param message the message
	* @param throwable the throwable
	*/
	public void warn( String message, Throwable throwable ) {
		if(isWarnEnabled()) {
			print(message, throwable);
		}
	}

	/**
	* Determine if messages of priority "warn" will be logged.
	*
	* @return true if "warn" messages will be logged
	*/
	public boolean isWarnEnabled() {
		return true;
	}

	/**
		* Log a error message.
		*
		* @param message the message
		*/
	public void error( String message ) {
		if(isErrorEnabled())
			print(message);
	}

		/**
		 * Log a error message.
		 *
		 * @param message the message
		 * @param throwable the throwable
		 */
	public void error( String message, Throwable throwable ) {
		if(isErrorEnabled()) {
			print(message, throwable);
		}
	}

		/**
		 * Determine if messages of priority "error" will be logged.
		 *
		 * @return true if "error" messages will be logged
		 */
	public boolean isErrorEnabled() {
		return true;
	}

			/**
			 * Log a fatalError message.
			 *
			 * @param message the message
			 */
	public void fatalError( String message ) {		
		if(isFatalErrorEnabled()) {
			print(message);
		}
	}


		/**
		 * Log a fatalError message.
		 *
		 * @param message the message
		 * @param throwable the throwable
		 */
	public void fatalError( String message, Throwable throwable ) {
		if(isFatalErrorEnabled()) {
			print(message, throwable);
		}
	}

		/**
		 * Determine if messages of priority "fatalError" will be logged.
		 *
		 * @return true if "fatalError" messages will be logged
		 */
	public boolean isFatalErrorEnabled() {
		return true;
	}

			/**
			 * Create a new child logger.
			 * The name of the child logger is [current-loggers-name].[passed-in-name]
			 *
			 * @param name the subname of this logger
			 * @return the new logger
			 * @exception IllegalArgumentException if name has an empty element name
			 */
	public Logger getChildLogger( String name ) {
		return new ConsoleLogger(LEVEL_INFO);
	}
}