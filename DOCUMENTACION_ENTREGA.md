# Documentación del Proceso de Distribución - TrucoTrato

Este documento describe los pasos seguidos para generar la distribución final de la aplicación TrucoTrato, incluyendo la generación del JAR, el ejecutable .exe y el instalador para Windows.

## 1. Generación del JAR Ejecutable

Para generar un único archivo JAR que contenga todas las dependencias necesarias (Fat JAR), se ha configurado el plugin `maven-shade-plugin` en el archivo `pom.xml`.

### Pasos:
1.  Se ha creado una clase `Launcher.java` en el paquete `org.trucotrato.trucotrato`. Esta clase contiene un método `main` que llama a `Main.main(args)`. Esto es necesario para evitar errores de tiempo de ejecución relacionados con los módulos de JavaFX al ejecutar el JAR como una aplicación clásica (classpath).
2.  Se ha modificado el `pom.xml` para incluir la configuración de `maven-shade-plugin`, especificando `org.trucotrato.trucotrato.Launcher` como la clase principal en el manifiesto.
3.  Para generar el JAR, ejecutar el siguiente comando en la raíz del proyecto:
    ```bash
    mvn clean package
    ```
    El archivo generado se encontrará en `target/TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar`.

## 2. Generación del Ejecutable (.exe) con Launch4j

Se utiliza Launch4j para envolver el JAR en un ejecutable de Windows.

### Configuración:
-   Archivo de configuración: `launch4j_config.xml`.
-   **JAR de entrada**: `target/TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar`.
-   **Salida**: `TrucoTrato.exe`.
-   **Tipo**: GUI (sin consola).
-   **JRE**: Se ha configurado para buscar una carpeta `jre` distribuida junto al ejecutable (`bundled JRE`).

### Pasos:
1.  Asegúrese de tener una carpeta llamada `jre` en la raíz del proyecto que contenga un JRE de Windows (versión 17 o superior) para distribuir.
2.  Abra Launch4j y cargue el archivo de configuración `launch4j_config.xml`.
3.  Genere el ejecutable (icono de engranaje o "Build wrapper").

## 3. Creación del Instalador con Inno Setup

Se utiliza Inno Setup para crear un instalador profesional que copie los archivos y cree accesos directos.

### Configuración:
-   Script: `setup_script.iss`.
-   **Archivos incluidos**:
    -   `TrucoTrato.exe` (generado en el paso anterior).
    -   Carpeta `jre` (para que la aplicación funcione sin Java instalado en el sistema).

### Pasos:
1.  Asegúrese de que `TrucoTrato.exe` y la carpeta `jre` existen en la raíz del proyecto.
2.  Abra el archivo `setup_script.iss` con Inno Setup Compiler.
3.  Compile el script (Run).
4.  El instalador generado se llamará `TrucoTratoInstaller.exe`.

## Problemas Encontrados y Soluciones

1.  **Error "JavaFX runtime components are missing" al ejecutar el JAR**:
    -   *Causa*: Al ejecutar un JAR sombreado (shaded), JavaFX no se inicia correctamente si la clase principal extiende `Application`.
    -   *Solución*: Se creó la clase `Launcher` que actúa como punto de entrada y delega en la clase `Main`.

2.  **Distribución sin Java instalado**:
    -   *Solución*: Se configuró Launch4j e Inno Setup para incluir una carpeta `jre` local. Esto asegura que la aplicación funcione en cualquier equipo Windows independientemente de si tiene Java instalado.

## Estructura de Archivos para la Entrega

La carpeta de entrega debe contener:
-   `TrucoTratoInstaller.exe` (Instalador final).
-   Carpeta `ArchivosProyecto`:
    -   `TrucoTrato-1.0-SNAPSHOT-jar-with-dependencies.jar`
    -   `TrucoTrato.exe`
    -   Carpeta `jre`
-   Este documento `DOCUMENTACION_ENTREGA.md`.
