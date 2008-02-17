@ECHO OFF
SET ILMERGE=%ProgramFiles%\Microsoft\ilmerge\ilmerge.exe

IF NOT EXIST %ILMERGE% GOTO ILMERGENOTFOUND

SET BUILD_CONFIGURATION=Debug
REM SET BUILD_CONFIGURATION=Release
SET TARGET_DIR=..\build

DEL %TARGET_DIR%\*.*

SET APACHE_FOP_DLL=apachefop.net.dll
SET FOP_NET_DLL=fop.net.dll
SET NFOP_DLL=nfop.dll
SET NFOP_EXE=nfop.exe
SET TTFREADER_EXE=ttfreader.exe

SET CREATE_TTFREADER=%ILMERGE% /target:exe /ndebug /v2 /out:%TARGET_DIR%\%TTFREADER_EXE% ..\NFop\TTFReader\bin\%BUILD_CONFIGURATION%\%TTFREADER_EXE% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%APACHE_FOP_DLL%
SET CREATE_NFOP=%ILMERGE% /target:exe /ndebug /v2 /out:%TARGET_DIR%\%NFOP_EXE% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%NFOP_EXE% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%FOP_NET_DLL% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%APACHE_FOP_DLL%
SET CREATE_EXTRA_DLL=%ILMERGE% /target:library  /ndebug /v2 /out:%TARGET_DIR%\%NFOP_DLL% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%FOP_NET_DLL% ..\NFop\NFopApp\bin\%BUILD_CONFIGURATION%\%APACHE_FOP_DLL%



echo %CREATE_TTFREADER%
%CREATE_TTFREADER%
echo.
echo %CREATE_NFOP%
%CREATE_NFOP%
echo.
echo %CREATE_EXTRA_DLL%
%CREATE_EXTRA_DLL%



SET BUILD_CONFIGURATION=
SET TARGET_DIR=

SET APACHE_FOP_DLL=
SET FOP_NET_DLL=
SET NFOP_DLL=
SET NFOP_EXE=
SET TTFREADER_EXE=

SET CREATE_TTFREADER=
SET CREATE_NFOP=
SET CREATE_EXTRA_DLL=
GOTO END

:ILMERGENOTFOUND
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
echo.
echo %ILMERGE% NOT FOUND !
echo.
echo download it from http://www.microsoft.com/downloads/details.aspx?FamilyID=22914587-b4ad-4eae-87cf-b14ae6a939b0
echo.
echo install and try again
echo.
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

:END
SET ILMERGE=