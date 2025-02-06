@echo off
rem ---------------------------------------------------------------------------
rem clean output for the MWMS Server
rem ---------------------------------------------------------------------------
setlocal
set "RAR=C:\Program Files\7-Zip\7z.exe"

set "CURRENT_DIR=%cd%"
cd ..\..
set "WORKSPACE_BASE=%cd%"
echo WORKSPACE_BASE="%WORKSPACE_BASE%"
set "OUTDIR=%WORKSPACE_BASE%\output\PRD\"

del /Q /S "%WORKSPACE_BASE%\output"

call "%WORKSPACE_BASE%\Environment\builders\package_prd.bat"

"%RAR%" x "%OUTDIR%WMS.server**.gz" -o%OUTDIR%
"%RAR%" e "%OUTDIR%WMS.server**.tar" WMS.server\lib\bootstrap.jar -o%OUTDIR%

explorer %OUTDIR%

:end