@ECHO OFF

IF EXIST ..\tests\userconfig.pdf DEL ..\tests\userconfig.pdf

call fop.cmd  -c ..\conf\userconfig.xml  -xml ..\conf\userconfig.xml -xsl ..\tests\userconfig.xsl -pdf ..\tests\userconfig1.pdf