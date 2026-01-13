@echo off
echo Intentando ejecutar la aplicacion...

if defined JAVA_HOME (
    echo Usando JAVA_HOME: %JAVA_HOME%
    "%JAVA_HOME%\bin\java" -jar target\TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar
) else (
    echo.
    echo [ERROR] El comando 'java' no se reconoce y JAVA_HOME no esta definido.
    echo.
    echo Para solucionar esto, necesitas saber donde tienes instalado Java (JDK).
    echo Por lo general esta en "C:\Program Files\Java\jdk-17..."
    echo.
    echo Intenta ejecutar el comando usando la ruta completa entre comillas. Ejemplo:
    echo "C:\Program Files\Java\jdk-17.0.2\bin\java" -jar target\TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar
    echo.
)
pause