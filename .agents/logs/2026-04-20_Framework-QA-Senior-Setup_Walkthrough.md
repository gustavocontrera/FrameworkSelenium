# Resumen: Setup de QA Automation Senior

## Cambios realizados
En base a lo conversado, se estableció la estructura base para permitir que la Inteligencia Artificial actúe bajo las premisas de un Ingeniero Automating Senior en el framework de Selenium + Cucumber.

### 1. Instrucciones de IA (Skills)
Hemos creado el archivo `SKILL.md` dentro de la carpeta oculta `.agents/skills/qa-automation-senior/`.
Este módulo instruirá siempre a la IA a:
- Mantener estrictamente el patrón Page Object Model.
- Utilizar Waits explícitos apropiados, sin recurrir a malas prácticas.
- No "hacer el trabajo por ti", sino ofrecer lineamientos para que tu aprendizaje sea orgánico, actuando como un mentor, y no tocar la carpeta `varios`.
- Centralizar y limpiar la estructura.

### 2. Gestión de Configuraciones Globales
Para hacer el código más escalable (que es uno de tus objetivos principales), configuramos un mecanismo centralizado de `properties`.

- **Se creó el archivo `src/test/resources/config.properties`**: Allí estarán tus URLs y tiempos de espera de manera global, y no perdidos o duplicados dentro de las clases de Java.
- **Se creó la clase `src/test/java/utils/ConfigReader.java`**: Su única función en la vida es leer `config.properties` eficientemente.

### 3. Bitácora de Ingeniería (Logs)
Se copiaron el plan de implementación y este resumen dentro del directorio `.agents/logs/` con la nomenclatura solicitada (`YYYY-MM-DD_Nombre-Tarea_*.md`). Así guardamos la trazabilidad histórica de nuestra toma de decisiones arquitectónicas en el proyecto mismo.

## Siguientes Pasos (Para tí, como práctica)
El lector de properties ya existe. En un futuro, para usarlo en áreas como `PaginaPrincipal.java` o en los Steps, en lugar de hacer esto:
```java
// Forma anterior (hardcodeada)
driver.get("https://www.freerangetesters.com");
```

Podrás empezar a usarlo así:
```java
// Nueva forma (Escalable y centralizada)
import utils.ConfigReader;

String url = ConfigReader.getProperty("baseUrl");
driver.get(url);
```
Cuando un día pasemos de un ambiente de `QA` a `UAT` (pruebas de usuario), solo deberemos cambiar el `.properties` y no revisar 20 clases java diferentes buscando direcciones hardcodeadas.
