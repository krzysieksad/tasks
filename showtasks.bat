call runcrud
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo Errors found while running runcrud.bat - breaking work.
goto fail

:openbrowser
start firefox http://localhost:8080/crud/v1/task/getTasks

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.