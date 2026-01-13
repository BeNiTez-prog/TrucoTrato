@echo off
setlocal

echo Buscando Java 17 o superior...

REM Lista de posibles rutas donde Android Studio o IntelliJ instalan el JDK
set "POSSIBLE_JAVA_PATHS=C:\Program Files\Android\Android Studio\jbr\bin\java.exe;C:\Program Files\Android\Android Studio\jre\bin\java.exe;C:\Users\Usuario1\.jdks\corretto-17.0.14\bin\java.exe;C:\Users\Usuario1\.jdks\openjdk-17.0.2\bin\java.exe"

REM Intentar encontrar uno que exista
for %%p in ("%POSSIBLE_JAVA_PATHS:;=" "%") do (
    if exist %%p (
        echo Encontrado Java en: %%p
        "%%~p" -jar target\TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar
        goto :end
    )
)

REM Si llegamos aqui, no encontramos las rutas comunes.
echo.
echo [ERROR] No se encontro una instalacion automatica de Java 17.
echo El error que ves (class file version 61.0) es porque tu terminal usa Java 8 por defecto.
echo.
echo Por favor, edita este archivo (run_jar.bat) y pon la ruta correcta a tu java.exe de la version 17.
echo.
pause

:end
pause