@ECHO OFF

IF EXIST ..\tests\userconfig1.pdf DEL ..\tests\userconfig1.pdf

call fop.cmd  -c ..\conf\userconfig.xml  -xml ..\conf\userconfig.xml -xsl ..\tests\userconfig.xsl -pdf ..\tests\userconfig1.pdf