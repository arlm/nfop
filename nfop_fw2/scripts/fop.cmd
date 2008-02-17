@ECHO OFF
SET ILMERGE=%ProgramFiles%\Microsoft\ilmerge\ilmerge.exe

IF NOT EXIST %ILMERGE% GOTO ILMERGENOTFOUND

SET NFOP="..\build\nfop.exe"

IF NOT EXIST %NFOP% GOTO NOEXECUTABLEFOUND

echo Call nfop
%NFOP% %1 %2 %3 %4 %5 %6 %7 %8 %9

GOTO END

:NOEXECUTABLEFOUND

echo %NFOP% not found

ECHO Merge Assembly
CALL merge_assembly.cmd

echo Call nfop
%NFOP% %1 %2 %3 %4 %5 %6 %7 %8

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
SET NFOP=