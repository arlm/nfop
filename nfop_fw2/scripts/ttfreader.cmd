@ECHO OFF

SET TTFREADER=..\build\ttfreader.exe

IF NOT EXIST %TTFREADER% GOTO TTFREADERNOTFOUND

SET NFOP_CONF_PATH=..\conf
SET TTF_FONTS_PATH=..\conf

IF NOT EXIST %TTF_FONTS_PATH%\arial.ttf    copy %windir%\fonts\arial.ttf    %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\arialbd.ttf  copy %windir%\fonts\arialbd.ttf  %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\ariali.ttf   copy %windir%\fonts\ariali.ttf   %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\arialbi.ttf  copy %windir%\fonts\arialbi.ttf  %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\cour.ttf     copy %windir%\fonts\cour.ttf     %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\courbd.ttf   copy %windir%\fonts\courbd.ttf   %TTF_FONTS_PATH%\ 
IF NOT EXIST %TTF_FONTS_PATH%\couri.ttf    copy %windir%\fonts\couri.ttf    %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\courbi.ttf   copy %windir%\fonts\courbi.ttf   %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\times.ttf    copy %windir%\fonts\times.ttf    %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\timesbd.ttf  copy %windir%\fonts\timesbd.ttf  %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\timesi.ttf   copy %windir%\fonts\timesi.ttf   %TTF_FONTS_PATH%\
IF NOT EXIST %TTF_FONTS_PATH%\timesbi.ttf  copy %windir%\fonts\timesbi.ttf  %TTF_FONTS_PATH%\ 

%TTFREADER%  %TTF_FONTS_PATH%\arial.ttf    %NFOP_CONF_PATH%\arial.xml
%TTFREADER%  %TTF_FONTS_PATH%\arialbd.ttf  %NFOP_CONF_PATH%\arial-bold.xml
%TTFREADER%  %TTF_FONTS_PATH%\ariali.ttf   %NFOP_CONF_PATH%\arial-italic.xml
%TTFREADER%  %TTF_FONTS_PATH%\arialbi.ttf  %NFOP_CONF_PATH%\arial-italic-bold.xml
%TTFREADER%  %TTF_FONTS_PATH%\cour.ttf     %NFOP_CONF_PATH%\cour-new.xml
%TTFREADER%  %TTF_FONTS_PATH%\courbd.ttf   %NFOP_CONF_PATH%\courier-new-bold.xml
%TTFREADER%  %TTF_FONTS_PATH%\couri.ttf    %NFOP_CONF_PATH%\courier-new-italic.xml
%TTFREADER%  %TTF_FONTS_PATH%\courbi.ttf   %NFOP_CONF_PATH%\courier-new-italic-bold.xml
%TTFREADER%  %TTF_FONTS_PATH%\times.ttf    %NFOP_CONF_PATH%\times-new-roman.xml
%TTFREADER%  %TTF_FONTS_PATH%\timesbd.ttf  %NFOP_CONF_PATH%\times-new-roman-bold.xml
%TTFREADER%  %TTF_FONTS_PATH%\timesi.ttf   %NFOP_CONF_PATH%\times-new-roman-italic.xml
%TTFREADER%  %TTF_FONTS_PATH%\timesbi.ttf  %NFOP_CONF_PATH%\times-new-roman-italic-bold.xml

GOTO END

:TTFREADERNOTFOUND
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
echo.
echo %TTFREADER% NOT FOUND !
echo.
echo !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

:END

SET TTFREADER=
SET NFOP_CONF_PATH=
SET TTF_FONTS_PATH=