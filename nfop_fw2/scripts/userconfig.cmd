@ECHO OFF

SET NFOP=..\build\nfop.exe

IF NOT EXIST %NFOP% GOTO NFOPNOTFOUND

IF EXIST ..\tests\userconfig1.pdf DEL ..\tests\userconfig1.pdf

%NFOP%  -c ..\conf\userconfig.xml  -xml ..\conf\userconfig.xml -xsl ..\tests\userconfig.xsl  -pdf ..\tests\userconfig1.pdf

GOTO END

:NFOPNOTFOUND

echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
echo.
echo %NFOP% NOT FOUND !
echo.
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

:END

SET NFOP=