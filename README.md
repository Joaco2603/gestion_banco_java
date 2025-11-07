# Gestion de banco

Proyecto de ejemplo en Java para la gestión de un banco (entidades y gestores).

## Descripción

Este repositorio contiene clases de entidades (Cliente, Cuenta, Operacion) y gestores (GestorCliente, GestorCuenta, GestorOperacion) organizadas bajo el paquete `cr.ac.ucenfotec.bl`. Es un proyecto pequeño pensado para ejercicios y prácticas.

## Estructura principal

- `src/` - código fuente en paquetes Java
  - `cr/ac/ucenfotec/bl/entities/` - entidades: `Cliente`, `Cuenta`, `Operacion`
  - `cr/ac/ucenfotec/bl/logic/` - lógica / gestores
  - `cr/ac/ucenfotec/dl/` - acceso a datos (clases `Data*`)
- `META-INF/MANIFEST.MF`

> Nota: No se detectó automáticamente un `pom.xml` ni `build.gradle` en la raíz. Asumo que este proyecto se compila desde un IDE (IntelliJ) o manualmente con `javac`.

## Requisitos

- Java JDK 8 o superior instalado y en PATH.
- Opcional: IntelliJ IDEA u otro IDE Java para abrir el proyecto.

## Cómo compilar y ejecutar (opciones)

Opción A — Usando IntelliJ IDEA (recomendado para desarrollo)

Pasos detallados para abrir y trabajar con este proyecto en IntelliJ IDEA (Windows):

1. Abrir el proyecto
  - En IntelliJ selecciona File > Open y elige la carpeta raíz del proyecto (la que contiene `src`).
  - Alternativamente, si lo prefieres, usa File > New > Project from Existing Sources... y selecciona la misma carpeta.

2. Configurar el SDK (JDK)
  - Ve a File > Project Structure (Ctrl+Alt+Shift+S).
  - En Project > Project SDK selecciona una JDK válida (8 o superior). Si no aparece, añade la ruta al JDK instalada en tu sistema.

3. Asegurar que `src` está marcado como Source Root
  - En el panel del proyecto (Project view), haz clic derecho sobre la carpeta `src` > Mark Directory as > Sources Root.
  - Comprueba que la estructura de paquetes (por ejemplo `cr/ac/ucenfotec/bl`) coincide con la estructura de carpetas dentro de `src`.

4. Compilar el proyecto
  - Usa Build > Build Project o Build > Rebuild Project.
  - Si hay errores, revisa la consola de Build para obtener detalles.

5. Ejecutar una clase con `main`
  - Localiza la clase que contiene `public static void main(String[] args)` en el panel de Project.
  - Haz clic derecho en la clase > Run 'NombreClase.main()'.
  - O crea una configuración manual: Run > Edit Configurations... > + > Application. Rellena:
    - Name: nombre descriptivo.
    - Main class: busca y selecciona la clase con `main`.
    - Use classpath of module: selecciona el módulo del proyecto.
  - Aplica y ejecuta la configuración.

6. Crear JAR ejecutable (opcional)
  - File > Project Structure > Artifacts > + > JAR > From modules with dependencies.
  - Selecciona el módulo y la clase Main.
  - Build > Build Artifacts... > Build para generar el JAR en la carpeta de salida configurada.

7. Terminal integrada
  - Usa View > Tool Windows > Terminal para abrir una terminal PowerShell integrada y ejecutar comandos `java -jar` o `javac` si lo necesitas.

Consejos y solución de problemas
  - Asegúrate de que el paquete declarado en la parte superior de cada `.java` coincide con la carpeta (por ejemplo `package cr.ac.ucenfotec.bl.entities;`).
  - Si IntelliJ no reconoce las dependencias o el JDK, revisa File > Project Structure > Modules y asegúrate de que el module SDK está correctamente configurado.
  - Para cambiar el nivel de lenguaje (Java 8, 11, 17): File > Project Structure > Project > Project language level.

Si quieres, puedo añadir una pequeña clase `Main` de ejemplo al proyecto y una configuración de artefacto ya preparada para que puedas ejecutar el JAR desde IntelliJ sin más cambios.

Opción B — Compilar y ejecutar manualmente desde PowerShell (Windows)

Ejemplo (compila todos los `.java` bajo `src` y pone los `.class` en `out`):

```powershell
# Crear carpeta de salida
New-Item -ItemType Directory -Force -Path .\out

# Recoger todos los .java y compilarlos
$files = Get-ChildItem -Path .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d .\out $files

# Para ejecutar (si hay una clase con main), usar:
# java -cp .\out fully.qualified.MainClassName
```

Sustituye `fully.qualified.MainClassName` por el nombre completo del paquete y la clase que tenga `public static void main(String[] args)`.

## Contribuir

Si quieres contribuir:
- Haz un fork y un pull request.
- Mantén la estructura de paquetes.
- Añade tests si agregas lógica nueva.

## Licencia

Este repositorio se distribuye bajo licencia MIT. Véase LICENSE (si quieres añadirla).

## Autor

Joaco2603

---

Si quieres, puedo:
- Añadir un archivo `LICENSE` con MIT.
- Añadir un pequeño `Main` de ejemplo que muestre cómo usar los gestores y que sea ejecutable desde la línea de comandos.
- Detectar automáticamente si hay `pom.xml` o `build.gradle` y añadir instrucciones específicas.

Dime qué prefieres y lo implemento.